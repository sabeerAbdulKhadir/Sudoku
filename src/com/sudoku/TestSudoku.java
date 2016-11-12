package com.sudoku;

import java.io.FileNotFoundException;

public class TestSudoku {

	public static void main(String[] args) throws FileNotFoundException {

		Sudoku sudoku = new Sudoku("C:\\Users\\abdulksa\\Desktop\\input.txt", "output.txt", "|", " . ");
		sudoku.solvePuzzle();

	}

}
