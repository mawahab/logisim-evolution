package com.cburch.logisim.statemachine.editor.editpanels;

import java.awt.Color;

import javax.swing.*;

import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLFactory;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.cburch.logisim.statemachine.validation.FSMValidation;



public class FSMStateEditPanel extends JPanel{

	JTextField nameField ;
	JTextField codeField ;
	JCheckBox  initialState ;
	State state;
	
	public FSMStateEditPanel(State state) {
		super();
		this.state=state;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		nameField = new JTextField(10);
		codeField = new JTextField(10);
		initialState = new JCheckBox("Initial state ?");
		nameField.setText(state.getName());
		codeField.setText(state.getCode());

		add(new JLabel("Label"));
		add(nameField);
		add(new JLabel("Binary code"));
		add(codeField);
		add(new JLabel("Initial state"));
		add(initialState);

		codeField.addActionListener
		(	
			new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				}
			}
		);

	}
	
	private boolean checkInput(int result) {
		FSM fsm = (FSM)(state.eContainer());
		if (result == JOptionPane.OK_OPTION) {
			String txt = codeField.getText();
			if(initialState.isSelected()) {
				fsm.setStart(state);
			}
			if (!FSMValidation.isValidBinaryString(codeField.getText(), fsm.getWidth())) {
				JOptionPane.showMessageDialog(null, "Error: Please enter a binary code (instead of "+codeField.getText()+")", "Error Message",
						JOptionPane.ERROR_MESSAGE);
				return true;
			}
			if (!FSMValidation.isValidIdentifier(nameField.getText())) {
				JOptionPane.showMessageDialog(null, "Error: Please enter a valid identifer string (instead of "+nameField.getText()+")", "Error Message",
						JOptionPane.ERROR_MESSAGE);
				return true;
			}
			if (FSMValidation.isReservedKeyword(nameField.getText())) {
				JOptionPane.showMessageDialog(null, "Error: "+nameField.getText()+" is a reserved keyword)", "Error Message",
						JOptionPane.ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}
	public void configure() {
		boolean error=true;
		while(error) {
			int dialog = JOptionPane.showConfirmDialog(null, this, "State configuration",JOptionPane.OK_CANCEL_OPTION);
			error = checkInput(dialog);
		}
		state.setName(nameField.getText());
		state.setCode(codeField.getText());
	}


}