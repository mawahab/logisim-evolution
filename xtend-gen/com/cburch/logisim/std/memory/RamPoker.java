/**
 * This file is part of logisim-evolution.
 * logisim-evolution is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * logisim-evolution is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with logisim-evolution.  If not, see <http://www.gnu.org/licenses/>.
 * Original code by Carl Burch (http://www.cburch.com), 2011.
 * Subsequent modifications by :
 * + Haute École Spécialisée Bernoise
 * http://www.bfh.ch
 * + Haute École du paysage, d'ingénierie et d'architecture de Genève
 * http://hepia.hesge.ch/
 * + Haute École d'Ingénierie et de Gestion du Canton de Vaud
 * http://www.heig-vd.ch/
 * The project is currently maintained by :
 * + REDS Institute - HEIG-VD
 * Yverdon-les-Bains, Switzerland
 * http://reds.heig-vd.ch
 */
package com.cburch.logisim.std.memory;

import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.instance.InstanceData;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstancePoker;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.proj.Project;
import com.cburch.logisim.std.memory.MemState;
import com.cburch.logisim.std.memory.RamState;
import com.cburch.logisim.std.memory.RomAttributes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@SuppressWarnings("all")
public class RamPoker extends InstancePoker {
  private static class AddrPoker extends RamPoker {
    @Override
    public Bounds getBounds(final InstancePainter painter) {
      InstanceData _data = painter.getData();
      MemState data = ((MemState) _data);
      return data.getBounds((-1), painter.getBounds());
    }
    
    @Override
    public void keyTyped(final InstanceState state, final KeyEvent e) {
      char c = e.getKeyChar();
      int val = Character.digit(e.getKeyChar(), 16);
      InstanceData _data = state.getData();
      MemState data = ((MemState) _data);
      if ((val >= 0)) {
        long _scroll = data.getScroll();
        long _multiply = (_scroll * 16);
        long newScroll = ((_multiply + val) & data.getLastAddress());
        data.setScroll(newScroll);
      } else {
        char _charValue = Character.valueOf(' ').charValue();
        boolean _tripleEquals = (c == _charValue);
        if (_tripleEquals) {
          long _scroll_1 = data.getScroll();
          int _GetNrOfLines = data.GetNrOfLines();
          int _minus = (_GetNrOfLines - 1);
          int _GetNrOfLineItems = data.GetNrOfLineItems();
          int _multiply_1 = (_minus * _GetNrOfLineItems);
          long _plus = (_scroll_1 + _multiply_1);
          data.setScroll(_plus);
        } else {
          if (((c == Character.valueOf('\r').charValue()) || (c == Character.valueOf('\n').charValue()))) {
            long _scroll_2 = data.getScroll();
            int _GetNrOfLineItems_1 = data.GetNrOfLineItems();
            long _plus_1 = (_scroll_2 + _GetNrOfLineItems_1);
            data.setScroll(_plus_1);
          } else {
            if (((c == Character.valueOf('\b').charValue()) || (c == Character.valueOf('').charValue()))) {
              long _scroll_3 = data.getScroll();
              int _GetNrOfLineItems_2 = data.GetNrOfLineItems();
              long _minus_1 = (_scroll_3 - _GetNrOfLineItems_2);
              data.setScroll(_minus_1);
            } else {
              if (((c == Character.valueOf('R').charValue()) || (c == Character.valueOf('r').charValue()))) {
                data.getContents().clear();
              }
            }
          }
        }
      }
    }
    
    @Override
    public void paint(final InstancePainter painter) {
      Bounds bds = this.getBounds(painter);
      Graphics g = painter.getGraphics();
      g.setColor(Color.RED);
      g.drawRect(bds.getX(), bds.getY(), bds.getWidth(), bds.getHeight());
      g.setColor(Color.BLACK);
    }
  }
  
  private static class DataPoker extends RamPoker {
    int initValue;
    
    int curValue;
    
    private DataPoker(final InstanceState state, final MemState data, final long addr) {
      data.setCursor(addr);
      this.initValue = data.getContents().get(data.getCursor());
      this.curValue = this.initValue;
      Object attrs = state.getInstance().getAttributeSet();
      if ((attrs instanceof RomAttributes)) {
        Project proj = state.getProject();
        if ((proj != null)) {
          ((RomAttributes) attrs).setProject(proj);
        }
      }
    }
    
