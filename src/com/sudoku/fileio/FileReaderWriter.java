package com.sudoku.fileio;

import java.io.File;

import com.sudoku.exception.FileException;
import com.sudoku.exception.SudokuFileException;

/**
 * Supports read and write operations.
 * 
 * @author abdulksa
 *
 */
public interface FileReaderWriter {

	static final String NUMBER_PATTERN = "[1-9]";

	static final String NEW_LINE = "\n";

	static final String PIPE_DELIMITER = "|";

	static final String EXTENSION_TXT = ".txt";

	static final String DEFAULT_OUTPUT_FILENAME = "output.txt";

	/**
	 * Reads the file and returns the content as a 2D string array.
	 * 
	 * @param file
	 *            , input file.
	 * @return 2D character array.
	 * @throws FileException
	 *             if the file cannot be located on the given location.
	 */
	String[][] readFile(File file) throws SudokuFileException;

	/**
	 * Writes the content of the character array onto a file in the same
	 * location.
	 * 
	 * @param charArray
	 *            solved grid to write into file.
	 * @param outputPath
	 *            the fully qualified output file name.
	 */
	void writeFile(String[][] charArray, String outputPath);

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
