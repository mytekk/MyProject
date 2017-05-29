package pl.sdacademy.stos;

import java.lang.reflect.Array;

public class GenericStack<T> implements IGenericStack<T> {

	private int maksymalnyRozmiarStosu;
	private T[] tablicaStosu;
	private int wierzcholek;

	// konstruktor
	public GenericStack(int rozmiarStosu, Class<T> klasaElementowStosu) {
		this.maksymalnyRozmiarStosu = rozmiarStosu;

		// stworzenie tablicy elementow danej klasy
		tablicaStosu = (T[]) Array.newInstance(klasaElementowStosu, rozmiarStosu); // co
																					// to
																					// za
																					// funkcja?
		wierzcholek = -1;
	}

	/**
	 * wrzucenie elementu na stos
	 */
	@Override
	public void push(T element) {
		if (wierzcholek < maksymalnyRozmiarStosu - 1) {
			wierzcholek++;
			tablicaStosu[wierzcholek] = element;
		}
	}

	/**
	 * pobranie elementu ze stosu i usuniecie tego elementu
	 */
	@Override
	public T pop() {
		T pierwszyElement = tablicaStosu[wierzcholek];
		tablicaStosu[wierzcholek] = null;
		wierzcholek--;
		return pierwszyElement;
	}

	/**
	 * podglądnięcie tego co jest na wierzchołku stosu, bez usuwania go
	 */
	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		} else {
			return tablicaStosu[wierzcholek];
		}
	}

	/**
	 * aktualna ilosc elementow na stosie
	 */
	@Override
	public int size() {
		return wierzcholek + 1;
	}

	/**
	 * czy stos jest pusty? jest pusty, kiedy wierzcholek jest rowny -1
	 */
	@Override
	public boolean isEmpty() {
		return wierzcholek == -1;
	}

}