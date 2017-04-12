package com.cburch.logisim.statemachine.editor

import java.awt.MenuItem
import java.awt.Point
import java.awt.PopupMenu
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import com.cburch.logisim.statemachine.editor.view.FSMZones.AreaType
import com.cburch.logisim.statemachine.fSMDSL.State
import com.cburch.logisim.statemachine.fSMDSL.InputPort
import com.cburch.logisim.statemachine.fSMDSL.OutputPort

class FSMPopupMenu extends PopupMenu implements ActionListener {

	FSMView view
	MenuItem editMenuItem
	MenuItem createMenuItem
	MenuItem copyMenuItem
	MenuItem pasteMenuItem
	MenuItem deleteMenuItem
	AreaType type = AreaType.NONE
	Point currentPos


	/* FIXME Non-static inner classes are not supported.*/
	override void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Edit")) {
			view.getController().executeEdit(currentPos)
		} else if (e.getActionCommand().equals("Create")) {
			view.getController().executeCreate(currentPos, type)
		} else if (e.getActionCommand().equals("Copy")) {
			view.getController().executeCopy(currentPos, type)
		} else if (e.getActionCommand().equals("Paste")) {
			view.getController().executePaste(currentPos, type)
		} else if (e.getActionCommand().equals("Delete")) {
			view.getController().executeDelete(currentPos)
		}

	}

	new(FSMView parent) {
		super("Menu")
		this.view = parent
		view.add(this)
		editMenuItem = new MenuItem("Edit")
		editMenuItem.setActionCommand("Edit")
		createMenuItem = new MenuItem("Create")
		createMenuItem.setActionCommand("Create")
		copyMenuItem = new MenuItem("Copy")
		copyMenuItem.setActionCommand("Copy")
		pasteMenuItem = new MenuItem("Paste")
		pasteMenuItem.setActionCommand("Paste")
		
		deleteMenuItem = new MenuItem("Delete")
		deleteMenuItem.setActionCommand("Delete")
		editMenuItem.addActionListener(this)
		createMenuItem.addActionListener(this)
		deleteMenuItem.addActionListener(this)
		copyMenuItem.addActionListener(this)
		add(editMenuItem)
		add(copyMenuItem)
		add(pasteMenuItem)
		add(createMenuItem)
		add(deleteMenuItem)
	}

	def void enableCreateTransitionMenuItem(boolean enable) {
		editMenuItem.setEnabled(enable)
	}

	def void enableEditMenuItem(boolean enable) {
		createMenuItem.setEnabled(enable)
	}

	def void showPopupMenu(Point p, AreaType type) {
		currentPos = p
		this.type = type
		val selection = view.getController().currentSelection
		setEnabled(true)
		pasteMenuItem.setEnabled(false)
		switch (type) {
			case INPUT: {
				copyMenuItem.setEnabled(true)
				copyMenuItem.setLabel("Copy")
				if (selection!=null && selection instanceof InputPort) {
					pasteMenuItem.setEnabled(true)
					pasteMenuItem.setLabel("Paste")
				}
				createMenuItem.setEnabled(true)
				copyMenuItem.setEnabled(true)
				copyMenuItem.setLabel("Duplicate")
				createMenuItem.setLabel("Add new input")
			}
			case STATE: {
				copyMenuItem.setEnabled(true)
				copyMenuItem.setLabel("Copy")
				if (selection!=null && selection instanceof State) {
					pasteMenuItem.setEnabled(true)
					pasteMenuItem.setLabel("Paste")
				}
				createMenuItem.setEnabled(true)
				createMenuItem.setLabel("Add new state")
			}
			case TRANSITION: {
				createMenuItem.setEnabled(true)
				createMenuItem.setLabel("Add new transition")
			}
			case NONE: {
				createMenuItem.setEnabled(false)
			}
			case OUTPUT: {
				copyMenuItem.setEnabled(true)
				copyMenuItem.setLabel("Duplicate")
				if (selection!=null && selection instanceof OutputPort) {
					pasteMenuItem.setEnabled(true)
					pasteMenuItem.setLabel("Paste")
				}
				createMenuItem.setEnabled(true)
				createMenuItem.setLabel("Add new output")
			}
		}
		show(view, p.x, p.y)
	}

}