package pl.sdacademy.searchGeneric;

import java.util.function.Predicate;

public interface IGenericSearchAlgorithm<T> {

	<T extends Comparable> int search(T[] array, Predicate<T> predicate);
	// T - ogólnym typ danych (klasa) spałniająca warunek porównywalności
	// <T extends Comparable> - ale musi być taka, żeby była porównywalna, czyli
	// musi rozszerzać interfejs Comparable, który zawiera metodę compareTo.

}
