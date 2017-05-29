package pl.sdacademy.lista;

public interface IList<T> extends Iterable<T> {

	T getFirst();

	T getLast();

	T get(int index) throws Exception;

	void add(T element);

	void remove(int index);

	int size();

	boolean isEmpty();

}