package pl.sdacademy.sort;

import java.util.Arrays;

public class SortAlgorithm implements ISortAlgorithm {

	public static void main(String[] args) {
		int[] tableToSort = { 4, 2, 5, 1, 7 };

		// wypisanie tablicy
		System.out.println(Arrays.toString(tableToSort));

		System.out.println("===========");

		// tworze obiekt mojej klasy
		ISortAlgorithm sortAlgorithm = new SortAlgorithm();
		sortAlgorithm.sort(tableToSort, true);

		// wypisanie posortowanej rosnaco
		System.out.println(Arrays.toString(tableToSort));

		System.out.println("===========");

		sortAlgorithm.sort(tableToSort, false);

		// wypisanie posortowanej malejaco
		System.out.println(Arrays.toString(tableToSort));

	}

	public SortAlgorithm() {
	}

	@Override
	public void sort(int[] array, boolean ascending) {
		int n = array.length;
		boolean isSwapped = false;

		while (n > 1 || isSwapped) {
			isSwapped = false; // jesli w forze nie zrobie zadnego przestawienia
			// to znaczy ze tablica jest posortowana - mozna opuscic petle while
			for (int i = 0; i < n - 1; i++) {
				if (ascending) {
					if (array[i] > array[i + 1]) {
						swap(array, i);
						isSwapped = true;
					}
				} else if (!ascending) {
					if (array[i] < array[i + 1]) {
						swap(array, i);
						isSwapped = true;
					}
				}
			}
			System.out.println(Arrays.toString(array));
			n--;
		}
	}

	/**
	 * dla tablicy array zamienia miejscami element i-ty z i+1 elementem
	 */
	private void swap(int[] array, int i) {
		int tmp = array[i];
		array[i] = array[i + 1];
		array[i + 1] = tmp;
	}

}
