package com.sudoku;

import java.io.FileNotFoundException;

public class TestSudokuSolver {

	public static void main(String[] args) throws FileNotFoundException {

		Sudoku sudoku = new Sudoku("C:\\input.txt", "C:\\output.txt");

		sudoku.solvePuzzle();

	}

}
