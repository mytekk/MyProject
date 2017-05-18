package pl.sdacademy.searchGeneric;

import java.util.function.Predicate;

public class GenericSearchAlgorithm<T> implements IGenericSearchAlgorithm<T> {

	public static void main(String[] args) throws Exception {

		// nowy obiekt klasy, zamiast T daję Integer
		IGenericSearchAlgorithm<Integer> myGenericSearchAlgorithm = new GenericSearchAlgorithm<Integer>();
		Integer[] arrayToSearch = new Integer[] { 6, 1, 8, 4, 9, 9, 5, 8, 3 };
		int valueToSearch = 4;

		int result = myGenericSearchAlgorithm.search(arrayToSearch, n -> n == valueToSearch);
		// powyżej w drugim argumencie podaję predykat (a dokładniej:
		// implementację
		// metody "test" interfejsu, który jest predykatem): predykat sprawdza,
		// czy
		// jakaś wartość n jest równa zadanej wartości valueToSearch
		// w tej implementacji pierwsze n to argument metody, a to co jest na
		// prawo: jej ciało

		System.out.println("Pozycja na której znaleziono element " + valueToSearch + " to: " + result);
	}

	@Override
	public <T extends Comparable> int search(T[] array, Predicate<T> predicate) throws Exception {
		int i = 0;
		int valueToReturn = -1;

		if (array == null) {
			throw new Exception("Array is null!");
		} else if (array.length == 0) {
			return -1;
		} else {
			while (i < array.length && valueToReturn == -1) {
				// tutaj wykonuję predykat. Jeśli zwróci true, to znaczy, że
				// bieżąca wartość tablicy spełnia warunek predykatu.
				// to, jaki to warunek widoczne jest w metodzie main, przy
				// wywołaniu
				// metody search

				boolean condition = predicate.test(array[i]);

				if (condition) {
					valueToReturn = i;
				}
				i++;
			}
		}
		return valueToReturn;
	}

}
