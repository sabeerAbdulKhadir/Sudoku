package com.sudoku;

public class Row {

	private Cell[] row = new Cell[9];

	/**
	 * @return the row
	 */
	public Cell[] getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(Cell[] row) {
		this.row = row;
	}
}
