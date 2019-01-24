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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;


import com.bfh.logisim.designrulecheck.CorrectLabel;
import com.cburch.logisim.cpu.NIOS2Instr;
import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeSet;
import com.cburch.logisim.data.Attributes;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Location;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.Instance;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.util.GraphicsUtil;

public class Nios2Simulator extends InstanceFactory {
	
	public static final int ROW_HEIGHT = 18;
	public static final int COL_WIDTH = 130;
	public  static final int HEIGHT = 230;
	public  static final int WIDTH = 320;
	public  static final int OFFX_VAL = 100;
	public  static final int OFFY_VAL = 40;
	public  static final int UP_X = OFFX_VAL-20;
	public  static final int UP_Y = OFFY_VAL;
	public  static final int DOWN_X = UP_X;
	private static final int NB_ROW = 8;
	public  static final int DOWN_Y = UP_Y+(NB_ROW-1)*ROW_HEIGHT+5;
	
	Port[] ps = new Port[13];
	
	public static void drawNiosII(InstancePainter painter, int x, int y,  boolean has_we,
			Nios2Data data) {

		Graphics g = painter.getGraphics();
		GraphicsUtil.switchToWidth(g, 2);
		g.drawRect(x, y , WIDTH, HEIGHT);
		GraphicsUtil.switchToWidth(g, 1);
		
		GraphicsUtil.drawCenteredText(g,"NIOS II SIMULATOR",x+WIDTH/2, y+8);
		GraphicsUtil.drawCenteredText(g,"("+data.currentState.name()+")",x+WIDTH/2, y+25);

		GraphicsUtil.drawText(g,"CLK",x+5, y+20, GraphicsUtil.H_LEFT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"RST",x+5, y+40, GraphicsUtil.H_LEFT,GraphicsUtil.V_CENTER);

		GraphicsUtil.drawText(g,"IO_ACK",x+5, y+60, GraphicsUtil.H_LEFT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"BRKPT",x+5, y+80, GraphicsUtil.H_LEFT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"DEBUG",x+5, y+100, GraphicsUtil.H_LEFT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"CPU_DIN",x+WIDTH-5, y+20 , GraphicsUtil.H_RIGHT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"CPU_DOUT",x+WIDTH-5, y+40, GraphicsUtil.H_RIGHT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"CPU_ADDR",x+WIDTH-5, y+60, GraphicsUtil.H_RIGHT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"CPU_IOWR",x+WIDTH-5, y+80, GraphicsUtil.H_RIGHT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"CPU_IORD",x+WIDTH-5, y+100, GraphicsUtil.H_RIGHT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"CPU_MEMWR",x+WIDTH-5, y+120, GraphicsUtil.H_RIGHT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"CPU_MEMRD",x+WIDTH-5, y+140, GraphicsUtil.H_RIGHT,GraphicsUtil.V_CENTER);
		GraphicsUtil.drawText(g,"CPU_BWE",x+WIDTH-5, y+160, GraphicsUtil.H_RIGHT,GraphicsUtil.V_CENTER);

		NIOS2Instr i = new NIOS2Instr(data.getIR());
		GraphicsUtil.drawText(g,i.toString().toUpperCase(),x+OFFX_VAL, y+HEIGHT-20, GraphicsUtil.H_LEFT,GraphicsUtil.V_TOP);
		GraphicsUtil.drawText(g,"PC="+String.format("%08X",data.getPC()),x+OFFX_VAL, y+HEIGHT-40, GraphicsUtil.H_LEFT,GraphicsUtil.V_TOP);
		
		
		drawRegValues(g, x+OFFX_VAL, y+OFFY_VAL, data.getOffset(), NB_ROW,  has_we, data);
		drawTriangle(g, x + UP_X, y +UP_Y, 15, 15, false);
		drawTriangle(g, x + DOWN_X, y +DOWN_Y, 15, 15, true);
		g.fillRect(x+ UP_X+5, y+UP_Y+9, 4, DOWN_Y-UP_Y-5);
		
		
	}
	
