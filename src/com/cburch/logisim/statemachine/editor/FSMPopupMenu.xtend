package com.cburch.logisim.statemachine.editor

import java.awt.MenuItem
import java.awt.Point
import java.awt.PopupMenu
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import com.cburch.logisim.statemachine.editor.view.FSMZones.AreaType


class FSMPopupMenu extends PopupMenu implements ActionListener {

	FSMView view
	MenuItem editMenuItem
	MenuItem createMenuItem
	MenuItem deleteMenuItem
	AreaType type = AreaType.NONE
	Point currentPos


	/* FIXME Non-static inner classes are not supported.*/
	override void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Edit")) {
			view.getController().executeEdit(currentPos)
		} else if (e.getActionCommand().equals("Create")) {
			view.getController().executeCreate(currentPos, type)
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
		deleteMenuItem = new MenuItem("Delete")
		deleteMenuItem.setActionCommand("Delete")
		editMenuItem.addActionListener(this)
		createMenuItem.addActionListener(this)
		deleteMenuItem.addActionListener(this)
		add(editMenuItem)
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
		setEnabled(true)
		switch (type) {
			case INPUT: {
				createMenuItem.setEnabled(true)
				createMenuItem.setLabel("Add new input")
			}
			case STATE: {
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
				createMenuItem.setEnabled(true)
				createMenuItem.setLabel("Add new output")
			}
		}
		show(view, p.x, p.y)
	}

}