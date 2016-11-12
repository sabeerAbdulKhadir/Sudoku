package com.sudoku;

public class Grid {

	private Cell[][] grid = new Cell[9][9];

	/**
	 * @return the grid
	 */
	public Cell[][] getGrid() {
		return grid;
	}

	/**
	 * @param grid
	 *            the grid to set
	 */
	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

}
