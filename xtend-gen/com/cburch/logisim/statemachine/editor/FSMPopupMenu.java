package com.cburch.logisim.statemachine.editor;

import com.cburch.logisim.statemachine.editor.FSMEditorController;
import com.cburch.logisim.statemachine.editor.FSMView;
import com.cburch.logisim.statemachine.editor.view.FSMZones;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.google.common.base.Objects;
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
  
  private MenuItem copyMenuItem;
  
  private MenuItem pasteMenuItem;
  
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
        boolean _equals_2 = _actionCommand_2.equals("Copy");
        if (_equals_2) {
          FSMEditorController _controller_2 = this.view.getController();
          _controller_2.executeCopy(this.currentPos, this.type);
        } else {
          String _actionCommand_3 = e.getActionCommand();
          boolean _equals_3 = _actionCommand_3.equals("Paste");
          if (_equals_3) {
            FSMEditorController _controller_3 = this.view.getController();
            _controller_3.executePaste(this.currentPos, this.type);
          } else {
            String _actionCommand_4 = e.getActionCommand();
            boolean _equals_4 = _actionCommand_4.equals("Delete");
            if (_equals_4) {
              FSMEditorController _controller_4 = this.view.getController();
              _controller_4.executeDelete(this.currentPos);
            }
          }
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
    MenuItem _menuItem_2 = new MenuItem("Copy");
    this.copyMenuItem = _menuItem_2;
    this.copyMenuItem.setActionCommand("Copy");
    MenuItem _menuItem_3 = new MenuItem("Paste");
    this.pasteMenuItem = _menuItem_3;
    this.pasteMenuItem.setActionCommand("Paste");
    MenuItem _menuItem_4 = new MenuItem("Delete");
    this.deleteMenuItem = _menuItem_4;
    this.deleteMenuItem.setActionCommand("Delete");
    this.editMenuItem.addActionListener(this);
    this.createMenuItem.addActionListener(this);
    this.deleteMenuItem.addActionListener(this);
    this.copyMenuItem.addActionListener(this);
    this.add(this.editMenuItem);
    this.add(this.copyMenuItem);
    this.add(this.pasteMenuItem);
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
    FSMEditorController _controller = this.view.getController();
    final FSMElement selection = _controller.getCurrentSelection();
    this.setEnabled(true);
    this.pasteMenuItem.setEnabled(false);
    if (type != null) {
      switch (type) {
        case INPUT:
          this.copyMenuItem.setEnabled(true);
          this.copyMenuItem.setLabel("Copy");
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(selection, null));
          if (!_notEquals) {
            _and = false;
          } else {
            _and = (selection instanceof InputPort);
          }
          if (_and) {
            this.pasteMenuItem.setEnabled(true);
            this.pasteMenuItem.setLabel("Paste");
          }
          this.createMenuItem.setEnabled(true);
          this.copyMenuItem.setEnabled(true);
          this.copyMenuItem.setLabel("Duplicate");
          this.createMenuItem.setLabel("Add new input");
          break;
        case STATE:
          this.copyMenuItem.setEnabled(true);
          this.copyMenuItem.setLabel("Copy");
          boolean _and_1 = false;
          boolean _notEquals_1 = (!Objects.equal(selection, null));
          if (!_notEquals_1) {
            _and_1 = false;
          } else {
            _and_1 = (selection instanceof State);
          }
          if (_and_1) {
            this.pasteMenuItem.setEnabled(true);
            this.pasteMenuItem.setLabel("Paste");
          }
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
          this.copyMenuItem.setEnabled(true);
          this.copyMenuItem.setLabel("Duplicate");
          boolean _and_2 = false;
          boolean _notEquals_2 = (!Objects.equal(selection, null));
          if (!_notEquals_2) {
            _and_2 = false;
          } else {
            _and_2 = (selection instanceof OutputPort);
          }
          if (_and_2) {
            this.pasteMenuItem.setEnabled(true);
            this.pasteMenuItem.setLabel("Paste");
          }
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
