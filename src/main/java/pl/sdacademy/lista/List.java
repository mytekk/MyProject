package pl.sdacademy.lista;

import java.util.Iterator;

public class List<T> implements IList<T> {

	ListElement<T> pierwszyElement;
	ListElement<T> ostatniElement;

	// konstruktor
	public List() {
		pierwszyElement = null;
		ostatniElement = null;
	}

	@Override
	public T getFirst() {
		return pierwszyElement.getValue();
	}

	@Override
	public T getLast() {
		return ostatniElement.getValue();
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
				element = element.getNext(); // getNext zwraca kolejny element
												// list, kolejny obiekt klasy
												// ListElement
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
			return elementPobierany.getValue(); // getValue zwraca faktyczna
												// wartosc przechowywana w
												// wyszukanym wcześniej
												// obiekcie klasy ListElement
		}
	}

	// funkcja poocnicza dla wczesniejszej
	public ListElement<T> getElement(int index) {
		if (isEmpty()) {
			return null;
		} else {
			// poczawszy od pierwszego elementu listy przechodzę w petli while
			// tak daleko jak wskazuje przekazany argument index
			// za każdym razem pobierając do zmiennej pomocniczej kolejny
			// element listy (kolejny obiekt klasy ListElement)
			// W momencie kiedy zrównam się z zadanym indeksem, to zwracam w
			// całości bieżący element listy, ten do którego
			// w tym momencie doszedłem
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
		//funkcją pomocniczą pobieram element do usunięcia
		ListElement<T> elementDoUsuniecia = getElement(index);
		
		//pobieram obiekty sąsiednie, getPrevious i getNext zwracaja obiekty klasy ListElement
		ListElement<T> elementPrzed = elementDoUsuniecia.getPrevious();
		ListElement<T> elementPo = elementDoUsuniecia.getNext();
		
		
		if (elementPo == null) {
			//jesli usuwany element jest jednoczesnie ostatnim elementem listy
			//to jako ostatni element listy ustawiam przedostatni element
			//oraz ZaczepZTylu tego nowego ostatniego elementu ustawiam jako null
			ostatniElement = elementPrzed;
			elementPrzed.ZaczepZTylu = null;
		} else {
			//jesli usuwany element jest gdzies w srodku
			//to tył poprzedniego elementu (względem usuwanego) ma wskazwać na kolejny element po tym usuwanym
			//oraz
			//przód kolejnego elementu po tym usuwanym ma wskazywać na element poprzedni, przed tym usuwanym
			elementPrzed.ZaczepZTylu = elementPo;
			elementPo.ZaczepZPrzodu = elementPrzed;
		}
		//a co jeśli usuwam pierwszy element listy?
	}

	@Override
	public void add(T wartosc) {
		//z dodaanej wartości tworzę obiekt klasy ListElement
		ListElement<T> dodawanyElement = new ListElement<T>(wartosc);
		
		if (isEmpty()) {
			//jeśli dodawany aktualnie element jest pierwszym elementem w liście, to
			//jest on jednocześnie pierwszym o ostatnim elementem listy
			pierwszyElement = dodawanyElement;
			ostatniElement = pierwszyElement;
		} else {
			//jeśli juz byly jakies elementy w liscie, to nowy element wskakuje na koniec, czyli
			//tylny zaczep dotychczasowego ostatniego elementu ma obecnie wskazywać na ten nowy element
			//a przedni zaczep dodawanego wlasnie elementu ma teraz wskazywac na dotychczasowy ostatni element
			ostatniElement.ZaczepZTylu = dodawanyElement;
			dodawanyElement.ZaczepZPrzodu = ostatniElement;
			//na koncu dodawany element staje sie wartoscia pola ostatniElement listy, zamiast tego, ktory
			//dotychczas pełnił rolę ostatniego
			ostatniElement = dodawanyElement;
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}