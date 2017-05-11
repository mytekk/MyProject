package pl.sdacademy.main;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.sdacademy.model.Cat;

public class TestCat {

	@Test
	/**
	 * ten test spraqwdza czy nasz getter, setter i konstruktor dziala
	 * poporawnie
	 */
	public void myFirstTest() {
		// given
		Cat cat = new Cat("Filemon");

		// when
		String name = cat.getName();

		// then
		assertTrue(name.equals("Filemon"));
	}

	@Test
	public void mySecondTest() {
		// given
		Cat cat = new Cat("Filemon");

		// when
		String name = cat.getName();

		// then
		assertTrue(name.equals("Mruczek"));
	}

}
