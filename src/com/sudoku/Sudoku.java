package com.sudoku;

import java.io.File;
import java.io.FileNotFoundException;

import com.sudoku.exception.SudokuFileException;
import com.sudoku.fileio.FileReaderWriter;
import com.sudoku.fileio.SudokuReaderWriter;

public class Sudoku {

	private static String outputFilePath = "";

	private static String inputFilePath = "";

	/**
	 * 2D array to hold the elements.
	 */
	private String[][] grid;

	/**
	 * Reader to read input from file.
	 */
	private FileReaderWriter readerWriter;

	/**
	 * Solver to solve the puzzle.
	 */
	private SudokuSolver solver;

	/**
	 * Initializes the class by reading the input file.
	 * 
	 * @param inputFilePath
	 *            path of the inputFile.
	 * @param outputFilePath
	 *            path of the outputFile.
	 * @throws FileNotFoundException
	 *             Throws FileNotFoundException if the file cannot be located on
	 *             the location.
	 */
	public Sudoku(String inputFilePath, String outputFilePath) {
		setOutputFilePath(outputFilePath);
		setInputFilePath(inputFilePath);
		readerWriter = new SudokuReaderWriter();
		solver = new SudokuSolver();
	}

	/**
	 * Solves the sudoku puzzle.
	 */
	public void solvePuzzle() {
		try {
			File inputFile = new File(getInputFilePath());
			String[][] grid = readerWriter.readFile(inputFile);
			setGrid(grid);
			solver.solveGrid(grid);
			readerWriter.writeFile(grid, getOutputFilePath());
		} catch (SudokuFileException e) {
			String error = e.getMessage();
			Throwable cause = e.getCause();
			if (cause != null) {
				error += "\n" + e.getCause().getMessage();
			}
			readerWriter.writeExceptionFile(error, getOutputFilePath(), getInputFilePath());
			e.printStackTrace();
		}
	}

	/**
	 * Getter for the grid.
	 * 
	 * @return the grid
	 */
	public String[][] getGrid() {
		return grid;
	}

	/**
	 * Setter for the grid.
	 * 
	 * @param grid
	 *            the grid to set
	 */
	public void setGrid(String[][] grid) {
		this.grid = grid;
	}

	/**
	 * Getter for outputFilePath.
	 * 
	 * @return the outputFilePath
	 */
	public static String getOutputFilePath() {
		return outputFilePath;
	}

	/**
	 * Setter for outputFilePath.
	 * 
	 * @param outputFilePath
	 *            the outputFilePath to set
	 */
	public static void setOutputFilePath(String outputFilePath) {
		Sudoku.outputFilePath = outputFilePath;
	}

	/**
	 * Getter for inputFilePath.
	 * 
	 * @return the inputFilePath
	 */
	public static String getInputFilePath() {
		return inputFilePath;
	}

	/**
	 * Setter for inputFilePath.
	 * 
	 * @param inputFilePath
	 *            the inputFilePath to set
	 */
	public static void setInputFilePath(String inputFilePath) {
		Sudoku.inputFilePath = inputFilePath;
	}

}
