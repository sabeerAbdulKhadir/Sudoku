package com.sudoku.solver;

import com.sudoku.components.Grid;

/**
 * Generic solver interface for grid puzzles.
 * 
 */
public interface GridPuzzleSolver {

	/**
	 * Solves the grid .
	 * 
	 * @param grid
	 *            the grid to be solved..
	 * 
	 * @return true if able to solve the grid, false otherwise.
	 * 
	 */
	public boolean solveGrid(Grid grid);

}
