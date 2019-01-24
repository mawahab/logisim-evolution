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

import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.instance.InstanceData;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstancePoker;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.std.memory.RegisterData;
import com.cburch.logisim.std.memory.TraceRecorderData;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@SuppressWarnings("all")
public class TraceRecorderPoker extends InstancePoker {
  private int initValue;
  
  private int curValue;
  
  @Override
  public boolean init(final InstanceState state, final MouseEvent e) {
    InstanceData _data = state.getData();
    RegisterData data = ((RegisterData) _data);
    if ((data == null)) {
      RegisterData _registerData = new RegisterData();
      data = _registerData;
      state.setData(data);
    }
    this.initValue = data.value;
    this.curValue = this.initValue;
    return true;
  }
  
  @Override
  public void keyTyped(final InstanceState state, final KeyEvent e) {
    int val = Character.digit(e.getKeyChar(), 16);
    if ((val < 0)) {
      return;
    }
    BitWidth dataWidth = state.<BitWidth>getAttributeValue(StdAttr.WIDTH);
    if ((dataWidth == null)) {
      dataWidth = BitWidth.create(8);
    }
    this.curValue = (((this.curValue * 16) + val) & dataWidth.getMask());
    InstanceData _data = state.getData();
    TraceRecorderData data = ((TraceRecorderData) _data);
    state.fireInvalidated();
  }
  
  @Override
  public void paint(final InstancePainter painter) {
    Bounds bds = painter.getBounds();
    BitWidth dataWidth = painter.<BitWidth>getAttributeValue(StdAttr.WIDTH);
    int _xifexpression = (int) 0;
    if ((dataWidth == null)) {
      _xifexpression = 8;
    } else {
      _xifexpression = dataWidth.getWidth();
    }
    int width = _xifexpression;
    int len = ((width + 3) / 4);
    Graphics g = painter.getGraphics();
    g.setColor(Color.RED);
    int wid = ((7 * len) + 2);
    int _x = bds.getX();
    int _width = bds.getWidth();
    int _minus = (_width - wid);
    int _divide = (_minus / 2);
    int _plus = (_x + _divide);
    g.drawRect(_plus, bds.getY(), wid, 16);
    g.setColor(Color.BLACK);
  }
}
