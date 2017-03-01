package com.cburch.logisim.statemachine.editor;

import com.cburch.logisim.statemachine.editor.FSMEditorController;
import com.cburch.logisim.statemachine.editor.FSMView;
import com.cburch.logisim.statemachine.editor.view.FSMZones;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("all")
public class FSMPopupMenu extends PopupMenu implements ActionListener {
  private FSMView view;
  
  private MenuItem editMenuItem;
  
  private MenuItem createMenuItem;
  
  private MenuItem deleteMenuItem;
  
  private FSMZones.AreaType type = FSMZones.AreaType.NONE;
  
  private Point currentPos;
  
  /**
   * FIXME Non-static inner classes are not supported.
   */
  @Override
  public void actionPerformed(final ActionEvent e) {
    String _actionCommand = e.getActionCommand();
    boolean _equals = _actionCommand.equals("Edit");
    if (_equals) {
      FSMEditorController _controller = this.view.getController();
      _controller.executeEdit(this.currentPos);
    } else {
      String _actionCommand_1 = e.getActionCommand();
      boolean _equals_1 = _actionCommand_1.equals("Create");
      if (_equals_1) {
        FSMEditorController _controller_1 = this.view.getController();
        _controller_1.executeCreate(this.currentPos, this.type);
      } else {
        String _actionCommand_2 = e.getActionCommand();
        boolean _equals_2 = _actionCommand_2.equals("Delete");
        if (_equals_2) {
          FSMEditorController _controller_2 = this.view.getController();
          _controller_2.executeDelete(this.currentPos);
        }
      }
    }
  }
  
  public FSMPopupMenu(final FSMView parent) {
    super("Menu");
    this.view = parent;
    this.view.add(this);
    MenuItem _menuItem = new MenuItem("Edit");
    this.editMenuItem = _menuItem;
    this.editMenuItem.setActionCommand("Edit");
    MenuItem _menuItem_1 = new MenuItem("Create");
    this.createMenuItem = _menuItem_1;
    this.createMenuItem.setActionCommand("Create");
    MenuItem _menuItem_2 = new MenuItem("Delete");
    this.deleteMenuItem = _menuItem_2;
    this.deleteMenuItem.setActionCommand("Delete");
    this.editMenuItem.addActionListener(this);
    this.createMenuItem.addActionListener(this);
    this.deleteMenuItem.addActionListener(this);
    this.add(this.editMenuItem);
    this.add(this.createMenuItem);
    this.add(this.deleteMenuItem);
  }
  
  public void enableCreateTransitionMenuItem(final boolean enable) {
    this.editMenuItem.setEnabled(enable);
  }
  
  public void enableEditMenuItem(final boolean enable) {
    this.createMenuItem.setEnabled(enable);
  }
  
  public void showPopupMenu(final Point p, final FSMZones.AreaType type) {
    this.currentPos = p;
    this.type = type;
    this.setEnabled(true);
    if (type != null) {
      switch (type) {
        case INPUT:
          this.createMenuItem.setEnabled(true);
          this.createMenuItem.setLabel("Add new input");
          break;
        case STATE:
          this.createMenuItem.setEnabled(true);
          this.createMenuItem.setLabel("Add new state");
          break;
        case TRANSITION:
          this.createMenuItem.setEnabled(true);
          this.createMenuItem.setLabel("Add new transition");
          break;
        case NONE:
          this.createMenuItem.setEnabled(false);
          break;
        case OUTPUT:
          this.createMenuItem.setEnabled(true);
          this.createMenuItem.setLabel("Add new output");
          break;
        default:
          break;
      }
    }
    this.show(this.view, p.x, p.y);
  }
}
