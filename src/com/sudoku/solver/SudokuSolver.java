package com.sudoku.solver;

import com.sudoku.components.Cell;
import com.sudoku.components.Grid;
import com.sudoku.utils.GridUtils;

public class SudokuSolver implements GridPuzzleSolver {

	/**
	 * Solves the grid by inserting a valid number in the location.
	 * 
	 * @param grid
	 *            the 2D representation of the sudoku board.
	 * 
	 * @return true if a correct value is identified for a location. false,
	 *         otherwise.
	 * 
	 */
	public boolean solveGrid(Grid grid) {

		for (int x = 0; x < grid.getNumberOfRows(); x++) {
			for (int y = 0; y < grid.getNumberOfColumns(); y++) {
				Cell cell = grid.getCell(x, y);
				if (cell.isEmpty()) {
					String value = cell.getValue();
					for (int number = 1; number <= 9; number++) {
						String formattedValue = GridUtils.formatWithSpace("" + number, cell.getEmptyValue());
						grid.setCellValue(formattedValue, x, y);
						// recursively check for the correctness of the value.
						if (isLegit(grid, x, y) && solveGrid(grid)) {
							return true;// if correct
						}
						// if wrong, set it back to original value
						grid.setCellValue(value, x, y);
					}
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Determines whether a number in the grid location(a,b) is valid or not.
	 * 
	 * @param grid
	 *            2D representation of the sudoku board.
	 * @param x
	 *            row location of the number.
	 * @param y
	 *            column location of the number.
	 * @return
	 */
	private boolean isLegit(Grid grid, int x, int y) {

		// Get the row and check for duplicates in it.
		if (GridUtils.hasRowDuplicates(grid, x)) {
			return false;
		}

		// Get the column and check for duplicates in it.
		if (GridUtils.hasColumnDuplicates(grid, y)) {
			return false;
		}

		// Get the region and check for duplicates in it.
		if (GridUtils.hasRegionDuplicates(grid, x, y)) {
			return false;
		}

		return true;
	}

}
