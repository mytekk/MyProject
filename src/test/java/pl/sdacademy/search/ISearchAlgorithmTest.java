package pl.sdacademy.search;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pl.sdacademy.utils.TableUtils;

public class ISearchAlgorithmTest {

	// zmienne globalne klasy
	ISearchAlgorithm mySearchAlgorithm;
	int[] arrayToSearch;
	int[] sortedArrayToSearch;
	int[] emptyArray;
	TableUtils myTableUtils;
	int invalidIndex;

	@Before
	public void setUp() {
		arrayToSearch = new int[] { 6, 1, 8, 4, 9, 9, 5, 8, 3 };
		sortedArrayToSearch = new int[] { 1, 23, 55, 66, 77, 88, 9012 };
		emptyArray = new int[0];
		myTableUtils = new TableUtils();
		mySearchAlgorithm = new SearchAlgorithm();
		invalidIndex = -1;
	}

	/**
	 * sprawdza, czy metoda znajduje element w jakiejs randomowej tablicy wiemy,
	 * ze element znajduje sie w tej tablicy
	 */
	@Test
	public void shouldFindElementInARandomArrayFirstVersion() {
		// given
		int valueToSearch = 4;
		int expectedResult = 3; // bo liczba 4 jest pod indeksem 3 w tablicy
								// arrayToSearch

		// when
		int receivedResult = mySearchAlgorithm.search(arrayToSearch, valueToSearch);

		// then
		boolean isOK = (receivedResult == expectedResult);

		assertTrue("Can't find element: " + valueToSearch + " in array: " + myTableUtils.print2(arrayToSearch), isOK);
	}

	// metoda pomocnicza
	private boolean shouldFindElementInArray(int valueToSearch, int expectedResult, int[] array) {
		// given

		// when
		int receicedResult = mySearchAlgorithm.search(array, valueToSearch);

		// then
		boolean result = (receicedResult == expectedResult);

		return result;
	}

	/**
	 * sprawdza, czy metoda znajduje element w jakiejs randomowej tablicy wiemy,
	 * ze element znajduje sie w tej tablicy
	 */
	@Test
	public void shouldFindElementInARandomArray() {
		// given
		int valueToSearch = 4;
		int expectedResult = 3;

		// when
		boolean result = shouldFindElementInArray(valueToSearch, expectedResult, arrayToSearch);

		// then
		assertTrue("Can't find element = " + valueToSearch + " in array: " + myTableUtils.print2(arrayToSearch),
				result);
	}

	/**
	 * sprawdza, czy metoda znajduje element w posortowanej tablicy wiemy, ze
	 * element znajduje sie w tej tablicy
	 */
	@Test
	public void shouldFindElementInSortedArray() {
		// given
		int valueToSearch = 23;
		int expectedResult = 1;

		// when
		boolean result = shouldFindElementInArray(valueToSearch, expectedResult, sortedArrayToSearch);

		// then
		assertTrue("Can't find element = " + valueToSearch + " in array: " + myTableUtils.print2(sortedArrayToSearch),
				result);
	}

	/**
	 * sprawdza, czy funkcja zwroci jakis przykladowy nieprawidlowy
	 * (nieistniejacy) indeks, jesli nie odnaleziono elementu w tablicy
	 */
	@Test
	public void shouldReturnInvalidIndexIfElementNotPresent() {
		// given
		int valueToSearch = 31;

		// when
		int searchResult = mySearchAlgorithm.search(arrayToSearch, valueToSearch);

		// then
		// jesli nie znajde elementu, to nasza przyszla funkcja
		// zwroci wartosc -1
		// wiec jesli zwrocila cos mniejszego od zera,to znaczy
		// test sie powiodl: elementu w tablicy nie bylo,
		// wiec funkcja zwrocila taka wartosc, ktora nie
		// jest zadnym poprawnym indeksem talicy
		assertTrue(searchResult < 0);

	}

	/**
	 * sprawdza, czy funkcja zwroci jakis przykladowy nieprawidlowy
	 * (nieistniejacy) indeks, jesli wejsciowa tablica ma dlugosc zero
	 */
	@Test
	public void shouldReturnInvalidIndexIfArrayLenghtIsZero() {
		// given
		int valueToSearch = 2;

		// when
		int receivedResult = mySearchAlgorithm.search(emptyArray, valueToSearch);

		// then
		assertTrue("Array is empty", receivedResult < 0);
	}

	/**
	 * sprawdza, czy funkcja rzuci wyjatek jesli dostanie nullową tablicę jesli
	 * rzuci taki wyjatekdla nullowej tablicy to test konczy sie sukcesem a
	 * zatem: tablica na wejsciu jest null, my sprawdzamy, czy był throw wyjątku
	 */
	@Test
	public void shouldThrowIfArrayIsNull() {
		// given
		boolean hasThrow = false;
		int[] nullArray = null;

		// when
		try {
			mySearchAlgorithm.search(nullArray, 31);
		} catch (Exception e) {
			// skoro tu wszedlem, to znaczy, ze metoda rzucila wyjatek
			// to chcielismy, wiec zmianiamwartosc flagi
			hasThrow = true;
		}

		// then
		assertTrue("Method didn't thrown exception when array was null.", hasThrow);
	}

}
