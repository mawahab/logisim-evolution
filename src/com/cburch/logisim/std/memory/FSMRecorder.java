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

package com.cburch.logisim.std.memory;

import java.awt.Color;
import java.awt.Graphics;

import com.bfh.logisim.designrulecheck.CorrectLabel;
import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.Attributes;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Location;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.Instance;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;

import com.cburch.logisim.tools.key.BitWidthConfigurator;
import com.cburch.logisim.util.GraphicsUtil;


public class FSMRecorder extends InstanceFactory {
	
	public static void DrawRegister(InstancePainter painter, int x, int y,
			int nr_of_bits, boolean isLatch, boolean neg_active,
			boolean has_we, String value) {
		int dq_width = (nr_of_bits == 1) ? 3 : 5;
		int len = (nr_of_bits + 3) / 4;
		int wid = 7 * len + 2;
		int xoff = (60 - wid) / 2;
		Graphics g = painter.getGraphics();
		if (painter.getShowState()) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(x + xoff, y + 1, wid, 16);
			g.setColor(Color.black);
			GraphicsUtil.drawCenteredText(g, value, x + 30, y + 8);
			g.setColor(Color.black);
		}
		GraphicsUtil.switchToWidth(g, 2);
		g.drawRect(x + 10, y + 20, 40, 60);
		if (nr_of_bits > 1) {
			g.drawLine(x + 15, y + 80, x + 15, y + 85);
			g.drawLine(x + 15, y + 85, x + 55, y + 85);
			g.drawLine(x + 55, y + 25, x + 55, y + 85);
			g.drawLine(x + 50, y + 25, x + 55, y + 25);
			if (nr_of_bits > 2) {
				g.drawLine(x + 20, y + 85, x + 20, y + 90);
				g.drawLine(x + 20, y + 90, x + 60, y + 90);
				g.drawLine(x + 60, y + 30, x + 60, y + 90);
				g.drawLine(x + 55, y + 30, x + 60, y + 30);
			}
		}
		GraphicsUtil.switchToWidth(g, 1);
		GraphicsUtil.switchToWidth(g, dq_width);
		g.drawLine(x, y + 30, x + 8, y + 30);
		g.drawLine(x + 52, y + 30, x + 60, y + 30);
		GraphicsUtil.switchToWidth(g, 1);
		GraphicsUtil.drawCenteredText(g, "D", x + 18, y + 30);
		GraphicsUtil.switchToWidth(g, 3);
		g.drawLine(x + 30, y + 81, x + 30, y + 90);
		GraphicsUtil.switchToWidth(g, 1);
		g.setColor(Color.GRAY);
		GraphicsUtil.drawCenteredText(g, "R", x + 30, y + 70);
		g.setColor(Color.BLACK);
		if (has_we) {
			GraphicsUtil.drawCenteredText(g, "WE", x + 22, y + 50);
			GraphicsUtil.switchToWidth(g, 3);
			g.drawLine(x, y + 50, x + 10, y + 50);
			GraphicsUtil.switchToWidth(g, 1);
		}
		if (!neg_active) {
			GraphicsUtil.switchToWidth(g, 3);
			g.drawLine(x, y + 70, x + 10, y + 70);
			GraphicsUtil.switchToWidth(g, 1);
		} else {
			GraphicsUtil.switchToWidth(g, 2);
			g.drawOval(x, y + 65, 10, 10);
			GraphicsUtil.switchToWidth(g, 1);
		}
	}

	static final int DELAY = 8;
	static final int IN = 0;
	static final int NXT = 1;
	static final int CS = 2;
	static final int O = 3;
	public static final int CK = 4;
	static final int CLR = 5;
	static final int EN = 6;
	static final int Xsize = 60;

	static final int Ysize = 90;

	public static final Attribute<Boolean> ATTR_SHOW_IN_TAB = Attributes
			.forBoolean("showInTab", Strings.getter("registerShowInTab"));

	public static final Attribute<String> FILENAME = Attributes.forString("filename",Strings.getter("stdFilenameAttr"));
	public static final Attribute<String> FORMAT = Attributes.forString("filename",Strings.getter("stdFilenameAttr"));

	public FSMRecorder() {
		super("TraceRecorder", Strings.getter("traceRecorderComponent"));
		
		
		setAttributes(
				new Attribute[] { 
					StdAttr.WIDTH, 
					StdAttr.TRIGGER,
					StdAttr.LABEL, 
					FILENAME,
					FORMAT,
					StdAttr.LABEL_FONT, 
					ATTR_SHOW_IN_TAB, 
				}, 
				new Object[] { 
					BitWidth.create(8), 
					StdAttr.TRIG_RISING, 
					"",
					"log.txt",
					"1/2/-",
					StdAttr.DEFAULT_LABEL_FONT, 
					false, 
				}
		);
		setKeyConfigurator(new BitWidthConfigurator(StdAttr.WIDTH));
		setOffsetBounds(Bounds.create(0, 0, Xsize, Ysize));
		setIconName("register.gif");
		

		Port[] ps = new Port[4];
		ps[IN] = new Port(0, 30, Port.INPUT, StdAttr.WIDTH);
		ps[NXT] = new Port(0, 30, Port.INPUT, StdAttr.WIDTH);
		ps[CS] = new Port(0, 30, Port.INPUT, StdAttr.WIDTH);
		ps[O] = new Port(0, 30, Port.OUTPUT, StdAttr.WIDTH);
		ps[CK] = new Port(0, 70, Port.INPUT, 1);
		ps[CLR] = new Port(30, 90, Port.INPUT, 1);
		ps[EN] = new Port(0, 50, Port.INPUT, 1);
		ps[IN].setToolTip(Strings.getter("registerDTip"));
		ps[CK].setToolTip(Strings.getter("registerClkTip"));
		ps[CLR].setToolTip(Strings.getter("registerClrTip"));
		ps[EN].setToolTip(Strings.getter("registerEnableTip"));
		setPorts(ps);
	}

	@Override
	protected void configureNewInstance(Instance instance) {
		Bounds bds = instance.getBounds();
		
		instance.setTextField(StdAttr.LABEL, StdAttr.LABEL_FONT, bds.getX()
				+ bds.getWidth() / 2, bds.getY() - 3, GraphicsUtil.H_CENTER,
				GraphicsUtil.V_BASELINE);
	}

	@Override
	public String getHDLName(AttributeSet attrs) {
		StringBuffer CompleteName = new StringBuffer();
		CompleteName.append(CorrectLabel.getCorrectLabel(this.getName())
				.toUpperCase());
		if ((attrs.getValue(StdAttr.TRIGGER) == StdAttr.TRIG_FALLING)
				|| (attrs.getValue(StdAttr.TRIGGER) == StdAttr.TRIG_RISING)) {
			CompleteName.append("_FLIP_FLOP");
		} else {
			CompleteName.append("_LATCH");
		}
		return CompleteName.toString();
	}

	@Override
	public boolean HDLSupportedComponent(String HDLIdentifier,
			AttributeSet attrs) {
		
		return false;
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		TraceRecorderData state = (TraceRecorderData) painter.getData();
		BitWidth widthVal = painter.getAttributeValue(StdAttr.WIDTH);
		int width = widthVal == null ? 8 : widthVal.getWidth();
		Location loc = painter.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		// determine text to draw in label
		String a;
		a = state.filename;
		
		DrawRegister(painter, x, y, width, false, false, true, a);
		painter.drawLabel();

		// draw input and output ports
		painter.drawPort(IN);
		painter.drawPort(CLR);
		painter.drawPort(EN);
		painter.drawPort(CK);

	}

	@Override
	public void propagate(InstanceState state) {
		String format = state.getAttributeValue(FORMAT);
		String filename = state.getAttributeValue(FILENAME);
		TraceRecorderData data = (TraceRecorderData) state.getData();
		if (data == null) {
			data = new TraceRecorderData(filename,format);
			state.setData(data);
		}
		boolean triggered = data.updateClock(state.getPortValue(CK),StdAttr.TRIG_RISING);
		data.format= format;

		if (state.getPortValue(CLR) == Value.TRUE) {
			data.refresh();
		} else if (triggered && state.getPortValue(EN) != Value.FALSE) {
			Value in = state.getPortValue(IN);
			if (in.isFullyDefined()) {
				data.save(in);
			}
		}

	}
}