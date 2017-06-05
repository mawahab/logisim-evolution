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
package com.cburch.logisim.std.io;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.bfh.logisim.fpgaboardeditor.FPGAIOInformationContainer;
import com.bfh.logisim.hdlgenerator.IOComponentInformationContainer;
import com.cburch.draw.shapes.DrawAttr;
import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.Attributes;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Direction;
import com.cburch.logisim.data.Location;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.Instance;
import com.cburch.logisim.instance.InstanceData;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstancePoker;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.util.GraphicsUtil;

public class KeyPad extends InstanceFactory {

	public static class Poker extends InstancePoker {

		@Override
		public void mousePressed(InstanceState state, MouseEvent e) {
			State val = (State) state.getData();
			Location loc = state.getInstance().getLocation();
			Bounds bds = state.getInstance().getBounds();
			int x0 = bds.getX() ;
			int y0 = bds.getY() ;
			int locX = e.getX()-BORDER-x0;
			int locY = e.getY()-BORDER-y0;
			
			int j = locY/ KEY_HEIGHT;
			int i = locX/ KEY_WIDTH;
			
			if (val.isActive(i,j)) {
				val.deActivate(i, j);
			} else {
				val.activate(i, j);
			}
			
			state.getInstance().fireInvalidated();
		}
	}

	private static class State implements InstanceData, Cloneable {

		private boolean matrix[][];
		private int col=-1;

		public State() {
			matrix = new boolean[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					matrix[i][j]=false;
				}
			}
		}


		public boolean isActive(int i, int j) {
			return matrix[i][j];
		}


		public void activate(int i, int j) {
			matrix[i][j]=true;
		}

		public void deActivate(int i, int j) {
			matrix[i][j]=false;
		}

