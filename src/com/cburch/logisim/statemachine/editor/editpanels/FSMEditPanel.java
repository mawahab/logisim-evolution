package com.cburch.logisim.statemachine.editor.editpanels;

import java.awt.Color;

import javax.swing.*;

import com.cburch.logisim.statemachine.editor.view.FSMCustomFactory;
import com.cburch.logisim.statemachine.fSMDSL.FSM;



public class FSMEditPanel extends JPanel{

	JTextField nameField ;
	JTextField codeField ;
	JCheckBox  initialFSM ;
	FSM fsm;
	private JTextField widthField;
	private JTextField heightField;
	
	public FSMEditPanel(FSM fsm) {
		super();
		this.fsm=fsm;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		nameField = new JTextField(10);
		codeField = new JTextField(10);
		widthField = new JTextField(10);
		heightField = new JTextField(10);
		nameField.setText(fsm.getName());
		codeField.setText(""+fsm.getWidth());
		widthField.setText(""+fsm.getLayout().getWidth());
		heightField.setText(""+fsm.getLayout().getHeight());
		add(new JLabel("Name"));
		add(nameField);
		add(new JLabel("Code width "));
		add(codeField);
		add(new JLabel("Diagram width "));
		add(widthField);
		add(new JLabel("Diagram height "));
		add(heightField);

		codeField.addActionListener
		(	
			new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				}
			}
		);

	}
	

	public void configure() {
		boolean error = true;

		while(error) {
			try {
				int dialog = JOptionPane.showConfirmDialog(null, this, "State configuration",JOptionPane.OK_CANCEL_OPTION);
				int parseInt = Integer.parseInt(codeField.getText());
				fsm.setName(nameField.getText());
				fsm.setWidth(parseInt);
				parseInt = Integer.parseInt(widthField.getText());
				fsm.getLayout().setWidth(Math.max(FSMCustomFactory.FSM_WIDTH, parseInt));
				parseInt = Integer.parseInt(heightField.getText());
				fsm.getLayout().setHeight(Math.max(FSMCustomFactory.FSM_HEIGHT, parseInt));
				error=false;
			} catch (NumberFormatException e) {
				error=true;
			}
		}		
	}


}