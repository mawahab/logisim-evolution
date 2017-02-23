package com.cburch.logisim.statemachine.editor;
// Editor.java

// An applet for an object-oriented graphical editor.
// This class implements the GUI for the editor.
// Written by THC for CS 5 Lab Assignment 3.
// Modified by Matthew McNierney for CS 5 Lab Assignment 3

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.cburch.logisim.statemachine.editor.commands.AddElementCmd;

import com.cburch.logisim.statemachine.editor.commands.EditorCommand;
import com.cburch.logisim.statemachine.editor.commands.MoveElementCmd;
import com.cburch.logisim.statemachine.editor.commands.DeleteCmd;
import com.cburch.logisim.statemachine.editor.view.FSMCustomFactory;
import com.cburch.logisim.statemachine.editor.view.FSMView;
import com.cburch.logisim.statemachine.fSMDSL.FSM;

public class EditorDialog extends Dialog implements IEditorDialog {
	

	private final int APPLET_WIDTH = 700, APPLET_HEIGHT = 500;
	public enum Mode  {DeleteMode,StateMode,InputPortMode,OutputPortMode}; 



	EditorCommand cmd; // the command being executed
	CanvasPanel canvasPanel;
	FSMView view; // the drawing: shapes in order
	FSM editorFSM= FSMCustomFactory.fsm("NoName");
	
	Mode mode = Mode.StateMode; // the drawing: shapes in order
	
	

	public EditorDialog(Frame parent) {
		super(parent);
		//super();
		setSize(200, 200);
		init();
	}

	@Override
	public FSMView getView() {
		return view;
	}

	@Override
	public EditorCommand getCommand() {
		return cmd;
	}

	public void init() {
		cmd = new EditorCommand(); // all methods in Command are empty
		view = new FSMView(editorFSM); // make an empty drawing

		// The drawing will appear in a white CanvasPanel.
		/* CanvasPanel */
		
		canvasPanel = new CanvasPanel(this);
		canvasPanel.setBackground(Color.white);

		// Make JButton objects for all the command buttons.
		JButton fsmOutpuButton = new JButton("Add Output");
		JButton fSMInputButton = new JButton("Add Input");
		JButton stateButton = new JButton("Add State");
		JButton moveButton = new JButton("Move Element");
		JButton deleteButton = new JButton("Delete Element");

		// Add listeners for all the command buttons.
		fsmOutpuButton.addActionListener(new FSMOutputButtonListener());
		fSMInputButton.addActionListener(new FSMInputButtonListener());
		deleteButton.addActionListener(new DeleteElementListener());
		stateButton.addActionListener(new CreateElementButtonListener());
		moveButton.addActionListener(new MoveElementListener());

		JPanel shapePanel = new JPanel(); // holds buttons for adding shapes
		JLabel shapeLabel = new JLabel("Add shape:");
		shapePanel.setLayout(new FlowLayout());
		shapePanel.add(shapeLabel);
		shapePanel.add(fsmOutpuButton);
		shapePanel.add(fSMInputButton);
		shapePanel.add(stateButton);
		shapePanel.add(moveButton);
		shapePanel.add(deleteButton);

		add(shapePanel, BorderLayout.NORTH);
		add(canvasPanel, BorderLayout.CENTER);
		
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}

	public void paint(Graphics page) {
		super.paint(page); // make all the GUI components paint themselves
	}

	// What to do when rectButton is pressed.
	private class FSMOutputButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			mode=Mode.OutputPortMode;
			cmd = new AddElementCmd(mode);
			repaint();
		}
	}

	// What to do when ellipseButton is pressed.
	private class FSMInputButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			mode=Mode.InputPortMode;
			cmd = new AddElementCmd(mode);
			repaint();
		}
	}

	// What to do when ellipseButton is pressed.
	private class CreateElementButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			mode=Mode.StateMode;
			cmd = new AddElementCmd(mode);
			repaint();
		}
	}

	// What to do when deleteButton is pressed.
	private class MoveElementListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new MoveElementCmd(editorFSM);
			repaint();
		}
	}

	// What to do when deleteButton is pressed.
	private class DeleteElementListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			mode= Mode.DeleteMode;
			cmd = new DeleteCmd(mode);
			repaint();
		}
	}




}
