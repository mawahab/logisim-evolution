/*******************************************************************************
 * This file is part of logisim-evolution.
 *
 *   logisim-evolution is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   logisim-evolution is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with logisim-evolution.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   Original code by Carl Burch (http://www.cburch.com), 2011.
 *   Subsequent modifications by :
 *     + Haute École Spécialisée Bernoise
 *       http://www.bfh.ch
 *     + Haute École du paysage, d'ingénierie et d'architecture de Genève
 *       http://hepia.hesge.ch/
 *     + Haute École d'Ingénierie et de Gestion du Canton de Vaud
 *       http://www.heig-vd.ch/
 *   The project is currently maintained by :
 *     + REDS Institute - HEIG-VD
 *       Yverdon-les-Bains, Switzerland
 *       http://reds.heig-vd.ch
 *******************************************************************************/

package com.cburch.logisim.std.memory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstancePoker;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.StdAttr;

public class RegisterFilePoker extends InstancePoker {
	private int initValue;
	private int curValue;
	
	private Point pos ;
	private boolean inZone;

	@Override
	public boolean init(InstanceState state, MouseEvent e) {
		RegisterFileData data = (RegisterFileData) state.getData();
//		if (data == null) {
//			data = new RegisterFileData();
//			state.setData(data);
//		}
//		initValue = data.value;
		curValue = initValue;
		return true;
	}

	@Override
	public void mouseMoved(InstanceState state, MouseEvent e) {
		
		Bounds bds = state.getInstance().getBounds();
		int x = e.getX() ;
		int y = e.getY() ;
		int x0 = bds.getX() ;
		int y0 = bds.getY() ;
		int x1 = bds.getX() + bds.getWidth() ;
		int y1 = bds.getY() + bds.getHeight();
		inZone = (x>=x0) && (x<=x1) && (y>=y0) && (y<=y1);
		pos=new Point(x-x0,y-y0);
		
	}

	
	public void keyTyped(InstanceState state, KeyEvent e) {
		int val = Character.digit(e.getKeyChar(), 16);
		if (val < 0)
			return;

		
		int locX = (int) (pos.getX() - RegisterFile.OFFX_VAL-35) ;
		int locY = (int) (pos.getY() - RegisterFile.OFFY_VAL);

	
		RegisterFileData data = (RegisterFileData) state.getData();
		if(inZone) {
			int col = locX/RegisterFile.COL_WIDTH;
			int row = locY/RegisterFile.ROW_HEIGHT;
			if(row>0&&row<16&&col>=0&&col<=1) {
	
				
				int addr = (int) (16*col + row);
				
				BitWidth dataWidth = state.getAttributeValue(StdAttr.WIDTH);
				if (dataWidth == null)
					dataWidth = BitWidth.create(8);
				
				curValue = data.getValue(addr);
				curValue = (curValue * 16 + val) & dataWidth.getMask();

				data.setValue(addr, curValue);
			}
			
		}

		state.fireInvalidated();
	}

	@Override
	public void paint(InstancePainter painter) {
		Bounds bds = painter.getBounds();
		BitWidth dataWidth = painter.getAttributeValue(StdAttr.WIDTH);
		int width = dataWidth == null ? 8 : dataWidth.getWidth();
		int len = (width + 3) / 4;

		Graphics g = painter.getGraphics();
		g.setColor(Color.RED);
		int wid = 7 * len + 2;
		g.drawRect(bds.getX() + (bds.getWidth() - wid) / 2, bds.getY(), wid, 16);
		g.setColor(Color.BLACK);
	}
}
