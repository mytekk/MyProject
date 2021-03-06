package pl.sdacademy.stos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IStackTest {

	int maxElement; // dlugosc stosu
	IGenericStack<Laptop> stosLaptopow; // jakis niepelen stos laptopow
	IGenericStack<Laptop> pelenStosLaptopow; // zakladamy, ze pelen stos jest
	// faktycznie pelen i ze ma rozmiar
	// maxElement
	IGenericStack<Laptop> pustyStosLaptopow; // zakladamy, ze pusty stos jest
	// faktycznie pusty
	boolean result;

	@Before
	public void setUp() throws Exception {

		maxElement = 3;
		result = false;

		stosLaptopow = new GenericStack<Laptop>(maxElement, Laptop.class);
		//powyzej moja propozycja rozwiazania warningu z definicji
		//zmiennych pelenStosLaptopow i pustyStosLaptopow
		
		Laptop nowyLaptop = new Laptop("Ania");
		stosLaptopow.push(nowyLaptop);

		pelenStosLaptopow = new GenericStack(maxElement, Laptop.class);
		pelenStosLaptopow.push(new Laptop("Jerzy"));
		pelenStosLaptopow.push(new Laptop("Jose"));
		pelenStosLaptopow.push(new Laptop("Brajan"));

		pustyStosLaptopow = new GenericStack(maxElement, Laptop.class);
	}

	/**
	 * sprawdza czy jest mozliwosc dodania elementu do pustego stosu
	 */
	@Test
	public void shouldPushElementToEmptyStack() {
		// given
		Laptop laptopJana = new Laptop("Jan"); // element do dodania

		// when
		if (pustyStosLaptopow.isEmpty()) { // probuj wrzucic kiedy stos jest
											// pusty
			pustyStosLaptopow.push(laptopJana); // wrzucam element na stos
			Laptop laptopPierwszyZGory = pustyStosLaptopow.peek();
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
		// nie mozna porownac nulla do czegos, mozna jedynie cos do nulla
		if (pierwszyLaptopZGory.equals(kolejnyLaptopZGory)) {
			result = false;
		} else {
			result = true; // spodziewam sie, ze beda rozne - wtedy test
							// zakonczy sie powodzeniem
		}

		// stara wersja powyzszego if-a
		/*
		 * if (!pierwszyLaptopZGory.equals(kolejnyLaptopZGory)) { result = true;
		 * // spodziewam sie, ze beda rozne - wtedy test // zakonczy sie
		 * powodzeniem }
		 */

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

	/**
	 * sprawdza czy isEmpty zwraca true jesli nie ma nic wrzuconego na pusty
	 * stos
	 */
	@Test
	public void shouldReturnTrueIfThereWereNoValuesPutOnStack() {
		assertTrue(pustyStosLaptopow.isEmpty());
	}

	/**
	 * sprawdza czy isEmpty zwroci false jesli na pusty stos zostalo cos
	 * wrzucone
	 */
	@Test
	public void shouldReturnFalseIfPushWasCalledPreviously() {
		pustyStosLaptopow.push(new Laptop("Madzia"));
		assertFalse(pustyStosLaptopow.isEmpty());
	}

	/**
	 * sprawdza czy isEmpty zwroci true jesli na pusty stos wrzucilismy i
	 * sciagnelismy jakis element
	 */
	@Test
	public void shouldReturnTrueIfElementWasPushedAndPoped() {
		pustyStosLaptopow.push(new Laptop("Jula"));
		pustyStosLaptopow.pop();
		assertTrue(pustyStosLaptopow.isEmpty());
	}

}
