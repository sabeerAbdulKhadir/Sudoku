package com.sudoku.test;

import java.io.FileNotFoundException;

import com.sudoku.Sudoku;

public class TestSudoku {

	public static void main(String[] args) throws FileNotFoundException {

		Sudoku sudoku = new Sudoku("C:\\Users\\abdulksa\\Desktop\\input.txt", "output.txt", "|", " . ");
		sudoku.solvePuzzle();

	}

}
