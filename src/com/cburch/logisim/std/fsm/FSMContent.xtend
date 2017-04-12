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
package com.cburch.logisim.std.fsm

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.Arrays
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.logging.Level
import java.util.logging.Logger
import javax.swing.JOptionPane
import org.eclipse.emf.ecore.util.EcoreUtil

import com.cburch.logisim.instance.Port
import com.cburch.logisim.statemachine.fSMDSL.FSM
import com.cburch.logisim.statemachine.fSMDSL.InputPort
import com.cburch.logisim.statemachine.fSMDSL.OutputPort
import com.cburch.logisim.statemachine.parser.FSMSerializer
import com.cburch.logisim.util.EventSourceWeakSupport
 
class FSMContent implements Cloneable {
	def protected static <T> T[] concat(T[] first, T[] second) {
		var T[] result = Arrays::copyOf(first, first.length + second.length)
		System::arraycopy(second, 0, result, first.length, second.length)
		return result
	}

	protected EventSourceWeakSupport<FSMModelListener> listeners

	def private void init() {
		this.listeners = null
		inMap = new HashMap<Port, InputPort>()
		outMap = new HashMap<Port, OutputPort>()
	}

	new(String text) {
		init()
		this.parseContent(text)
	}

	new() {
		init()
		this.parseContent(TEMPLATE)
	}

	def void updateContent(String txt) {
		init()
		this.parseContent(txt)
	}

	def FSM getFsm() {
		return fsm
	}

	def void setFsm(FSM fsm) {
		this.fsm = fsm
	}

	override FSMContent clone() {
		try {
			var FSMContent ret = super.clone() as FSMContent
			ret.fsm = EcoreUtil::copy(fsm)
			ret.listeners = null
			return ret
		} catch (CloneNotSupportedException ex) {
			return this
		}

	}

	def void addFSMModelListener(FSMModelListener l) {
		if (listeners === null) {
			listeners = new EventSourceWeakSupport<FSMModelListener>()
		}
		listeners.add(l)
	}

	def protected void fireContentSet() {
		if (listeners === null) {
			return;
		}
		var boolean found = false
		for (FSMModelListener l : listeners) {
			found = true
			l.contentSet(this)
		}  
		if (!found) {
			listeners = null
		}

	}

	def void removeFSMModelListener(FSMModelListener l) {
		if (listeners === null) {
			return;
		}
		listeners.remove(l)
		if (listeners.isEmpty()) {
			listeners = null
		}

	}

	static final String TEMPLATE = 
	'''fsm example @[50,50,800,500] {
		in A[1]@[50,100];
		in B[3]@[50,120];
		out X[1]@[500,140];
		codeWidth=2 ;
		reset=S0 ;
	
		state S0="01" @[300,200] {
			code = "01";
			commands @[340,180,50,20]{
				X="0";
			}  
			transitions {
				goto S1 when A @[400,150,40,30];
			}
		}
		state S1="10" @[500,200] {
			code = "10";
			commands @[540,180,40,30]{
				X=A ;
			}
			transitions {
				goto S0 when "1" @[400,250,40,30];
			}
		}
	}
	''';
	static final package int CLK = 0
	static final package int CLR = 1
	static final package int EN = 2
	protected Port[] inputs
	protected Port[] outputs
	protected Map<Port, InputPort> inMap
	protected Map<Port, OutputPort> outMap
	protected String name
	FSM fsm
	Port[] ctrl

	def String getContent() {
		return FSMSerializer::saveAsString(fsm)
	}

	def Port[] getInputs() {
		if(inputs === null) return newArrayOfSize(0)
		return inputs
	}

	def int getInputsNumber() {
		if(inputs === null) return 0
		return inputs.length
	}

	def String getName() {
		if(fsm === null) return ""
		return fsm.getName()
	}

	def Port[] getOutputs() {
		if(outputs === null) return newArrayOfSize(0)
		return outputs
	}

	def int getOutputsNumber() {
		if(outputs === null) return 0
		return outputs.length
	}

