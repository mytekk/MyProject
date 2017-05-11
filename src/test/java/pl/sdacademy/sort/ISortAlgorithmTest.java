package pl.sdacademy.sort;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ISortAlgorithmTest {

	// zmienne globalne klasy
	ISortAlgorithm sortAlgorithm = new SortAlgorithm();
	int[] tableToSort = { 1, 2, 4, 3 };
	int[] sortedAscending = { 1, 2, 3, 4 };
	int[] sortedDescending = { 4, 3, 2, 1 };

	@Test
	/**
	 * sprawdza, czy metoda sort sortuje rosnąco i czy robi to domyslnie rosnąco
	 */
	public void shouldSortArrayAscendingByDefault() {

		// given

		// when
		sortAlgorithm.sort(tableToSort); // celowo nie przesylam drugiego
											// argumentu

		// then
		boolean isAllElementEqual = isTableEqual(tableToSort, sortedAscending);

		assertTrue(isAllElementEqual);
	}

	/**
	 * porownuje dwie tablice i sprawda czy sa takie same
	 */
	private boolean isTableEqual(int[] tableToSort, int[] sortedTable) {
		boolean isAllElementEqual = true;
		int i = 0;
		while (i < tableToSort.length && isAllElementEqual) {
			isAllElementEqual = tableToSort[i] == sortedTable[i];
			i++;
			if (!isAllElementEqual) {
				break;
			}
		}
		return isAllElementEqual;
	}

	@Test
	/**
	 * sprawdza, czy metoda sort sortuje rosnąco kiedy chce zeby bylo rosnaca i
	 * malejaco kiedy chce zeby bylo malejaco
	 */
	public void shouldSortArrayDependingOnTheOrder() {

		// given

		// when
		sortAlgorithm.sort(tableToSort, true); // ascending
		sortAlgorithm.sort(tableToSort, false); // descending

		// then
		boolean isAscendingOK = isTableEqual(tableToSort, sortedAscending);
		boolean isDescendingOK = isTableEqual(tableToSort, sortedDescending);

		assertTrue(isAscendingOK && isDescendingOK);
	}

	/**
	 * Test sprawdzjacy, czy posortowana tablica pozostanie posortowana po
	 * uzyciu metody sortujacej
	 */
	public void shouldLeaveSortedArrayUnchanged() {
		// given
		int[] tmpTableToSort = { 1, 2, 3, 4 };

		// when
		sortAlgorithm.sort(tmpTableToSort); // przesylam posortowana juz tablice

		// then
		boolean isAllElementEqual = isTableEqual(tmpTableToSort, sortedAscending);

		assertTrue(isAllElementEqual);

	}

	/**
	 * Test sprawdzajacy zrzucenie wyjatku w przypadku tablicy będącej jednym
	 * wielkim nullem
	 */
	@Test
	public void shouldThrowExceptionIfArrayIsNull() {
		// given
		boolean isArrayNull = false;
		int[] notInitializedArray = null;

		// when
		try {
			sortAlgorithm.sort(notInitializedArray);
		} catch (Exception e) {
			// skoro tu wszedlem, to znaczy, ze metoda rzucila wyjatek (throw
			// exception)
			// bo dostala nulla zamiast tablicy -
			// takie rzucenie wyjatku to poprawne zachowanie
			// metody sort
			// skoro tu wszedlem to moge zmienic wartosc naszej flagi
			isArrayNull = true;
			// e.printStackTrace();
		}

		// then
		assertTrue(isArrayNull);
	}

	/**
	 * Test sprawdzajacy wykonania metody </br>
	 * bez zrzucania wyjatku w przypadku tablicy pustej sprawdzamy, czy metoda
	 * nie rzuca wyjatku jesli dodanie pusta tablice jesli dostanie taka tabele,
	 * to nie powinna rzucic wyjatku, tylko ładnie zadziałać
	 */
	@Test
	public void shouldNotThrowIfArrayIsZeroSize() {
		// given
		int[] emptyArray = {};
		boolean isThrowException = false; // czy rzucilo wyjatek?

		// when
		try {
			sortAlgorithm.sort(emptyArray);
		} catch (Exception e) {
			// jesli metoda wywalila blad, to zmien flage
			isThrowException = true;
		}

		// then
		assertTrue(!isThrowException); // bo porządane jest nie rzucenie
										// wyjątku!!!
		// albo:
		// assertFalse(isThrowException);

	}

	/**
	 * Test sprawdzajacy czy elementy tablicy sortuja się </br>
	 * w przypadku gdy elementy nie sa unikalne czyli</br>
	 * powtarzaja sie
	 */
	@Test
	public void shouldSortIfElementsAreNotUnique() {
		// given
		int[] notUniqueUnsortedTable = { 1, 3, 5, 7, 3, 1, 5 };
		int[] notUniqueSortedTable = { 1, 1, 3, 3, 5, 5, 7 };

		// when
		sortAlgorithm.sort(notUniqueUnsortedTable);

		// then
		boolean isAllElementEqual = isTableEqual(notUniqueUnsortedTable, notUniqueSortedTable);
		// jesli jest true, to znaczy, ze posortowalo taka tablice z
		// powtarzajacymi sie
		// elementami

		assertTrue(isAllElementEqual);
	}

}
