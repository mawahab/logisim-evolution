package com.cburch.logisim.statemachine.editor.editpanels;

import java.awt.Color;
import java.io.IOException;

import javax.swing.*;

import org.eclipse.emf.ecore.EObject;

import com.cburch.logisim.statemachine.PrettyPrinter;
import com.cburch.logisim.statemachine.bdd.BDDOptimizer;

import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLFactory;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.PredicateStmt;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.cburch.logisim.statemachine.parser.FSMSerializer;

public class FSMTransitionEditPanel extends JPanel{

	JTextField condField ;
	Transition t;
	
	public FSMTransitionEditPanel(Transition t) {
		super();
		this.t=t;
		
		condField = new JTextField(20);
		BoolExpr predicate = t.getPredicate();
		if(predicate!=null) {
			condField.setText(PrettyPrinter.pp(predicate));
		}
		
		add(new JLabel("Condition"));
		add(condField);

	}
	
	private BoolExpr checkInput(int result) {
		PredicateStmt res= null;
		if (result == JOptionPane.OK_OPTION) {
			String txt = condField.getText();
			try {
				FSM fsm = (FSM)t.eContainer().eContainer();
				res= (PredicateStmt) FSMSerializer.parsePredicate(fsm, txt);
				BoolExpr predicate = res.getPredicate();
				if (!(predicate instanceof DefaultPredicate)) {
					PortReferenceFix fixer = new PortReferenceFix(fsm);
					fixer.replaceRef(predicate);
					BDDOptimizer optimizer = new BDDOptimizer(predicate);
					if (optimizer.isAlwaysFalse()) {
						JOptionPane.showConfirmDialog(null, 
								"Warning : predicate "+PrettyPrinter.pp(predicate)+" can never be satisfied",
								"Warning", 
								JOptionPane.OK_OPTION);
					}
				}
				return predicate;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, this, "Error : "+e.getMessage(),JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}
		return t.getPredicate();
	}
	public void configure() {
		BoolExpr condition=null;
		while(condition==null) {
			int dialog = JOptionPane.showConfirmDialog(null, 
					this, 
					"FSM transition configuration",JOptionPane.OK_CANCEL_OPTION);
			condition = checkInput(dialog);
		}
		t.setPredicate(condition);
	}


}