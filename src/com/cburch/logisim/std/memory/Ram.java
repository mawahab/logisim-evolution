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
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.JLabel;

import com.bfh.logisim.designrulecheck.CorrectLabel;
import com.cburch.logisim.circuit.CircuitState;
import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Location;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.gui.hex.HexFile;
import com.cburch.logisim.gui.hex.HexFrame;
import com.cburch.logisim.gui.main.Frame;
import com.cburch.logisim.instance.Instance;
import com.cburch.logisim.instance.InstanceLogger;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.proj.Project;
import com.cburch.logisim.util.GraphicsUtil;

import static  com.cburch.logisim.util.GraphicsUtil.*;

public class Ram extends Mem {

	private static final int WE_OFFSET = 150;
	private static final int CLK_OFFSET = 170;

	static class ContentsAttribute extends Attribute<MemContents> {

		public ContentsAttribute() {
			super("contents", Strings.getter("romContentsAttr"));
		}

		@Override
		public java.awt.Component getCellEditor(Window source, MemContents value) {
			ContentsCell ret = new ContentsCell(source, value);
			ret.mouseClicked(null);
			return ret;
		}

		public MemContents parse(String value) {
			int lineBreak = value.indexOf('\n');
			String first = lineBreak < 0 ? value : value
					.substring(0, lineBreak);
			String rest = lineBreak < 0 ? "" : value.substring(lineBreak + 1);
			StringTokenizer toks = new StringTokenizer(first);
			try {
				String header = toks.nextToken();
				if (!header.equals("addr/data:")) {
					return null;
				}
				int addr = Integer.parseInt(toks.nextToken());
				int data = Integer.parseInt(toks.nextToken());
				MemContents ret = MemContents.create(addr, data);
				HexFile.open(ret, new StringReader(rest));
				return ret;
			} catch (IOException e) {
				return null;
			} catch (NumberFormatException e) {
				return null;
			} catch (NoSuchElementException e) {
				return null;
			}
		}

		@Override
		public String toDisplayString(MemContents value) {
			return Strings.get("romContentsValue");
		}

		@Override
		public String toStandardString(MemContents state) {
			int addr = state.getLogLength();
			int data = state.getWidth();
			StringWriter ret = new StringWriter();
			ret.write("addr/data: " + addr + " " + data + "\n");
			try {
				HexFile.save(ret, state);
			} catch (IOException e) {
			}
			return ret.toString();
		}
	}

	@SuppressWarnings("serial")
	private static class ContentsCell extends JLabel implements MouseListener {

		Window source;
		MemContents contents;

		ContentsCell(Window source, MemContents contents) {
			super(Strings.get("romContentsValue"));
			this.source = source;
			this.contents = contents;
			addMouseListener(this);
		}

		public void mouseClicked(MouseEvent e) {
			if (contents == null) {
				return;
			}
			Project proj = source instanceof Frame ? ((Frame) source)
					.getProject() : null;
			HexFrame frame = RamAttributes.getHexFrame(contents, proj);
			frame.setVisible(true);
			frame.toFront();
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}

	public static class Logger extends InstanceLogger {

		@Override
		public String getLogName(InstanceState state, Object option) {
			String Label = state.getAttributeValue(StdAttr.LABEL);
			if (Label.equals("")) {
				Label = null;
			}
			if (option instanceof Integer) {
				String disp = Strings.get("ramComponent");
				Location loc = state.getInstance().getLocation();
				return (Label == null) ? disp + loc + "[" + option + "]"
						: Label + "[" + option + "]";
			} else {
				return Label;
			}
		}

		@Override
		public Object[] getLogOptions(InstanceState state) {
			int addrBits = state.getAttributeValue(ADDR_ATTR).getWidth();
			if (addrBits >= logOptions.length) {
				addrBits = logOptions.length - 1;
			}
			synchronized (logOptions) {
				Object[] ret = logOptions[addrBits];
				if (ret == null) {
					ret = new Object[1 << addrBits];
					logOptions[addrBits] = ret;
					for (int i = 0; i < ret.length; i++) {
						ret[i] = Integer.valueOf(i);
					}
				}
				return ret;
			}
		}

		@Override
		public Value getLogValue(InstanceState state, Object option) {
			if (option instanceof Integer) {
				MemState s = (MemState) state.getData();
				int addr = ((Integer) option).intValue();
				return Value.createKnown(BitWidth.create(s.getDataBits()), s
						.getContents().get(addr));
			} else {
				return Value.NIL;
			}
		}
	}

