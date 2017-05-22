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
import com.cburch.logisim.statemachine.codegen.FSMVHDLCodeGen;
  
public class RegisterFileHDLGeneratorFactory extends AbstractHDLGeneratorFactory {

	@Override
	public ArrayList<String> GetArchitecture(Netlist TheNetlist,
			AttributeSet attrs, String ComponentName, FPGAReport Reporter,
			String HDLType) {
		ArrayList<String> arrayList = new ArrayList<String>();
		ArrayList<String> contents = arrayList;
		contents.addAll(FileWriter.getGenerateRemark(ComponentName, HDLType,
				TheNetlist.projName()));

//		FSMContent content = (FSMContent) attrs
//				.getValue(FSMEntity.CONTENT_ATTR);
		RegisterFileVHDLCodeGen codegen = new RegisterFileVHDLCodeGen();
		arrayList.add(codegen.generate(null).toString());
		
		return arrayList;
	}

	@Override
	public String getComponentStringIdentifier() {
		return "VHDL";
	}

	@Override
	public SortedMap<String, Integer> GetInputList(Netlist TheNetlist,
			AttributeSet attrs) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public SortedMap<String, Integer> GetOutputList(Netlist TheNetlist,
			AttributeSet attrs) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public SortedMap<String, String> GetPortMap(Netlist Nets,
			NetlistComponent ComponentInfo, FPGAReport Reporter, String HDLType) {
		throw new UnsupportedOperationException("Not implemented");
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
