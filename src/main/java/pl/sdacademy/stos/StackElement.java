package pl.sdacademy.stos;

public class StackElement<T> {

	T element;
	StackElement<T> previous;

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public StackElement<T> getPrevious() {
		return previous;
	}

	public void setPrevious(StackElement<T> previous) {
		this.previous = previous;
	}

}