	public static int ByteEnableIndex(AttributeSet Attrs) {
		Object trigger = Attrs.getValue(StdAttr.TRIGGER);
		boolean asynch = trigger.equals(StdAttr.TRIG_HIGH)
				|| trigger.equals(StdAttr.TRIG_LOW);
		Object bus = Attrs.getValue(RamAttributes.ATTR_DBUS);
		boolean separate = bus == null ? false : bus
				.equals(RamAttributes.BUS_SEP);
		Object be = Attrs.getValue(RamAttributes.ATTR_ByteEnables);
		boolean byteEnables = be == null ? false : be
				.equals(RamAttributes.BUS_WITH_BYTEENABLES);
		if (byteEnables) {
			int ByteEnableIndex = (asynch) ? (separate) ? AByEnSep : AByEnBiDir
					: (separate) ? SByEnSep : SByEnBiDir;
			return ByteEnableIndex;
		}
		return -1;
	}

	public static int GetNrOfByteEnables(AttributeSet Attrs) {
		int NrOfBits = Attrs.getValue(Mem.DATA_ATTR).getWidth();
		return (NrOfBits + 7) / 8;
	}

	public static Attribute<MemContents> CONTENTS_ATTR = new ContentsAttribute();
	static final int WE = MEM_INPUTS + 0;
	public static final int CLK = MEM_INPUTS + 1;
	static final int SDIN = MEM_INPUTS + 2;
	static final int ADIN = MEM_INPUTS + 1;

	static final int AByEnBiDir = MEM_INPUTS + 2;
	static final int AByEnSep = MEM_INPUTS + 3;
	static final int SByEnBiDir = MEM_INPUTS + 3;
	static final int SByEnSep = MEM_INPUTS + 4;
	
	private static final int CONTROL_HEIGHT = 0;
	private static final int ADDR_OFFSET = 40;

	private static Object[][] logOptions = new Object[9][];

	
	
	public Ram() {
		super("RAM", Strings.getter("ramComponent"), 3);
		setOffsetBounds(Bounds.create(-20, -20, SymbolWidth, SymbolHeight-40));
		setIconName("ram.gif");
		setInstanceLogger(Logger.class);
		setInstancePoker(RamPoker.class);

	}

	@Override
	protected void configureNewInstance(Instance instance) {
		super.configureNewInstance(instance);
		instance.addAttributeListener();
	}

	@Override
	void configurePorts(Instance instance) {

		Port[] ps = new Port[5];
		ps[ADDR] = new Port(0, 40, Port.INPUT, ADDR_ATTR);
		ps[ADDR].setToolTip(Strings.getter("memAddrTip"));
		ps[WE] = new Port(0, WE_OFFSET, Port.INPUT, 1);
		ps[WE].setToolTip(Strings.getter("ramWETip"));
		ps[CLK] = new Port(0, CLK_OFFSET, Port.INPUT, 1);
		ps[CLK].setToolTip(Strings.getter("ramClkTip"));
//		ps[SDIN] = new Port(20+(SymbolWidth/15)*10, SymbolHeight+20, Port.INPUT, DATA_ATTR);
		ps[SDIN] = new Port(20+SymbolWidth, 20+(SymbolHeight/30)*10, Port.INPUT, DATA_ATTR);
		ps[SDIN].setToolTip(Strings.getter("ramInTip"));
//		ps[DATA] = new Port(20+(SymbolWidth/30)*10, SymbolHeight+20, Port.OUTPUT, DATA_ATTR);
		ps[DATA] = new Port(20+SymbolWidth, 20+(SymbolHeight/15)*10, Port.OUTPUT, DATA_ATTR);
		ps[DATA].setToolTip(Strings.getter("memDataTip"));
		instance.setPorts(ps);
	}

	@Override
	public AttributeSet createAttributeSet() {
		return new RamAttributes();
	}




	public int getControlHeight(AttributeSet attrs) {
		return CONTROL_HEIGHT;
	}

	@Override
	public String getHDLName(AttributeSet attrs) {
		StringBuffer CompleteName = new StringBuffer();
		CompleteName.append(CorrectLabel.getCorrectLabel(attrs
				.getValue(StdAttr.LABEL)));
		if (CompleteName.length() == 0) {
			CompleteName.append("RAM");
		}
		return CompleteName.toString();
	}

	@Override
	HexFrame getHexFrame(Project proj, Instance instance, CircuitState circState) {
		return RamAttributes.getHexFrame(
				instance.getAttributeValue(CONTENTS_ATTR), proj);
	}

	@Override
	public Bounds getOffsetBounds(AttributeSet attrs) {
		return Bounds.create(0, 0, SymbolWidth+20, SymbolHeight);
	}

	@Override
	MemState getState(Instance instance, CircuitState state) {
		RamState ret = (RamState) instance.getData(state);
		if (ret == null) {
			MemContents contents = instance
					.getAttributeValue(Ram.CONTENTS_ATTR);
			ret = new RamState(instance, contents, new MemListener(instance));
			instance.setData(state, ret);
		} else {
			ret.setRam(instance);
		}
		return ret;
	}

