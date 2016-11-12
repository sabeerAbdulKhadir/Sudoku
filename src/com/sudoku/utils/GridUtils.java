package com.sudoku.utils;

import java.util.HashSet;
import java.util.Set;

import com.sudoku.components.Cell;
import com.sudoku.components.Grid;
import com.sudoku.constants.SudokuConstants;

/**
 * Utility class to perform various grid related operations.
 * 
 */
public class GridUtils {

	/**
	 * Gets the row corresponding to the x coordinate from the grid.
	 * 
	 * @param grid
	 *            supplied grid.
	 * @param x
	 *            x coordinate of the row
	 * @return row ({@link Cell}[]) corresponding to the supplied x coordinate.
	 */
	public static Cell[] getRow(Grid grid, int x) {
		Cell[] row = new Cell[grid.getNumberOfColumns()];
		for (int indexOfColumns = 0; indexOfColumns < grid.getNumberOfColumns(); indexOfColumns++) {
			row[indexOfColumns] = grid.getCell(x, indexOfColumns);
		}
		return row;
	}

	/**
	 * Gets the column corresponding to the y coordinate from the grid.
	 * 
	 * @param grid
	 *            supplied grid.
	 * @param y
	 *            y coordinate of the row
	 * @return column ({@link Cell}[]) corresponding to the supplied y
	 *         coordinate.
	 */
	public static Cell[] getColumn(Grid grid, int y) {
		Cell[] column = new Cell[grid.getNumberOfRows()];
		for (int indexOfRows = 0; indexOfRows < grid.getNumberOfRows(); indexOfRows++) {
			column[indexOfRows] = grid.getCell(indexOfRows, y);
		}
		return column;
	}

	/**
	 * Gets the <b>'sudoku region'</b> where the cell identified by the supplied
	 * coordinates belongs to. A <b>'sudoku region'</b> is a <b>3x3 grid </b>.
	 * 
	 * @param grid
	 *            the grid
	 * @param x
	 *            x coordinate of the element
	 * @param y
	 *            y coordinate of the element
	 * @return a 3x3 {@link Cell}
	 */
	public static Cell[][] getRegion(Grid grid, int x, int y) {
		Cell[][] region = new Cell[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// general expression to determine the location of elements of
				// 3x3 inner grid for a number represented by the coordinates
				// (x,y) in the main grid.
				int xx = x / 3 * 3 + i;
				int yy = y / 3 * 3 + j;
				region[i][j] = grid.getCell(xx, yy);
			}
		}

		return region;
	}

	/**
	 * Checks whether the row identified by x has duplicate elements or not in
	 * the supplied grid.
	 * 
	 * @param grid
	 *            the grid
	 * @param x
	 *            the x coordinate
	 * @return true if duplicates present, false otherwise.
	 */
	public static boolean hasRowDuplicates(Grid grid, int x) {
		Set<String> distinctElements = new HashSet<String>();
		for (int indexOfColumns = 0; indexOfColumns < grid.getNumberOfColumns(); indexOfColumns++) {
			String element = grid.getCellValue(x, indexOfColumns).trim();

			if (distinctElements.contains(element)) {
				return true;
			}

			if (element.matches(SudokuConstants.NUMBER_PATTERN)) {
				distinctElements.add(element);
			}
		}
		return false;
	}

	/**
	 * 
	 * Checks whether the column identified by y has duplicate elements or not
	 * in the supplied grid.
	 * 
	 * @param grid
	 *            the grid
	 * @param y
	 *            the y coordinate
	 * @return true if duplicates present, false otherwise.
	 * 
	 */
	public static boolean hasColumnDuplicates(Grid grid, int y) {
		Set<String> distinctElements = new HashSet<String>();
		for (int indexOfRows = 0; indexOfRows < grid.getNumberOfRows(); indexOfRows++) {
			String element = grid.getCellValue(indexOfRows, y).trim();

			if (distinctElements.contains(element)) {
				return true;
			}

			if (element.matches(SudokuConstants.NUMBER_PATTERN)) {
				distinctElements.add(element);
			}
		}
		return false;
	}

	/**
	 * Checks whether duplicates present in the <b>'sudoku region'</b> where the
	 * cell identified by the supplied coordinates belongs to. A <b>'sudoku
	 * region'</b> is a <b>3x3 grid </b>.
	 * 
	 * @param grid
	 *            the grid
	 * @param x
	 *            x coordinate of the element
	 * @param y
	 *            y coordinate of the element
	 * @return true if duplicates present, false otherwise.
	 */
	public static boolean hasRegionDuplicates(Grid grid, int x, int y) {

		Set<String> distinctElements = new HashSet<String>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// general expression to determine the location of elements of
				// 3x3 inner grid for a number represented by the coordinates
				// (x,y) in the main grid.
				int xx = x / 3 * 3 + i;
				int yy = y / 3 * 3 + j;

				String element = grid.getCellValue(xx, yy).trim();
				if (distinctElements.contains(element)) {
					// Checks whether the element is already present in the
					// inner grid
					return true;
				}
				if (element.matches(SudokuConstants.NUMBER_PATTERN)) {
					// else, add to the set
					distinctElements.add(element);
				}
			}
		}
		return false;
	}

	/**
	 * Formats newValue into originalValue format(with space).
	 * 
	 * @param newValue
	 *            to be formatted
	 * @param originalValue
	 *            newValue to have the format of originalValue.
	 * 
	 * @return
	 */
	public static String formatWithSpace(String newValue, String originalValue) {
		String charToReplace = originalValue.trim();
		return originalValue.replace(charToReplace, newValue);
	}

}
