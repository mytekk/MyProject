package pl.sdacademy.lista;

import java.util.Iterator;

public class List<T> implements IList<T> {

	ListElement<T> pierwszyElement;
	ListElement<T> ostatniElement;

	@Override
	public T getFirst() {
		return pierwszyElement.getValue();
	}

	@Override
	public T getLast() {
		return ostatniElement.getValue();
	}

	public List() {
		pierwszyElement = null;
		ostatniElement = null;
	}

	@Override
	public boolean isEmpty() {
		return pierwszyElement == null;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			int size = 0;
			ListElement<T> element = pierwszyElement;
			while (element != null) {
				element = element.getNext();
				size++;
			}
			return size;
		}
	}

	@Override
	public T get(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception();
		}
		ListElement<T> elementPobierany = getElement(index);
		if (elementPobierany == null) {
			return null;
		} else {
			return elementPobierany.getValue();
		}
	}

	public ListElement<T> getElement(int index) {
		if (isEmpty()) {
			return null;
		} else {
			int counter = 0;
			ListElement<T> element = pierwszyElement;
			while (counter != index) {
				element = element.getNext();
				counter++;
			}
			return element;
		}
	}

	@Override
	public void remove(int index) {
		ListElement<T> elementDoUsuniecia = getElement(index);
		ListElement<T> elementPrzed = elementDoUsuniecia.getPrevious();
		ListElement<T> elementPo = elementDoUsuniecia.getNext();
		if (elementPo == null) {
			ostatniElement = elementPrzed;
			elementPrzed.ZaczepZTylu = null;
		} else {
			elementPrzed.ZaczepZTylu = elementPo;
			elementPo.ZaczepZPrzodu = elementPrzed;
		}
	}

	@Override
	public void add(T wartosc) {
		ListElement<T> dodawanyElement = new ListElement<T>(wartosc);
		if (isEmpty()) {
			pierwszyElement = dodawanyElement;
			ostatniElement = pierwszyElement;
		} else {
			ostatniElement.ZaczepZTylu = dodawanyElement;
			dodawanyElement.ZaczepZPrzodu = ostatniElement;
			ostatniElement = dodawanyElement;
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}