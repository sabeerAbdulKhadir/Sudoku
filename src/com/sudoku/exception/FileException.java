package com.sudoku.exception;

public class FileException extends RuntimeException {

	private static final long serialVersionUID = -5842693570402850204L;

	/**
	 * Wrapper to {@link RuntimeException} (String message)
	 * 
	 * @param message
	 *            error message
	 */
	public FileException(String message) {
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
	public FileException(String message, Throwable e) {
		super(message, e);
	}
}
