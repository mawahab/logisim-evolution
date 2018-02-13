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

import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeOption;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.Attributes;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.Instance;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.std.wiring.DurationAttribute;
import com.cburch.logisim.util.GraphicsUtil;

// TODO repropagate when rows/cols change

public class VGAConsole extends InstanceFactory {
	final static int rows=40;
	final static int cols=80;
	
	static final Attribute<Integer> ATTR_PERSIST = new DurationAttribute(
			"persist", Strings.getter("ioMatrixPersistenceAttr"), 0,
			Integer.MAX_VALUE);

	public VGAConsole() {
		super("VGAConsole", Strings.getter("vgaConsoleComponent"));
		setIconName("vgaconsole.gif");
	}

	@Override
	protected void configureNewInstance(Instance instance) {
		instance.addAttributeListener();
		updatePorts(instance);
	}

	@Override
	public Bounds getOffsetBounds(AttributeSet attrs) {
		return Bounds.create(-5, -10 * rows, 10 * cols, 10 * rows);
	}

	private VGAConsoleState getState(InstanceState state) {

		VGAConsoleState data = (VGAConsoleState) state.getData();
		if (data == null) {
			data = new VGAConsoleState(rows, cols);
			state.setData(data);
		} 
		return data;
	}

	@Override
	protected void instanceAttributeChanged(Instance instance, Attribute<?> attr) {
		instance.recomputeBounds();
		updatePorts(instance);
	}

	@Override
	public void paintInstance(InstancePainter painter) {

		VGAConsoleState data = getState(painter);
		Bounds bds = painter.getBounds();
		Graphics g = painter.getGraphics();
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				int x = bds.getX() + 10 * i;
				int y = bds.getY() + 10 * j;
				Value val = data.get(j, i);
				g.drawString(""+new Character((char)val.toIntValue()), x, y);
			}
		}
		g.setColor(Color.BLACK);
		GraphicsUtil.switchToWidth(g, 2);
		g.drawRect(bds.getX(), bds.getY(), bds.getWidth(), bds.getHeight());
		GraphicsUtil.switchToWidth(g, 1);
		painter.drawPorts();
	}

	@Override
	public void propagate(InstanceState state) {
		long clock = state.getTickCount();

		VGAConsoleState data = getState(state);
		
//		if (type == INPUT_ROW) {
//			for (int i = 0; i < rows; i++) {
//				data.setRow(i, state.getPortValue(i), persist);
//			}
//		} else if (type == INPUT_COLUMN) {
//			for (int i = 0; i < cols; i++) {
//				data.setColumn(i, state.getPortValue(i), persist);
//			}
//		} else if (type == INPUT_SELECT) {
//			data.setSelect(state.getPortValue(1), state.getPortValue(0),
//					persist);
//		} else {
			throw new RuntimeException("unexpected matrix type");
//		}
	}

	private void updatePorts(Instance instance) {
		Port[] ps;
		ps = new Port[] { 
				// ocrx
				new Port(0, 20, Port.INPUT, 8),
				// ocry
				new Port(0, 40, Port.INPUT, 8), 
				// octl
				new Port(0, 60, Port.INPUT, 8), 
				// clk
				new Port(100, 20, Port.INPUT, 1), 
				// reset
				new Port(100, 40, Port.INPUT, 1), 
				// hsync
				new Port(100, 60, Port.INPUT, 1), 
				// vsync
				new Port(100, 80, Port.INPUT, 1), 
				// R
				new Port(100, 100, Port.INPUT, 8), 
				// G
				new Port(100, 120, Port.INPUT, 8), 
				// B
				new Port(100, 140, Port.INPUT, 8)
		};
		instance.setPorts(ps);
	}
}
