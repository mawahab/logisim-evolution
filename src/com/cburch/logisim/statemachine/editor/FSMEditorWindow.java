package com.cburch.logisim.statemachine.editor;

import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.cburch.logisim.std.fsm.FSMContent;
import com.cburch.logisim.std.fsm.IFSMEditor;

public class FSMEditorWindow extends Panel implements IFSMEditor, ChangeListener{

	// This is not a Command Design Pattern : must be fixed
	private FSMContent content;
	private FSMView view;
	private ScrollPane scroller;
	private JSlider slider;
	

	public FSMEditorWindow(FSMContent content) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		System.out.println(this.toString()+":"+getWidth()+"x"+getHeight());		
		this.content=content;
		setMinimumSize(new Dimension(500, 500));
		
		Panel shapePanel = new Panel(); // holds buttons for adding shapes
		shapePanel.setLayout(new FlowLayout());
		add(shapePanel);

		view =new FSMView(this);
	    scroller = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		scroller.setMinimumSize(new Dimension(500, 500));
		scroller.setSize(new Dimension(500, 500));

	    //	    Adjustable vadjust = scroller.getVAdjustable();
//        Adjustable hadjust = scroller.getHAdjustable();
//        hadjust.setUnitIncrement(10);
//        vadjust.setUnitIncrement(10);
       
        scroller.add(view);
        scroller.setEnabled(true);
	    //scroller.setScrollPosition(300, 300);
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
	@Override
	public void stateChanged(ChangeEvent e) {
	    int value = ((JSlider)e.getSource()).getValue();
	    view.setScale(value/100.0);
	    repaint();
	    revalidate();
	}

	@Override
	public void repaint() {
		super.repaint();
		slider.repaint();
		scroller.repaint();
		view.repaint();
		
	}

}
