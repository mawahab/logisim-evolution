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
package com.cburch.logisim.std.io;

import com.bfh.logisim.designrulecheck.Netlist;
import com.bfh.logisim.designrulecheck.NetlistComponent;
import com.bfh.logisim.fpgagui.FPGAReport;
import com.bfh.logisim.fpgagui.MappableResourcesContainer;
import com.bfh.logisim.hdlgenerator.AbstractHDLGeneratorFactory;
import com.bfh.logisim.hdlgenerator.HDLGeneratorFactory;
import com.bfh.logisim.settings.Settings;
import com.cburch.logisim.data.AttributeSet;
import java.util.ArrayList;
import java.util.SortedMap;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class KeypadHDLGeneratorFactory extends AbstractHDLGeneratorFactory {
  @Override
  public SortedMap<String, String> GetPortMap(final Netlist Nets, final NetlistComponent ComponentInfo, final FPGAReport Reporter, final String HDLType) {
    return super.GetPortMap(Nets, ComponentInfo, Reporter, HDLType);
  }
  
  @Override
  public ArrayList<String> GetInlinedCode(final String HDLType, final ArrayList<String> ComponentIdentifier, final FPGAReport Reporter, final MappableResourcesContainer MapInfo) {
    return super.GetInlinedCode(HDLType, ComponentIdentifier, Reporter, MapInfo);
  }
  
  @Override
  public ArrayList<String> GetInlinedCode(final Netlist Nets, final Long ComponentId, final NetlistComponent ComponentInfo, final FPGAReport Reporter, final String CircuitName, final String HDLType) {
    ArrayList<String> Contents = new ArrayList<String>();
    for (int i = 0; (i < ComponentInfo.NrOfEnds()); i++) {
      {
        final String netName = this.GetNetName(ComponentInfo, i, true, HDLType, Nets);
        boolean _EndIsInput = ComponentInfo.EndIsInput(i);
        boolean _not = (!_EndIsInput);
        if (_not) {
          int _GetLocalBubbleInputStartId = ComponentInfo.GetLocalBubbleInputStartId();
          int _plus = (_GetLocalBubbleInputStartId + i);
          int _minus = (_plus - 4);
          final String offset = Integer.toString(_minus);
          boolean _EndIsConnected = ComponentInfo.EndIsConnected(i);
          if (_EndIsConnected) {
            final String bubbleName = HDLGeneratorFactory.LocalInputBubbleBusname;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("\t");
            _builder.append("-- WTF ? Input connect i=");
            _builder.append(i, "\t");
            _builder.append(", offset=");
            _builder.append(i, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t\t");
            _builder.append(netName, "\t\t\t\t\t\t");
            _builder.append("<=");
            _builder.append(bubbleName, "\t\t\t\t\t\t");
            _builder.append("(");
            _builder.append(offset, "\t\t\t\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            Contents.add(_builder.toString());
          }
        } else {
          int _GetLocalBubbleOutputStartId = ComponentInfo.GetLocalBubbleOutputStartId();
          int _plus_1 = (_GetLocalBubbleOutputStartId + i);
          final String offset_1 = Integer.toString(_plus_1);
          boolean _EndIsConnected_1 = ComponentInfo.EndIsConnected(i);
          if (_EndIsConnected_1) {
            final String bubbleName_1 = HDLGeneratorFactory.LocalOutputBubbleBusname;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("\t");
            _builder_1.append("-- WTF ? Output connect i=");
            _builder_1.append(i, "\t");
            _builder_1.append(", offset=");
            _builder_1.append(i, "\t");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t\t\t\t\t\t");
            _builder_1.append(bubbleName_1, "\t\t\t\t\t\t");
            _builder_1.append("(");
            _builder_1.append(offset_1, "\t\t\t\t\t\t");
            _builder_1.append(")<= ");
            _builder_1.append(netName, "\t\t\t\t\t\t");
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
            Contents.add(_builder_1.toString());
          }
        }
      }
    }
    return Contents;
  }
  
  @Override
  public boolean HDLTargetSupported(final String HDLType, final AttributeSet attrs) {
    return HDLType.equals(Settings.VHDL);
  }
  
  @Override
  public boolean IsOnlyInlined(final String HDLType) {
    return true;
  }
}
