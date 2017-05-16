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

		System.out.println(Arrays.toString(tableToSort));
		System.out.println("===================================");

		int firstIndex = 0;
		int lastIndex = tableToSort.length - 1;
		
		sortAlgorithm.quickSort(tableToSort, firstIndex, lastIndex);

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

	
	/**
	 * Sortowanie szybkie
	 * na podstawie: http://eduinf.waw.pl/inf/alg/003_sort/0018.php
	 */
	public void quickSort(int[] array, int firstIndex, int lastIndex) {
		System.out.println("-------------------------");
		System.out.println("Wywołano funkcję z argumentami: firstIndex: " + firstIndex + ", lastIndex: " + lastIndex);
		
		System.out.println("Oto pod-tablica do posortowania:");
		for (int z = firstIndex; z <= lastIndex; z++) {
			System.out.print("array[" + z + "]: " + array[z] + ", ");
		}
		System.out.println();
		
		
		int tmp = (firstIndex + lastIndex) / 2; // indeks srodkowego
												// elementu
		int piwot = array[tmp]; // piwot to wartosc srodkowego elementu
		
		System.out.println("Index elementu środkowego: " + tmp);
		System.out.println("Piwot: " + piwot);

		// piwot wymieniam z ostatnim elementem tablicy
		array[tmp] = array[lastIndex];
		array[lastIndex] = piwot;

		int j = firstIndex;

		// dwa "wskazniki":
		// Wskaźnik i będzie przeglądał zbiór do przedostatniej pozycji.
		// Wskaźnik j zapamiętuje ostatnie miejsce wstawienia elementu
		// mniejszego od
		// piwotu
		System.out.println("Poczatek petli, petle robie do: " + lastIndex);
		for (int i = firstIndex; i <= lastIndex; i++) {
			// jesli biezacy element tablicy jest mniejszy od piwotu
			// to wymień go z elementem na pozycji j-tej
			// po tej wymianie j przesun o jedna pozycje
			if (array[i] < piwot) {
				System.out.println(
						"znaleziono element mniejszy od piwotu, iteracja petli: i = " + i + ", j = " + j + ", piwot: " + piwot + ", wartosc: " + array[i]);
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

		System.out.println("koncowa wartosc j: " + j);
		System.out.println("Sprawdzenie: array[j]: " + array[j] + ", array od piwot: " + piwot);

		// koniec podzialu na partycje, wypisanie zmodyfikowanej tablicy
		System.out.println("Wypisanie tablicy po podziale na partycje:");
		System.out.println(Arrays.toString(array));

		// wywolanie rekurencyjne dla utworzonych partycji
		if (firstIndex < j - 1) {
			System.out.println("Kolejne wywolanie typu PIERWSZEGO dla: firstIndex = " + firstIndex + ", j = " + j);
			this.quickSort(array, firstIndex, j - 1);
		}
		if (j + 1 < lastIndex) {
			System.out
					.println("Kolejne wywolanie typu DRUGIEGO dla: (j+1) = " + (j + 1) + ", lastIndex = " + (lastIndex));
			this.quickSort(array, j + 1, lastIndex);
		}
	}

}