	@Override
	MemState getState(InstanceState state) {
		RamState ret = (RamState) state.getData();
		if (ret == null) {
			MemContents contents = state.getInstance().getAttributeValue(
					Ram.CONTENTS_ATTR);
			Instance instance = state.getInstance();
			ret = new RamState(instance, contents, new MemListener(instance));
			state.setData(ret);
		} else {
			ret.setRam(state.getInstance());
		}
		return ret;
	}

	@Override
	public boolean HDLSupportedComponent(String HDLIdentifier,
			AttributeSet attrs) {
		if (MyHDLGenerator == null) {
			MyHDLGenerator = new RamHDLGeneratorFactory();
		}
		return MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs);
	}

	@Override
	protected void instanceAttributeChanged(Instance instance, Attribute<?> attr) {
		super.instanceAttributeChanged(instance, attr);
		if ((attr == Mem.DATA_ATTR) || (attr == RamAttributes.ATTR_DBUS)
				|| (attr == StdAttr.TRIGGER)
				|| (attr == RamAttributes.ATTR_ByteEnables)) {
			if ((attr == Mem.DATA_ATTR) || (attr == StdAttr.TRIGGER)) {
				boolean disable_due_to_bits = instance.getAttributeValue(
						Mem.DATA_ATTR).getWidth() < 9;
				boolean disable_due_to_async = instance.getAttributeValue(
						StdAttr.TRIGGER).equals(StdAttr.TRIG_HIGH)
						|| instance.getAttributeValue(StdAttr.TRIGGER).equals(
								StdAttr.TRIG_LOW);
				if (disable_due_to_bits || disable_due_to_async) {
					if (!instance.getAttributeValue(
							RamAttributes.ATTR_ByteEnables).equals(
							RamAttributes.BUS_WITHOUT_BYTEENABLES)) {
						instance.getAttributeSet().setValue(
								RamAttributes.ATTR_ByteEnables,
								RamAttributes.BUS_WITHOUT_BYTEENABLES);
						super.instanceAttributeChanged(instance,
								RamAttributes.ATTR_ByteEnables);
					}
					instance.setAttributeReadOnly(
							RamAttributes.ATTR_ByteEnables, true);
					super.instanceAttributeChanged(instance,
							RamAttributes.ATTR_ByteEnables);
					instance.setAttributeReadOnly(
							RamAttributes.ATTR_ByteEnables, true);
					super.instanceAttributeChanged(instance,
							RamAttributes.ATTR_ByteEnables);
				} else {
					if (instance.getAttributeSet().isReadOnly(
							RamAttributes.ATTR_ByteEnables)) {
						instance.setAttributeReadOnly(
								RamAttributes.ATTR_ByteEnables, false);
						super.instanceAttributeChanged(instance,
								RamAttributes.ATTR_ByteEnables);
					}
				}
			}
			instance.recomputeBounds();
			configurePorts(instance);
		}
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		Graphics g = painter.getGraphics();
		Bounds bds = painter.getBounds();

		//g.setColor(Color.GREEN);
		//g.drawRect(bds.getX()-2, bds.getY()-2, bds.getWidth(), bds.getHeight());
		//painter.drawBounds();
		//g.setColor(Color.BLACK);
		String Label = painter.getAttributeValue(StdAttr.LABEL);
		if (Label != null) {
			Font font = g.getFont();
			g.setFont(painter.getAttributeValue(StdAttr.LABEL_FONT));
			drawCenteredText(g, Label, bds.getX() + bds.getWidth()
					/ 2, bds.getY() - g.getFont().getSize());
			g.setFont(font);
		}
		int x = bds.getX();
		int y = bds.getY();

		switchToWidth(g, 2);
		int memDepth = painter.getAttributeValue(Mem.ADDR_ATTR).getWidth();
		int memWordwidth = painter.getAttributeValue(Mem.DATA_ATTR).getWidth();
		
		String memLabel = "RAM "+ GetSizeLabel(memDepth)+ " x "+ memWordwidth;
		drawCenteredText(g, memLabel, x+ (SymbolWidth / 2) + 20, y + 28);
		//g.setColor(Color.RED);
		g.drawRect(x+20, y+20, SymbolWidth-20, SymbolHeight-20);
		
		switchToWidth(g, 2);
		g.drawLine(x, y + CLK_OFFSET, x+20, y + CLK_OFFSET);
		drawText(g, "Clk", x + 33, y + CLK_OFFSET,H_LEFT, V_CENTER);
		painter.drawClockSymbol(x+20, y + CLK_OFFSET);
		painter.drawPort(CLK);
	
		switchToWidth(g, 2);
		g.drawLine(x, y + WE_OFFSET, x+20, y + WE_OFFSET);
		drawText(g, "WE", x + 23, y + WE_OFFSET, H_LEFT, V_CENTER);
		painter.drawPort(WE);

		switchToWidth(g, 4);
		g.drawLine(x, y + ADDR_OFFSET, x+20, y + ADDR_OFFSET);
		drawText(g, "AD", x + 23, y+ADDR_OFFSET ,H_LEFT, V_CENTER);
		painter.drawPort(ADDR);
		
//		int x1 = x+20+(SymbolWidth/15)*10;
//		drawText(g, "DIn", x1, y+SymbolHeight-20,H_CENTER, V_TOP);
//		g.drawLine(x1, y+SymbolHeight, x1, y+SymbolHeight+20);
		int y1 = y+20+(SymbolWidth/30)*10;
		drawText(g, "DIn", x+SymbolWidth+20, y1,H_CENTER, V_TOP);
		g.drawLine(x+SymbolWidth, y1, x+SymbolWidth+20, y1);
		painter.drawPort(SDIN);


		int y2 = y+20+(SymbolWidth/15)*10;
		drawText(g, "DOut", x+SymbolWidth+20, y2,H_CENTER, V_TOP);
		g.drawLine(x+SymbolWidth, y2, x+SymbolWidth+20, y2);
//		int x2 = x+20+(SymbolWidth/30)*10;
//		drawText(g, "DOut", x2, y+SymbolHeight-20,H_CENTER, V_TOP);
//		g.drawLine(x2, y+SymbolHeight, x2, y+SymbolHeight+20);

		painter.drawPort(DATA);
		switchToWidth(g, 2);
	
		RamState state = (RamState) getState(painter);
		state.paint2(painter.getGraphics(), x+15, y+45,true, (SymbolHeight-80)/18);
	}