    @Override
    public void mousePressed(final InstanceState state, final MouseEvent e) {
      final int clickCount = e.getClickCount();
      if (((clickCount == 2) && (!e.isConsumed()))) {
        e.consume();
        InstanceData _data = state.getData();
        RamState ram = ((RamState) _data);
        boolean _isCode = ram.isCode();
        boolean _not = (!_isCode);
        ram.setCode(_not);
      }
    }
    
    @Override
    public Bounds getBounds(final InstancePainter painter) {
      InstanceData _data = painter.getData();
      MemState data = ((MemState) _data);
      Bounds inBounds = painter.getInstance().getBounds();
      return data.getBounds(data.getCursor(), inBounds);
    }
    
    @Override
    public void keyTyped(final InstanceState state, final KeyEvent e) {
      char c = e.getKeyChar();
      int val = Character.digit(e.getKeyChar(), 16);
      InstanceData _data = state.getData();
      MemState data = ((MemState) _data);
      if ((val >= 0)) {
        this.curValue = ((this.curValue * 16) + val);
        data.getContents().set(data.getCursor(), this.curValue);
        state.fireInvalidated();
      } else {
        if (((c == Character.valueOf(' ').charValue()) || (c == Character.valueOf('\t').charValue()))) {
          long _cursor = data.getCursor();
          long _plus = (_cursor + 1);
          this.moveTo(data, _plus);
        } else {
          if (((c == Character.valueOf('\r').charValue()) || (c == Character.valueOf('\n').charValue()))) {
            long _cursor_1 = data.getCursor();
            int _GetNrOfLineItems = data.GetNrOfLineItems();
            long _plus_1 = (_cursor_1 + _GetNrOfLineItems);
            this.moveTo(data, _plus_1);
          } else {
            if (((c == Character.valueOf('\b').charValue()) || (c == Character.valueOf('').charValue()))) {
              long _cursor_2 = data.getCursor();
              long _minus = (_cursor_2 - 1);
              this.moveTo(data, _minus);
            } else {
              if (((c == Character.valueOf('R').charValue()) || (c == Character.valueOf('r').charValue()))) {
                data.getContents().clear();
              }
            }
          }
        }
      }
    }
    
    private void moveTo(final MemState data, final long addr) {
      boolean _isValidAddr = data.isValidAddr(addr);
      if (_isValidAddr) {
        data.setCursor(addr);
        data.scrollToShow(addr);
        this.initValue = data.getContents().get(addr);
        this.curValue = this.initValue;
      }
    }
    
    @Override
    public void paint(final InstancePainter painter) {
      Bounds bds = this.getBounds(painter);
      Graphics g = painter.getGraphics();
      g.setColor(Color.RED);
      g.drawRect(bds.getX(), bds.getY(), bds.getWidth(), bds.getHeight());
      g.setColor(Color.BLACK);
    }
    
    @Override
    public void stopEditing(final InstanceState state) {
      InstanceData _data = state.getData();
      MemState data = ((MemState) _data);
      data.setCursor((-1));
    }
  }
  
  private RamPoker sub;
  
  @Override
  public Bounds getBounds(final InstancePainter state) {
    return this.sub.getBounds(state);
  }
  
  @Override
  public boolean init(final InstanceState state, final MouseEvent event) {
    Bounds bds = state.getInstance().getBounds();
    InstanceData _data = state.getData();
    MemState data = ((MemState) _data);
    int _x = event.getX();
    int _x_1 = bds.getX();
    int _minus = (_x - _x_1);
    int _y = event.getY();
    int _y_1 = bds.getY();
    int _minus_1 = (_y - _y_1);
    long addr = data.getAddressAt(_minus, _minus_1);
    if ((addr < 0)) {
      RamPoker.AddrPoker _addrPoker = new RamPoker.AddrPoker();
      this.sub = _addrPoker;
    } else {
      RamPoker.DataPoker _dataPoker = new RamPoker.DataPoker(state, data, addr);
      this.sub = _dataPoker;
    }
    return true;
  }
  
  @Override
  public void keyTyped(final InstanceState state, final KeyEvent e) {
    this.sub.keyTyped(state, e);
  }
  
  @Override
  public void paint(final InstancePainter painter) {
    this.sub.paint(painter);
  }
}
