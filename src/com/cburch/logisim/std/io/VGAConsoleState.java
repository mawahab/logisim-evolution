package com.cburch.logisim.std.io;

import java.util.Arrays;

import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.InstanceData;

class VGAConsoleState implements InstanceData, Cloneable {
	
	private Value[] grid;
	private long[] persistTo;

	public VGAConsoleState(int rows, int cols) {
		int length = rows * cols; 
		grid = new Value[length];
		persistTo = new long[length];
		Arrays.fill(grid, Value.UNKNOWN);
	}

	@Override
	public Object clone() {
		try {
			VGAConsoleState ret = (VGAConsoleState) super.clone();
			ret.grid = this.grid.clone();
			ret.persistTo = this.persistTo.clone();
			return ret;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	Value get(int row, int col) {
		int index = row * VGAConsole.cols + col;
		Value ret = grid[index];
		return ret;
	}

	public void set(int row, int col, Value newVal) {
		int index = row * VGAConsole.cols + col;
		grid[index] = Value.create(new Value[]{newVal});
	}


}