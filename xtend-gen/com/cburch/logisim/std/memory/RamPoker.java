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
import com.cburch.logisim.instance.Instance;
import com.cburch.logisim.instance.InstanceData;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstancePoker;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.proj.Project;
import com.cburch.logisim.std.memory.MemContents;
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
      Bounds _bounds = painter.getBounds();
      return data.getBounds((-1), _bounds);
    }
    
    @Override
    public void keyTyped(final InstanceState state, final KeyEvent e) {
      char c = e.getKeyChar();
      char _keyChar = e.getKeyChar();
      int val = Character.digit(_keyChar, 16);
      InstanceData _data = state.getData();
      MemState data = ((MemState) _data);
      if ((val >= 0)) {
        long _scroll = data.getScroll();
        long _multiply = (_scroll * 16);
        long _plus = (_multiply + val);
        long _lastAddress = data.getLastAddress();
        long newScroll = (_plus & _lastAddress);
        data.setScroll(newScroll);
      } else {
        Character _valueOf = Character.valueOf(' ');
        char _charValue = _valueOf.charValue();
        boolean _tripleEquals = (c == _charValue);
        if (_tripleEquals) {
          long _scroll_1 = data.getScroll();
          int _GetNrOfLines = data.GetNrOfLines();
          int _minus = (_GetNrOfLines - 1);
          int _GetNrOfLineItems = data.GetNrOfLineItems();
          int _multiply_1 = (_minus * _GetNrOfLineItems);
          long _plus_1 = (_scroll_1 + _multiply_1);
          data.setScroll(_plus_1);
        } else {
          boolean _or = false;
          Character _valueOf_1 = Character.valueOf('\r');
          char _charValue_1 = _valueOf_1.charValue();
          boolean _tripleEquals_1 = (c == _charValue_1);
          if (_tripleEquals_1) {
            _or = true;
          } else {
            Character _valueOf_2 = Character.valueOf('\n');
            char _charValue_2 = _valueOf_2.charValue();
            boolean _tripleEquals_2 = (c == _charValue_2);
            _or = _tripleEquals_2;
          }
          if (_or) {
            long _scroll_2 = data.getScroll();
            int _GetNrOfLineItems_1 = data.GetNrOfLineItems();
            long _plus_2 = (_scroll_2 + _GetNrOfLineItems_1);
            data.setScroll(_plus_2);
          } else {
            boolean _or_1 = false;
            Character _valueOf_3 = Character.valueOf('\b');
            char _charValue_3 = _valueOf_3.charValue();
            boolean _tripleEquals_3 = (c == _charValue_3);
            if (_tripleEquals_3) {
              _or_1 = true;
            } else {
              Character _valueOf_4 = Character.valueOf('');
              char _charValue_4 = _valueOf_4.charValue();
              boolean _tripleEquals_4 = (c == _charValue_4);
              _or_1 = _tripleEquals_4;
            }
            if (_or_1) {
              long _scroll_3 = data.getScroll();
              int _GetNrOfLineItems_2 = data.GetNrOfLineItems();
              long _minus_1 = (_scroll_3 - _GetNrOfLineItems_2);
              data.setScroll(_minus_1);
            } else {
              boolean _or_2 = false;
              Character _valueOf_5 = Character.valueOf('R');
              char _charValue_5 = _valueOf_5.charValue();
              boolean _tripleEquals_5 = (c == _charValue_5);
              if (_tripleEquals_5) {
                _or_2 = true;
              } else {
                Character _valueOf_6 = Character.valueOf('r');
                char _charValue_6 = _valueOf_6.charValue();
                boolean _tripleEquals_6 = (c == _charValue_6);
                _or_2 = _tripleEquals_6;
              }
              if (_or_2) {
                MemContents _contents = data.getContents();
                _contents.clear();
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
      int _x = bds.getX();
      int _y = bds.getY();
      int _width = bds.getWidth();
      int _height = bds.getHeight();
      g.drawRect(_x, _y, _width, _height);
      g.setColor(Color.BLACK);
    }
  }
  
  private static class DataPoker extends RamPoker {
    int initValue;
    
    int curValue;
    
    private DataPoker(final InstanceState state, final MemState data, final long addr) {
      data.setCursor(addr);
      MemContents _contents = data.getContents();
      long _cursor = data.getCursor();
      int _get = _contents.get(_cursor);
      this.initValue = _get;
      this.curValue = this.initValue;
      Instance _instance = state.getInstance();
      Object attrs = _instance.getAttributeSet();
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
      boolean _and = false;
      if (!(clickCount == 2)) {
        _and = false;
      } else {
        boolean _isConsumed = e.isConsumed();
        boolean _not = (!_isConsumed);
        _and = _not;
      }
      if (_and) {
        e.consume();
        InstanceData _data = state.getData();
        RamState ram = ((RamState) _data);
        boolean _isCode = ram.isCode();
        boolean _not_1 = (!_isCode);
        ram.setCode(_not_1);
      }
    }
    
    @Override
    public Bounds getBounds(final InstancePainter painter) {
      InstanceData _data = painter.getData();
      MemState data = ((MemState) _data);
      Instance _instance = painter.getInstance();
      Bounds inBounds = _instance.getBounds();
      long _cursor = data.getCursor();
      return data.getBounds(_cursor, inBounds);
    }
    
    @Override
    public void keyTyped(final InstanceState state, final KeyEvent e) {
      char c = e.getKeyChar();
      char _keyChar = e.getKeyChar();
      int val = Character.digit(_keyChar, 16);
      InstanceData _data = state.getData();
      MemState data = ((MemState) _data);
      if ((val >= 0)) {
        this.curValue = ((this.curValue * 16) + val);
        MemContents _contents = data.getContents();
        long _cursor = data.getCursor();
        _contents.set(_cursor, this.curValue);
        state.fireInvalidated();
      } else {
        boolean _or = false;
        Character _valueOf = Character.valueOf(' ');
        char _charValue = _valueOf.charValue();
        boolean _tripleEquals = (c == _charValue);
        if (_tripleEquals) {
          _or = true;
        } else {
          Character _valueOf_1 = Character.valueOf('\t');
          char _charValue_1 = _valueOf_1.charValue();
          boolean _tripleEquals_1 = (c == _charValue_1);
          _or = _tripleEquals_1;
        }
        if (_or) {
          long _cursor_1 = data.getCursor();
          long _plus = (_cursor_1 + 1);
          this.moveTo(data, _plus);
        } else {
          boolean _or_1 = false;
          Character _valueOf_2 = Character.valueOf('\r');
          char _charValue_2 = _valueOf_2.charValue();
          boolean _tripleEquals_2 = (c == _charValue_2);
          if (_tripleEquals_2) {
            _or_1 = true;
          } else {
            Character _valueOf_3 = Character.valueOf('\n');
            char _charValue_3 = _valueOf_3.charValue();
            boolean _tripleEquals_3 = (c == _charValue_3);
            _or_1 = _tripleEquals_3;
          }
          if (_or_1) {
            long _cursor_2 = data.getCursor();
            int _GetNrOfLineItems = data.GetNrOfLineItems();
            long _plus_1 = (_cursor_2 + _GetNrOfLineItems);
            this.moveTo(data, _plus_1);
          } else {
            boolean _or_2 = false;
            Character _valueOf_4 = Character.valueOf('\b');
            char _charValue_4 = _valueOf_4.charValue();
            boolean _tripleEquals_4 = (c == _charValue_4);
            if (_tripleEquals_4) {
              _or_2 = true;
            } else {
              Character _valueOf_5 = Character.valueOf('');
              char _charValue_5 = _valueOf_5.charValue();
              boolean _tripleEquals_5 = (c == _charValue_5);
              _or_2 = _tripleEquals_5;
            }
            if (_or_2) {
              long _cursor_3 = data.getCursor();
              long _minus = (_cursor_3 - 1);
              this.moveTo(data, _minus);
            } else {
              boolean _or_3 = false;
              Character _valueOf_6 = Character.valueOf('R');
              char _charValue_6 = _valueOf_6.charValue();
              boolean _tripleEquals_6 = (c == _charValue_6);
              if (_tripleEquals_6) {
                _or_3 = true;
              } else {
                Character _valueOf_7 = Character.valueOf('r');
                char _charValue_7 = _valueOf_7.charValue();
                boolean _tripleEquals_7 = (c == _charValue_7);
                _or_3 = _tripleEquals_7;
              }
              if (_or_3) {
                MemContents _contents_1 = data.getContents();
                _contents_1.clear();
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
        MemContents _contents = data.getContents();
        int _get = _contents.get(addr);
        this.initValue = _get;
        this.curValue = this.initValue;
      }
    }
    
    @Override
    public void paint(final InstancePainter painter) {
      Bounds bds = this.getBounds(painter);
      Graphics g = painter.getGraphics();
      g.setColor(Color.RED);
      int _x = bds.getX();
      int _y = bds.getY();
      int _width = bds.getWidth();
      int _height = bds.getHeight();
      g.drawRect(_x, _y, _width, _height);
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
    Instance _instance = state.getInstance();
    Bounds bds = _instance.getBounds();
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
