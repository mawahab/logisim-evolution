package com.cburch.logisim.statemachine.editor.editpanels;

import java.awt.Color;

import javax.swing.*;

import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLFactory;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;



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
			char first = txt.charAt(0);
			char last = txt.charAt(txt.length()-1);
			if(first=='"'&& last=='"') {
				txt=txt.substring(1, txt.length()-1);
				for (char c : txt.toCharArray()) {
					if (c != '0' && c != '1') {
						JOptionPane.showMessageDialog(null, "Error: Please enter a binary code (instead of "+txt+")", "Error Message",
								JOptionPane.ERROR_MESSAGE);
						return true;
						
					}
				}
				if ((txt.length())!=fsm.getWidth()) {
					JOptionPane.showMessageDialog(null, "Error: Please enter a "+fsm.getWidth()+" bit code ", "Error Message",
							JOptionPane.ERROR_MESSAGE);
				}
			}  else {
				JOptionPane.showMessageDialog(null, "Error: Please enter a binary code (instead of "+txt+")", "Error Message",
						JOptionPane.ERROR_MESSAGE);
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