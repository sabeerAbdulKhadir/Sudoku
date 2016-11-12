package com.sudoku.components;

public class Cell {

	private String emptyValue;

	private String value;

	public Cell(String value, String emptyValue) {
		this.value = value;
		this.emptyValue = emptyValue;

	}

	/**
	 * Getter for value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Setter for value.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the emptyValue
	 */
	public String getEmptyValue() {
		return emptyValue;
	}

	public boolean isEmpty() {

		return value == null || value.equals(getEmptyValue());
	}

}
