package com.sudoku.fileio;

import com.sudoku.components.Grid;
import com.sudoku.exception.FileException;
import com.sudoku.exception.SudokuFileException;

/**
 * Supports read and write operations.
 * 
 * @author abdulksa
 *
 */
public interface FileReaderWriter {

	/**
	 * Reads the file and returns the content as a {@link Grid} .
	 * 
	 * @param file
	 *            the input file path.
	 * @return {@link Grid}.
	 * @throws FileException
	 *             if the file cannot be located on the given location.
	 */
	Grid readFileToGrid(String file) throws SudokuFileException;

	/**
	 * Writes the grid onto a file in the same location.
	 * 
	 * @param Grid
	 *            solved grid to write into file.
	 * @param outputPath
	 *            the fully qualified output file name.
	 */
	void writeFileFromGrid(Grid grid, String outputPath);

	/**
	 * Writes the exception occurred during the execution of the program into
	 * the output file.
	 * 
	 * @param message
	 *            error message.
	 * @param outputPath
	 *            the fully qualified output file name.
	 * @param inputPath
	 *            uses this path to find out the directory to place the output
	 *            file if there is any problem with the outputPath.
	 */
	void writeExceptionFile(String message, String outputPath, String inputPath);
}
