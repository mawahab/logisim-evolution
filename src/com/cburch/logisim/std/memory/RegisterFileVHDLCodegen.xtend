package com.cburch.logisim.std.memory

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
import com.cburch.logisim.statemachine.fSMDSL.CmpExpr
import java.io.FileNotFoundException
import com.cburch.logisim.statemachine.fSMDSL.InputPort
import com.cburch.logisim.statemachine.fSMDSL.OutputPort

class RegisterFileVHDLCodeGen{


	/** 
	 * Constructor. Initialize the color to the default color and create the
	 * ArrayList to hold the shapes.
	 * @param defaultColor
	 */
	new() {
	}

	
	def  generate() {
		'''
		library IEEE;
		use IEEE.STD_LOGIC_1164.ALL;
		use IEEE.NUMERIC_STD.ALL;
		
		architecture RTL of REGISTER_FILE is

		type RAM_type is ARRAY(0 to 31) of STD_LOGIC_VECTOR(31 downto 0);
		signal RAM : RAM_type := (others => (others => '0'));

		begin
		
		    DO0 <= RAM(to_integer(unsigned(RAD0)));
		    DO1 <= RAM(to_integer(unsigned(RAD1)));

		    process(CLK, RST) is
		    begin
		        if rising_edge(CLK)  THEN
		            if (RST = '1') THEN
		               	RAM <= (others => (others => '0'));
		            ELSIF (WE = '1' and Tick='1') THEN
		               	RAM(to_integer(unsigned(WAD))) <= DI;
		            end if;
		        end if;
		    end process;			

		end RTL;
		'''
	}
	
	
}
