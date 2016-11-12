package com.sudoku.test;

import java.io.FileNotFoundException;

import com.sudoku.Sudoku;

public class TestSudokuSolver {

	public static void main(String[] args) throws FileNotFoundException {

		Sudoku sudoku = new Sudoku("C:\\input.txt", "C:\\output.txt");

		sudoku.solvePuzzle();

	}

}
