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

import com.bfh.logisim.designrulecheck.Netlist
import com.bfh.logisim.designrulecheck.NetlistComponent
import com.bfh.logisim.fpgagui.FPGAReport
import com.bfh.logisim.hdlgenerator.AbstractHDLGeneratorFactory
import com.bfh.logisim.settings.Settings
import com.cburch.logisim.data.AttributeSet
import java.util.ArrayList
import com.cburch.logisim.data.BitWidth

class BitSlicerHDLGeneratorFactory extends AbstractHDLGeneratorFactory {
	override ArrayList<String> GetInlinedCode(Netlist Nets, Long ComponentId, NetlistComponent ComponentInfo,
		FPGAReport Reporter, String CircuitName, String HDLType) {
		val outname= GetNetName(ComponentInfo, 0, true, HDLType, Nets)
		val inname= GetNetName(ComponentInfo, 1, true, HDLType, Nets)
		val attributeSet = ComponentInfo.GetComponent().getAttributeSet()

		var BitWidth oWidth = attributeSet.getValue(BitSlicer.ATTR_OUT_WIDTH)
		var Integer iOffset = attributeSet.getValue(BitSlicer.ATTR_OFFSET_WIDTH)
		
		var ArrayList<String> Contents = new ArrayList<String>()
		if (HDLType.equals(Settings.VHDL)) {
			Contents.add('''«outname» <= «inname»(«oWidth.width+iOffset-1» downto «iOffset»);''');
		} else {
			Contents.add('''assign «outname» = «inname»[«oWidth.width+iOffset-1» : «iOffset»];''');
			
		}
		return Contents
	}

	override boolean HDLTargetSupported(String HDLType, AttributeSet attrs) {
		return true
	}

	override boolean IsOnlyInlined(String HDLType) {
		return true
	}

}
