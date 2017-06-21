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

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.help.UnsupportedOperationException;

import com.bfh.logisim.designrulecheck.Netlist;
import com.bfh.logisim.designrulecheck.NetlistComponent;
import com.bfh.logisim.fpgagui.FPGAReport;
import com.bfh.logisim.hdlgenerator.AbstractHDLGeneratorFactory;
import com.bfh.logisim.hdlgenerator.FileWriter;
import com.bfh.logisim.settings.Settings;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.statemachine.codegen.FSMVHDLCodeGen;
import com.cburch.logisim.std.wiring.ClockHDLGeneratorFactory;
import static com.cburch.logisim.std.wiring.ClockHDLGeneratorFactory.*;

public class RegisterFileHDLGeneratorFactory extends AbstractHDLGeneratorFactory {

	@Override
	public ArrayList<String> GetArchitecture(Netlist TheNetlist,
			AttributeSet attrs, String ComponentName, FPGAReport Reporter,
			String HDLType) {
		ArrayList<String> arrayList = new ArrayList<String>();
		ArrayList<String> contents = arrayList;
		contents.addAll(FileWriter.getGenerateRemark(ComponentName, HDLType,
				TheNetlist.projName()));

		RegisterFileVHDLCodeGen codegen = new RegisterFileVHDLCodeGen();
		arrayList.add(codegen.generate().toString());
		
		return arrayList;
	}

	@Override
	public String getComponentStringIdentifier() {
		return "REGFILE";
	}

	@Override
	public SortedMap<String, Integer> GetInputList(Netlist TheNetlist,
			AttributeSet attrs) {
		SortedMap<String, Integer> inputs = new TreeMap<String, Integer>();
		inputs.put("Rst", 1);
		inputs.put("WE", 1);
		inputs.put("Tick", 1);
		inputs.put("WAD", 5);
		inputs.put("RAD0", 5);
		inputs.put("RAD1", 5);
		inputs.put("Clk", 1);
		inputs.put("DI", 32);
		return inputs;
	}

	@Override
	public SortedMap<String, Integer> GetOutputList(Netlist TheNetlist,
			AttributeSet attrs) {
		SortedMap<String, Integer> outputs = new TreeMap<String, Integer>();
		outputs.put("DO0", 32);
		outputs.put("DO1", 32);
		return outputs;
	}

	@Override
	public SortedMap<String, String> GetPortMap(Netlist Nets,
			NetlistComponent ComponentInfo, FPGAReport Reporter, String HDLType) {
		SortedMap<String, String> PortMap = new TreeMap<String, String>();
		boolean GatedClock = false;
		boolean ActiveLow = false;
		
		AttributeSet attrs = ComponentInfo.GetComponent().getAttributeSet();
		if (!ComponentInfo.EndIsConnected(RegisterFile.CLK)) {
			Reporter.AddSevereWarning("Component \"Register\" in circuit \""
					+ Nets.getCircuitName() + "\" has no clock connection");
		}
		String ClockNetName = GetClockNetName(ComponentInfo, RegisterFile.CLK, Nets);
		if (ClockNetName.isEmpty()) {
			GatedClock = true;
		}
		if (attrs.getValue(StdAttr.TRIGGER) == StdAttr.TRIG_FALLING
				|| attrs.getValue(StdAttr.TRIGGER) == StdAttr.TRIG_LOW)
			ActiveLow = true;

		PortMap.putAll(GetNetMap("RST", true, ComponentInfo, RegisterFile.RST,Reporter, HDLType, Nets));
		PortMap.putAll(GetNetMap("WE", false, ComponentInfo, RegisterFile.WE, Reporter, HDLType, Nets));
		PortMap.putAll(GetNetMap("WAD", false, ComponentInfo, RegisterFile.WAD, Reporter, HDLType, Nets));
		PortMap.putAll(GetNetMap("RAD0", false, ComponentInfo, RegisterFile.RAD0, Reporter, HDLType, Nets));
		PortMap.putAll(GetNetMap("RAD1", false, ComponentInfo, RegisterFile.RAD1, Reporter, HDLType, Nets));

		if (!GatedClock && Netlist.IsFlipFlop(attrs)) {
			if (Nets.RequiresGlobalClockConnection()) {
				PortMap.put("Tick", "'1'");
			} else {
				PortMap.put(
							"Tick",
							ClockNetName
									+ "("
									+ PositiveEdgeTickIndex
									+ ")");
			}
			PortMap.put(
					"CLK",
					ClockNetName
							+ "("
							+ GlobalClockIndex
							+ ")");
		} else {
			PortMap.put("Tick", "'1'");
			if (!GatedClock) {
				if (ActiveLow)
					PortMap.put(
							"CLK",
							ClockNetName
									+ "("
									+ InvertedDerivedClockIndex
									+ ")");
				else
					PortMap.put(
							"CLK",
							ClockNetName
									+ "("
									+ (DerivedClockIndex)
									+ ")");
			} else {
				PortMap.put(
						"CLK",
						GetNetName(ComponentInfo, RegisterFile.CLK, true, HDLType,
								Nets));
			}
		}
	
		PortMap.putAll(GetNetMap("DI", true, ComponentInfo, RegisterFile.DI, Reporter, HDLType, Nets));
		PortMap.putAll(GetNetMap("DO0", true, ComponentInfo, RegisterFile.DO0,Reporter, HDLType, Nets));
		PortMap.putAll(GetNetMap("DO1", true, ComponentInfo, RegisterFile.DO1,Reporter, HDLType, Nets));
		return PortMap;
	}


	@Override
	public String GetSubDir() {
		return "circuit";
	}

	@Override
	public boolean HDLTargetSupported(String HDLType, AttributeSet attrs) {
		return HDLType.equals(Settings.VHDL);
	}

	
	
}
