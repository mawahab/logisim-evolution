package com.cburch.logisim.statemachine.editor.commands;
// DeleteCmd.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds information on how to delete a shape from the drawing

import java.awt.*;
import java.util.List;

import com.cburch.logisim.statemachine.editor.EditorDialog.Mode;
import com.cburch.logisim.statemachine.editor.view.FSMView;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;

public class DeleteCmd extends EditorCommand {
	
	Mode mode;
	
	public DeleteCmd(Mode mode) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * On click, remove the frontmost shape from the drawing.
	 */
	public void executeClick(Point p, FSMView view) {
		List<FSMElement>  selection = view.getActiveElement(p);
		if(selection.size()>0) view.deleteElement(selection.get(0));
	}
}