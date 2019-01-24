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
package com.cburch.logisim.std.wiring;

import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.Attributes;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Direction;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.Instance;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.std.wiring.BitSlicerHDLGeneratorFactory;
import com.cburch.logisim.std.wiring.Strings;
import com.cburch.logisim.tools.key.BitWidthConfigurator;
import com.cburch.logisim.tools.key.IntegerConfigurator;
import com.cburch.logisim.tools.key.JoinedConfigurator;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class BitSlicer extends InstanceFactory {
  static final Attribute<BitWidth> ATTR_IN_WIDTH = Attributes.forBitWidth("in_width", 
    Strings.getter("slicerInAttr"));
  
  static final Attribute<BitWidth> ATTR_OUT_WIDTH = Attributes.forBitWidth("lsb_index", 
    Strings.getter("slicerOutAttr"));
  
  static final Attribute<Integer> ATTR_OFFSET_WIDTH = Attributes.forInteger("msb_index", 
    Strings.getter("slicerOffsetAttr"));
  
  public static final BitSlicer FACTORY = new BitSlicer();
  
  public BitSlicer() {
    super("Bit Slicer", Strings.getter("slicerComponent"));
    this.setIconName("slicer.gif");
    BitWidth _create = BitWidth.create(8);
    BitWidth _create_1 = BitWidth.create(3);
    this.setAttributes(new Attribute[] { BitSlicer.ATTR_IN_WIDTH, BitSlicer.ATTR_OUT_WIDTH, BitSlicer.ATTR_OFFSET_WIDTH }, new Object[] { _create, _create_1, Integer.valueOf(4) });
    this.setFacingAttribute(StdAttr.FACING);
    BitWidthConfigurator _bitWidthConfigurator = new BitWidthConfigurator(BitSlicer.ATTR_IN_WIDTH, 0, 7, 0);
    BitWidthConfigurator _bitWidthConfigurator_1 = new BitWidthConfigurator(BitSlicer.ATTR_OUT_WIDTH, 0, 7, 0);
    JoinedConfigurator _create_2 = JoinedConfigurator.create(_bitWidthConfigurator, _bitWidthConfigurator_1);
    IntegerConfigurator _integerConfigurator = new IntegerConfigurator(BitSlicer.ATTR_OFFSET_WIDTH, 0, 7, 0);
    this.setKeyConfigurator(
      JoinedConfigurator.create(_create_2, _integerConfigurator));
    this.setOffsetBounds(Bounds.create((-50), (-15), 50, 30));
  }
  
  @Override
  protected void configureNewInstance(final Instance instance) {
    this.configurePorts(instance);
    instance.addAttributeListener();
  }
  
  private void configurePorts(final Instance instance) {
    Port p0 = new Port(0, 0, Port.OUTPUT, BitSlicer.ATTR_OUT_WIDTH);
    Port p1 = new Port((-50), 0, Port.INPUT, BitSlicer.ATTR_IN_WIDTH);
    instance.setPorts(new Port[] { p0, p1 });
  }
  
  @Override
  public boolean HDLSupportedComponent(final String HDLIdentifier, final AttributeSet attrs) {
    if ((this.MyHDLGenerator == null)) {
      BitSlicerHDLGeneratorFactory _bitSlicerHDLGeneratorFactory = new BitSlicerHDLGeneratorFactory();
      this.MyHDLGenerator = _bitSlicerHDLGeneratorFactory;
    }
    return this.MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs);
  }
  
  @Override
  protected void instanceAttributeChanged(final Instance instance, final Attribute<?> attr) {
    if ((attr == BitSlicer.ATTR_IN_WIDTH)) {
      this.configurePorts(instance);
      instance.fireInvalidated();
    } else {
      instance.fireInvalidated();
    }
  }
  
  @Override
  public void paintInstance(final InstancePainter painter) {
    Graphics g = painter.getGraphics();
    Graphics2D g2d = ((Graphics2D) g);
    FontMetrics fm = g.getFontMetrics();
    int asc = fm.getAscent();
    painter.drawBounds();
    BitWidth w0 = painter.<BitWidth>getAttributeValue(BitSlicer.ATTR_OUT_WIDTH);
    BitWidth w1 = painter.<BitWidth>getAttributeValue(BitSlicer.ATTR_IN_WIDTH);
    int offset = (painter.<Integer>getAttributeValue(BitSlicer.ATTR_OFFSET_WIDTH)).intValue();
    final AffineTransform defaultAt = g2d.getTransform();
    g2d.setTransform(defaultAt);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    int _width = w0.getWidth();
    int _minus = (_width - 1);
    int _plus = (offset + _minus);
    _builder.append(_plus);
    _builder.append(":");
    _builder.append(offset);
    _builder.append("]");
    String s1 = _builder.toString();
    Bounds bds = painter.getBounds();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("[");
    int _width_1 = w0.getWidth();
    int _minus_1 = (_width_1 - 1);
    int _plus_1 = (offset + _minus_1);
    _builder_1.append(_plus_1);
    _builder_1.append(":");
    _builder_1.append(offset);
    _builder_1.append("]");
    painter.drawPort(0, _builder_1.toString(), Direction.WEST);
    StringConcatenation _builder_2 = new StringConcatenation();
    int _width_2 = w1.getWidth();
    _builder_2.append(_width_2);
    painter.drawPort(1, _builder_2.toString(), Direction.EAST);
  }
  
  @Override
  public void propagate(final InstanceState state) {
    Value in = state.getPortValue(1);
    BitWidth wout = state.<BitWidth>getAttributeValue(BitSlicer.ATTR_OUT_WIDTH);
    int offset = (state.<Integer>getAttributeValue(BitSlicer.ATTR_OFFSET_WIDTH)).intValue();
    int _width = wout.getWidth();
    int _plus = (_width + offset);
    int _minus = (_plus - 1);
    Value out = in.range(_minus, offset);
    state.setPort(0, out, 1);
  }
}
