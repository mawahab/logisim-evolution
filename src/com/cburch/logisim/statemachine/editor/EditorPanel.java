package com.cburch.logisim.statemachine.editor;
// Editor.java

// An applet for an object-oriented graphical editor.
// This class implements the GUI for the editor.
// Written by THC for CS 5 Lab Assignment 3.
// Modified by Matthew McNierney for CS 5 Lab Assignment 3
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.cburch.logisim.statemachine.codegen.FSMVHDLCodeGen;
import com.cburch.logisim.statemachine.editor.EditorDialog.Mode;
import com.cburch.logisim.statemachine.editor.commands.AddElementCmd;
import com.cburch.logisim.statemachine.editor.commands.DeleteCmd;
import com.cburch.logisim.statemachine.editor.commands.EditorCommand;
import com.cburch.logisim.statemachine.editor.commands.MoveElementCmd;
import com.cburch.logisim.statemachine.editor.view.FSMCustomFactory;
import com.cburch.logisim.statemachine.editor.view.FSMValidation;
import com.cburch.logisim.statemachine.editor.view.FSMView; 
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.parser.FSMSerializer;


public class EditorPanel extends Panel implements IEditorDialog {
	

	private final int APPLET_WIDTH = 700, APPLET_HEIGHT = 500;



	EditorCommand cmd; // the command being executed
	ScrollPane scroller;
	CanvasPanel canvasPanel;
	FSMView view; // the drawing: shapes in order
	FSM fsm= FSMCustomFactory.fsm("NoName");
	
	Mode mode = Mode.StateMode; // the drawing: shapes in order
	
	

	public EditorPanel() {
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
		view = new FSMView(fsm); // make an empty drawing

		// The drawing will appear in a white CanvasPanel.
		/* CanvasPanel */
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


	    ScrollPane scroller = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		canvasPanel = new CanvasPanel(this);
		canvasPanel.setBackground(Color.white);
        Adjustable vadjust = scroller.getVAdjustable();
        Adjustable hadjust = scroller.getHAdjustable();
        hadjust.setUnitIncrement(10);
        vadjust.setUnitIncrement(10);
        scroller.setSize(1024, 700);
        scroller.add(canvasPanel);

		// Make JButton objects for all the command buttons.
		JButton loadButton = new JButton("Load file");
		JButton saveButton = new JButton("Save file");
		JButton validateButton = new JButton("Check FSM");
		JButton exportButton = new JButton("Export VHDL");
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
		loadButton.addActionListener(new LoadButtonListener());
		exportButton.addActionListener(new ExportButtonListener());
			saveButton.addActionListener(new SaveButtonListener());
		validateButton.addActionListener(new ValidateButtonListener());

		JPanel shapePanel = new JPanel(); // holds buttons for adding shapes
		shapePanel.setLayout(new FlowLayout());
		shapePanel.add(loadButton);
		shapePanel.add(saveButton);
		shapePanel.add(validateButton);
		shapePanel.add(exportButton);
		
		shapePanel.add(fsmOutpuButton);
		shapePanel.add(fSMInputButton);
		shapePanel.add(stateButton);
		shapePanel.add(moveButton);
		shapePanel.add(deleteButton);

		add(shapePanel);
		add(scroller);
		
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}

	public void paint(Graphics page) {
		super.paint(page); // make all the GUI components paint themselves
	}

	// What to do when rectButton is pressed.
	private class LoadButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Load FSM");
				int choice = chooser.showOpenDialog(EditorPanel.this);
				if (choice == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					try {
						fsm = new FSMSerializer().load(f);
						view = new FSMView(fsm);
						repaint();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(EditorPanel.this,
								e.getMessage(),
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
	}

	// What to do when rectButton is pressed.
	private class SaveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Save FSM");
				int choice = chooser.showSaveDialog(EditorPanel.this);
				if (choice == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					new FSMSerializer().saveToFile(fsm, f);
				}
		}
	}

	// What to do when rectButton is pressed.
	private class ExportButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Export FSM as VHDL");
				int choice = chooser.showSaveDialog(EditorPanel.this);
				if (choice == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					new FSMVHDLCodeGen().export(fsm, f);
				}
		}
	}

	// What to do when rectButton is pressed.
	private class ValidateButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			FSMValidation validator = new FSMValidation(fsm);
			validator.validate(fsm);
			String message = validator.getErrors().stream().map((x)->("Error:"+x)).reduce((x,y)->(x+'\n'+y)).get();
			message+="\n"+validator.getErrors().stream().map((x)->("Warning :"+x)).reduce((x,y)->(x+'\n'+y)).get();
			JOptionPane.showMessageDialog(EditorPanel.this,
					message,
					"FSM validation results",
					JOptionPane.INFORMATION_MESSAGE);

		}
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
			cmd = new MoveElementCmd(fsm);
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
