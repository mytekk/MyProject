package pl.sdacademy.lista;

public class ListElement<T> {
	
	T value;
	ListElement<T> ZaczepZTylu; //pole klasy jest jednoczesnie obiektem tej samej klasy?
	ListElement<T> ZaczepZPrzodu;
	
	//konstruktor
	public ListElement(T value) {
		super();
		this.value = value;
	}

	//getter do pola value
	public T getValue() {
		return value;
	}

	//setter do pola value
	public void setValue(T value) {
		this.value = value;
	}

	//metoda dodatkowa
	public ListElement<T> getNext() {
		return ZaczepZTylu;
	}

	//metoda dodatkowa
	public void setNext(ListElement<T> next) {
		this.ZaczepZTylu = next;
	}

	//metoda dodatkowa
	public ListElement<T> getPrevious() {
		return ZaczepZPrzodu;
	}

	//metoda dodatkowa
	public void setPrevious(ListElement<T> previous) {
		this.ZaczepZPrzodu = previous;
	}

}