package com.cburch.logisim.statemachine.simulator

import com.cburch.logisim.statemachine.PrettyPrinter
import com.cburch.logisim.statemachine.fSMDSL.*
import com.cburch.logisim.statemachine.fSMDSL.Constant
import com.cburch.logisim.statemachine.fSMDSL.FSM
import com.cburch.logisim.statemachine.fSMDSL.InputPort
import java.util.ArrayList
import java.util.HashMap
import java.util.List

import com.cburch.logisim.instance.InstanceData
import com.cburch.logisim.std.memory.ClockState

class FSMSimulator extends ClockState implements InstanceData {
	
	FSM fsm;
	
	State current  
	HashMap<Port,String> inputs;
	HashMap<Port,String> outputs;
	
	static final char ONE_C = '1';
	static final char ZERO_C = '0';
	
	
	new(FSM fsm) {
		this.fsm=fsm;
		inputs =  new HashMap<Port,String>();
		outputs =  new HashMap<Port,String>();
		current=fsm.start
		refreshPorts
	}
	


	def setCurrentState(State s) {
		current = s;
	}
	
	def getCurrentState() {
		current ;
	}
	
	def quote(String s) {
		"\""+s+ "\"";
	}

	def zeros(int width) {
		var res = "";
		for (int i:0..width-1) {
			res+="0"
		}
		quote(res)
	}
	
	def ones(int width) {
		var res = "";
		for (int i:0..width-1) {
			res+="1"
		}
		quote(res)
	}
	
	static final String ZERO = "\"0\"";
	static final String ONE = "\"1\"";
	
	def isTrue(String s) {
		s.equals(ONE);
	}
	
	def refreshPorts() {
		inputs.clear;
		outputs.clear;
		this.fsm.in.forEach[ip | inputs.put(ip,zeros(ip.width))]
		this.fsm.out.forEach[op | outputs.put(op,zeros(op.width))]
	}
	
	def getFSM() {
		fsm
	}
	def reset() {
		current=fsm.start
	}

	def getOutput(int i) {
		try {
			return outputs.get(fsm.out.get(i));
		} catch (Exception e) {
			throw new RuntimeException(i+" is not a known output for fsm "+fsm.name+ " "+fsm.out.map[p|p.name])
		}
	}

	def setInput(InputPort ip,String b) {
		inputs.put(ip,b)
	}
	
	def updateState() { 
		println("FSM "+fsm.name+" current state "+current.name)
		for (Port e : inputs.keySet) {
			println("\tIn "+e.name+"=>"+inputs.get(e))
		}  
		
		var State defaultDst =null;
		var State nextDst =null;
		for (Transition t : current.transition) {
			println("\tTransition= "+PrettyPrinter.pp(t))
			if(t.predicate instanceof DefaultPredicate) {
				defaultDst = t.dst
			} else {
				val res = (eval(t.predicate))
				if (isTrue(res)) {
					nextDst= t.dst
					println("\t\tTransition fired : next state is "+nextDst.name)
				} else {
					println("\t\tTransition not actived")
				}
			}
		}
		if (nextDst!=null) {
			current = nextDst
		} else if (defaultDst!=null) {
			current = defaultDst
			println("\t\tDefault transition fired "+defaultDst.name)
		}		
		return current;
	}
	
	def updateCommands() {
		for (Command c : current.commandList.commands) {
			val res= eval(c.value)
			outputs.replace(c.getName(), res);
			println("\tSet "+c.name.name+" to "+res)
		}  
	}

	def dispatch String eval(BoolExpr exp) {
		 throw new RuntimeException("Unsupported operation"+PrettyPrinter.pp(exp));
	}

	def dispatch String eval(ConcatExpr exp) {
		val r  = new StringBuffer()
		for(arg : exp.args) {
			r.append(unquote(eval(arg)))
		}
		quote(r.toString)
	}

	def unquote(String s) {
		s.substring(1,s.length-1)		
	}


	def dispatch String eval(DefaultPredicate exp) {
		ZERO
	}
	
	
	def dispatch String eval(CmpExpr b) {
		if (b.args.size!=2) {
		 		throw new RuntimeException("Inconsistent arity for expression "+PrettyPrinter.pp(b));
		}
		val equ = b.args.get(0).equals(b.args.get(1))
		switch(b.op) {
			case "==" :{
				if (equ) {
					quote("1")
				} else {
					quote("0")
				}
			}
			case "/=" :{
				if (equ) {
					quote("0")
				} else {
					quote("1")
				}
			}
			default : {
				throw new RuntimeException("Inconsistent operator "+b.op+" for expression "+PrettyPrinter.pp(b));
			}
		}
	}


	def dispatch String eval(Constant exp) {
		exp.value
	}

	def setCharAt(String s, char c, int i) {
		val StringBuilder myName = new StringBuilder(s);
		myName.setCharAt(i, c);
		myName.toString;
	}	

	def dispatch String eval(OrExpr b) {
		var width = -1;
		var List<String> l= new ArrayList<String>(); 
		var orRes = ""
		for(arg : b.args) {
			val res = (eval(arg))
			l+= res
			if (width==-1) {
				width = res.length
				orRes = zeros(width);
		 	} else if (width!=res.length) {
		 		throw new RuntimeException("Inconsistent width in expression "+PrettyPrinter.pp(b));
		 	}
		 	for(i:0..width-1) {
		 		orRes.setCharAt(or(orRes.charAt(i), res.charAt(i)),i)
		 	}
		}
		quote(orRes)
		
	}
	def dispatch String eval(AndExpr b) {
		var width = -1;
		var List<String> l= new ArrayList<String>(); 
		var andRes = ""
		for(arg : b.args) {
			val res = (eval(arg))
			l+= res
			if (width==-1) {
				width = res.length
				andRes = zeros(width);
		 	} else if (width!=res.length) {
		 		throw new RuntimeException("Inconsistent width in expression "+PrettyPrinter.pp(b));
		 	}
		 	for(i:0..width-1) {
		 		andRes.setCharAt(and(andRes.charAt(i), res.charAt(i)),i)
		 	}
		}
		quote(andRes)
		
	}
	
	def dispatch String eval(NotExpr b) {
		if (b.args.size!=1) {
		 		throw new RuntimeException("Inconsistent arity for expression "+PrettyPrinter.pp(b));
		 }
		var width = -1;
		var List<String> l= new ArrayList<String>(); 
		var notExpr = ""
		
		
		var res = eval(b.args.get(0))
		res= res.replace('0', '@');
		res= res.replace('1', '0');
		res= res.replace('@', '1');
		
//		l+= res
//		width = res.length
//		notExpr = zeros(width);
//		for(i:0..width-1) {
//			val c= res.charAt(i)
//			val neg=not(c)
//	 		notExpr.setCharAt(neg,i+1)
//	 	}
//		val r= quote(notExpr)
		println("eval("+PrettyPrinter.pp(b)+")="+res)
		res
		
	}

	def char or(char c, char b) {
		if (c=='1' || b=='1') '1' else '0'
	}
	
	def char and(char c, char b) {
		if (c=='1' && b=='1') '1' else '0'
	}

	def char not(char c) {
		
		switch(c) { 
		  case '0' : '1' 
		  case '1' : '0' 
		  default : {
		  	throw new RuntimeException("Unsupported value "+c+", only '0' or '1' supported");
		  }  
		}
	}

	def dispatch String eval(PortRef b) {
		if(b.range!=null) {
			val lb = b.range.lb+1 
			val ub = b.range.ub+1 
			quote(inputs.get(b.port).substring(lb,ub))
		} else {
			inputs.get(b.port)
		}
	}
		
	

	
}