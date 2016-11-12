package com.sudoku.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sudoku.components.Cell;
import com.sudoku.components.Grid;
import com.sudoku.constants.SudokuConstants;
import com.sudoku.exception.SudokuFileException;

public class SudokuReaderWriter implements FileReaderWriter {

	private String deLimiter;
	private String emptyCellValue;

	public SudokuReaderWriter(String fileDelimiter, String emptyCellValue) {
		deLimiter = fileDelimiter;
		this.emptyCellValue = emptyCellValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public Grid readFileToGrid(String filePath) throws SudokuFileException {

		File file = new File(filePath);
		/**
		 * Use 9x9 array to hold the sudoku board.
		 */
		Grid grid = new Grid(9, 9);

		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			int row = 0;
			while (scanner.hasNext()) {
				int column = 0;
				String line = scanner.nextLine();

				/**
				 * to read values separated by pipe delimiter.
				 */
				StringTokenizer st = new StringTokenizer(line, deLimiter);
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if (emptyCellValue.equals(token) || token.trim().matches(SudokuConstants.NUMBER_PATTERN)) {
						if (row < grid.getNumberOfRows() && column < grid.getNumberOfColumns()) {
							Cell cell = new Cell(token, emptyCellValue);
							grid.getGrid()[row][column] = cell;
							column++;
						}
					} else {
						throw new SudokuFileException("Pipe delimited file " + file.getAbsolutePath()
								+ " has invalid character " + token + " other than a 'number' or a 'period'");
					}
				}
				row++;
			}

		} catch (FileNotFoundException e) {
			throw new SudokuFileException("Error reading message from file '" + file.getAbsolutePath() + "'.", e);
		} finally {
			scanner.close();
		}

		return grid;

	}

	/**
	 * {@inheritDoc}
	 */
	public void writeFileFromGrid(Grid grid, String outputPath) {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < grid.getGrid().length; i++) {
			builder.append(deLimiter);
			for (int j = 0; j < grid.getGrid().length; j++) {
				builder.append(grid.getCellValue(i, j)).append(deLimiter);
			}
			builder.append(SudokuConstants.NEW_LINE);
		}

		String gridContent = builder.toString();
		if (gridContent.contains(emptyCellValue)) {
			builder.insert(0, "The grid is invalid and cannot be solved.\n");
			gridContent = builder.toString();
		}

		try {
			write(gridContent, outputPath, null);
		} catch (IOException e) {
			throw new SudokuFileException("Unable to write output to the file '" + outputPath + "'. \nERROR:", e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void writeExceptionFile(String message, String outputPath, String inputPath) {

		try {
			write(message, outputPath, inputPath);
		} catch (IOException e) {
			throw new SudokuFileException("Unable to write error message to file '" + outputPath + "'.", e);
		}
	}

	/**
	 * Writes the content to the file.
	 * 
	 * @param content
	 *            content to write.
	 * @param outputFile
	 *            the fully qualified output file name
	 * @throws IOException
	 *             if unable to write the file.
	 */
	private void write(String content, String outputPath, String inputPath) throws IOException {
		FileWriter fileWriter = null;
		try {
			File outputFile = new File(outputPath);
			outputFile.createNewFile();
			fileWriter = new FileWriter(outputFile);
			fileWriter.write(content);
		} catch (IOException e) {
			if (inputPath == null) {
				throw e;
			}
			String outputDir = new File(inputPath).getParentFile().getAbsolutePath();
			outputDir += "\\" + SudokuConstants.DEFAULT_OUTPUT_FILENAME;
			fileWriter = new FileWriter(outputDir);
			fileWriter.write(content);
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}
	}
}
