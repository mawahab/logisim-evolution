package com.cburch.logisim.statemachine.editor.editpanels

import com.cburch.logisim.statemachine.fSMDSL.BoolExpr
import com.cburch.logisim.statemachine.fSMDSL.OrExpr
import com.cburch.logisim.statemachine.fSMDSL.AndExpr
import com.cburch.logisim.statemachine.fSMDSL.NotExpr
import com.cburch.logisim.statemachine.fSMDSL.PortRef
import com.cburch.logisim.statemachine.fSMDSL.InputPort
import java.util.HashMap
import com.cburch.logisim.statemachine.fSMDSL.OutputPort
import com.cburch.logisim.statemachine.fSMDSL.Port
import com.cburch.logisim.statemachine.fSMDSL.FSM
import com.cburch.logisim.statemachine.fSMDSL.Command
import com.cburch.logisim.statemachine.fSMDSL.Transition
import com.cburch.logisim.statemachine.fSMDSL.CmpExpr
import com.cburch.logisim.statemachine.fSMDSL.Constant

class PortReferenceFix {
	
	HashMap<String,Port> portMap = new HashMap<String,Port>()
	
	new(FSM fsm) {
		fsm.in.forEach[ip|portMap.put(ip.name,ip)]
		fsm.out.forEach[op|portMap.put(op.name,op)]
	}
	
	def dispatch void replaceRef(Command c) {
		if (c.name!=null) {
			c.name = portMap.get(c.name.name) as OutputPort;
		}
		replaceRef(c.value)
	}


	def dispatch void replaceRef(BoolExpr b) {
		throw new UnsupportedOperationException("NYI");
	}
	
	def dispatch void replaceRef(Constant  b) {
	
	}
	def  dispatch void replaceRef(OrExpr b) {
		b.args.forEach[a|replaceRef(a)]
	}
	def  dispatch void replaceRef(AndExpr b) {
		b.args.forEach[a|replaceRef(a)]
	}
	def  dispatch void replaceRef(CmpExpr b) {
		b.args.forEach[a|replaceRef(a)]
	}
	def  dispatch void replaceRef(NotExpr b) {
		b.args.forEach[a|replaceRef(a)]
	}
	def  dispatch void replaceRef(PortRef b) {
		if (b.port!=null) {
			b.port = portMap.get(b.port.name);
		} else {
			
		}
	}
	

}