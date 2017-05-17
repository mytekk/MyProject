package pl.sdacademy.searchGeneric;

import java.util.function.Predicate;

public class NaiveGenericSearchAlgorithm<T> implements IGenericSearchAlgorithm<T> {

	@Override
	public <T extends Comparable> int search(T[] array, Predicate<T> predicate) {
		// not implemented - specjalnie
		return -1;
	}

}
