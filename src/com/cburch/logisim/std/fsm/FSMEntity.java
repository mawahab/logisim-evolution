/*******************************************************************************
 * This file is part of logisim-evolution.
 *
 *   logisim-evolution is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   logisim-evolution is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with logisim-evolution.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   Original code by Carl Burch (http://www.cburch.com), 2011.
 *   Subsequent modifications by :
 *     + Haute École Spécialisée Bernoise
 *       http://www.bfh.ch
 *     + Haute École du paysage, d'ingénierie et d'architecture de Genève
 *       http://hepia.hesge.ch/
 *     + Haute École d'Ingénierie et de Gestion du Canton de Vaud
 *       http://www.heig-vd.ch/
 *   The project is currently maintained by :
 *     + REDS Institute - HEIG-VD
 *       Yverdon-les-Bains, Switzerland
 *       http://reds.heig-vd.ch
 *******************************************************************************/

package com.cburch.logisim.std.fsm;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Window;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.WeakHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.Attributes;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.gui.main.Frame;
import com.cburch.logisim.instance.Instance;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.proj.Project;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.parser.FSMSerializer;
import com.cburch.logisim.statemachine.simulator.FSMSimulator;
import com.cburch.logisim.tools.key.BitWidthConfigurator;
import com.cburch.logisim.util.GraphicsUtil;
import com.cburch.logisim.util.StringUtil;

public class FSMEntity extends InstanceFactory {

	static class ContentAttribute extends Attribute<FSMContent> {

		public ContentAttribute() {
			super("content", Strings.getter("fsmContentAttr"));
		}

		@Override
		public java.awt.Component getCellEditor(Window source, FSMContent value) {
			Project proj = source instanceof Frame ? ((Frame) source)
					.getProject() : null;
			return FSMEntityAttributes.getContentEditor(source, value, proj);
		}

		@Override
		public FSMContent parse(String value) {
			return new FSMContent(value);
		}

		@Override
		public String toDisplayString(FSMContent value) {
			return Strings.get("fsmContentValue");
		}

		@Override
		public String toStandardString(FSMContent value) {
			return FSMSerializer.saveAsString(value.getFsm());
		}
	}

	static class FSMEntityListener implements FSMModelListener {

		Instance instance;

		FSMEntityListener(Instance instance) {
			this.instance = instance;
		}

		@Override
		public void contentSet(FSMContent source) {
			instance.fireInvalidated();
			instance.recomputeBounds();
		}
	}

	final static Logger logger = LoggerFactory.getLogger(FSMEntity.class);


	static final Attribute<FSMContent> CONTENT_ATTR = new ContentAttribute();
	static final int WIDTH = 140;
	static final int HEIGHT = 40;
	static final int PORT_GAP = 20;

	static final int X_PADDING = 5;

	private static final int CLK = 0;
	private static final int CLR = 1;
	private static final int EN = 2;

	private static final int DELAY = 8;

	private WeakHashMap<Instance, FSMEntityListener> contentListeners;

	private FSMSimulator simulator;

	public static final Attribute<Boolean> ATTR_SHOW_IN_TAB = Attributes.forBoolean("showInTab",
			Strings.getter("registerShowInTab"));

	public FSMEntity() {
		super("FSM Entity", Strings.getter("fsmComponent"));
		this.contentListeners = new WeakHashMap<Instance, FSMEntityListener>();
		setAttributes(
					new Attribute[] { 
							StdAttr.WIDTH, 
							StdAttr.TRIGGER, 
							StdAttr.LABEL, 
							StdAttr.LABEL_FONT,
							ATTR_SHOW_IN_TAB, 
					},
					new Object[] { 
							BitWidth.create(8), 
							StdAttr.TRIG_RISING, 
							"", 
							StdAttr.DEFAULT_LABEL_FONT, 
							false, 
					}
				);
		setKeyConfigurator(new BitWidthConfigurator(StdAttr.WIDTH));
		setIconName("RAM.gif");

	}

