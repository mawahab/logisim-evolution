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

import org.eclipse.xpand2.XpandExecutionContextImpl.DefinitionOperationAdapter;

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
import com.cburch.logisim.util.StringUtil;

public class RegisterFile extends InstanceFactory {
	
	public static final int ROW_HEIGHT = 18;

	public static final int COL_WIDTH = 130;

	public  static final int HEIGHT = 360;

	public  static final int WIDTH = 360;
	public  static final int OFFX_VAL = 50;
	public  static final int OFFY_VAL = 40;

	
	Port[] ps = new Port[9];
	
	static int OFFX = 30;
	static int OFFY = 30;
	public static void DrawRegister(InstancePainter painter, int x, int y, int nr_of_bits, boolean has_we,
			RegisterFileData data) {

		Graphics g = painter.getGraphics();
		g.drawRect(x, y , WIDTH, HEIGHT);

		GraphicsUtil.drawCenteredText(g,"CLK",x+WIDTH/4, y+10);
		GraphicsUtil.drawCenteredText(g,"RST",x+2*WIDTH/4, y+10);
		GraphicsUtil.drawCenteredText(g,"WE",x+3*WIDTH/4, y+10);
		
		GraphicsUtil.drawCenteredText(g,"WAD",x+20,y-5+ HEIGHT/3 );
		GraphicsUtil.drawCenteredText(g,"DI",x+20, y-5+2*HEIGHT/3 );
		
		GraphicsUtil.drawCenteredText(g,"DO0",x+WIDTH-20, y-5+HEIGHT/3 );
		GraphicsUtil.drawCenteredText(g,"DO1",x+WIDTH-20, y-5+2*HEIGHT/3 );

		GraphicsUtil.drawCenteredText(g,"RAD0",x+WIDTH/3, y+HEIGHT-15);
		GraphicsUtil.drawCenteredText(g,"RAD1",x+2*WIDTH/3, y+HEIGHT-15);

		
		for (int c = 0; c < 2; c += 1) {
			for (int r = 0; r < 16; r += 1) {
				int locX = x + OFFX_VAL + c*COL_WIDTH;
				int locY = y + OFFY_VAL + ROW_HEIGHT * r;
				int address = 16*c+r;
				g.drawRect(locX+35, locY, 80, ROW_HEIGHT-3);
				g.drawString("R" + address, locX, locY+13);
				String code = Integer.toHexString(data.getValue(address));
				while (code.length() < ((nr_of_bits+1)/4)) {    //pad with 16 0's
	        		code = "0" + code;
	  			}
				g.drawString(code, x + OFFX_VAL + 90 / 2 + c*COL_WIDTH, y + OFFY_VAL+13 + ROW_HEIGHT * r);
			}	
		}
		
		
	}

	public static final int CLK = 0;
	public static final int RST = 1;
	public static final int WE = 2;
	public static final int WAD = 3;
	public static final int DI = 4;
	public static final int DO0 = 5;
	public static final int RAD0 = 6;
	public static final int DO1 = 7;
	public static final int RAD1 = 8;
	
	static final int DELAY = 8;

	static final int Xsize = 60;
	static final int Ysize = 90;

	public static final Attribute<Boolean> ATTR_SHOW_IN_TAB = Attributes
			.forBoolean("showInTab", Strings.getter("registerShowInTab"));
	private static final int ADDR_WIDTH = 5;

	public RegisterFile() {
		super("Register File", Strings.getter("registerFileComponent"));
		setAttributes(new Attribute[] { StdAttr.WIDTH, StdAttr.TRIGGER,
				StdAttr.LABEL, StdAttr.LABEL_FONT, ATTR_SHOW_IN_TAB, },
				new Object[] { BitWidth.create(32), StdAttr.TRIG_RISING, "",
						StdAttr.DEFAULT_LABEL_FONT, false, });
		setKeyConfigurator(new BitWidthConfigurator(StdAttr.WIDTH));
		
		setOffsetBounds(Bounds.create(0, 0, WIDTH, HEIGHT));
		
		setIconName("register.gif");
		setInstancePoker(RegisterFilePoker.class);
		setInstanceLogger(RegisterFileLogger.class);

		
		ps[CLK]= new Port(WIDTH/4, 0, Port.INPUT, 1);
		ps[RST]= new Port(2*WIDTH/4, 0, Port.INPUT, 1);
		ps[WE]= new Port(3*WIDTH/4, 0, Port.INPUT, 1);
		
		ps[WAD]= new Port(0, HEIGHT/3, Port.INPUT, ADDR_WIDTH);
		ps[DI]= new Port(0, 2*HEIGHT/3, Port.INPUT, StdAttr.WIDTH);
		
		ps[DO0]= new Port(WIDTH, HEIGHT/3, Port.OUTPUT, StdAttr.WIDTH);
		ps[DO1]= new Port(WIDTH, 2*HEIGHT/3, Port.OUTPUT, StdAttr.WIDTH);

		ps[RAD0]= new Port(WIDTH/3, HEIGHT, Port.INPUT, ADDR_WIDTH);
		ps[RAD1]= new Port(2*WIDTH/3, HEIGHT, Port.INPUT, ADDR_WIDTH);


		ps[DO1].setToolTip(Strings.getter("registerQTip"));
		ps[DO0].setToolTip(Strings.getter("registerQTip"));
		ps[DI].setToolTip(Strings.getter("registerDTip"));
		ps[CLK].setToolTip(Strings.getter("registerClkTip"));
		ps[RST].setToolTip(Strings.getter("registerClrTip"));
		ps[WE].setToolTip(Strings.getter("registerEnableTip"));
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
		if (MyHDLGenerator == null) {
			MyHDLGenerator = new RegisterHDLGeneratorFactory();
		}
		return MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs);
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		RegisterFileData state = (RegisterFileData) painter.getData();
		BitWidth widthVal = painter.getAttributeValue(StdAttr.WIDTH);
		int width = widthVal == null ? 8 : widthVal.getWidth();
		Location loc = painter.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		// determine text to draw in label
		DrawRegister(painter, x, y, width, true, state);
		painter.drawLabel();

		// draw input and output ports
		for(int i=0;i<ps.length;i++)
			painter.drawPort(i);
	
	}

	@Override
	public void propagate(InstanceState state) {
		RegisterFileData data = (RegisterFileData) state.getData();
		if (data == null) {
			data = new RegisterFileData(ADDR_WIDTH);
			state.setData(data);
		}

		BitWidth dataWidth = state.getAttributeValue(StdAttr.WIDTH);
		Object triggerType = state.getAttributeValue(StdAttr.TRIGGER);
		boolean triggered = data.updateClock(state.getPortValue(CLK),
				triggerType);

		if (state.getPortValue(RST) == Value.TRUE) {
			data.clear();
		} else if (triggered && state.getPortValue(WE) != Value.FALSE) {
			Value in = state.getPortValue(DI);
			Value addr = state.getPortValue(WAD);
			if (in.isFullyDefined()) {
				data.setValue(addr.toIntValue(), in.toIntValue());
			}
		}

		Value addr0 = state.getPortValue(RAD0);
		if (addr0.isFullyDefined()) {
			state.setPort(DO0, Value.createKnown(dataWidth, data.getValue(addr0.toIntValue())), DELAY);
		}
		Value addr1 = state.getPortValue(RAD1);
		if (addr1.isFullyDefined()) {
			state.setPort(DO1, Value.createKnown(dataWidth, data.getValue(addr1.toIntValue())), DELAY);
		}
	}
}