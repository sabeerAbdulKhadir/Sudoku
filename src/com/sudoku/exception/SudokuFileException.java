package com.sudoku.exception;

/**
 * Exception class to handle the error scenarios during the SudokuFile
 * operations.
 *
 */
public class SudokuFileException extends FileException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Sudoku Wrapper to {@link RuntimeException} (String message)
	 * 
	 * @param message
	 *            error message
	 */
	public SudokuFileException(String message) {
		super(message);
	}

	/**
	 * Sudoku wrapper to {@link RuntimeException} (String message, Throwable e).
	 * 
	 * @param message
	 *            error message
	 * @param e
	 *            exception
	 */
	public SudokuFileException(String message, Throwable e) {
		super(message, e);
	}

}
