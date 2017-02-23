package com.cburch.logisim.statemachine.editor.view

import java.awt.Point
import org.eclipse.emf.ecore.EObject
import com.cburch.logisim.statemachine.fSMDSL.*
import java.awt.Color
import java.awt.RenderingHints
import java.awt.Graphics2D
import java.awt.geom.RoundRectangle2D
import com.cburch.logisim.statemachine.PrettyPrinter
import com.cburch.logisim.statemachine.editor.shapes.CommandShape
import com.cburch.logisim.statemachine.editor.shapes.FSMStateShape
import org.eclipse.emf.ecore.util.EcoreUtil
import com.cburch.logisim.statemachine.fSMDSL.FSM
import com.cburch.logisim.statemachine.editor.editpanels.FSMCommandListEditPanel
import com.cburch.logisim.statemachine.bdd.BDDOptimizer
import javax.swing.JOptionPane
import java.util.HashSet
import java.util.List
import java.util.ArrayList

class FSMValidation{

	FSM fsm
	
	HashSet<State> targets = new HashSet<State>();
	List<String> warnings= new ArrayList<String>()
	List<String> errors= new ArrayList<String>()

	new(FSM fsm) {
		this.fsm=fsm;
	}
	
	public def getErrors() {errors}
	public def getWarnings() {warnings}

	public def dispatch validate(FSM e) {  
		if(e.start==null) {
			error("No initial state")
		}
		if(e.states.size==0) {
			error("The FSM has no states !")
		}
		if(e.out==0) {
			warning("The FSM has no output pins !")
		}
		if(e.in==0) {
			warning("The FSM has no input pins !")
		}
		for(s : e.states) {
			validate(s)
		}  
		for(s : e.states) {
			if (s!=fsm.start && !targets.contains(s)) {
				warning("State "+PrettyPrinter.pp(s)+" is not reachable from initial state "+PrettyPrinter.pp(e.start));
			}
		}
	}
	
	
	public def warning(String string) {
		warnings.add(string);
	}
	public def error(String string) {
		errors.add(string);
	}

	public def dispatch validate(FSMElement e) {
		
	}
	public def dispatch validate(CommandList cl) {
		for(c : cl.commands) {
			val optimizer = new BDDOptimizer(c.value);
			optimizer.simplify
			
			if (optimizer.isAlwaysFalse()) {
				warning("command "+PrettyPrinter.pp(c)+" is always evaluated to 0");
			}
			if (optimizer.isAlwaysTrue()) {
				warning("command "+PrettyPrinter.pp(c)+" is always evaluated to 1");
			}
		}
	}

	public def dispatch validate(Transition t) {
		val optimizer = new BDDOptimizer(t.predicate);
		optimizer.simplify
		if (optimizer.isAlwaysFalse()) {
			error("Transition  "+PrettyPrinter.pp(t)+" is never taken (evaluated to 0)");
		}
		if (optimizer.isAlwaysTrue()) {
			warning("Transition "+PrettyPrinter.pp(t)+" is always taken (evaluated to 1)");
		}		
	}
	
	public def dispatch validate(State e) {
		var int i=0;
		var int j=0
		if (e.eContainer instanceof FSM) {
			val fsm = e.eContainer as FSM
			if(e.code.length!=(fsm.width+2)) {
				error("State "+PrettyPrinter.pp(e)+" code is not consistent with FSM configuration ("+fsm.width+" bits expected");
			}
		}
		if(e.transition.size==0) {
			warning("State "+PrettyPrinter.pp(e)+" has no output transition");
		}
		val nonDefaultTransitions = e.transition.filter[t|!(t instanceof DefaultPredicate)]
		if ((e.transition.size-nonDefaultTransitions.length)>1) {
			error("State "+PrettyPrinter.pp(e)+" has multiple default transitions");
		}
		for (a: nonDefaultTransitions) {
			validate(a)
			targets.add(a.dst)
			j=0;
			for (b: nonDefaultTransitions) {
				if(i<j) {
					val or = FSMCustomFactory.or(a.predicate,b.predicate) 
					val optimizer = new BDDOptimizer(or);
					if (!optimizer.isAlwaysFalse()) {
						error("Transitions "+PrettyPrinter.pp(a)+" and "+PrettyPrinter.pp(a)+" are not mutually exclusive");
					}
				}
				j+=1
			}
			i+=1
		}
		
	}


}