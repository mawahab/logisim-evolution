package com.cburch.logisim.statemachine.editor.editpanels;

import java.awt.Color;

import javax.swing.*;

import com.cburch.logisim.statemachine.fSMDSL.FSM;



public class FSMEditPanel extends JPanel{

	JTextField nameField ;
	JTextField codeField ;
	JCheckBox  initialFSM ;
	FSM fsm;
	
	public FSMEditPanel(FSM fsm) {
		super();
		this.fsm=fsm;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		nameField = new JTextField(10);
		codeField = new JTextField(10);
		nameField.setText(fsm.getName());
		codeField.setText(""+fsm.getWidth());

		add(new JLabel("Name"));
		add(nameField);
		add(new JLabel("Code width "));
		add(codeField);

		codeField.addActionListener
		(	
			new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				}
			}
		);

	}
	
	private boolean checkInput(int result) {
		if (result == JOptionPane.OK_OPTION) {
			String txt = codeField.getText();
			char first = txt.charAt(0);
			char last = txt.charAt(txt.length()-1);
			if(first=='"'&& last=='"') {
				txt=txt.substring(1, txt.length()-2);
				for (char c : txt.toCharArray()) {
					if (c != '0' && c != '1') {
						JOptionPane.showMessageDialog(null, "Error: Please enter a binary code (instead of "+txt+")", "Error Message",
								JOptionPane.ERROR_MESSAGE);
						return true;
						
					}
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
		int dialog = JOptionPane.showConfirmDialog(null, this, "Please Enter X and Y Values",JOptionPane.OK_CANCEL_OPTION);
		int parseInt = Integer.parseInt(codeField.getText());
		fsm.setName(nameField.getText());
		fsm.setWidth(parseInt);
	}


}