	def Port[] getPorts() {
		return concat(ctrl, concat(inputs, outputs))
	}

	def int getPortsNumber() {
		if(inputs === null || outputs === null) return 0
		return ctrl.length + inputs.length + outputs.length
	}

	def private boolean parseContent(String content) {
		var FSMSerializer parser = new FSMSerializer()
		try {
			fsm = FSMSerializer.load(content.toString()) as FSM
			name = fsm.getName()
			var List<InputPort> inputsDesc = fsm.getIn() as List
			var List<OutputPort> outputsDesc = fsm.getOut() as List
			ctrl = newArrayOfSize(3)
			inputs = newArrayOfSize(inputsDesc.size())
			outputs = newArrayOfSize(outputsDesc.size())
			{
				val _wrVal_ctrl = ctrl
				val _wrIndx_ctrl = CLK
				_wrVal_ctrl.set(_wrIndx_ctrl, new Port(0, FSMEntity::HEIGHT, Port::INPUT, 1))
			}
			{
				val _wrVal_ctrl = ctrl
				val _wrIndx_ctrl = CLR
				_wrVal_ctrl.set(_wrIndx_ctrl, new Port(0, FSMEntity::HEIGHT + FSMEntity::PORT_GAP, Port::INPUT, 1))
			}
			{
				val _wrVal_ctrl = ctrl
				val _wrIndx_ctrl = EN
				_wrVal_ctrl.set(_wrIndx_ctrl, new Port(0, FSMEntity::HEIGHT + 2 * FSMEntity::PORT_GAP, Port::INPUT, 1))
			}
			{
				val _rdIndx_ctrl = CLK
				ctrl.get(_rdIndx_ctrl)
			}.setToolTip(Strings::getter("registerClkTip"))
			{
				val _rdIndx_ctrl = CLR
				ctrl.get(_rdIndx_ctrl)
			}.setToolTip(Strings::getter("registerClrTip"))
			{
				val _rdIndx_ctrl = EN
				ctrl.get(_rdIndx_ctrl)
			}.setToolTip(Strings::getter("registerEnableTip"))
			for (var int i = 0; i < inputsDesc.size(); i++) {
				var InputPort desc = inputsDesc.get(i)
				{
					val _wrVal_inputs = inputs
					val _wrIndx_inputs = i
					_wrVal_inputs.set(_wrIndx_inputs,
						new Port(0, ((i + ctrl.length) * FSMEntity::PORT_GAP) + FSMEntity::HEIGHT, Port::INPUT,
							desc.getWidth()))
				}
				{
					val _rdIndx_inputs = i
					inputs.get(_rdIndx_inputs)
				}.setToolTip(Strings::getter(desc.getName()))
				inMap.put({
					val _rdIndx_inputs = i
					inputs.get(_rdIndx_inputs)
				}, desc)
			}

			for (var int i = 0; i < outputsDesc.size(); i++) {
				var OutputPort desc = outputsDesc.get(i)
				{
					val _wrVal_outputs = outputs
					val _wrIndx_outputs = i
					_wrVal_outputs.set(_wrIndx_outputs,
						new Port(FSMEntity::WIDTH, ((i + ctrl.length) * FSMEntity::PORT_GAP) + FSMEntity::HEIGHT,
							Port::OUTPUT, desc.getWidth()))
				}
				{
					val _rdIndx_outputs = i
					outputs.get(_rdIndx_outputs)
				}.setToolTip(Strings::getter(desc.getName()))
				outMap.put({
					val _rdIndx_outputs = i
					outputs.get(_rdIndx_outputs)
				}, desc)
			}
			fireContentSet()
			return true
		} catch (Exception ex) {
			ex.printStackTrace()
			JOptionPane::showMessageDialog(null, ex.getMessage(), Strings::get("validationParseError"),
				JOptionPane::ERROR_MESSAGE)
			return false
		}

	}

	def Port[] getControls() {
		return ctrl
	}

}
