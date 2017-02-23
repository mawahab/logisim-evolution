package com.cburch.logisim.statemachine.editor.editpanels;

import java.awt.Color;
import java.io.IOException;

import javax.swing.*;

import org.eclipse.emf.ecore.EObject;

import com.cburch.logisim.statemachine.PrettyPrinter;
import com.cburch.logisim.statemachine.bdd.BDDOptimizer;
import com.cburch.logisim.statemachine.editor.shapes.FSMStateShape;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
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
				PortReferenceFix fixer = new PortReferenceFix(fsm);
				fixer.replaceRef(res.getPredicate());
				BDDOptimizer optimizer = new BDDOptimizer(res.getPredicate());
				if (optimizer.isAlwaysFalse()) {
					JOptionPane.showConfirmDialog(null, 
							"Warning : predicate "+PrettyPrinter.pp(res.getPredicate())+" can never be satisfied",
							"Warning", 
							JOptionPane.OK_OPTION);
				}
				return res.getPredicate();
			} catch (IOException e) {
				e.printStackTrace();
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