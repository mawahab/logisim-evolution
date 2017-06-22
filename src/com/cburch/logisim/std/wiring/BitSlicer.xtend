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
package com.cburch.logisim.std.wiring

import java.awt.FontMetrics
import java.awt.Graphics
import com.cburch.logisim.data.Attribute
import com.cburch.logisim.data.AttributeOption
import com.cburch.logisim.data.AttributeSet
import com.cburch.logisim.data.Attributes
import com.cburch.logisim.data.BitWidth
import com.cburch.logisim.data.Bounds
import com.cburch.logisim.data.Direction
import com.cburch.logisim.data.Value
import com.cburch.logisim.instance.Instance
import com.cburch.logisim.instance.InstanceFactory
import com.cburch.logisim.instance.InstancePainter
import com.cburch.logisim.instance.InstanceState
import com.cburch.logisim.instance.Port
import com.cburch.logisim.instance.StdAttr
import com.cburch.logisim.tools.key.BitWidthConfigurator
import com.cburch.logisim.tools.key.IntegerConfigurator
import com.cburch.logisim.tools.key.JoinedConfigurator
import com.cburch.logisim.util.GraphicsUtil
import com.sun.media.sound.FFT
import java.awt.Graphics2D
import java.awt.geom.AffineTransform

class BitSlicer extends InstanceFactory {
	static final package Attribute<BitWidth> ATTR_IN_WIDTH = Attributes.forBitWidth("in_width",
		Strings.getter("slicerInAttr"))
	static final package Attribute<BitWidth> ATTR_OUT_WIDTH = Attributes.forBitWidth("lsb_index",
		Strings.getter("slicerOutAttr"))
	static final package Attribute<Integer> ATTR_OFFSET_WIDTH = Attributes.forInteger("msb_index",
		Strings.getter("slicerOffsetAttr"))
	public static final BitSlicer FACTORY = new BitSlicer()

	new() {
		super("Bit Slicer", Strings.getter("slicerComponent"))
		setIconName("slicer.gif")
		setAttributes(#[ATTR_IN_WIDTH, ATTR_OUT_WIDTH, ATTR_OFFSET_WIDTH], #[BitWidth.create(8), BitWidth.create(3), 4])
		setFacingAttribute(StdAttr.FACING)
		setKeyConfigurator(
			JoinedConfigurator.create(
				JoinedConfigurator.create(new BitWidthConfigurator(ATTR_IN_WIDTH, 0, 7, 0),
					new BitWidthConfigurator(ATTR_OUT_WIDTH, 0, 7, 0)),
				new IntegerConfigurator(ATTR_OFFSET_WIDTH, 0, 7, 0)))
		setOffsetBounds(Bounds.create(-50, -15, 50, 30))
	}

	//
	// methods for instances
	//
	override protected void configureNewInstance(Instance instance) {
		configurePorts(instance)
		instance.addAttributeListener()
	}

	def private void configurePorts(Instance instance) {
		var Port p0 = new Port(0, 0, Port.OUTPUT, ATTR_OUT_WIDTH)
		var Port p1 = new Port(-50, 0, Port.INPUT, ATTR_IN_WIDTH)
		instance.setPorts(#[p0, p1])
	}

	// private String getType(AttributeSet attrs) {
	// AttributeOption topt = attrs.getValue(ATTR_TYPE);
	// return (String) topt.getValue();
	// }
	override boolean HDLSupportedComponent(String HDLIdentifier, AttributeSet attrs) {
		if(MyHDLGenerator === null) MyHDLGenerator = new BitSlicerHDLGeneratorFactory()
		return MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs)
	}

	override protected void instanceAttributeChanged(Instance instance, Attribute<?> attr) {
		if (attr === ATTR_IN_WIDTH) {
			configurePorts(instance)
			instance.fireInvalidated()
		} else {
			instance.fireInvalidated()
		}
	}

	//
	// graphics methods
	//
	override void paintInstance(InstancePainter painter) {
		var Graphics g = painter.getGraphics()
		var Graphics2D g2d = g as Graphics2D;
		var FontMetrics fm = g.getFontMetrics()
		var int asc = fm.getAscent()
		painter.drawBounds()
		var BitWidth w0 = painter.getAttributeValue(ATTR_OUT_WIDTH)
		var BitWidth w1 = painter.getAttributeValue(ATTR_IN_WIDTH)
		var int offset = painter.getAttributeValue(ATTR_OFFSET_WIDTH)
		
		// get a reference of the affine transform of the original coordinate system
		val AffineTransform defaultAt = g2d.getTransform();
 

		g2d.setTransform(defaultAt);

		var String s1 = '''[«(offset+(w0.width-1))»:«offset»]'''
		var Bounds bds = painter.getBounds()
//		var int x = bds.getX() + bds.getWidth() / 2
//		var int y1 = bds.getY() + (3 * bds.getHeight() / 2 + asc) / 2
//	//	GraphicsUtil.drawText(g, s1, x, y1, GraphicsUtil.H_CENTER, GraphicsUtil.V_BASELINE)
		painter.drawPort(0, '''[«(offset+(w0.width-1))»:«offset»]''', Direction.WEST)
		painter.drawPort(1, '''«w1.getWidth()»''', Direction.EAST)
	}

	override void propagate(InstanceState state) {
		var Value in = state.getPortValue(1)
		var BitWidth wout = state.getAttributeValue(ATTR_OUT_WIDTH)
		var int offset = state.getAttributeValue(ATTR_OFFSET_WIDTH)
		var Value out = in.range(wout.getWidth() + offset - 1, offset)
		state.setPort(0, out, 1)
	}

}