	@Override
	protected void configureNewInstance(Instance instance) {
		FSMContent content = instance.getAttributeValue(CONTENT_ATTR);
		this.simulator = new FSMSimulator(content.getFsm());
		FSMEntityListener listener = new FSMEntityListener(instance);

		contentListeners.put(instance, listener);
		content.addFSMModelListener(listener);

		instance.addAttributeListener();
		updatePorts(instance);
	}

	@Override
	public AttributeSet createAttributeSet() {
		return new FSMEntityAttributes();
	}

	@Override
	public String getHDLName(AttributeSet attrs) {
		return attrs.getValue(CONTENT_ATTR).getName().toLowerCase();
	}

	@Override
	public String getHDLTopName(AttributeSet attrs) {

		String label = "";

		if (attrs.getValue(StdAttr.LABEL) != "")
			label = "_" + attrs.getValue(StdAttr.LABEL).toLowerCase();

		return getHDLName(attrs) + label;
	}

	@Override
	public Bounds getOffsetBounds(AttributeSet attrs) {
		FSMContent content = attrs.getValue(CONTENT_ATTR);
		int nbInputs = content.getInputsNumber();
		int nbOutputs = content.getOutputsNumber();

		int nbio = content.getControls().length+Math.max(nbInputs, nbOutputs);
		return Bounds.create(0, 0, WIDTH, nbio* PORT_GAP + HEIGHT);
	}

	
	public boolean HDLSupportedComponent(String HDLIdentifier,
			AttributeSet attrs, char Vendor) {
		if (MyHDLGenerator == null)
			MyHDLGenerator = new FSMHDLGeneratorFactory();
		return MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs);
	}

	@Override
	protected void instanceAttributeChanged(Instance instance, Attribute<?> attr) {
		if (attr == CONTENT_ATTR) {
			updatePorts(instance);
			instance.recomputeBounds();
		}
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		Graphics g = painter.getGraphics();
		FSMContent content = painter.getAttributeValue(CONTENT_ATTR);
		FSMStateData state = (FSMStateData) painter.getData();
		if (state == null) {
			state = new FSMStateData(content.getFsm().getStart(),0);
			painter.setData(state);
		}

		
		FontMetrics metric = g.getFontMetrics();

		Bounds bds = painter.getBounds();
		int x0 = bds.getX() + (bds.getWidth() / 2);
		int y0 = bds.getY() + metric.getHeight() + 12;
		GraphicsUtil.drawText(g,
				StringUtil.resizeString("FSM:"+content.getName(), metric, WIDTH), x0,
				y0, GraphicsUtil.H_CENTER, GraphicsUtil.V_BOTTOM);

		State currentState = state.getState();
		if (painter.getShowState()) {
			g.setColor(Color.LIGHT_GRAY);
			//g.fillRect(x0 + 20, y0 + 20, 80, 16);
			g.setColor(Color.black);
			String cs = currentState.getName();
			if (cs!=null) {
				GraphicsUtil.drawCenteredText(g, cs, x0, y0 + 8);
			}
			//if()
			String code = currentState.getCode();
			if(code!=null)	{
				GraphicsUtil.drawCenteredText(g, code, x0, y0 + 8+metric.getHeight());
			}
			g.setColor(Color.black);
		}

		String glbLabel = painter.getAttributeValue(StdAttr.LABEL);
		if (glbLabel != null) {
			Font font = g.getFont();
			g.setFont(painter.getAttributeValue(StdAttr.LABEL_FONT));
			GraphicsUtil.drawCenteredText(g, glbLabel,
					bds.getX() + bds.getWidth() / 2, bds.getY()
							- g.getFont().getSize());
			g.setFont(font);
		}

		g.setColor(Color.GRAY);
		g.setFont(g.getFont().deriveFont((float) 10));
		metric = g.getFontMetrics();

		Port[] ctrl = content.getControls();
		Port[] inputs = content.getInputs();
		Port[] outputs = content.getOutputs();
		String names[] =new String[]{"CLK","CLR","EN"};
		for (int i = 0; i < ctrl.length; i++)
			GraphicsUtil.drawText(g, StringUtil.resizeString(
					names[i], metric, (WIDTH / 2) - X_PADDING),
					bds.getX() + 5, bds.getY() + HEIGHT - 2 + (i * PORT_GAP),
					GraphicsUtil.H_LEFT, GraphicsUtil.V_CENTER);
		
		for (int i = 0; i < inputs.length; i++) {
			GraphicsUtil.drawText(g, StringUtil.resizeString(
					inputs[i].getToolTip(), metric, (WIDTH / 2) - X_PADDING),
					bds.getX() + 5, bds.getY() + HEIGHT - 2 + ((i+ctrl.length) * PORT_GAP),
					GraphicsUtil.H_LEFT, GraphicsUtil.V_CENTER);
			
		}
		for (int i = 0; i < outputs.length; i++)
			GraphicsUtil.drawText(g, StringUtil.resizeString(
					outputs[i].getToolTip(), metric, (WIDTH / 2) - X_PADDING),
					bds.getX() + WIDTH - 5, bds.getY() + HEIGHT - 2
							+ ((i+ctrl.length) * PORT_GAP), GraphicsUtil.H_RIGHT,
					GraphicsUtil.V_CENTER);

		painter.drawBounds();
		painter.drawPorts();
	}

	@Override
	/**
	 * Propagate signals through the VHDL component.
	 * Logisim doesn't have a VHDL simulation tool. So we need to use an external tool.
	 * We send signals to Questasim/Modelsim through a socket and a tcl binder. Then,
	 * a simulation step is done and the tcl server sends the output signals back to
	 * Logisim. Then we can set the VHDL component output properly.
	 *
	 * This can be done only if Logisim could connect to the tcl server (socket). This is
	 * done in Simulation.java.
	 */

	
	public void propagate(InstanceState istate) {
		FSMStateData data = (FSMStateData) istate.getData();
		FSMContent content = istate.getAttributeValue(CONTENT_ATTR);
		updatePorts(istate.getInstance());
		FSM fsm = content.getFsm();
		System.out.println("FSM id:"+fsm.hashCode());
		if (simulator.getFSM()!=fsm) {
			simulator = new FSMSimulator(fsm);
		}
		if (data == null) {
			data = new FSMStateData(fsm.getStart(),0);
			istate.setData(data);
		}

		Value clk = istate.getPortValue(CLK);
		Value clear = istate.getPortValue(CLR);
		Value enable = istate.getPortValue(EN);
		boolean triggered = data.updateClock(clk, null);// triggerType);
		int offsetInput = content.getControls().length;

		if (clear == Value.TRUE) {
			data.setState(fsm.getStart());
			simulator.reset();
		} else {
			if (triggered && enable != Value.FALSE) {
				
				for (int i =0; i< content.getInputsNumber();i++) {
					Value in = istate.getPortValue(i+offsetInput);
					if (in.isFullyDefined()) {
						InputPort ip = content.inMap.get(content.inputs[i]);
						boolean val = in.toIntValue()==1;
						System.out.println("Input "+ip.getName()+ "="+val);
						simulator.setInput(ip, val);
					} else {
						throw new RuntimeException(in+" not fullly defined");
					}
				}
				State nextState = simulator.update();
				if(nextState==null) throw new RuntimeException("Eroor");
				data.setState(nextState);
				
			}
		}

		for (int i =0; i< content.getOutputsNumber();i++) {
			Port key = content.outputs[i];
			OutputPort op = content.outMap.get(key);
			boolean res = simulator.getOutput(i);
			int portIndex = istate.getPortIndex(content.outputs[i]);
			istate.setPort(portIndex, res?Value.TRUE:Value.FALSE,DELAY); 
			System.out.println("Output["+i+","+op.getName()+"]="+res);
		}
		
	}

	@Override
	public boolean RequiresNonZeroLabel() {
		return true;
	}


	void updatePorts(Instance instance) {
		FSMContent content = instance.getAttributeValue(CONTENT_ATTR);
		instance.setPorts(content.getPorts());
	}
}
