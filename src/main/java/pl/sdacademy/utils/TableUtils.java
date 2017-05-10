package pl.sdacademy.utils;

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

}