		@Override
		public Object clone() {
			try {
				return super.clone();
			} catch (CloneNotSupportedException e) {
				return null;
			}
		}

	}


	public static final ArrayList<String> GetLabels() {
		ArrayList<String> LabelNames = new ArrayList<String>();
		LabelNames.addAll(GetInputLabels());
		LabelNames.addAll(GetOutputLabels());
		return LabelNames;
	}

	public static final ArrayList<String> GetOutputLabels() {
		ArrayList<String> LabelNames = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			LabelNames.add("L" + Integer.toString(i));
		}
		return LabelNames;
	}
	public static final ArrayList<String> GetInputLabels() {
		ArrayList<String> LabelNames = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			LabelNames.add("C" + Integer.toString(i));
		}
		return LabelNames;
	}
	private static final int KEY_WIDTH = 30;
	private static final int KEY_HEIGHT= 30;
	private static final int BORDER = 20;

	
	public static final int MAX_SWITCH = 32;
	public static final int MIN_SWITCH = 2;

	public static final Attribute<Integer> ATTR_SIZE = Attributes
			.forIntegerRange("number", Strings.getter("nrOfSwitch"),
					MIN_SWITCH, MAX_SWITCH);

	public KeyPad() {
		super("KeyPad", Strings.getter("KeyPadComponent"));
		setAttributes(new Attribute[] { StdAttr.LABEL, Io.ATTR_LABEL_LOC,
				StdAttr.LABEL_FONT, StdAttr.LABEL_COLOR, StdAttr.LABEL_VISIBILITY },
				new Object[] { "", Direction.EAST, StdAttr.DEFAULT_LABEL_FONT,
						StdAttr.DEFAULT_LABEL_COLOR, false });
		setFacingAttribute(StdAttr.FACING);
		setIconName("KeyPad.gif");
		setInstancePoker(Poker.class);
		MyIOInformation = new IOComponentInformationContainer(4, 4, 0,
				GetInputLabels(), GetOutputLabels(), null,
				FPGAIOInformationContainer.IOComponentTypes.KeyPad);
//		MyIOInformation
//				.AddAlternateMapType(FPGAIOInformationContainer.IOComponentTypes.Button);
//		MyIOInformation
//				.AddAlternateMapType(FPGAIOInformationContainer.IOComponentTypes.Pin);
	}

	private void computeTextField(Instance instance) {
		Direction facing = Direction.NORTH;
		Object labelLoc = instance.getAttributeValue(Io.ATTR_LABEL_LOC);

		Bounds bds = instance.getBounds();
		int x = bds.getX() + bds.getWidth() / 2;
		int y = bds.getY() + bds.getHeight() / 2;
		int halign = GraphicsUtil.H_CENTER;
		int valign = GraphicsUtil.V_CENTER;
		if (labelLoc == Direction.NORTH) {
			y = bds.getY() - 2;
			valign = GraphicsUtil.V_BOTTOM;
		} else if (labelLoc == Direction.SOUTH) {
			y = bds.getY() + bds.getHeight() + 2;
			valign = GraphicsUtil.V_TOP;
		} else if (labelLoc == Direction.EAST) {
			x = bds.getX() + bds.getWidth() + 2;
			halign = GraphicsUtil.H_LEFT;
		} else if (labelLoc == Direction.WEST) {
			x = bds.getX() - 2;
			halign = GraphicsUtil.H_RIGHT;
		}
		if (labelLoc == facing) {
			if (labelLoc == Direction.NORTH || labelLoc == Direction.SOUTH) {
				x += 2;
				halign = GraphicsUtil.H_LEFT;
			} else {
				y -= 2;
				valign = GraphicsUtil.V_BOTTOM;
			}
		}

		instance.setTextField(StdAttr.LABEL, StdAttr.LABEL_FONT, x, y, halign,
				valign);
	}

	@Override
	protected void configureNewInstance(Instance instance) {
		instance.addAttributeListener();
		configurePorts(instance);
		computeTextField(instance);
	}

	private void configurePorts(Instance instance) {
		Port[] ps = new Port[8];
		for (int i = 0; i < 8; i++) {
			if(i<4) {
				ps[i] = new Port((i+1 ) * KEY_WIDTH, 0, Port.INPUT, 1);
							
			} else {
				ps[i] = new Port(KEY_WIDTH*4+2*BORDER, (i-4 +1 )* KEY_WIDTH, Port.OUTPUT, 1);
			}
		}
		instance.setPorts(ps);
	}

	@Override
	public Bounds getOffsetBounds(AttributeSet attrs) {
		return Bounds.create(0, 0,
				10 + KEY_WIDTH * 4, 10 + KEY_HEIGHT * 4).rotate(
				Direction.NORTH, Direction.NORTH, 0, 0);
	}

	@Override
	public boolean HDLSupportedComponent(String HDLIdentifier,
			AttributeSet attrs) {
		if (MyHDLGenerator == null) {
			MyHDLGenerator = new KeypadHDLGeneratorFactory();
		}
		return MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs);
	}

	@Override
	protected void instanceAttributeChanged(Instance instance, Attribute<?> attr) {
		if (attr == Io.ATTR_LABEL_LOC) {
			computeTextField(instance);
		} 
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		// FIXME : Render a Keypad object
		State state = (State) painter.getData();
		if (state == null ) {
			state = new State();
			painter.setData(state);
		}
		Bounds bds = painter.getBounds().expand(-1);

		Graphics g = painter.getGraphics();
		GraphicsUtil.switchToWidth(g, 2);

		g.drawRect(bds.getX(), bds.getY(), 2*BORDER+ KEY_WIDTH*4, 2*BORDER+KEY_HEIGHT*4);
		GraphicsUtil.switchToWidth(g, 1);
		
		for (int i=0;i<4; i++) {
			GraphicsUtil.drawCenteredText(g,"C"+i,bds.getX()+KEY_WIDTH/2+i*KEY_WIDTH+BORDER, bds.getY()+BORDER/2);
		}
		for (int i=0;i<4; i++) {
			GraphicsUtil.drawCenteredText(g,"L"+i,bds.getX()+KEY_WIDTH*4+2*BORDER-5, bds.getY()+KEY_HEIGHT/2+i*KEY_WIDTH+BORDER);
		}
		
		//g.drawString(magrux, bds.getX(), bds.getY());
		for (int i=0;i<4; i++) {
			for (int j=0;j<4; j++) {
				int locX = bds.getX()+i*KEY_WIDTH+BORDER;
				int locY = bds.getY()+j*KEY_HEIGHT+BORDER;
				if (state.isActive(i, j)) {
					g.setColor(Color.darkGray);
					g.fillRect(locX, locY, KEY_WIDTH-4, KEY_HEIGHT-4);
					g.setColor(Color.WHITE);
					GraphicsUtil.drawCenteredText(g, Integer.toHexString(4*i+j).toUpperCase(), locX+KEY_WIDTH/2, locY+KEY_HEIGHT/2);
					g.setColor(Color.BLACK);
				} else {
					g.drawRect(locX, locY, KEY_WIDTH-4, KEY_HEIGHT-4);
					GraphicsUtil.drawCenteredText(g, Integer.toHexString(4*i+j).toUpperCase(), locX+KEY_WIDTH/2, locY+KEY_HEIGHT/2);
				}
			}
		}
//		GraphicsUtil.switchToWidth(g, 2);
//		g.setColor(Color.darkGray);
//		g.fillRect(bds.getX(), bds.getY(), bds.getWidth(), bds.getHeight());
//		GraphicsUtil.switchToWidth(g, 1);
//		g.setColor(Color.white);
//		g.setFont(DrawAttr.DEFAULT_FONT);
//		int offset = 0;
//		for (int i = 0; i < painter.getAttributeValue(ATTR_SIZE); i++) {
//			if (i == 9) {
//				g.setFont(g.getFont()
//						.deriveFont(g.getFont().getSize2D() * 0.6f));
//				offset = -2;
//			}
//			g.fillRect(bds.getX() + 6 + (i * 10), bds.getY() + 15, 6, 20);
//			g.drawChars(Integer.toString(i + 1).toCharArray(), 0, Integer
//					.toString(i + 1).toCharArray().length, bds.getX() + 5
//					+ offset + i * 10, bds.getY() + 12);
//		}
//		g.setColor(Color.lightGray);
//		for (int i = 0; i < painter.getAttributeValue(ATTR_SIZE); i++) {
//			int ypos = (state.BitSet(i)) ? bds.getY() + 16 : bds.getY() + 25;
//			g.fillRect(bds.getX() + 7 + (i * 10), ypos, 4, 9);
//		}
		painter.drawLabel();
		painter.drawPorts();

	}

	@Override
	public void propagate(InstanceState state) {
		State pins = (State) state.getData();
		// FIXME
		if (pins == null) {
			pins = new State();
			state.setData(pins);
		}

		for (int row = 0; row < 4; row++) {
			Value pinstate =Value.FALSE;
			for (int col = 0; col < 4; col++) {
				if(pins.isActive(col, row) && (state.getPortValue(col)==Value.TRUE)) {
					pinstate = Value.TRUE ;
				}
			}
			state.setPort(row+4, pinstate, 1);
		}
	}

	@Override
	public boolean RequiresNonZeroLabel() {
		return true;
	}
}
