package com.cburch.logisim.statemachine.editor;

import com.cburch.logisim.statemachine.editor.FSMEditorController;
import com.cburch.logisim.statemachine.editor.FSMView;
import com.cburch.logisim.statemachine.editor.view.FSMSelectionZone;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings("all")
public class FSMPopupMenu extends PopupMenu implements ActionListener {
  private FSMView view;
  
  private MenuItem editMenuItem;
  
  private MenuItem createMenuItem;
  
  private MenuItem copyMenuItem;
  
  private MenuItem pasteMenuItem;
  
  private MenuItem deleteMenuItem;
  
  private FSMSelectionZone.AreaType type = FSMSelectionZone.AreaType.NONE;
  
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
          _controller_2.executeCopy(this.currentPos);
        } else {
          String _actionCommand_3 = e.getActionCommand();
          boolean _equals_3 = _actionCommand_3.equals("Paste");
          if (_equals_3) {
            FSMEditorController _controller_3 = this.view.getController();
            _controller_3.executePaste(this.currentPos);
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
    this.pasteMenuItem.addActionListener(this);
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
  
  public void showPopupMenu(final Point p, final FSMSelectionZone.AreaType type) {
    this.currentPos = p;
    this.type = type;
    this.setEnabled(true);
    FSMEditorController _controller = this.view.getController();
    List<FSMElement> _clipboard = _controller.getClipboard();
    int _size = _clipboard.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      this.pasteMenuItem.setEnabled(true);
      FSMEditorController _controller_1 = this.view.getController();
      List<FSMElement> _clipboard_1 = _controller_1.getClipboard();
      int _size_1 = _clipboard_1.size();
      String _plus = ("Paste " + Integer.valueOf(_size_1));
      this.pasteMenuItem.setLabel(_plus);
    }
    if (type != null) {
      switch (type) {
        case INPUT:
          this.copyMenuItem.setEnabled(true);
          this.copyMenuItem.setLabel("Copy");
          this.createMenuItem.setEnabled(true);
          this.copyMenuItem.setEnabled(true);
          this.copyMenuItem.setLabel("Duplicate");
          this.createMenuItem.setLabel("Add new input");
          break;
        case STATE:
          this.copyMenuItem.setEnabled(true);
          this.copyMenuItem.setLabel("Copy");
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
