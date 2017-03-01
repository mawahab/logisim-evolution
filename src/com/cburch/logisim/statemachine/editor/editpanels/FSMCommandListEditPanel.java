package com.cburch.logisim.statemachine.editor.editpanels;

import java.awt.Color;
import java.io.IOException;
import java.util.Optional;

import javax.swing.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.cburch.logisim.statemachine.PrettyPrinter;
import com.cburch.logisim.statemachine.FSMExample;

import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLFactory;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.PredicateStmt;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.CommandStmt;
import com.cburch.logisim.statemachine.parser.FSMSerializer;

public class FSMCommandListEditPanel extends JPanel{

	JTextField condField ;
	CommandList list;
	
	public FSMCommandListEditPanel(CommandList state) {
		super();
		this.list=state;
		
		condField = new JTextField(20);
		condField.setText("");
		if(state!=null & state.getCommands().size()>0) {
			Optional<String> command = state.getCommands().stream().map(
					(c)->
					(c.getName().getName()+"="+PrettyPrinter.pp(c.getValue()))
			).reduce((x,y)->(x+","+y));
			condField.setText(command.get());
		}
		
		add(new JLabel("Commands"));
		add(condField);

	}
	
	private EList<Command> checkInput(int result) {
		CommandStmt res= null;
		if (result == JOptionPane.OK_OPTION) {
			String txt = condField.getText();
			try {
				FSM fsm = (FSM)list.eContainer().eContainer();
				res= (CommandStmt) FSMSerializer.parseCommandList(fsm, txt);
				EList<Command> commands = res.getCommands();
				for(Command c:commands) {
					PortReferenceFix fixer = new PortReferenceFix(fsm);
					fixer.replaceRef(c);
				}
				return commands;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list.getCommands();
	}
	public void configure() {
		EList<Command> commands=null;
		while(commands==null) {
			int dialog = JOptionPane.showConfirmDialog(null, this, "Please specify transition predicate",JOptionPane.OK_CANCEL_OPTION);
			commands = checkInput(dialog);
		}
		list.getCommands().clear();
		list.getCommands().addAll(commands);
	}
}