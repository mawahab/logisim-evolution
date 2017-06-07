package com.cburch.logisim.statemachine.simulator

import com.cburch.logisim.statemachine.fSMDSL.BoolExpr
import com.cburch.logisim.statemachine.fSMDSL.InputPort
import com.cburch.logisim.statemachine.fSMDSL.OutputPort
import com.cburch.logisim.statemachine.fSMDSL.Port
import com.cburch.logisim.statemachine.fSMDSL.PredicateStmt
import com.cburch.logisim.statemachine.parser.FSMSerializer
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.util.List
import org.junit.Test

import static org.junit.Assert.*

class TestSimulator {
	
	def static BoolExpr boolExpr(String in) throws IOException {
		var InputStream fis = new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8))
		val stmt= FSMSerializer.parse(fis) as PredicateStmt
		stmt.predicate
	}

	List<List<String>> in = #[
		#["1100", "1"],
		#["1100", "0"],
		#["0011", "1"],
		#["0000", "0"],
		#["0000", "0"]
	];

	List<List<String>> out = #[
		#["S0","0001"],
		#["S0","0001"],
		#["S1","0010"],
		#["S2","0000"],
		#["S0","0001"]
	];

	val fsm = '''fsm example  { 

		in  keypad [ 4 ]; 
		in  A [ 1 ]; 
		out X [ 4 ] ; 
		codeWidth = 2 ; 
		reset = S0 ; 

		state S0 = "01" { 
			commands  { X = "0001" ; }
			transitions { 
				S0 -> S1 when A.keypad/="1100" ; 
			}
		} 
		state S1 = "10" { 
			commands { X = "0010" ; } 
			transitions { 
				S1 -> S2 when keypad/="1010"   ; 
			} 
		} 
		state S2 = "00"  { 
			commands { X = { "0000" } ; } 
			transitions { 
				S2 -> S0 when default   ; 
			} 
		}
	}
	
	''' 
	@Test 
	def test1() {
		testFSM(fsm,in,out);
	}
	
	def void testFSM(String sfsm, List<List<String>> in, List<List<String>> out) {
		val fsm = FSMSerializer.load(sfsm)
		val fsmSim = new FSMSimulator(fsm);
		fsmSim.reset
		var tick = 0;
		for (tick = 0; tick<in.size; tick++) {
			println(''' current state = «fsmSim.currentState.name»''');
			for(i : 0..fsm.in.size-1) {
				val iport = fsm.in.get(i) as InputPort
				println('''    - input «iport.name»=>«in.get(tick).get(i)»''');
				fsmSim.updateInput(iport, quote(in.get(tick).get(i)))
			}
			fsmSim.updateState
			println(''' new state = «fsmSim.currentState.name»''');
			if(!out.get(tick).get(0).equals(fsmSim.currentState.name)) {
					fail('''Inconsitent state at tick «tick», state «out.get(tick).get(0)» expected, «fsmSim.currentState.name» observed''')
			}

			fsmSim.updateCommands
			for(i : 0..fsm.out.size-1) {
				val oport = fsm.out.get(i) as OutputPort
				val v=  fsmSim.getOutput(i)
				println('''    - output «oport.name»=>«v»''');
				val ref = quote(out.get(tick).get(i+1))
				if (!(ref).equals(v)) {
					fail('''Inconsitent output for «oport.name» at tick «tick», value «out.get(tick).get(i)» expected, «v» observed''')
				}
			}
		}
	}
	
	def quote(String string) {
		"\""+string+"\""
	}

}
