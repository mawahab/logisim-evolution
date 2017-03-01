package com.cburch.logisim.std.fsm;

import java.awt.Adjustable;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import com.cburch.logisim.statemachine.editor.FSMView;

import com.cburch.logisim.statemachine.editor.IEditorDialog;



public class FSMEditorWindow extends Panel implements IFSMEditor{

	
	// This is not a Command Design Pattern : must be fixed
	FSMContent content;
	FSMView view;

	public FSMEditorWindow(FSMContent content) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		System.out.println(this.toString()+":"+getWidth()+"x"+getHeight());		
		this.content=content;
		
		// FIXME
		//this.setSize(APPLET_WIDTH, APPLET_HEIGHT+200);


	
		System.out.println(this.toString()+":"+getWidth()+"x"+getHeight());

		Panel shapePanel = new Panel(); // holds buttons for adding shapes
		shapePanel.setLayout(new FlowLayout());

		//shapePanel.setSize(APPLET_WIDTH, 100);
		add(shapePanel);

		view =new FSMView(this);
	    ScrollPane scroller = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
	    Adjustable vadjust = scroller.getVAdjustable();
        Adjustable hadjust = scroller.getHAdjustable();
        hadjust.setUnitIncrement(10);
        vadjust.setUnitIncrement(10);
        scroller.setSize(1200, 400);
        scroller.add(view);
		add(scroller);
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
