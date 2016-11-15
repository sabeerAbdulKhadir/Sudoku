package com.sudoku.test;

import java.io.FileNotFoundException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sudoku.Sudoku;

public class TestSudoku {

	public static void main(String[] args) throws FileNotFoundException {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Sudoku sudoku = (Sudoku) context.getBean("sudoku");
		sudoku.solvePuzzle();

	}

}
