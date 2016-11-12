package com.sudoku;

public class Column {
	private Cell[] column = new Cell[9];

	/**
	 * @return the column
	 */
	public Cell[] getColumn() {
		return column;
	}

	/**
	 * @param column
	 *            the column to set
	 */
	public void setColumn(Cell[] column) {
		this.column = column;
	}
}
