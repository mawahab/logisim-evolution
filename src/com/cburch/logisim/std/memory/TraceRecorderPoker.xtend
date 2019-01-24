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
package com.cburch.logisim.std.memory

import java.awt.Color
import java.awt.Graphics
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import com.cburch.logisim.data.BitWidth
import com.cburch.logisim.data.Bounds
import com.cburch.logisim.instance.InstancePainter
import com.cburch.logisim.instance.InstancePoker
import com.cburch.logisim.instance.InstanceState
import com.cburch.logisim.instance.StdAttr

class TraceRecorderPoker extends InstancePoker {
	int initValue
	int curValue

	override boolean init(InstanceState state, MouseEvent e) {
		var RegisterData data = (state.getData() as RegisterData)
		if (data === null) {
			data = new RegisterData()
			state.setData(data)
		}
		initValue = data.value
		curValue = initValue
		return true
	}

	override void keyTyped(InstanceState state, KeyEvent e) {
		var int ^val = Character.digit(e.getKeyChar(), 16)
		if(^val < 0) return;
		var BitWidth dataWidth = state.getAttributeValue(StdAttr.WIDTH)
		if(dataWidth === null) dataWidth = BitWidth.create(8)
		curValue = (curValue * 16 + ^val).bitwiseAnd(dataWidth.getMask())
		var TraceRecorderData data = (state.getData() as TraceRecorderData)
		///data.value = curValue
		state.fireInvalidated()
	}

	override void paint(InstancePainter painter) {
		var Bounds bds = painter.getBounds()
		var BitWidth dataWidth = painter.getAttributeValue(StdAttr.WIDTH)
		var int width = if(dataWidth === null) 8 else dataWidth.getWidth()
		var int len = (width + 3) / 4
		var Graphics g = painter.getGraphics()
		g.setColor(Color.RED)
		var int wid = 7 * len + 2
		g.drawRect(bds.getX() + (bds.getWidth() - wid) / 2, bds.getY(), wid, 16)
		g.setColor(Color.BLACK)
	}
}
