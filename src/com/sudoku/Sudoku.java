
package com.sudoku;

import java.util.Date;

import org.springframework.web.jsf.DelegatingPhaseListenerMulticaster;

import com.sudoku.components.Grid;
import com.sudoku.exception.SudokuFileException;
import com.sudoku.fileio.FileReaderWriter;
import com.sudoku.fileio.SudokuReaderWriter;
import com.sudoku.solver.GridPuzzleSolver;
import com.sudoku.solver.SudokuSolver;

public class Sudoku {

	private String outputFilePath = "";

	private String inputFilePath = "";

	private String emptyCellValue = "";

	private String delimiter = "";

	/**
	 * 2D representation to hold the elements.
	 */
	private Grid grid;

	/**
	 * Reader to read input from file.
	 */
	private FileReaderWriter readerWriter;

	/**
	 * Solver to solve the puzzle.
	 */
	private GridPuzzleSolver solver;

	/**
	 * Initializes the class by reading the input file.
	 * 
	 * @param inFilePath
	 *            path of the inputFile.
	 * @param outFilePath
	 *            path of the outputFile.
	 * @param delimiter
	 *            delimiter of the input file(which will be used in output file
	 *            as well).
	 * @param emptyCellValue
	 *            value used to represent empty cells in the input file.
	 * 
	 */
	public Sudoku(String inFilePath, String outFilePath, String delimiter, String emptyCellValue) {
		setInputFilePath(inFilePath);
		setOutputFilePath(outFilePath);
		setDelimiter(delimiter);
		setEmptyCellValue(emptyCellValue);
	}

	/**
	 * Solves the sudoku puzzle.
	 */
	public void solvePuzzle() {
		try {

			grid = getReaderWriter().readFileToGrid(inputFilePath);
			getSolver().solveGrid(grid);
			getReaderWriter().writeFileFromGrid(grid, getOutputFilePath());

		} catch (SudokuFileException e) {
			String errorMessage = getFormattedExceptionMessage(e);
			getReaderWriter().writeExceptionFile(errorMessage, getOutputFilePath(), getInputFilePath());
			e.printStackTrace();
		}
	}

	/**
	 * Creates a message from the exception and returns to the caller.
	 * 
	 * @return exception message.
	 */
	private String getFormattedExceptionMessage(SudokuFileException e) {
		String error = new Date() + ":  " + e.getMessage();
		Throwable cause = e.getCause();
		if (cause != null) {
			error += "Caused by: " + e.getCause().getMessage();
		}
		return error;
	}

	/**
	 * Getter for the grid.
	 * 
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * Setter for the grid.
	 * 
	 * @param grid
	 *            the grid to set
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	/**
	 * Getter for outputFilePath.
	 * 
	 * @return the outputFilePath
	 */
	public String getOutputFilePath() {
		return this.outputFilePath;
	}

	/**
	 * Setter for outputFilePath.
	 * 
	 * @param outputFilePath
	 *            the outputFilePath to set
	 */
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	/**
	 * Getter for inputFilePath.
	 * 
	 * @return the inputFilePath
	 */
	public String getInputFilePath() {
		return inputFilePath;
	}

	/**
	 * Setter for inputFilePath.
	 * 
	 * @param inputFilePath
	 *            the inputFilePath to set
	 */
	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}

	/**
	 * Getter for emptyCellValue.
	 * 
	 * @return the emptyCellValue
	 */
	public String getEmptyCellValue() {
		return emptyCellValue;
	}

	/**
	 * Setter for empty cell value.
	 * 
	 * @param emptyCellValue
	 *            the emptyCellValue to set
	 */
	public void setEmptyCellValue(String emptyCellValue) {
		this.emptyCellValue = emptyCellValue;
	}

	/**
	 * Getter for delimiter.
	 * 
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * Setter for delimiter.
	 * 
	 * @param delimiter
	 *            the delimiter to set
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Getter for FileReaderWriter. If null, instantiates
	 * {@linkplain SudokuReaderWriter} with the supplied delimiter and
	 * emptyCellValue.
	 * 
	 * @return the readerWriter
	 */
	public FileReaderWriter getReaderWriter() {
		if (readerWriter == null) {
			readerWriter = new SudokuReaderWriter(getDelimiter(), getEmptyCellValue());
		}
		return readerWriter;
	}

	/**
	 * Setter for {@linkplain FileReaderWriter}.
	 * 
	 * @param readerWriter
	 *            the readerWriter to set
	 */
	public void setReaderWriter(FileReaderWriter readerWriter) {
		this.readerWriter = readerWriter;
	}

	/**
	 * Getter for {@linkplain GridPuzzleSolver}. If null, instantiates a new
	 * instance of {@linkplain SudokuSolver}.
	 * 
	 * @return the solver
	 */
	public GridPuzzleSolver getSolver() {
		if (solver == null) {
			solver = new SudokuSolver();
		}
		return solver;
	}

	/**
	 * Setter for {@linkplain GridPuzzleSolver}.
	 * @param solver
	 *            the solver to set
	 */
	public void setSolver(GridPuzzleSolver solver) {
		this.solver = solver;
	}
}
