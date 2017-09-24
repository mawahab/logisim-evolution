/** 
 * This file is part of logisim-evolution.
 * logisim-evolution is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * logisim-evolution is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with logisim-evolution.  If not, see <http://www.gnu.org/licenses/>.
 * Original code by Carl Burch (http://www.cburch.com), 2011.
 * Subsequent modifications by :
 * + Haute École Spécialisée Bernoise
 * http://www.bfh.ch
 * + Haute École du paysage, d'ingénierie et d'architecture de Genève
 * http://hepia.hesge.ch/
 * + Haute École d'Ingénierie et de Gestion du Canton de Vaud
 * http://www.heig-vd.ch/
 * The project is currently maintained by :
 * + REDS Institute - HEIG-VD
 * Yverdon-les-Bains, Switzerland
 * http://reds.heig-vd.ch
 */
package com.cburch.logisim.std.memory

import java.awt.Color
import java.awt.Graphics
import org.eclipse.xpand2.XpandExecutionContextImpl.DefinitionOperationAdapter
import com.bfh.logisim.designrulecheck.CorrectLabel
import com.cburch.logisim.data.Attribute
import com.cburch.logisim.data.AttributeOption
import com.cburch.logisim.data.AttributeSet
import com.cburch.logisim.data.Attributes
import com.cburch.logisim.data.BitWidth
import com.cburch.logisim.data.Bounds
import com.cburch.logisim.data.Location
import com.cburch.logisim.data.Value
import com.cburch.logisim.instance.Instance
import com.cburch.logisim.instance.InstanceFactory
import com.cburch.logisim.instance.InstancePainter
import com.cburch.logisim.instance.InstanceState
import com.cburch.logisim.instance.Port
import com.cburch.logisim.instance.StdAttr
import com.cburch.logisim.tools.key.BitWidthConfigurator
import com.cburch.logisim.util.GraphicsUtil
import com.cburch.logisim.util.StringUtil

class CPUCodeMemory extends InstanceFactory {
	public static final int ROW_HEIGHT = 18
	public static final int COL_WIDTH = 130
	public static final int HEIGHT = 360
	public static final int WIDTH = 360
	public static final int OFFX_VAL = 50
	public static final int OFFY_VAL = 40
	package Port[] ps = newArrayOfSize(6)
	static package int OFFX = 30
	static package int OFFY = 30

	def static void DrawRegister(InstancePainter painter, int x, int y, int nr_of_bits, boolean has_we,
		CPUMemoryData data) {
		var Graphics g = painter.getGraphics()
		g.drawRect(x, y, WIDTH, HEIGHT)
		
		
		GraphicsUtil.drawCenteredText(g, "CLK", x + WIDTH / 4, y + 10)
		GraphicsUtil.drawCenteredText(g, "RST", x + 2 * WIDTH / 4, y + 10)
		GraphicsUtil.drawCenteredText(g, "WE", x + 3 * WIDTH / 4, y + 10)
		GraphicsUtil.drawCenteredText(g, "ADDR", x + 20, y - 5 + 2 * HEIGHT / 3)
		GraphicsUtil.drawCenteredText(g, "DI", x + WIDTH - 20, y - 5 + HEIGHT / 3)
		GraphicsUtil.drawCenteredText(g, "DO", x + WIDTH - 20, y - 5 + 2 * HEIGHT / 3)
		for(i:0..3) {
			GraphicsUtil.drawCenteredText(g, "+"+i, x + OFFX_VAL +CELL_WIDTH/2+CELL_WIDTH*i, y + OFFY_VAL )
		}
		for (var int r = 0; r < (1<<ADDR_WIDTH); r += 1) {
			var int locX = x + OFFX_VAL 
			var int locY = y + OFFY_VAL + ROW_HEIGHT * r
			var int address =  r
			
			var String code = Integer.toHexString(address).toUpperCase()
			while (code.length() < ADDR_WIDTH/4) {
				code = '''0«code»'''
			}
			g.drawString('''«code»''', locX, locY )
			for(i:0..3) {
				g.drawRect(locX+35+CELL_WIDTH*i, locY, CELL_WIDTH, ROW_HEIGHT - 3)
				code = Integer.toHexString(data.getValue(address)).toUpperCase()
				while (code.length() < 2) {
					code = '''0«code»'''
				}
				GraphicsUtil.drawCenteredText(g,code, locX +35+CELL_WIDTH/2+CELL_WIDTH*i ,locY+ ROW_HEIGHT/2)
			}
		}


	}

