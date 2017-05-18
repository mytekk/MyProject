package pl.sdacademy.searchGeneric;

import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import pl.sdacademy.utils.TableUtils;

public class IGenericSearchAlgorithmTest {

	// zmienne globalne klasy
	IGenericSearchAlgorithm<Integer> myGenericSearchAlgorithm;
	Integer[] arrayToSearch;
	Integer[] sortedArrayToSearch;
	Integer[] emptyArray;
	TableUtils myTableUtils;
	int invalidIndex;

	@Before
	public void setUp() {
		arrayToSearch = new Integer[] { 6, 1, 8, 4, 9, 9, 5, 8, 3 };
		sortedArrayToSearch = new Integer[] { 1, 23, 55, 66, 77, 88, 9012 };
		emptyArray = new Integer[0];
		myTableUtils = new TableUtils();
		myGenericSearchAlgorithm = new GenericSearchAlgorithm<Integer>();
		invalidIndex = -1;
	}

	// metoda pomocnicza
	private boolean shouldFindElementInArray(int valueToSearch, int expectedResult, Integer[] array) throws Exception {
		// given

		// when
		Predicate<Integer> condition = p -> p == valueToSearch;
		int receicedResult = myGenericSearchAlgorithm.search(array, condition);

		// then
		boolean result = (receicedResult == expectedResult);

		return result;
	}

	/**
	 * sprawdza, czy metoda znajduje element w jakiejs randomowej tablicy wiemy,
	 * ze element znajduje sie w tej tablicy
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldFindElementInARandomArray() throws Exception {
		// given
		int valueToSearch = 4;
		int expectedResult = 3;

		// when
		boolean result = shouldFindElementInArray(valueToSearch, expectedResult, arrayToSearch);

		// then
		assertTrue("Can't find element = " + valueToSearch + " in array: " + myTableUtils.print3(arrayToSearch),
				result);
	}

	/**
	 * sprawdza, czy metoda znajduje element w posortowanej tablicy wiemy, ze
	 * element znajduje sie w tej tablicy
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldFindElementInSortedArray() throws Exception {
		// given
		int valueToSearch = 23;
		int expectedResult = 1;

		// when
		boolean result = shouldFindElementInArray(valueToSearch, expectedResult, sortedArrayToSearch);

		// then
		assertTrue("Can't find element = " + valueToSearch + " in array: " + myTableUtils.print3(sortedArrayToSearch),
				result);
	}

	/**
	 * sprawdza, czy funkcja zwroci jakis przykladowy nieprawidlowy
	 * (nieistniejacy) indeks, jesli nie odnaleziono elementu w tablicy
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldReturnInvalidIndexIfElementNotPresent() throws Exception {
		// given
		int valueToSearch = 31;

		// when
		int searchResult = myGenericSearchAlgorithm.search(arrayToSearch, p -> p == valueToSearch); // drugi
																									// argument
																									// musi
																									// byc
																									// predykatem

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
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldReturnInvalidIndexIfArrayLenghtIsZero() throws Exception {
		// given
		int valueToSearch = 2;

		// when
		int receivedResult = myGenericSearchAlgorithm.search(emptyArray, p -> p == valueToSearch); // drugi
																									// argument
																									// musi
																									// byc
																									// predykatem

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
		Integer[] nullArray = null;

		// when
		try {
			myGenericSearchAlgorithm.search(nullArray, p -> p == 31); // drugi
																		// argument
																		// musi
																		// byc
																		// predykatem
		} catch (Exception e) {
			// skoro tu wszedlem, to znaczy, ze metoda rzucila wyjatek
			// to chcielismy, wiec zmianiamwartosc flagi
			hasThrow = true;
		}

		// then
		assertTrue("Method didn't thrown exception when array was null.", hasThrow);
	}

}
