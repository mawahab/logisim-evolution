package com.cburch.logisim.statemachine.simulator

import com.cburch.logisim.statemachine.fSMDSL.*
import com.cburch.logisim.statemachine.fSMDSL.Constant
import com.cburch.logisim.statemachine.fSMDSL.FSM
import com.cburch.logisim.statemachine.fSMDSL.InputPort
import java.util.HashMap
import java.util.Map.Entry
import com.cburch.logisim.statemachine.PrettyPrinter

class FSMSimulator {
	
	FSM fsm;
	
	State current  
	HashMap<Port,Boolean> inputs;
	HashMap<Port,Boolean> outputs;
	
	new(FSM fsm) {
		this.fsm=fsm;
		inputs =  new HashMap<Port,Boolean>();
		outputs =  new HashMap<Port,Boolean>();
		current=fsm.start
		refreshPorts
	}
	
	def refreshPorts() {
		inputs.clear;
		outputs.clear;
		this.fsm.in.forEach[ip | inputs.put(ip,false)]
		this.fsm.out.forEach[op | outputs.put(op,false)]
	}
	
	def getFSM() {
		fsm
	}
	def reset() {
		current=fsm.start
	}
	def setInput(String ip,Boolean b) {
		for(Port p : inputs.keySet) {
			if(p.name==ip) {
				setInput(p as InputPort,b);
				return;
			}
		}
		throw new RuntimeException(ip+" is not a known input for fsm "+fsm.name+ " "+fsm.in.map[p|p.name])
	}

	def getOutput(int i) {
		try {
			return outputs.get(fsm.out.get(i));
			
		} catch (Exception e) {
			throw new RuntimeException(i+" is not a known output for fsm "+fsm.name+ " "+fsm.out.map[p|p.name])
		}
	}

	def setInput(InputPort ip,Boolean b) {
		inputs.put(ip,b)
	}
	
	def update() {
		println("Current state "+current.name)
		for (Port e : inputs.keySet) {
			println("\tinputs"+e.name+"=>"+inputs.get(e))
		}  
		for (Command c : current.commandList.commands) {
			val res= eval(c.value)
			outputs.replace(c.getName(), res);
			println("\t"+c.name.name+"="+res)
		}  
		for (Transition t : current.transition) {
			println("Evaluating transition= "+PrettyPrinter.pp(t))
			if (eval(t.predicate)) {
				current= t.dst
				println("\nTransition fired : next state is "+current.name)
			} else {
				println("\nTransition no actived")
			}
		}
		return current;
	}
	
	def dispatch boolean eval(BoolExpr exp) {
		false	
	}

	def dispatch boolean eval(Constant exp) {
		if (exp.value.equals("\"0\"")) {
			false
		} else if (exp.value.equals("\"1\"")) {
			true
		} else {
			println("ËRROR")
			throw new UnsupportedOperationException("NYI");
		}
	}

	def dispatch boolean eval(OrExpr b) {
		for(arg : b.args) {
			if (eval(arg)) return true;
		}
		false
	}
	def dispatch boolean eval(AndExpr b) {
		for(arg : b.args) {
			if (!eval(arg)) return false;
		}
		true
	}
	def dispatch boolean eval(NotExpr b) {
		!(eval(b.args.get(0)))
		
	}
	def dispatch boolean eval(PortRef b) {
		inputs.get(b.port)
	}

	
}