	public static final int CLK = 0
	public static final int RST = 1
	public static final int WE = 2
	public static final int AD = 3
	public static final int DI = 4
	public static final int DO = 5
	static final package int DELAY = 8
	static final package int Xsize = 60
	static final package int Ysize = 90
	
	public static final Attribute<Boolean> ATTR_SHOW_IN_TAB = Attributes.forBoolean("showInTab",
		Strings.getter("registerShowInTab"))
	static final int ADDR_WIDTH = 7
	
	static final int CELL_WIDTH = 30;

	new() {
		super("CPU memory", Strings.getter("cpuMemoryComponent"))
		setAttributes(#[StdAttr.WIDTH, StdAttr.TRIGGER, StdAttr.LABEL, StdAttr.LABEL_FONT, ATTR_SHOW_IN_TAB],
			#[BitWidth.create(32), StdAttr.TRIG_RISING, "", StdAttr.DEFAULT_LABEL_FONT, false])
		setKeyConfigurator(new BitWidthConfigurator(StdAttr.WIDTH))
		setOffsetBounds(Bounds.create(0, 0, WIDTH, HEIGHT))
		setIconName("register.gif")
		setInstancePoker(RegisterFilePoker)
		setInstanceLogger(RegisterFileLogger)
		ps.set(CLK, new Port(WIDTH / 4, 0, Port.INPUT, 1))
		ps.set(RST, new Port(2 * WIDTH / 4, 0, Port.INPUT, 1))
		ps.set(WE, new Port(3 * WIDTH / 4, 0, Port.INPUT, 1))
		ps.set(DI, new Port(0, 2 * HEIGHT / 3, Port.INPUT, StdAttr.WIDTH))
		ps.set(DO, new Port(WIDTH, HEIGHT / 3, Port.OUTPUT, StdAttr.WIDTH))
		ps.set(AD, new Port(WIDTH / 3, HEIGHT, Port.INPUT, ADDR_WIDTH))

		setPorts(ps)
	}

	override protected void configureNewInstance(Instance instance) {
		var Bounds bds = instance.getBounds()
		instance.setTextField(StdAttr.LABEL, StdAttr.LABEL_FONT, bds.getX() + bds.getWidth() / 2, bds.getY() - 3,
			GraphicsUtil.H_CENTER, GraphicsUtil.V_BASELINE)
	}

	override String getHDLName(AttributeSet attrs) {
		var StringBuffer CompleteName = new StringBuffer()
		CompleteName.append(CorrectLabel.getCorrectLabel(this.getName()).toUpperCase())
		return CompleteName.toString()
	}

	override boolean HDLSupportedComponent(String HDLIdentifier, AttributeSet attrs) {
		if (MyHDLGenerator === null) {
			MyHDLGenerator = new RegisterFileHDLGeneratorFactory()
		}
		return MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs)
	}

	override void paintInstance(InstancePainter painter) {
		var CPUMemoryData state = painter.getData() as CPUMemoryData
		var BitWidth widthVal = painter.getAttributeValue(StdAttr.WIDTH)
		var int width = if(widthVal === null) 8 else widthVal.getWidth()
		var Location loc = painter.getLocation()
		var int x = loc.getX()
		var int y = loc.getY()
		// determine text to draw in label
		DrawRegister(painter, x, y, width, true, state)
		painter.drawLabel() // draw input and output ports
		for (var int i = 0; i < ps.length; i++)
			painter.drawPort(i)
	}

	override void propagate(InstanceState state) {
		var CPUMemoryData data = state.getData() as CPUMemoryData
		if (data === null) {
			data = new CPUMemoryData(ADDR_WIDTH)
			state.setData(data)
		}
		var BitWidth dataWidth = state.getAttributeValue(StdAttr.WIDTH)
		var Object triggerType = state.getAttributeValue(StdAttr.TRIGGER)
		var boolean triggered = data.updateClock(state.getPortValue(CLK), triggerType)
		if (state.getPortValue(RST) === Value.TRUE) {
			data.clear()
		} else if (triggered && state.getPortValue(WE) !== Value.FALSE) {
			var Value in = state.getPortValue(DI)
			var Value addr = state.getPortValue(AD)
			if (in.isFullyDefined()) {
				data.setValue(addr.toIntValue(), in.toIntValue() as byte)
			}

		}
		var Value addr0 = state.getPortValue(AD)
		if (addr0.isFullyDefined()) {
			state.setPort(DO, Value.createKnown(dataWidth, data.getValue(addr0.toIntValue())), DELAY)
		}

	}

}
