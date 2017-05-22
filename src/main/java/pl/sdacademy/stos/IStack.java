package pl.sdacademy.stos;

public interface IStack<T> {

	void push(T element);

	T pop();

	T peek();

	int size();

	boolean isEmpty();

}
