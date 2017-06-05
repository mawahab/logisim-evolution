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
package com.cburch.logisim.std.io

import com.bfh.logisim.designrulecheck.Netlist
import com.bfh.logisim.designrulecheck.NetlistComponent
import com.bfh.logisim.fpgagui.FPGAReport
import com.bfh.logisim.hdlgenerator.AbstractHDLGeneratorFactory
import com.bfh.logisim.hdlgenerator.HDLGeneratorFactory
import com.bfh.logisim.settings.Settings
import com.cburch.logisim.data.AttributeSet
import java.util.ArrayList
import java.util.SortedMap
import com.bfh.logisim.fpgagui.MappableResourcesContainer

class KeypadHDLGeneratorFactory extends AbstractHDLGeneratorFactory {
	
	override SortedMap<String, String> GetPortMap(Netlist Nets,
			NetlistComponent ComponentInfo, FPGAReport Reporter, String HDLType) {
		/*
		 * This method returns the assigned input/outputs of the component, the
		 * key is the name of the input/output (bit), and the value represent
		 * the connected net.
		 */
		super.GetPortMap(Nets, ComponentInfo, Reporter,HDLType)
	}
	
	
	
	override ArrayList<String> GetInlinedCode(String HDLType,
			ArrayList<String> ComponentIdentifier, FPGAReport Reporter,
			MappableResourcesContainer MapInfo) {
		super.GetInlinedCode(HDLType,ComponentIdentifier, Reporter, MapInfo);
	}
	override ArrayList<String> GetInlinedCode(Netlist Nets, Long ComponentId, NetlistComponent ComponentInfo,
		FPGAReport Reporter, String CircuitName, String HDLType) {
		var ArrayList<String> Contents = new ArrayList<String>()

		for (var int i = 0; i < ComponentInfo.NrOfEnds(); i++) {
			val netName = GetNetName(ComponentInfo, i, true, HDLType, Nets)
			if(!ComponentInfo.EndIsInput(i)) {
				val offset = Integer.toString(ComponentInfo.GetLocalBubbleInputStartId() + i-4)
				if (ComponentInfo.EndIsConnected(i)) {
					val bubbleName = HDLGeneratorFactory.LocalInputBubbleBusname
					Contents.add(
					'''	-- WTF ? Input connect i=«i», offset=«i»
						«netName»<=«bubbleName»(«offset»);
					''')
				}
			} else {
				val offset = Integer.toString(ComponentInfo.GetLocalBubbleOutputStartId() + i)
				if (ComponentInfo.EndIsConnected(i)) {
					val bubbleName = HDLGeneratorFactory.LocalOutputBubbleBusname
					Contents.add(
					'''	-- WTF ? Output connect i=«i», offset=«i»
						«bubbleName»(«offset»)<= «netName»;
					''')
				}			
			}

		}
		return Contents
	}

	override boolean HDLTargetSupported(String HDLType, AttributeSet attrs) {
		return HDLType.equals(Settings.VHDL)
	}

	override boolean IsOnlyInlined(String HDLType) {
		return true
	}

}
