package com.sudoku;

public class Cell {

	private Point point;

	private String value;

	public Cell(String value, Point point) {
		this.value = value;
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;

	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
