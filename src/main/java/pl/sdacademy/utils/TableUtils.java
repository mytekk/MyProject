package pl.sdacademy.utils;

import java.util.Random;
import java.util.stream.Stream;

import pl.sdacademy.interfaces.ITableUtils;

public class TableUtils implements ITableUtils {

	/**
	 * Zamiana elementów w tablicy</br>
	 * i i j to elementy od 0 do n, gdzie n to length tablicy
	 * 
	 * @param i
	 * @param j
	 */
	public void changeElement(Object[] table, int i, int j) {
		// TODO Proszę zrobić zamianę elementów w tablicy

		if (i >= table.length || j >= table.length) { // jesli poza zakresem to
														// won
			return;
		}

		Object tmp = table[i];

		table[i] = table[j];
		table[j] = tmp;

	}

	public void print(Object[] table) {
		// petla foreach
		for (Object element : table) {
			System.out.println(element);
		}
	}

	public void print(int[] table) {
		// petla foreach
		for (int element : table) {
			System.out.print(element + " ");
		}
	}

	public String print2(int[] table) {
		String result = "";
		// petla foreach
		for (int element : table) {
			result += element + ", ";
		}
		return result;
	}

	public int[] generateNumbers(int length, int from, int to) {
		if (from >= to) {
			throw new IllegalArgumentException("Exception: " + from + " >= " + to);
		}
		Random random = new Random();
		int[] table = new int[length];

		for (int i = 0; i < table.length; i++) {
			table[i] = random.nextInt(to - from) + from;
		}
		return table;

	}

	public void printStream(Object[] table) {
		int start = 0;
		int end = table.length;

		Stream.of(table).forEach(e -> System.out.print(e + ", "));
	}

}
