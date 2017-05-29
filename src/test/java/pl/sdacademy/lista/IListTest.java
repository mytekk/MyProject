package pl.sdacademy.lista;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IListTest {

	IList<Laptop> pustaListaLaptopow;
	IList<Laptop> niePustaListaLaptopow;
	Laptop laptopMarka;
	Laptop laptopAdama;
	boolean result;

	@Before
	public void setUp() {
		pustaListaLaptopow = new List<>();
		result = false;
		laptopMarka = new Laptop("Marek");
		laptopAdama = new Laptop("Adam");
		niePustaListaLaptopow = new List<>();
		niePustaListaLaptopow.add(laptopMarka);
		niePustaListaLaptopow.add(laptopAdama);
	}

	/**
	 * sprawdza czy do pustej listy mozna dodac element i czy ten dodany element
	 * znajduje sie pod indeksem zero i czy jest on taki sam jak ten co go
	 * dodawalismy
	 */
	@Test
	public void shouldAddElementIfListIsEmpty() {
		Laptop laptopMarka = new Laptop("Marek");
		pustaListaLaptopow.add(laptopMarka);
		Laptop pierwszyElementZListy;
		try {
			pierwszyElementZListy = pustaListaLaptopow.get(0);
			if (pierwszyElementZListy.equals(laptopMarka)) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(result);
	}

	/**
	 * sprawdza czy mozna pobrac pierwszy element z niepustej listy i czy ten
	 * pobrany element jest rowny temu, ktory zostal do tej listy wrzucony jako
	 * pierwszy
	 */
	@Test
	public void shouldGetFirstElementOfNonEmptyList() {
		if (niePustaListaLaptopow.getFirst().equals(laptopMarka)) {
			result = true;
		}
		assertTrue(result);
	}

	/**
	 * sprawdza czy mozna pobrac ostatni element z niepustej listy i czy ten
	 * pobrany element jest rowny temu, ktory zostal do tej listy faktycznie
	 * wrzucony jako ostatni
	 */
	@Test
	public void shouldGetLastElementOfNonEmptyList() {
		if (niePustaListaLaptopow.getLast().equals(laptopAdama)) {
			result = true;
		}
		assertTrue(result);
	}

	/**
	 * sprawdza czy funkcja isEmpty zwroci true dla pustej listy
	 */
	@Test
	public void shouldReturnNullIfThereAreNoElements() {
		if (pustaListaLaptopow.isEmpty()) {
			result = true;
		}
		assertTrue(result);
	}

	/**
	 * sprawdza czy element spod indeksu zero jest rowny elementowi, o ktorym
	 * wiemy ze został uprzednio wrzucony pod ten wlasnie indeks
	 */
	@Test
	public void shouldGetSpecificElementFromTheList() {
		try {
			assertTrue(laptopMarka.equals(niePustaListaLaptopow.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * sprawdza czy po wyrzuceniu elementu z listy, w jego miejscu faktycznie
	 * jest teraz null
	 */
	@Test
	public void shouldRemoveElementFromNonEmptyList() {
		niePustaListaLaptopow.remove(1);
		try {
			assertTrue(niePustaListaLaptopow.get(1) == null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * sprawdza, czy funkcja get rzuci wyjatkiem w przypadku, gdy nastapi proba
	 * pobrania jakiegos elementu z pustej listy
	 */
	@Test
	public void shouldThrowExceptionIfGetCalledOnEmptyList() {
		try {
			pustaListaLaptopow.get(0);
		} catch (Exception e) {
			result = true;
		}
		assertTrue(result);
	}

	/**
	 * sprawdza, czy funkcja remove rzuci wyjatkiem, gdy nastapi proba usuniecia
	 * jakiegos elementu z pustej listy
	 */
	@Test
	public void shouldThrowExceptionIfRemoveCalledOnEmptyList() {
		try {
			pustaListaLaptopow.remove(0);
		} catch (Exception e) {
			result = true;
		}
		assertTrue(result);
	}
}