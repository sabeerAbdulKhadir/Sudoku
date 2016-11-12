
package com.sudoku.components;

public class Grid {

	private Cell[][] grid;

	private int numberOfRows;

	private int numberOfColumns;

	public Grid(int noOfRows, int noOfColumns) {
		setNumberOfRows(noOfRows);
		setNumberOfColumns(noOfColumns);
		setGrid(new Cell[getNumberOfRows()][getNumberOfColumns()]);
	}

	/**
	 * Gets the cells in corresponding point.
	 * 
	 * @param point
	 * @return
	 */
	public Cell getCell(int x, int y) {

		return getGrid()[x][y];
	}

	/**
	 * Sets the cell on to the location (x,y)
	 * 
	 * @param cell
	 *            the cell to set
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 */
	public void setCell(Cell cell, int x, int y) {
		getGrid()[x][y] = cell;
	}

	/**
	 * Gets the value of the cell in the location x, y;
	 * 
	 * @param x
	 *            x-coordinate of the cell.
	 * @param y
	 *            y-coordinate of the cell.
	 * @return value of the cell.
	 */
	public String getCellValue(int x, int y) {
		return getCell(x, y).getValue();
	}

	/**
	 * Sets the value on to the cell identified by the location (x,y).
	 * 
	 * @param value
	 *            the value to set.
	 * @param x
	 *            x-coordinate of the cell.
	 * @param y
	 *            y-coordinate of the cell.
	 */
	public void setCellValue(String value, int x, int y) {
		getCell(x, y).setValue(value);
	}

	/**
	 * Getter for grid.
	 * 
	 * @return the cells
	 */
	public Cell[][] getGrid() {
		return grid;
	}

	/**
	 * Setter for cells.
	 * 
	 * @param cells
	 *            the cells to set
	 */
	public void setGrid(Cell[][] cells) {
		this.grid = cells;
	}

	/**
	 * Getter for numberOfRows.
	 * 
	 * @return the numberOfRows.
	 */
	public int getNumberOfRows() {
		return numberOfRows;
	}

	/**
	 * Setter for numberOfRows.
	 * 
	 * @param numberOfRows
	 *            the numberOfRows to set.
	 */
	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	/**
	 * Getter for numberOfColumns.
	 * 
	 * @return the numberOfColumns
	 */
	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	/**
	 * Setter for numberOfColumns.
	 * 
	 * @param numberOfColumns
	 *            the numberOfColumns to set
	 */
	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}
}
