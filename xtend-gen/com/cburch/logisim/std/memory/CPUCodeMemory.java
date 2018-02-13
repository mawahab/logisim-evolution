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
package com.cburch.logisim.std.memory;

import com.bfh.logisim.designrulecheck.CorrectLabel;
import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeOption;
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
import com.cburch.logisim.std.memory.CPUMemoryData;
import com.cburch.logisim.std.memory.RegisterFileHDLGeneratorFactory;
import com.cburch.logisim.std.memory.RegisterFileLogger;
import com.cburch.logisim.std.memory.RegisterFilePoker;
import com.cburch.logisim.std.memory.Strings;
import com.cburch.logisim.tools.key.BitWidthConfigurator;
import com.cburch.logisim.util.GraphicsUtil;
import java.awt.Graphics;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class CPUCodeMemory extends InstanceFactory {
  public final static int ROW_HEIGHT = 18;
  
  public final static int COL_WIDTH = 130;
  
  public final static int HEIGHT = 360;
  
  public final static int WIDTH = 360;
  
  public final static int OFFX_VAL = 50;
  
  public final static int OFFY_VAL = 40;
  
  Port[] ps = new Port[6];
  
  static int OFFX = 30;
  
  static int OFFY = 30;
  
  public static void DrawRegister(final InstancePainter painter, final int x, final int y, final int nr_of_bits, final boolean has_we, final CPUMemoryData data) {
    Graphics g = painter.getGraphics();
    g.drawRect(x, y, CPUCodeMemory.WIDTH, CPUCodeMemory.HEIGHT);
    GraphicsUtil.drawCenteredText(g, "CLK", (x + (CPUCodeMemory.WIDTH / 4)), (y + 10));
    GraphicsUtil.drawCenteredText(g, "RST", (x + ((2 * CPUCodeMemory.WIDTH) / 4)), (y + 10));
    GraphicsUtil.drawCenteredText(g, "WE", (x + ((3 * CPUCodeMemory.WIDTH) / 4)), (y + 10));
    GraphicsUtil.drawCenteredText(g, "ADDR", (x + 20), ((y - 5) + ((2 * CPUCodeMemory.HEIGHT) / 3)));
    GraphicsUtil.drawCenteredText(g, "DI", ((x + CPUCodeMemory.WIDTH) - 20), ((y - 5) + (CPUCodeMemory.HEIGHT / 3)));
    GraphicsUtil.drawCenteredText(g, "DO", ((x + CPUCodeMemory.WIDTH) - 20), ((y - 5) + ((2 * CPUCodeMemory.HEIGHT) / 3)));
    IntegerRange _upTo = new IntegerRange(0, 3);
    for (final Integer i : _upTo) {
      GraphicsUtil.drawCenteredText(g, ("+" + i), (((x + CPUCodeMemory.OFFX_VAL) + (CPUCodeMemory.CELL_WIDTH / 2)) + (CPUCodeMemory.CELL_WIDTH * (i).intValue())), (y + CPUCodeMemory.OFFY_VAL));
    }
    {
      int r = 0;
      boolean _while = (r < (1 << CPUCodeMemory.ADDR_WIDTH));
      while (_while) {
        {
          int locX = (x + CPUCodeMemory.OFFX_VAL);
          int locY = ((y + CPUCodeMemory.OFFY_VAL) + (CPUCodeMemory.ROW_HEIGHT * r));
          int address = r;
          String _hexString = Integer.toHexString(address);
          String code = _hexString.toUpperCase();
          while ((code.length() < (CPUCodeMemory.ADDR_WIDTH / 4))) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("0");
            _builder.append(code, "");
            code = _builder.toString();
          }
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(code, "");
          g.drawString(_builder.toString(), locX, locY);
          IntegerRange _upTo_1 = new IntegerRange(0, 3);
          for (final Integer i_1 : _upTo_1) {
            {
              g.drawRect(((locX + 35) + (CPUCodeMemory.CELL_WIDTH * (i_1).intValue())), locY, CPUCodeMemory.CELL_WIDTH, (CPUCodeMemory.ROW_HEIGHT - 3));
              int _value = data.getValue(address);
              String _hexString_1 = Integer.toHexString(_value);
              String _upperCase = _hexString_1.toUpperCase();
              code = _upperCase;
              while ((code.length() < 2)) {
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("0");
                _builder_1.append(code, "");
                code = _builder_1.toString();
              }
              GraphicsUtil.drawCenteredText(g, code, (((locX + 35) + (CPUCodeMemory.CELL_WIDTH / 2)) + (CPUCodeMemory.CELL_WIDTH * (i_1).intValue())), (locY + (CPUCodeMemory.ROW_HEIGHT / 2)));
            }
          }
        }
        int _r = r;
        r = (_r + 1);
        _while = (r < (1 << CPUCodeMemory.ADDR_WIDTH));
      }
    }
  }
  
  public final static int CLK = 0;
  
  public final static int RST = 1;
  
  public final static int WE = 2;
  
  public final static int AD = 3;
  
  public final static int DI = 4;
  
  public final static int DO = 5;
  
  final static int DELAY = 8;
  
  final static int Xsize = 60;
  
  final static int Ysize = 90;
  
  public final static Attribute<Boolean> ATTR_SHOW_IN_TAB = Attributes.forBoolean("showInTab", 
    Strings.getter("registerShowInTab"));
  
  private final static int ADDR_WIDTH = 7;
  
  private final static int CELL_WIDTH = 30;
  
  public CPUCodeMemory() {
    super("CPU memory", Strings.getter("cpuMemoryComponent"));
    BitWidth _create = BitWidth.create(32);
    this.setAttributes(new Attribute[] { StdAttr.WIDTH, StdAttr.TRIGGER, StdAttr.LABEL, StdAttr.LABEL_FONT, CPUCodeMemory.ATTR_SHOW_IN_TAB }, 
      new Object[] { _create, StdAttr.TRIG_RISING, "", StdAttr.DEFAULT_LABEL_FONT, Boolean.valueOf(false) });
    BitWidthConfigurator _bitWidthConfigurator = new BitWidthConfigurator(StdAttr.WIDTH);
    this.setKeyConfigurator(_bitWidthConfigurator);
    Bounds _create_1 = Bounds.create(0, 0, CPUCodeMemory.WIDTH, CPUCodeMemory.HEIGHT);
    this.setOffsetBounds(_create_1);
    this.setIconName("register.gif");
    this.setInstancePoker(RegisterFilePoker.class);
    this.setInstanceLogger(RegisterFileLogger.class);
    Port _port = new Port((CPUCodeMemory.WIDTH / 4), 0, Port.INPUT, 1);
    this.ps[CPUCodeMemory.CLK] = _port;
    Port _port_1 = new Port(((2 * CPUCodeMemory.WIDTH) / 4), 0, Port.INPUT, 1);
    this.ps[CPUCodeMemory.RST] = _port_1;
    Port _port_2 = new Port(((3 * CPUCodeMemory.WIDTH) / 4), 0, Port.INPUT, 1);
    this.ps[CPUCodeMemory.WE] = _port_2;
    Port _port_3 = new Port(0, ((2 * CPUCodeMemory.HEIGHT) / 3), Port.INPUT, StdAttr.WIDTH);
    this.ps[CPUCodeMemory.DI] = _port_3;
    Port _port_4 = new Port(CPUCodeMemory.WIDTH, (CPUCodeMemory.HEIGHT / 3), Port.OUTPUT, StdAttr.WIDTH);
    this.ps[CPUCodeMemory.DO] = _port_4;
    Port _port_5 = new Port((CPUCodeMemory.WIDTH / 3), CPUCodeMemory.HEIGHT, Port.INPUT, CPUCodeMemory.ADDR_WIDTH);
    this.ps[CPUCodeMemory.AD] = _port_5;
    this.setPorts(this.ps);
  }
  
  @Override
  protected void configureNewInstance(final Instance instance) {
    Bounds bds = instance.getBounds();
    int _x = bds.getX();
    int _width = bds.getWidth();
    int _divide = (_width / 2);
    int _plus = (_x + _divide);
    int _y = bds.getY();
    int _minus = (_y - 3);
    instance.setTextField(StdAttr.LABEL, StdAttr.LABEL_FONT, _plus, _minus, 
      GraphicsUtil.H_CENTER, GraphicsUtil.V_BASELINE);
  }
  
  @Override
  public String getHDLName(final AttributeSet attrs) {
    StringBuffer CompleteName = new StringBuffer();
    String _name = this.getName();
    String _correctLabel = CorrectLabel.getCorrectLabel(_name);
    String _upperCase = _correctLabel.toUpperCase();
    CompleteName.append(_upperCase);
    return CompleteName.toString();
  }
  
  @Override
  public boolean HDLSupportedComponent(final String HDLIdentifier, final AttributeSet attrs) {
    if ((this.MyHDLGenerator == null)) {
      RegisterFileHDLGeneratorFactory _registerFileHDLGeneratorFactory = new RegisterFileHDLGeneratorFactory();
      this.MyHDLGenerator = _registerFileHDLGeneratorFactory;
    }
    return this.MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs);
  }
  
  @Override
  public void paintInstance(final InstancePainter painter) {
    InstanceData _data = painter.getData();
    CPUMemoryData state = ((CPUMemoryData) _data);
    BitWidth widthVal = painter.<BitWidth>getAttributeValue(StdAttr.WIDTH);
    int _xifexpression = (int) 0;
    if ((widthVal == null)) {
      _xifexpression = 8;
    } else {
      _xifexpression = widthVal.getWidth();
    }
    int width = _xifexpression;
    Location loc = painter.getLocation();
    int x = loc.getX();
    int y = loc.getY();
    CPUCodeMemory.DrawRegister(painter, x, y, width, true, state);
    painter.drawLabel();
    for (int i = 0; (i < this.ps.length); i++) {
      painter.drawPort(i);
    }
  }
  
  @Override
  public void propagate(final InstanceState state) {
    InstanceData _data = state.getData();
    CPUMemoryData data = ((CPUMemoryData) _data);
    if ((data == null)) {
      CPUMemoryData _cPUMemoryData = new CPUMemoryData(CPUCodeMemory.ADDR_WIDTH);
      data = _cPUMemoryData;
      state.setData(data);
    }
    BitWidth dataWidth = state.<BitWidth>getAttributeValue(StdAttr.WIDTH);
    Object triggerType = state.<AttributeOption>getAttributeValue(StdAttr.TRIGGER);
    Value _portValue = state.getPortValue(CPUCodeMemory.CLK);
    boolean triggered = data.updateClock(_portValue, triggerType);
    Value _portValue_1 = state.getPortValue(CPUCodeMemory.RST);
    boolean _tripleEquals = (_portValue_1 == Value.TRUE);
    if (_tripleEquals) {
      data.clear();
    } else {
      boolean _and = false;
      if (!triggered) {
        _and = false;
      } else {
        Value _portValue_2 = state.getPortValue(CPUCodeMemory.WE);
        boolean _tripleNotEquals = (_portValue_2 != Value.FALSE);
        _and = _tripleNotEquals;
      }
      if (_and) {
        Value in = state.getPortValue(CPUCodeMemory.DI);
        Value addr = state.getPortValue(CPUCodeMemory.AD);
        boolean _isFullyDefined = in.isFullyDefined();
        if (_isFullyDefined) {
          int _intValue = addr.toIntValue();
          int _intValue_1 = in.toIntValue();
          data.setValue(_intValue, ((byte) _intValue_1));
        }
      }
    }
    Value addr0 = state.getPortValue(CPUCodeMemory.AD);
    boolean _isFullyDefined_1 = addr0.isFullyDefined();
    if (_isFullyDefined_1) {
      int _intValue_2 = addr0.toIntValue();
      int _value = data.getValue(_intValue_2);
      Value _createKnown = Value.createKnown(dataWidth, _value);
      state.setPort(CPUCodeMemory.DO, _createKnown, CPUCodeMemory.DELAY);
    }
  }
}
