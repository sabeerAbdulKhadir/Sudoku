package com.sudoku;

public class Region {

	private Cell[][] region = new Cell[3][3];

	/**
	 * @return the region
	 */
	public Cell[][] getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(Cell[][] region) {
		this.region = region;
	}

}
