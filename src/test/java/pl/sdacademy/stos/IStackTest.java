package pl.sdacademy.stos;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IStackTest {

	int maxElement; // dlugosc stosu
	IStack<Laptop> stosLaptopow;
	IStack<Laptop> pelenStosLaptopow; // zakladamy, ze pelen stos jest
										// faktycznie pelen i ze ma rozmiar
										// maxElement
	IStack<Laptop> pustyStosLaptopow; // zakladamy, ze pusty stos jest
										// faktycznie pusty
	boolean result;

	@Before
	public void setUp() throws Exception {

		maxElement = 3;
		result = false;
	}

	/**
	 * sprawdza czy jest mozliwosc dodania elementu do pustego stosu
	 */
	@Test
	public void shouldPushElementToEmptyStack() {
		// given
		Laptop laptopJana = new Laptop("Jan"); // element do dodania

		// when
		if (stosLaptopow.isEmpty()) { // probuj wrzucic kiedy stos jest pusty
			stosLaptopow.push(laptopJana); // wrzucam element na stos
			Laptop laptopPierwszyZGory = stosLaptopow.peek();
			result = laptopJana.equals(laptopPierwszyZGory); // porównanie
																// referencji o
																// nazwie tem
			// z
			// referencja o nazwie vehicle
			// spodziewamy sie, ze obydwie
			// referencje wskazuja na ten sam
			// obiekt
			// czyli ze sa takie same
		}

		// then
		assertTrue(result);

	}

	/**
	 * sprawdza czy mozna dodacelement do zapelnionego stosu spodziewamy sie, ze
	 * sie nei uda zakladamy, ze stops jest zapelniony
	 */
	@Test
	public void shouldNotPushElementToFillStack() {
		// given
		Laptop laptopAni = new Laptop("Ania");

		// when
		pelenStosLaptopow.push(laptopAni); // dodajemy elementdo pelnego stosu
											// spodziewamy sie, ze sie nie uda

		// then
		if (!laptopAni.equals(pelenStosLaptopow.peek())) {
			result = true; // jesli nie sa rozne, to test zadzialal, zwracamy
							// true
		}
		assertTrue(result);
	}

	/**
	 * czy usuwa wartosc po zdjeciu jej ze stosu
	 */
	@Test
	public void shouldDeleteValueAfterPoping() {
		// given
		Laptop pierwszyLaptopZGory = stosLaptopow.peek();

		// when
		stosLaptopow.pop();
		Laptop kolejnyLaptopZGory = stosLaptopow.peek();

		// then
		if (!pierwszyLaptopZGory.equals(kolejnyLaptopZGory)) {
			result = true; // spodziewam sie, ze beda rozne - wtedy test
							// zakonczy sie powodzeniem
		}
		assertTrue(result);
	}

	/**
	 * sprawdza czy peek nie usuwa wartosci z gory stosu spodziewamy sie, ze nei
	 * usunie
	 */
	@Test
	public void shouldReceiveValueWhenPeekingButNotDeleteIt() {
		// given
		Laptop pierwszeSpojrzenie = stosLaptopow.peek();

		// when
		Laptop drugieSpojrzenie = stosLaptopow.peek();

		// then
		if (pierwszeSpojrzenie.equals(drugieSpojrzenie)) {
			result = true;
		}
		assertTrue(result);
	}

	/**
	 * sprawdza czy rozmiar pustego stosu jest rowny zero
	 * 
	 */
	@Test
	public void shouldReturnZeroAsSizeOfEmptyStack() {
		// given, when, then
		if (pustyStosLaptopow.size() == 0) {
			result = true;
		}

		assertTrue(result);
		// lub
		// assertTrue(pustyStosLaptopow.size() == 0);
	}

	/**
	 * sprawdza czy poprawnie zwraca rozmiar calkowiecie wypelnionego stosu
	 * 
	 */
	@Test
	public void shouldReturnCorrectSizeForFilledStack() {
		// given
		assertTrue(pelenStosLaptopow.size() == maxElement);
	}

}
