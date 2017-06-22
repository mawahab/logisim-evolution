package com.cburch.logisim.statemachine.bdd

import static org.junit.Assert.*
import org.junit.Test
import com.cburch.logisim.statemachine.parser.FSMSerializer

class TestBdd {

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

	def void testFSM(String sfsm) {
		val fsm = FSMSerializer.load(sfsm)
		
		
	}

	@Test def void test() {
		fail("Not yet implemented")
	}

}
