package com.sudoku;

public class Cell {

	private String value;

	public Cell(String value, Point point) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
