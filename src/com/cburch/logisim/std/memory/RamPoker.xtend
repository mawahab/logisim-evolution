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

import com.cburch.logisim.data.Bounds
import com.cburch.logisim.instance.InstancePainter
import com.cburch.logisim.instance.InstancePoker
import com.cburch.logisim.instance.InstanceState
import com.cburch.logisim.proj.Project
import java.awt.Color
import java.awt.Graphics
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

class RamPoker extends InstancePoker {
	private static class AddrPoker extends RamPoker {
		override Bounds getBounds(InstancePainter painter) {
			var MemState data = painter.getData() as MemState
			return data.getBounds(-1, painter.getBounds())
		}

		override void keyTyped(InstanceState state, KeyEvent e) {
			var char c = e.getKeyChar()
			var int ^val = Character.digit(e.getKeyChar(), 16)
			var MemState data = state.getData() as MemState
			if (^val >= 0) {
				var long newScroll = (data.getScroll() * 16 + ^val).bitwiseAnd((data.getLastAddress()))
				data.setScroll(newScroll)
			} else if (c === Character.valueOf(' ').charValue) {
				data.setScroll(data.getScroll() + (data.GetNrOfLines() - 1) * data.GetNrOfLineItems())
			} else if (c === Character.valueOf('\r').charValue || c === Character.valueOf('\n').charValue) {
				data.setScroll(data.getScroll() + data.GetNrOfLineItems())
			} else if (c === Character.valueOf('\u0008').charValue || c === Character.valueOf('\u007f').charValue) {
				data.setScroll(data.getScroll() - data.GetNrOfLineItems())
			} else if (c === Character.valueOf('R').charValue || c === Character.valueOf('r').charValue) {
				data.getContents().clear()
			}

		}

		override void paint(InstancePainter painter) {
			var Bounds bds = getBounds(painter)
			var Graphics g = painter.getGraphics()
			g.setColor(Color.RED)
			g.drawRect(bds.getX(), bds.getY(), bds.getWidth(), bds.getHeight())
			g.setColor(Color.BLACK)
		}
	// See if outside box
	}

	private static class DataPoker extends RamPoker {
		package int initValue
		package int curValue

		private new(InstanceState state, MemState data, long addr) {
			data.setCursor(addr)
			initValue = data.getContents().get(data.getCursor())
			curValue = initValue
			var Object attrs = state.getInstance().getAttributeSet()
			if (attrs instanceof RomAttributes) {
				var Project proj = state.getProject()
				if (proj !== null) {
					(attrs as RomAttributes).setProject(proj)
				}
			}
		}
		override void mousePressed(InstanceState state, MouseEvent e) {
			val clickCount = e.getClickCount()
			if (clickCount == 2 && !e.isConsumed()) {
     			e.consume();
     			var RamState ram = state.getData() as RamState
     			ram.code = !ram.code;
			}
		}

		override Bounds getBounds(InstancePainter painter) {
			var MemState data = painter.getData() as MemState
			var Bounds inBounds = painter.getInstance().getBounds()
			return data.getBounds(data.getCursor(), inBounds)
		}

		override void keyTyped(InstanceState state, KeyEvent e) {
			var char c = e.getKeyChar()
			var int ^val = Character.digit(e.getKeyChar(), 16)
			var MemState data = state.getData() as MemState
			if (^val >= 0) {
				curValue = curValue * 16 + ^val
				data.getContents().set(data.getCursor(), curValue)
				state.fireInvalidated()
			} else if (c === Character.valueOf(' ').charValue || c === Character.valueOf('\t').charValue) {
				moveTo(data, data.getCursor() + 1)
			} else if (c === Character.valueOf('\r').charValue || c === Character.valueOf('\n').charValue) {
				moveTo(data, data.getCursor() + data.GetNrOfLineItems())
			} else if (c === Character.valueOf('\u0008').charValue || c === Character.valueOf('\u007f').charValue) {
				moveTo(data, data.getCursor() - 1)
			} else if (c === Character.valueOf('R').charValue || c === Character.valueOf('r').charValue) {
				data.getContents().clear()
			}

		}
		
		def private void moveTo(MemState data, long addr) {
			if (data.isValidAddr(addr)) {
				data.setCursor(addr)
				data.scrollToShow(addr)
				initValue = data.getContents().get(addr)
				curValue = initValue
			}

		}

		override void paint(InstancePainter painter) {
			var Bounds bds = getBounds(painter)
			var Graphics g = painter.getGraphics()
			g.setColor(Color.RED)
			g.drawRect(bds.getX(), bds.getY(), bds.getWidth(), bds.getHeight())
			g.setColor(Color.BLACK)
		}

		override void stopEditing(InstanceState state) {
			var MemState data = state.getData() as MemState
			data.setCursor(-1)
		}

	}

	RamPoker sub

	override Bounds getBounds(InstancePainter state) {
		return sub.getBounds(state)
	}

	override boolean init(InstanceState state, MouseEvent event) {
		var Bounds bds = state.getInstance().getBounds()
		var MemState data = state.getData() as MemState
		var long addr = data.getAddressAt(event.getX() - bds.getX(), event.getY() - bds.getY())
		if (addr < 0) {
			sub = new AddrPoker()
		} else {
			sub = new DataPoker(state, data, addr)
		}
		return true
	}

	override void keyTyped(InstanceState state, KeyEvent e) {
		sub.keyTyped(state, e)
	}

	override void paint(InstancePainter painter) {
		sub.paint(painter)
	}

}
