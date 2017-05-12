package pl.sdacademy.sort;

import java.util.Arrays;

public class SortAlgorithm implements ISortAlgorithm {

	public static void main(String[] args) {

		// tworze obiekt mojej klasy
		ISortAlgorithm sortAlgorithm = new SortAlgorithm();

		/*
		 * //POCZATEK TESTOWANIA METODY BUBLESORT int[] tableToSort = { 4, 2, 5,
		 * 1, 7 };
		 * 
		 * // wypisanie tablicy
		 * System.out.println(Arrays.toString(tableToSort));
		 * 
		 * System.out.println("===========");
		 * 
		 * sortAlgorithm.bubleSort(tableToSort, true);
		 * 
		 * // wypisanie posortowanej rosnaco
		 * System.out.println(Arrays.toString(tableToSort));
		 * 
		 * System.out.println("===========");
		 * 
		 * sortAlgorithm.bubleSort(tableToSort, false);
		 * 
		 * // wypisanie posortowanej malejaco
		 * System.out.println(Arrays.toString(tableToSort)); // KONIEC
		 * TESTOWANIA METODY BUBLESORT
		 */

		// POCZATEK TESTOWANIA METODY QUICKSORT
		int[] tableToSort = { 7, 2, 4, 7, 3, 1, 4, 6, 5, 8, 3, 9, 2, 6, 7, 6, 3 };

		sortAlgorithm.quickSort(tableToSort);

	}

	public SortAlgorithm() {
	}

	@Override
	public void bubleSort(int[] array, boolean ascending) {
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

	public void quickSort(int[] array) {
		// wypisanie tablicy wejsciowej
		System.out.println(Arrays.toString(array));

		int firstIndex = 0;
		int lastIndex = array.length - 1;
		int tmp = (firstIndex + lastIndex) / 2; // indeks srodkowego elementu
		int piwot = array[tmp]; // piwot to wartosc srodkowego elementu

		// piwot wymieniam z ostatnim elementem tablicy
		array[tmp] = array[lastIndex];
		array[lastIndex] = piwot;

		// wypisanie tablicy
		System.out.println(Arrays.toString(array));

		// dwa "wskazniki":
		// Wskaźnik i będzie przeglądał zbiór do przedostatniej pozycji.
		// Wskaźnik j zapamiętuje ostatnie miejsce wstawienia elementu
		// mniejszego od
		// piwotu
		int j = 0;
		for (int i = 0; i < lastIndex - 1; i++) {
			// jesli biezacy element tablicy jest mniejszy od piwotu
			// to wymień go z elementem na pozycji j-tej
			// po tej wymianie j przesun o jedna pozycje
			if (array[i] < piwot) {
				int tmpElement = array[i];
				array[i] = array[j];
				array[j] = tmpElement;

				j++;
			}
		}

		// po zakonczeniu petli piwot wymieniam z elementem na pozycji j-tej
		// (piwot to teraz ostatni element)
		array[lastIndex] = array[j];
		array[j] = piwot;

		// koniec podzialu na partycje
		// wypisanie tablicy
		System.out.println(Arrays.toString(array));
	}

}
