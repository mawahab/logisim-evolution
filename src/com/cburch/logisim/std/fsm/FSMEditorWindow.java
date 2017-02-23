package com.cburch.logisim.std.fsm;

import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.cburch.logisim.statemachine.editor.CanvasPanel;
import com.cburch.logisim.statemachine.editor.EditorDialog.Mode;
import com.cburch.logisim.statemachine.editor.IEditorDialog;
import com.cburch.logisim.statemachine.editor.commands.AddElementCmd;
import com.cburch.logisim.statemachine.editor.commands.DeleteCmd;
import com.cburch.logisim.statemachine.editor.commands.EditorCommand;
import com.cburch.logisim.statemachine.editor.commands.MoveElementCmd;
import com.cburch.logisim.statemachine.editor.view.FSMView;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.parser.FSMSerializer;


public class FSMEditorWindow extends Panel implements IFSMEditor,IEditorDialog{

	private final int APPLET_WIDTH = 700, APPLET_HEIGHT = 500;

	EditorCommand cmd; // the command being executed
	private CanvasPanel canvasPanel;
	FSMView view; // the drawing: shapes in order
	FSMContent content;
	Mode mode = Mode.StateMode; // the drawing: shapes in order
	
	public FSMView getView() {
		return view;
	}

	public FSMEditorWindow(FSMContent content) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		System.out.println(this.toString()+":"+getWidth()+"x"+getHeight());
		cmd = new EditorCommand(); // all methods in Command are empty
		
		this.content=content;
		
		cmd = new EditorCommand(); // all methods in Command are empty
		view = new FSMView(content.getFsm()); // make an empty drawing
		this.setSize(APPLET_WIDTH, APPLET_HEIGHT+200);

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
		
		System.out.println(this.toString()+":"+getWidth()+"x"+getHeight());

		Panel shapePanel = new Panel(); // holds buttons for adding shapes
		Label shapeLabel = new Label("Add shape:");
		shapePanel.setLayout(new FlowLayout());
		shapePanel.add(shapeLabel);
		shapePanel.add(fsmOutpuButton);
		shapePanel.add(fSMInputButton);
		shapePanel.add(stateButton);
		shapePanel.add(moveButton);
		shapePanel.add(deleteButton);
		shapePanel.setSize(APPLET_WIDTH, 100);
		add(shapePanel);

		canvasPanel = new CanvasPanel(this);
		canvasPanel.setSize(APPLET_WIDTH, APPLET_HEIGHT);
		canvasPanel.setBackground(Color.white);
	    ScrollPane scroller = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
	    Adjustable vadjust = scroller.getVAdjustable();
        Adjustable hadjust = scroller.getHAdjustable();
        hadjust.setUnitIncrement(10);
        vadjust.setUnitIncrement(10);
        scroller.setSize(1200, 400);
        scroller.add(canvasPanel);
		add(scroller);
	}

	public EditorCommand getCommand() {
		return cmd;
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
			cmd = new MoveElementCmd(content.getFsm());
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

	@Override
	public FSMContent getContent() {
		return content;
	}

	@Override
	public void setContent(FSMContent content) {
		this.content=content;
	}


}
