package com.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

	private static final String PERIOD = ".";

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
	public boolean solveGrid(String[][] grid) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				String value = grid[i][j];
				if (PERIOD.equals(value.trim())) {// Empty cell

					// Checking values 1-9 for this location
					for (int k = 1; k <= 9; k++) {
						// assign value of k.
						grid[i][j] = value.replace(PERIOD, "" + k);
						// recursively check for the correctness of the value.
						if (isLegit(grid, i, j) && solveGrid(grid)) {
							return true;// if correct
						}
						grid[i][j] = value;
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
	 * @param a
	 *            row location of the number.
	 * @param b
	 *            column location of the number.
	 * @return
	 */
	private boolean isLegit(String[][] grid, int a, int b) {
		Set<Character> row = new HashSet<Character>();// Set for holding the row
		// numbers.
		for (int j = 0; j < 9; j++) {
			char rowElement = grid[a][j].trim().charAt(0);
			if (row.contains(rowElement)) {// Checks whether the number is
				// already present in the row.
				return false;
			}
			if (rowElement > '0' && rowElement <= '9') {// else, add to the set.
				row.add(rowElement);
			}
		}

		// Set for holding column values.
		Set<Character> column = new HashSet<Character>();
		for (int j = 0; j < 9; j++) {
			char colElement = grid[j][b].trim().charAt(0);
			// Checks whether the number is already present in the columns
			if (column.contains(colElement)) {
				return false;
			}
			if (colElement > '0' && colElement <= '9') {// else, add to the set.
				column.add(colElement);
			}
		}

		// Set to check for the inner 3x3 grid.
		Set<Character> innerGrid = new HashSet<Character>();
		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 3; n++) {
				// general expression to determine the location of 3x3 inner
				// grid for a number represented by the coordinates (a,b) in the
				// main grid.
				int x = a / 3 * 3 + m;
				int y = b / 3 * 3 + n;

				if (innerGrid.contains(grid[x][y].trim().charAt(0))) {
					// Checks whether the number is already present in the inner
					// grid
					return false;
				}
				char number = grid[x][y].trim().charAt(0);
				if (number > '0' && number <= '9') {// else, add to the
					// set
					innerGrid.add(number);
				}

			}
		}

		return true;
	}

}
