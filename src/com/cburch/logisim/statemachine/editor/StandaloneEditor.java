package com.cburch.logisim.statemachine.editor;

import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;

public class StandaloneEditor {

	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public StandaloneEditor() {
		prepareGUI();
	}

	public static void main(String[] args) {
		StandaloneEditor awtControlDemo = new StandaloneEditor();
		awtControlDemo.showDialogDemo();
	}

	private void prepareGUI() {
		mainFrame = new Frame("Java AWT Examples");
		mainFrame.setSize(1024, 760);
		BoxLayout mgr = new BoxLayout(mainFrame,BoxLayout.Y_AXIS);
		mainFrame.setLayout(mgr);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
			
		//EditorPanel pn = new EditorPanel();
		//mainFrame.add(pn);
		mainFrame.setVisible(true);
	}

	private void showDialogDemo() {
	}


}