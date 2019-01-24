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
import java.io.File;
import java.io.PrintStream;

import com.bfh.logisim.designrulecheck.CorrectLabel;
import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.Attributes;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Location;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.Instance;
import com.cburch.logisim.instance.InstanceData;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;

import com.cburch.logisim.tools.key.BitWidthConfigurator;
import com.cburch.logisim.util.GraphicsUtil;


public class MysteryMessage extends InstanceFactory {
	
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


	public static final String[] cookie = new String[]{
		"The early bird gets the worm, but the second mouse gets the cheese.\n\n",
		"Be on the alert to recognize your prime at whatever time of your life it may occur.\n\n",
		"Your road to glory will be rocky, but fulfilling.\n\n",
		"Courage is not simply one of the virtues, but the form of every virtue at the testing point.\n\n",
		"Patience is your alley at the moment. Don't worry!\n\n",
		"Nothing is impossible to a willing heart.\n\n",
		"Don’t worry about money. The best things in life are free.\n\n",
		"Don’t pursue happiness – create it.\n\n",
		"Courage is not the absence of fear; it is the conquest of it.\n\n",
		"Nothing is so much to be feared as fear.\n\n",
		"All things are difficult before they are easy.\n\n",
		"The real kindness comes from within you.\n\n",
		"A ship in harbor is safe, but that's not why ships are built.\n\n",
		"you don't need strength to let go of something. What you really need is understanding.\n\n",
		"if you want the rainbow, you have to tolerate the rain.\n\n",
		"Fear is interest paid on a debt you may not owe.\n\n",
		"Hardly anyone knows how much is gained by ignoring the future.\n\n",
		"The wise man is the one that makes you think that he is dumb.\n\n",
		"The usefulness of a cup is in its emptiness.\n\n",
		"He who throws mud loses ground.\n\n"
	};

	static final int DELAY = 8;
	static final int TX = 0;
	public static final int CK = 1;
	static final int CLR = 2;
	static final int Xsize = 160;
	static final int Ysize = 80;

	static final int W = Xsize;
	static final int H = Ysize;

	public static final Attribute<Boolean> ATTR_SHOW_IN_TAB = Attributes
			.forBoolean("showInTab", Strings.getter("registerShowInTab"));

	public static final Attribute<String> FILENAME = Attributes.forString("filename",Strings.getter("stdFilenameAttr"));
	public static final Attribute<String> FORMAT = Attributes.forString("filename",Strings.getter("stdFilenameAttr"));

	public MysteryMessage() {
		super("MysteryMessage", Strings.getter("mysteryMessageComponent"));
		
		
		setAttributes(
				new Attribute[] { 
					StdAttr.LABEL, 
					StdAttr.LABEL_FONT, 
					ATTR_SHOW_IN_TAB, 
				}, 
				new Object[] { 
					"",
					StdAttr.DEFAULT_LABEL_FONT, 
					false, 
				}
		);
//		setKeyConfigurator(new BitWidthConfigurator(StdAttr.WIDTH));
		setOffsetBounds(Bounds.create(0, 0, Xsize, Ysize));
		setIconName("mysteryMessage.gif");

		Port[] ps = new Port[3];
		ps[TX] = new Port(W, 10, Port.OUTPUT, 1);
		ps[CK] = new Port(0, 10, Port.INPUT, 1);
		ps[CLR] = new Port(0, 30, Port.INPUT, 1);
		ps[TX].setToolTip(Strings.getter("Donnée série"));
		ps[CK].setToolTip(Strings.getter("registerClkTip"));
		ps[CLR].setToolTip(Strings.getter("registerClrTip"));
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
		return null;
	}

	@Override
	public boolean HDLSupportedComponent(String HDLIdentifier,AttributeSet attrs) {
		return false;
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		MysteryEmitterData state = (MysteryEmitterData) painter.getData();
		Location loc = painter.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		// determine text to draw in label
		String a;
		
		int wid = 16;
		int xoff = 30;
		Graphics g = painter.getGraphics();

		g.setColor(Color.WHITE);
		
		g.fillRect(x , y , W, H);
		g.setColor(Color.black);
		String value = ""; //Integer.toBinaryString(state.c+0x100).substring(0,8);
		
		GraphicsUtil.drawCenteredText(g, "Mystery Machine", x + W/2, y + H/2-10);
		GraphicsUtil.drawCenteredText(g, "("+state.state.toString()+":'"+value+"')", x + W/2, y + H/2+7);
		//GraphicsUtil.drawCenteredText(g, "("+state.state.toString()+")", x + W/2, y + H/2+7);
		g.setColor(Color.black);

		GraphicsUtil.switchToWidth(g, 2);
		g.drawRect(x , y , W, H);
		
		painter.drawLabel();

		// draw input and output ports
		painter.drawPort(TX);
		painter.drawPort(CLR);
		painter.drawPort(CK);

	}

	enum State {IDLE, WAIT,START, DATA, PARITY, STOP, WAIT_OUT};

	class MysteryEmitterData extends ClockState implements InstanceData {
		
		
		String message;
		int offset;
		public State state;
		int pos = 0;
		int wait=0;
		int error=0;
		int parity;
		char c=0;
		public MysteryEmitterData() {
			state=State.IDLE;
			message = MysteryMessage.cookie[(int) (MysteryMessage.cookie.length*Math.random())];
		}

		public void reset() {
			offset= 0;
			pos= 0; 
			error = 0;
			state =State.IDLE;
		}
		static final boolean DEBUG= true;
		public Value output() {
			int output = 0;
			c=message.charAt(offset);
			//if (DEBUG) c=0xF0; 
			switch (state) {
				case IDLE : 
					state = State.WAIT;
					wait= (int) (6+ 3*(Math.random()));
					break;
				
				case WAIT:
					if (wait==0) {
						state = State.START;
					} else {
						wait--;
					}
					break;
				case START:
					state = State.DATA;
					parity = 0;
					break;
				case DATA:
					parity = parity^output;
					if (pos==7) {
						state = State.PARITY;
						pos=0;
					} else {
						pos++;
					}
					break;
				case PARITY:
					state = State.STOP;
					break;
				case STOP:
					state = State.WAIT_OUT;
					wait = 3;
					break;
				case WAIT_OUT:
					wait--;
					if(wait==0) {
						state = State.IDLE;
						offset++;
						if (offset>=message.length()) {
							message = MysteryMessage.cookie[(int) (MysteryMessage.cookie.length*Math.random())];
							offset=0;
						}
					}
					break;
			
			}
			
			switch (state) {
			case IDLE : 
				output=1;
				break;
			case WAIT:
				output=1;
				break;
			case START:
				output=0;
				break;
			case DATA:
				output=(c>>pos)&1;
				break;
			case PARITY:
				output=parity;
				break;
			case STOP:
				output=1;
				break;
			case WAIT_OUT:
				output=1;
				break;
			}
//			if(Math.random()<0.005) {
//				output = 1- output;
//			}
			return Value.createKnown(BitWidth.ONE, output);
		}

	}	
	@Override
	public void propagate(InstanceState state) {
		MysteryEmitterData data = (MysteryEmitterData) state.getData();
		if (data == null) {
			data = new MysteryEmitterData();
			state.setData(data);
		}
		boolean triggered = data.updateClock(state.getPortValue(CK),StdAttr.TRIG_RISING);

		if (state.getPortValue(CLR) == Value.TRUE) {
			data.reset();
		} else if (triggered ) {
			state.setPort(TX, data.output(), Memory.DELAY);
		}

	}
}