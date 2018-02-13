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

package com.cburch.logisim.std.arith;

import static com.cburch.logisim.util.GraphicsUtil.*;
import static com.cburch.logisim.util.GraphicsUtil.drawText;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.bfh.logisim.designrulecheck.CorrectLabel;
import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Direction;
import com.cburch.logisim.data.Location;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.tools.key.BitWidthConfigurator;
import com.cburch.logisim.util.GraphicsUtil;

public class ALU extends InstanceFactory {
	private static final int ALU_H = 160;
	private static final int SPAN = 10*(ALU_H/40);
	private static final int ALU_W = 80;
	private static final int HSTEP = 10*(ALU_W/40);
	static Value[] computeSum(BitWidth width, Value a, Value b, Value c_in) {
		int w = width.getWidth();
		if (c_in == Value.UNKNOWN || c_in == Value.NIL)
			c_in = Value.FALSE;
		if (a.isFullyDefined() && b.isFullyDefined() && c_in.isFullyDefined()) {
			if (w >= 32) {
				long mask = (1L << w) - 1;
				long ax = (long) a.toIntValue() & mask;
				long bx = (long) b.toIntValue() & mask;
				long cx = (long) c_in.toIntValue() & mask;
				long sum = ax + bx + cx;
				return new Value[] { Value.createKnown(width, (int) sum),
						((sum >> w) & 1) == 0 ? Value.FALSE : Value.TRUE };
			} else {
				int sum = a.toIntValue() + b.toIntValue() + c_in.toIntValue();
				return new Value[] { Value.createKnown(width, sum),
						((sum >> w) & 1) == 0 ? Value.FALSE : Value.TRUE };
			}
		} else {
			Value[] bits = new Value[w];
			Value carry = c_in;
			for (int i = 0; i < w; i++) {
				if (carry == Value.ERROR) {
					bits[i] = Value.ERROR;
				} else if (carry == Value.UNKNOWN) {
					bits[i] = Value.UNKNOWN;
				} else {
					Value ab = a.get(i);
					Value bb = b.get(i);
					if (ab == Value.ERROR || bb == Value.ERROR) {
						bits[i] = Value.ERROR;
						carry = Value.ERROR;
					} else if (ab == Value.UNKNOWN || bb == Value.UNKNOWN) {
						bits[i] = Value.UNKNOWN;
						carry = Value.UNKNOWN;
					} else {
						int sum = (ab == Value.TRUE ? 1 : 0)
								+ (bb == Value.TRUE ? 1 : 0)
								+ (carry == Value.TRUE ? 1 : 0);
						bits[i] = (sum & 1) == 1 ? Value.TRUE : Value.FALSE;
						carry = (sum >= 2) ? Value.TRUE : Value.FALSE;
					}
				}
			}
			return new Value[] { Value.create(bits), carry };
		}
	}

	static final int PER_DELAY = 1;
	private static final int IN0 = 0;
	private static final int IN1 = 1;
	private static final int OUT = 2;
	private static final int C_IN = 3;

	private static final int C_OUT = 4;
	private static final int ZERO = 5;
	private static final int NEG = 6;
	private static final int OP = 7;
	private static final int SLOPE = 20;

	public ALU() {
		super("ALU", Strings.getter("aluComponent"));
		setAttributes(new Attribute[] { StdAttr.WIDTH },
				new Object[] { BitWidth.create(32) });
		setKeyConfigurator(new BitWidthConfigurator(StdAttr.WIDTH));
		setOffsetBounds(Bounds.create(-ALU_W/2, -ALU_H/2, ALU_W, ALU_H));
		setIconName("alu.gif");

		Port[] ps = new Port[8];
		int x0 = ALU_W/2;
		int y0 = ALU_H/2;
		
	
		ps[IN0] = new Port(-x0, -SPAN, Port.INPUT, StdAttr.WIDTH);
		ps[IN1] = new Port(-x0, SPAN, Port.INPUT, StdAttr.WIDTH);
		ps[OUT] = new Port(x0, 0, Port.OUTPUT, StdAttr.WIDTH);
		ps[C_IN] = new Port(-x0+HSTEP, y0, Port.INPUT, 1);
		ps[C_OUT] = new Port(-x0+HSTEP, -y0, Port.OUTPUT, 1);
		ps[ZERO] = new Port(-x0+2*HSTEP, -y0, Port.OUTPUT, 1);
		ps[NEG] = new Port(-x0+3*HSTEP, -y0, Port.OUTPUT, 1);
		ps[OP] = new Port(-x0+3*HSTEP, y0, Port.INPUT, 3);
		
		
		ps[IN0].setToolTip(Strings.getter("aluInputTip"));
		ps[IN1].setToolTip(Strings.getter("aluInputTip"));
		ps[OUT].setToolTip(Strings.getter("aluOutputTip"));
		ps[C_IN].setToolTip(Strings.getter("aluCarryInTip"));
		ps[C_OUT].setToolTip(Strings.getter("aluCarryOutTip"));
		setPorts(ps);
	}

	@Override
	public String getHDLName(AttributeSet attrs) {
		StringBuffer CompleteName = new StringBuffer();
		if (attrs.getValue(StdAttr.WIDTH).getWidth() == 1)
			CompleteName.append("ALU");
		else
			CompleteName.append(CorrectLabel.getCorrectLabel(this.getName()));
		return CompleteName.toString();
	}

	@Override
	public boolean HDLSupportedComponent(String HDLIdentifier,
			AttributeSet attrs) {
		if (MyHDLGenerator == null)
			MyHDLGenerator = new AdderHDLGeneratorFactory();
		return MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs);
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		Graphics g = painter.getGraphics();
		//painter.drawBounds();

