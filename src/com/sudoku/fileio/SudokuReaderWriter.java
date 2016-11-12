package com.sudoku.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sudoku.exception.SudokuFileException;

public class SudokuReaderWriter implements FileReaderWriter {

	/**
	 * {@inheritDoc}.
	 */
	public String[][] readFile(File file) {
		/**
		 * Use 9x9 array to hold the sudoku board.
		 */
		String[][] grid = new String[9][9];
		Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new SudokuFileException("Error reading message from file '" + file.getAbsolutePath() + "'.", e);
		}
		try {
			int row = 0;
			while (scanner.hasNext()) {
				int column = 0;
				String line = scanner.nextLine();

				/**
				 * to read values separated by pipe delimiter.
				 */
				StringTokenizer st = new StringTokenizer(line, PIPE_DELIMITER);
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if (token.trim().matches(NUMBER_PATTERN) || ".".equals(token.trim())) {
						if (row < 9 && column < 9) {
							grid[row][column] = token;
							column++;
						}
					} else {
						throw new SudokuFileException("Pipe delimited file " + file.getAbsolutePath()
								+ " has invalid character " + token + " other than a 'number' or a 'period'");
					}
				}
				row++;
			}
		} finally {
			scanner.close();
		}

		return grid;
	}

	/**
	 * {@inheritDoc}.
	 */
	public void writeFile(String[][] grid, String outputPath) {

		if (!outputPath.endsWith(EXTENSION_TXT)) {
			throw new SudokuFileException("Output file name is not a valid text file.");
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < grid.length; i++) {
			builder.append(PIPE_DELIMITER);
			for (int j = 0; j < grid.length; j++) {
				builder.append(grid[i][j]).append(PIPE_DELIMITER);
			}
			builder.append(NEW_LINE);
		}

		String gridContent = builder.toString();
		if (gridContent.contains(".")) {
			builder.insert(0, "The grid is invalid and cannot be solved.\n");
			gridContent = builder.toString();
		}

		try {
			write(gridContent, outputPath, null);
		} catch (IOException e) {
			throw new SudokuFileException("Unable to write output to the file '" + outputPath + "'. \nERROR:", e);
		}
	}

	@Override
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
			outputDir += "\\" + DEFAULT_OUTPUT_FILENAME;
			fileWriter = new FileWriter(outputDir);
			fileWriter.write(content);
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}
	}
}
