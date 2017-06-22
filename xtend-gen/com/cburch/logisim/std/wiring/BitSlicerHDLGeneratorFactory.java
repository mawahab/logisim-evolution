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

import com.bfh.logisim.designrulecheck.Netlist;
import com.bfh.logisim.designrulecheck.NetlistComponent;
import com.bfh.logisim.fpgagui.FPGAReport;
import com.bfh.logisim.hdlgenerator.AbstractHDLGeneratorFactory;
import com.bfh.logisim.settings.Settings;
import com.cburch.logisim.comp.Component;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.std.wiring.BitSlicer;
import java.util.ArrayList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class BitSlicerHDLGeneratorFactory extends AbstractHDLGeneratorFactory {
  @Override
  public ArrayList<String> GetInlinedCode(final Netlist Nets, final Long ComponentId, final NetlistComponent ComponentInfo, final FPGAReport Reporter, final String CircuitName, final String HDLType) {
    final String outname = this.GetNetName(ComponentInfo, 0, true, HDLType, Nets);
    final String inname = this.GetNetName(ComponentInfo, 1, true, HDLType, Nets);
    Component _GetComponent = ComponentInfo.GetComponent();
    final AttributeSet attributeSet = _GetComponent.getAttributeSet();
    BitWidth oWidth = attributeSet.<BitWidth>getValue(BitSlicer.ATTR_OUT_WIDTH);
    Integer iOffset = attributeSet.<Integer>getValue(BitSlicer.ATTR_OFFSET_WIDTH);
    ArrayList<String> Contents = new ArrayList<String>();
    boolean _equals = HDLType.equals(Settings.VHDL);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(outname, "");
      _builder.append(" <= ");
      _builder.append(inname, "");
      _builder.append("(");
      int _width = oWidth.getWidth();
      int _plus = (_width + (iOffset).intValue());
      int _minus = (_plus - 1);
      _builder.append(_minus, "");
      _builder.append(" downto ");
      _builder.append(iOffset, "");
      _builder.append(");");
      Contents.add(_builder.toString());
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("assign ");
      _builder_1.append(outname, "");
      _builder_1.append(" = ");
      _builder_1.append(inname, "");
      _builder_1.append("[");
      int _width_1 = oWidth.getWidth();
      int _plus_1 = (_width_1 + (iOffset).intValue());
      int _minus_1 = (_plus_1 - 1);
      _builder_1.append(_minus_1, "");
      _builder_1.append(" : ");
      _builder_1.append(iOffset, "");
      _builder_1.append("];");
      Contents.add(_builder_1.toString());
    }
    return Contents;
  }
  
  @Override
  public boolean HDLTargetSupported(final String HDLType, final AttributeSet attrs) {
    return true;
  }
  
  @Override
  public boolean IsOnlyInlined(final String HDLType) {
    return true;
  }
}