	@Override
	public void propagate(InstanceState state) {
		RamState myState = (RamState) getState(state);
		Object trigger = state.getAttributeValue(StdAttr.TRIGGER);
		boolean triggered = myState.setClock(state.getPortValue(CLK), trigger);;
		BitWidth dataBits = state.getAttributeValue(DATA_ATTR);
		/* Set the outputs in tri-state in case of combined bus */
		if (!triggered) {
			state.setPort(DATA,
					Value.createKnown(dataBits, myState.GetCurrentData()),
					DELAY);
		}
		if (triggered) {
			Object be = state.getAttributeValue(RamAttributes.ATTR_ByteEnables);
			boolean byteEnables = be == null ? false : be
					.equals(RamAttributes.BUS_WITH_BYTEENABLES);
			int NrOfByteEnables = GetNrOfByteEnables(state.getAttributeSet());
			int ByteEnableIndex = ByteEnableIndex(state.getAttributeSet());
			boolean shouldStore =  state.getPortValue(WE) != Value.FALSE;
			Value addrValue = state.getPortValue(ADDR);
			int addr = addrValue.toIntValue();
			if (!addrValue.isFullyDefined() || addr < 0) {
				return;
			}
			if (addr != myState.getCurrent()) {
				myState.setCurrent(addr);
				myState.scrollToShow(addr);
			}

			if (shouldStore) {
				int dataValue = state.getPortValue(SDIN).toIntValue();
				int memValue = myState.getContents().get(addr);
				if (byteEnables) {
					int mask = 0xFF << (NrOfByteEnables - 1) * 8;
					for (int i = 0; i < NrOfByteEnables; i++) {
						Value bitvalue = state
								.getPortValue(ByteEnableIndex + i);
						boolean disabled = bitvalue == null ? false : bitvalue
								.equals(Value.FALSE);
						if (disabled) {
							dataValue &= ~mask;
							dataValue |= (memValue & mask);
						}
						mask >>= 8;
					}
				}
				myState.getContents().set(addr, dataValue);
			}
			int val = myState.getContents().get(addr);
			int currentValue = myState.GetCurrentData();
			if (byteEnables) {
				int mask = 0xFF << (NrOfByteEnables - 1) * 8;
				for (int i = 0; i < NrOfByteEnables; i++) {
					Value bitvalue = state.getPortValue(ByteEnableIndex + i);
					boolean disabled = bitvalue == null ? false : bitvalue
							.equals(Value.FALSE);
					if (disabled) {
						val &= ~mask;
						val |= (currentValue & mask);
					}
					mask >>= 8;
				}
			}
			myState.SetCurrentData(val);
				state.setPort(DATA, Value.createKnown(dataBits, val), DELAY);
		}
	}

	@Override
	public boolean RequiresNonZeroLabel() {
		return true;
	}
}