		Location loc = painter.getLocation();
		
		int x = loc.getX()-ALU_W/2 ;	
		int y = loc.getY()-ALU_H/2 ;
	
		
		GraphicsUtil.switchToWidth(g, 2);
		//g.drawLine(x-40, y+30, x -20, y+30);
		
		painter.drawPort(IN0);//,"_I0", Direction.EAST);
		drawText(g, "I0", x+5, y+ALU_H/2-SPAN,H_LEFT,V_CENTER);
		//g.drawLine(x-40, y+70, x -20, y+70);
		
		painter.drawPort(IN1);//, "_I1", Direction.EAST);
		drawText(g, "I1", x+5, y+ALU_H/2+SPAN,H_LEFT,V_CENTER);

		
		//g.drawLine(x+20, y+50, x +40, y+50);
		painter.drawPort(OUT);//, "_R", Direction.WEST);
		drawText(g, "R", x+ALU_W-5, y+ALU_H/2,H_RIGHT,V_CENTER);

		
		painter.drawPort(OP);//, "_Op", Direction.SOUTH);
		drawText(g, "Op", x+3*HSTEP, y+ALU_H-20,H_CENTER,V_BOTTOM);
		g.drawLine(x+3*HSTEP,y+ALU_H, x+3*HSTEP, y+ALU_H-15);

		painter.drawPort(C_IN);//, "_Ci", Direction.SOUTH);
		drawText(g, "Ci", x+HSTEP, y+ALU_H-5,H_CENTER,V_BOTTOM);
		g.drawLine(x+HSTEP,y+ALU_H, x+HSTEP, y+ALU_H-5);

		//g.drawLine(x-10, y+7, x-10, y);
		painter.drawPort(C_OUT);//, "_Co", Direction.NORTH);
		drawText(g, "Co", x+HSTEP, y+5,H_CENTER,V_TOP);
		g.drawLine(x+HSTEP,y, x+HSTEP, y+5);
		
		//g.drawLine(x, y+10, x, y);
		painter.drawPort(ZERO);//, "_Z", Direction.NORTH);
		drawText(g, "Z", x+2*HSTEP, y+10,H_CENTER,V_TOP);
		g.drawLine(x+2*HSTEP,y, x+2*HSTEP, y+10);
		
		//g.drawLine(x+10, y+13, x+10, y);
		painter.drawPort(NEG);//, "_N", Direction.NORTH);
		drawText(g, "N", x+3*HSTEP, y+15,H_CENTER,V_TOP);
		g.drawLine(x+3*HSTEP,y, x+3*HSTEP, y+16);
	
		x = loc.getX();
		y = loc.getY();
	
		g.setColor(Color.BLACK);
		Font oldFont = g.getFont();
		g.setFont(oldFont.deriveFont(32).deriveFont(Font.BOLD));
		g.drawString("ALU", x-10, y+5);
		g.setFont(oldFont);
		// Shape
		g.drawString("ALU", x-10, y+5);
		g.drawString("ALU", x-10, y+5);
		

		g.drawLine(x - ALU_W/2, y-ALU_H/2, x +ALU_W/2, y-(ALU_H/2-SLOPE));
		g.drawLine(x - ALU_W/2, y+ALU_H/2, x +ALU_W/2, y+(ALU_H/2-SLOPE));
		g.drawLine(x -ALU_W/2, y-ALU_H/2, x -ALU_W/2 , y+ALU_H/2);
		g.drawLine(x +ALU_W/2, y-(ALU_H/2-SLOPE), x +ALU_W/2 , y+(ALU_H/2-SLOPE));
		
		GraphicsUtil.switchToWidth(g, 1);
	}

	@Override
	public void propagate(InstanceState state) {
		// get attributes
		BitWidth dataWidth = state.getAttributeValue(StdAttr.WIDTH);

		// compute outputs
		Value a = state.getPortValue(IN0);
		Value b = state.getPortValue(IN1);
		Value c_in = state.getPortValue(C_IN);
		Value op = state.getPortValue(OP);
		int in0 = a.toIntValue();
		int in1 = b.toIntValue();
		int carry = c_in.toIntValue();
		long res = 0; 
		switch (op.toIntValue()) {
		case 0: {
			res = in0+in1+carry;
			break;
		}
		case 1: {
			res = in0-in1-carry;
			break;
		}
		case 2: {
			res = ( in0 & in1); 
			break;
		}
		case 3: {
			res = ( in0 | in1); 
			break;
		}
		case 4: {
			res = ( in0 ^ in1); 
			break;
			
		}
		case 5: {
			res = ~( in0 & in1); 
			break;
		}
		case 6: {
			res = in0>>in1;
			break;
		}
		case 7: {
			res = in0+(int)((short)(in1));
			break;
		}
		
		
		}
		if(res<0) {
			//state.setPort(NEG, outs[2], delay);
			state.setPort(NEG, Value.TRUE, PER_DELAY);
			System.out.println("neg! "+res);
		} else {
			state.setPort(NEG, Value.FALSE, PER_DELAY);
		}
		if(res==0) {
			state.setPort(ZERO, Value.TRUE, PER_DELAY);
		} else {
			state.setPort(ZERO, Value.FALSE, PER_DELAY);
			
		}
			
		// propagate them
		int delay = PER_DELAY;
		state.setPort(OUT, Value.createKnown(dataWidth, (int) res), delay);
	
	}

}
