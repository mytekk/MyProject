package pl.sdacademy.main;

import pl.sdacademy.interfaces.IAction;
import pl.sdacademy.model.Bike;
import pl.sdacademy.model.Car;
import pl.sdacademy.model.Cat;
import pl.sdacademy.model.Dog;
import pl.sdacademy.model.OpelCar;
import pl.sdacademy.model.RenaultCar;
import pl.sdacademy.utils.TableUtils;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		System.out.println("Hello!:)");

		Bike marcinsRomet = new Bike();
		Car adamsOpel = new OpelCar();
		Car maciejsRenault = new RenaultCar();

		// tablica obiektow typu Car
		Car[] carTable = new Car[2];
		carTable[0] = adamsOpel;
		carTable[1] = maciejsRenault;
		/*
		 * maciejsRenault.refuel(); adamsOpel.refuel();
		 * 
		 * maciejsRenault.run(); marcinsRomet.run();
		 */
		for (int i = 0; i < carTable.length; i++) {
			System.out.println(carTable[i].getInfo());
		}

		// tablica obiektow implementujacych interfejs IAction
		IAction[] iActionTable = new IAction[3];
		iActionTable[0] = marcinsRomet;
		iActionTable[1] = adamsOpel;
		iActionTable[2] = maciejsRenault;

		for (int i = 0; i < iActionTable.length; i++) {
			iActionTable[i].run();
		}

		voiceFromAnimals();

		// tworze obiekt klasy, w ktorej mam funkcje dotyczace tablic
		TableUtils tableUtils = new TableUtils();

		// wypisz
		tableUtils.print(iActionTable);

		// zamiana
		System.out.println("--------");
		tableUtils.changeElement(iActionTable, 0, 1);

		// wypisz
		tableUtils.print(iActionTable);

	}

	/**
	 * Metoda, która wykonuje metode voice. Jest to przyklad bez interfejsu
	 */
	private static void voiceFromAnimals() {
		// tablica typów Object - bo Dog i Cat nie sa "polaczone" ze soba zadnym
		// interfejsem
		Object[] animalsTable = new Object[2];
		Dog dog = new Dog();
		Cat cat = new Cat();
		animalsTable[0] = dog;
		animalsTable[1] = cat;

		for (int i = 0; i < animalsTable.length; i++) {
			// animalsTable[i].voice(); // to sie nie uda, bo animalsTable[i]
			// jest
			// klasy Object, a nie cat lub dog, a klasa object nie ma
			// metodyObject

			// tworze wiec z i-tego elementu tablicy obiekt typu Object
			Object animal = animalsTable[i];

			// i teraz w naszej pętli wiem, że pierwszy jest typu Dog, a drugi
			// Cat
			if (i == 0) { // pierwszy jest typu Dog
				Dog animal1 = (Dog) animal; // rzutuję obiekt typu Object na typ
											// Dog
				animal1.voice(); // i teraz moge wykonac metode voice
			} else if (i == 1) { // pierwszy jest typu Cat
				Cat animal2 = (Cat) animal;
				animal2.voice();
			}
		}
	}

}
