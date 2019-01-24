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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;


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

public class RegisterFile extends InstanceFactory {
	
	public static final int ROW_HEIGHT = 18;

	public static final int COL_WIDTH = 130;

	public  static final int HEIGHT = 220;

	public  static final int WIDTH = 240;
	
	public  static final int OFFX_VAL = 30;
	public  static final int OFFY_VAL = 35;

	public  static final int UP_X = OFFX_VAL+25;
	public  static final int UP_Y = OFFY_VAL;

	public  static final int DOWN_X = UP_X;

	private static final int NB_ROW = 8;
	public  static final int DOWN_Y = UP_Y+(NB_ROW-1)*ROW_HEIGHT+5;

	
	Port[] ps = new Port[9];
	
	public static void DrawRegister(InstancePainter painter, int x, int y, int nr_of_bits, boolean has_we,
			RegisterFileData data) {

		Graphics g = painter.getGraphics();
		GraphicsUtil.switchToWidth(g, 2);
		g.drawRect(x, y , WIDTH, HEIGHT);
		GraphicsUtil.switchToWidth(g, 1);
		
		GraphicsUtil.drawCenteredText(g,"Register File 32x32",x+WIDTH/2, y+10);

		GraphicsUtil.drawCenteredText(g,"CLK",x+15, y+30);
		GraphicsUtil.drawCenteredText(g,"RST",x+15, y+60);

		GraphicsUtil.drawCenteredText(g,"DI",x+15, y+120 );
		GraphicsUtil.drawCenteredText(g,"WE",x+15, y+160);

		GraphicsUtil.drawCenteredText(g,"DO0",x+WIDTH-20, y+80 );
		GraphicsUtil.drawCenteredText(g,"DO1",x+WIDTH-20, y+HEIGHT-80);

		GraphicsUtil.drawCenteredText(g,"WAD" ,x+40,  y+HEIGHT-15);
		GraphicsUtil.drawCenteredText(g,"RAD0",x+120, y+HEIGHT-15);
		GraphicsUtil.drawCenteredText(g,"RAD1",x+180, y+HEIGHT-15);

		
		
		drawRegValues(g, x+OFFX_VAL+40, y+OFFY_VAL, data.getOffset(), NB_ROW, nr_of_bits, has_we, data);
		drawTriangle(g, x + UP_X, y +UP_Y, 15, 15, false);
		drawTriangle(g, x + DOWN_X, y +DOWN_Y, 15, 15, true);
		g.fillRect(x+ UP_X+5, y+UP_Y+9, 4, DOWN_Y-UP_Y-5);
		
		
	}
	
	static void  drawRegValues(Graphics g,  int x, int y,int offset, int nvalues, int nr_of_bits, boolean has_we,
			RegisterFileData data) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x-20, y-4, 140, nvalues*ROW_HEIGHT+8);
		g.setColor(Color.black);
		for (int r = offset; r < Math.min(offset+nvalues, data.value.length-1); r += 1) {
			int locY = y + ROW_HEIGHT * (r-offset);
			int address = r;
			String code = getPaddedBinary(nr_of_bits, data, address);
			if(data.lastRegEvent!=r) {
				g.drawRect(x+30, locY, 80, ROW_HEIGHT-3);
				g.drawString("R" + address, x+5, locY+13);
				g.drawString(code, x +37, locY +13);
			} else {
				g.setColor(Color.RED);
				g.drawRect(x+30, locY, 80, ROW_HEIGHT-3);
				g.drawString("R" + address, x+5, locY+13);
				Font oldfont = g.getFont();
				g.setFont(oldfont.deriveFont(Font.BOLD));
				g.drawString(code, x +35, locY +13);
				g.setFont(oldfont);
				g.setColor(Color.black);
			}
		}
	}

	private static String getPaddedBinary(int nr_of_bits, RegisterFileData data, int address) {
		String code = Integer.toHexString(data.getValue(address)).toUpperCase();
		while (code.length() < ((nr_of_bits+1)/4)) {    //pad with 16 0's
			code = "0" + code;
		}
		return code;
	}
	static void  drawTriangle(Graphics g, int x, int y, int w, int h, boolean reverse) {
		
		if (reverse) {
			g.fillPolygon(new Polygon(new int[] {x, x+w/2, x+w}, new int[] {y, y + h, y }, 3));
		} else {
			g.fillPolygon(new Polygon(new int[] {x, x+w/2, x+w}, new int[] {y+h, y, y+h}, 3));
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

		ps[CLK]= new Port(0, 30, Port.INPUT, 1);
		ps[RST]= new Port(0, 60, Port.INPUT, 1);

		ps[DI]= new Port(0, 120, Port.INPUT, StdAttr.WIDTH);
		ps[WE]= new Port(0, 160, Port.INPUT, 1);
		
		
		ps[DO0]= new Port(WIDTH, 80, Port.OUTPUT, StdAttr.WIDTH);
		ps[DO1]= new Port(WIDTH, HEIGHT-80, Port.OUTPUT, StdAttr.WIDTH);

		ps[WAD]= new Port(40, HEIGHT, Port.INPUT, ADDR_WIDTH);
		ps[RAD0]= new Port(120, HEIGHT, Port.INPUT, ADDR_WIDTH);
		ps[RAD1]= new Port(180, HEIGHT, Port.INPUT, ADDR_WIDTH);


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
		return CompleteName.toString();
	}

	@Override
	public boolean HDLSupportedComponent(String HDLIdentifier,
			AttributeSet attrs) {
		if (MyHDLGenerator == null) {
			MyHDLGenerator = new RegisterFileHDLGeneratorFactory();
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
			data.lastRegEvent=-1;
			Value in = state.getPortValue(DI);
			Value addr = state.getPortValue(WAD);
			if (in.isFullyDefined()) {
				int intAddr = addr.toIntValue();
				data.lastRegEvent=intAddr;
				data.setValue(intAddr, in.toIntValue());
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