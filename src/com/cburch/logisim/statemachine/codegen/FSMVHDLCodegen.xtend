package com.cburch.logisim.statemachine.codegen

// Drawing.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds various methods for manipulating and storing the shapes in the drawing.

import com.cburch.logisim.statemachine.fSMDSL.AndExpr
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr
import com.cburch.logisim.statemachine.fSMDSL.FSM
import com.cburch.logisim.statemachine.fSMDSL.NotExpr
import com.cburch.logisim.statemachine.fSMDSL.OrExpr
import com.cburch.logisim.statemachine.fSMDSL.Port
import com.cburch.logisim.statemachine.fSMDSL.PortRef
import com.cburch.logisim.statemachine.fSMDSL.State
import com.cburch.logisim.statemachine.fSMDSL.Constant
import com.cburch.logisim.statemachine.fSMDSL.Command
import com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate
import javafx.animation.Transition
import java.io.PrintStream
import java.io.File
import java.util.ArrayList

class FSMVHDLCodeGen{


	/** 
	 * Constructor. Initialize the color to the default color and create the
	 * ArrayList to hold the shapes.
	 * @param defaultColor
	 */
	new() {
	}

	def export(FSM fsm, File f) {
		val ps  = new PrintStream(f);
		ps.append(generate(fsm));
		ps.close
	}

	def dispatch generate(FSM e) {
		var ios = new ArrayList<Port>();
		ios.addAll(e.in)
		ios.addAll(e.out)
		'''
		library IEEE;  
		use IEEE.std_logic_1164.all; 
		
		entity «e.name» is port (
			clk : in std_logic;
			clr : in std_logic;
			en  : in std_logic;
			«FOR i:ios SEPARATOR ";"»
			«ENDFOR»
		);
		end entity;
		
		architecture RTL of «e.name» is
			type state_type is («e.states.map[s|'_'+s.name].reduce[s1,s2|s1+','+s2]»);  
			signal symCS : state_type ;  
			signal CS : std_logic_vector(«e.width-1» downto 0) ;  
			
			«FOR s:e.states»
			constant «s.name» is std_logic_vector(«e.width-1» downto 0):=«s.code»;
			«ENDFOR»
			
		begin
			UPDATE: process(clk,clr)
			begin
				if clr='1' then
					CS <= «e.start.name»;
					symCS <= _«e.start.name»;
				elsif rising_edge(clk) then
					case (CS) is
						«FOR s:e.states»«genTransition(s)»«ENDFOR» 
						when others => null;
					end case; 
				end if;
			end process;
			
			OUTPUT : process(CS,«FOR i:e.in SEPARATOR ","»«i.name»«ENDFOR»)
			begin
				case (CS) is
					«FOR s:e.states»«genCommand(s)»«ENDFOR» 
					when others => null;
				end case; 
			end process;
			
		end RTL;
		'''
	}
	
	def getDefault(State s) {
		s.transition.findFirst[p|(p.predicate instanceof DefaultPredicate)]
	}
	def genTransition(State state) {
		'''when «state.name» =>
				«FOR t:state.transition.filter[t|!(t.predicate instanceof DefaultPredicate)]»
				if «genPred(t.predicate)» then
					CS <= «t.dst.name»;
					symCS <= _«t.dst.name»;
				end if;
				«ENDFOR»
				«IF getDefault(state)!=null»
				-- default transition
				CS <= «getDefault(state).dst»;
				symCS <= _«getDefault(state).dst»;
				«ENDIF»
		'''
	}
	

	def static dispatch genPred(OrExpr b) {
		'''(«FOR i:b.args SEPARATOR " or "»«genPred(i)»«ENDFOR»)'''.toString
	}
	def static dispatch genPred(AndExpr b) {
		'''(«FOR i:b.args SEPARATOR " and "»«genPred(i)»«ENDFOR»)'''.toString
	}
	def static dispatch genPred(NotExpr b) {
		"(/"+genPred(b.args.get(0))+")";
		
	}
	def static dispatch genPred(PortRef b) {
		b.port.name
	}
	def static dispatch genPred(Constant b) {
		b.value
	}


	def genCommand(State s) {
		'''
		when «s.name» => 
		«FOR c:s.commandList.commands»
			«genCommand(c)»
		«ENDFOR»
		'''
	}
	
	def genCommand(Command c) {
		c.name.name+"<="+genPred(c.value)+";";		
	}
	def gen(Port port) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}




}