	static void  drawRegValues(Graphics g,  int x, int y,int offset, int nvalues, boolean has_we,
			Nios2Data data) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x-20, y-4, 140, nvalues*ROW_HEIGHT+8);
		g.setColor(Color.black);
		for (int r = offset; r < Math.min(offset+nvalues, data.R.length-1); r += 1) {
			int locY = y + ROW_HEIGHT * (r-offset);
			int address = r;
			String code = getPaddedBinary(32, data, address);
			if(data.lastRegEvent!=r) {
				g.drawRect(x+30, locY, 80, ROW_HEIGHT-3);
				g.drawString("R" + address, x+5, locY+13);
				g.drawString(code, x +37, locY +13);
			} else {
				g.setColor(Color.RED);
				g.drawRect(x+30, locY, 80, ROW_HEIGHT-3);
				g.drawString("R" + address, x+5, locY+13);
				Font oldfont = g.getFont();
				g.setFont(oldfont.deriveFont(Font.BOLD));
				g.drawString(code, x +35, locY +13);
				g.setFont(oldfont);
				g.setColor(Color.black);
			}
		}
	}

	private static String getPaddedBinary(int nr_of_bits, Nios2Data data, int address) {
		String code = Integer.toHexString(data.getReg(address)).toUpperCase();
		while (code.length() < ((nr_of_bits+1)/4)) {    //pad with 16 0's
			code = "0" + code;
		}
		return code;
	}
	static void  drawTriangle(Graphics g, int x, int y, int w, int h, boolean reverse) {
		
		if (reverse) {
			g.fillPolygon(new Polygon(new int[] {x, x+w/2, x+w}, new int[] {y, y + h, y }, 3));
		} else {
			g.fillPolygon(new Polygon(new int[] {x, x+w/2, x+w}, new int[] {y+h, y, y+h}, 3));
		}
	}


	public static final int CLK = 0;
	public static final int RST = 1;
	public static final int IO_RD = 2;
	public static final int IO_WR = 3;
	public static final int CPU_DIN = 4;
	public static final int CPU_DOUT = 5;
	public static final int CPU_ADDR = 6;
	public static final int MEM_WR = 7;
	public static final int MEM_RD = 8;
	public static final int IO_ACK= 9;
	public static final int BE= 10;

	public static final int BKPT= 11;
	public static final int DEBUG= 12;
	
	static final int DELAY = 1;

	static final int Xsize = 60;
	static final int Ysize = 90;

	public static final Attribute<Boolean> ATTR_SHOW_IN_TAB = Attributes
			.forBoolean("showInTab", Strings.getter("registerShowInTab"));
	private static final int ADDR_WIDTH = 5;

	public Nios2Simulator() {
		super("Nios2Simulator", Strings.getter("Nios2Simulator"));
		setAttributes(new Attribute[] { 
				StdAttr.LABEL, StdAttr.LABEL_FONT, ATTR_SHOW_IN_TAB, },
				new Object[] { "",StdAttr.DEFAULT_LABEL_FONT, false, });
		
		
		setOffsetBounds(Bounds.create(0, 0, WIDTH, HEIGHT));
		
		setIconName("Nios2Simulator.gif");
		setInstancePoker(NIOS2SimPoker.class);
		//setInstanceLogger(RegisterFileLogger.class);

		ps[CLK]= new Port(0, 20, Port.INPUT, 1);
		ps[RST]= new Port(0, 40, Port.INPUT, 1);
		ps[IO_ACK]= new Port(0, 60, Port.INPUT, 1);
		ps[BKPT]= new Port(0, 80, Port.INPUT, 32);
		ps[DEBUG]= new Port(0, 100, Port.INPUT, 1);


		ps[CPU_DIN]= new Port(WIDTH, 20, Port.INPUT, 32);
		ps[CPU_DOUT]= new Port(WIDTH, 40, Port.OUTPUT, 32);
		ps[CPU_ADDR]= new Port(WIDTH, 60, Port.OUTPUT, 32);

		ps[IO_WR]= new Port(WIDTH, 80, Port.OUTPUT, 1);
		ps[IO_RD]= new Port(WIDTH, 100, Port.OUTPUT, 1);
		
		ps[MEM_WR]= new Port(WIDTH, 120, Port.OUTPUT, 1);
		ps[MEM_RD]= new Port(WIDTH, 140, Port.OUTPUT, 1);	

		ps[BE]= new Port(WIDTH, 160, Port.OUTPUT, 4);	
		setPorts(ps);
	}

	@Override
	protected void configureNewInstance(Instance instance) {
		Bounds bds = instance.getBounds();
		instance.setTextField(StdAttr.LABEL, StdAttr.LABEL_FONT, bds.getX()
				+ bds.getWidth() / 2, bds.getY() - 3, GraphicsUtil.H_CENTER,
				GraphicsUtil.V_BASELINE);
	}

	@Override
	public String getHDLName(AttributeSet attrs) {
		StringBuffer CompleteName = new StringBuffer();
		CompleteName.append(CorrectLabel.getCorrectLabel(this.getName())
				.toUpperCase());
		return CompleteName.toString();
	}

	@Override
	public boolean HDLSupportedComponent(String HDLIdentifier,
			AttributeSet attrs) {
		if (MyHDLGenerator == null) {
			MyHDLGenerator = new RegisterFileHDLGeneratorFactory();
		}
		return MyHDLGenerator.HDLTargetSupported(HDLIdentifier, attrs);
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		Nios2Data state = (Nios2Data) painter.getData();
		Location loc = painter.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		// determine text to draw in label
		drawNiosII(painter, x, y,  true, state);
		painter.drawLabel();
		// draw input and output ports
		for(int i=0;i<ps.length;i++)
			painter.drawPort(i);
	
	}

	@Override
	public void propagate(InstanceState state) {
		Nios2Data data = (Nios2Data) state.getData();
		if (data == null) {
			data = new Nios2Data();
			state.setData(data);
		}

		Object triggerType = state.getAttributeValue(StdAttr.TRIGGER);
		boolean triggered = data.updateClock(state.getPortValue(CLK),triggerType);

		if (state.getPortValue(RST) == Value.TRUE) {
			data.clear();
		} else if (triggered) {
			data.currentState = data.nextState;
			switch(data.currentState) {
				case IDLE :{
					data.setNextState(Nios2Data.CPUState.FETCH);
					break;
				}
				case FETCH:{
					state.setPort(BE, Value.createKnown(BitWidth.create(4), 0xF),DELAY);
					Value valPC = Value.createKnown(BitWidth.create(32), data.getPC());
					state.setPort(CPU_ADDR, valPC,DELAY);
					state.setPort(MEM_WR, Value.FALSE,DELAY);
					state.setPort(MEM_RD, Value.TRUE,DELAY);
					state.setPort(IO_RD, Value.FALSE,DELAY);
					state.setPort(IO_WR, Value.FALSE,DELAY);
					data.setNextState(Nios2Data.CPUState.DECODE);
					break;

				}
				case DECODE :{
					data.setNextState(Nios2Data.CPUState.EXECUTE);
					Value IR = state.getPortValue(CPU_DIN);
					if(IR.isFullyDefined()) {
						data.setIR(IR.toIntValue());
					}
					Value valPC = Value.createKnown(BitWidth.create(32), data.getPC());
					if (state.getPortValue(DEBUG)==Value.TRUE) {
						if (state.getPortValue(BKPT).equals(valPC)) {
							data.setNextState(Nios2Data.CPUState.DECODE);
						}
					}
					break;
				}
				case EXECUTE :{
					Value IR = state.getPortValue(CPU_DIN);
					state.setPort(MEM_RD, Value.FALSE,DELAY);
					if(IR.isFullyDefined()) {
						data.setIR(IR.toIntValue());
					} else {
						data.setNextState(Nios2Data.CPUState.ILLEGAL_INSTR);
					}
					data.setNextState(Nios2Data.CPUState.FETCH);
					data.execute();
					state.setPort(CPU_ADDR, Value.createKnown(BitWidth.create(32), data.getCPUAddress()),DELAY);
					state.setPort(CPU_DOUT, Value.createKnown(BitWidth.create(32), data.getCPUDout()),DELAY);
					state.setPort(MEM_WR, Value.FALSE,DELAY);
					state.setPort(MEM_RD, Value.FALSE,DELAY);
					state.setPort(IO_RD, Value.FALSE,DELAY);
					state.setPort(IO_WR, Value.FALSE,DELAY);
					data.cpt=2;
					break;

				}
				case MEM_READ:{
					state.setPort(MEM_RD, Value.TRUE,DELAY);
					Value in = state.getPortValue(CPU_DIN);
					if (in.isFullyDefined()) {
						switch (data.instr.op) {
						case ldw: {
							data.setReg(data.instr.rb, in.toIntValue());
							break;
						}
						case ldh: {
							int shift= 8*(data.R[data.instr.ra]&0x2);
							data.setReg(data.instr.rb, (in.toIntValue()>>shift)&0xFFFF);
							break;
						}
						case ldb: {
							int shift= 8*(data.R[data.instr.ra]&0x3);
							data.setReg(data.instr.rb, (in.toIntValue()>>shift)&0xFF);
							break;
						}
						}
					}
					if (data.cpt==0) data.setNextState(Nios2Data.CPUState.FETCH);
					data.cpt--;
					break;
				}
				case IO_READ:{
					state.setPort(IO_RD, Value.TRUE,DELAY);
					Value ack = state.getPortValue(IO_ACK);
					if (ack.isFullyDefined()) {
						if (ack.toIntValue()==1) {
							data.setNextState(Nios2Data.CPUState.FETCH);
							Value in = state.getPortValue(CPU_DIN);
							if (in.isFullyDefined()) {
								switch (data.instr.op) {
								case ldwio: {
									data.setReg(data.instr.rb, in.toIntValue());
									break;
								}
								case ldhio: {
									int shift= 8*(data.R[data.instr.ra]&0x2);
									data.setReg(data.instr.rb, (in.toIntValue()>>shift)&0xFFFF);
									break;
								}
								case ldbio: {
									int shift= 8*(data.R[data.instr.ra]&0x2);
									data.setReg(data.instr.rb, (in.toIntValue()>>shift)&0xFF);
									break;
								
								}
								}
							}
						}
					} else {
						data.setNextState(Nios2Data.CPUState.BUS_ERROR);
					}
					break;
				}
				case MEM_WRITE:{
					
					state.setPort(MEM_WR, Value.TRUE,DELAY);
					switch (data.instr.op) {
					case stw: {
						state.setPort(BE, Value.createKnown(BitWidth.create(4), 0xF),DELAY);
						break;
					}
					case sth: {
						int shift= (data.R[data.instr.ra]&0x2)>>1;
						state.setPort(BE, Value.createKnown(BitWidth.create(4), 3<<shift),DELAY);
						break;
					}
					case stb: {
						int shift= data.R[data.instr.ra]&0x3;
						state.setPort(BE, Value.createKnown(BitWidth.create(4), 1<<shift),DELAY);
						break;
					}
					}
					if (data.cpt==0) data.setNextState(Nios2Data.CPUState.FETCH);
					data.cpt--;
					break;
				}
				case IO_WRITE:{
					state.setPort(IO_WR, Value.TRUE,DELAY);
					switch (data.instr.op) {
					case stwio: {
						state.setPort(BE, Value.createKnown(BitWidth.create(4), 0xF),DELAY);
						break;
					}
					case sthio: {
						int shift= (data.R[data.instr.ra]&0x2)>>1;
						state.setPort(BE, Value.createKnown(BitWidth.create(4), 3<<shift),DELAY);
						break;
					}
					case stbio: {
						int shift= data.R[data.instr.ra]&0x3;
						state.setPort(BE, Value.createKnown(BitWidth.create(4), 1<<shift),DELAY);
						break;
					}
					}
					Value ack = state.getPortValue(IO_ACK);
					if (ack.isFullyDefined()) {
						if (ack.toIntValue()==1)
							data.setNextState(Nios2Data.CPUState.FETCH);
					} else {
						data.setNextState(Nios2Data.CPUState.BUS_ERROR);
					}
					break;
				}
			}
		}
	}
}