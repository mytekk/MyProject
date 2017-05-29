package pl.sdacademy.main;

import pl.sdacademy.interfaces.IAction;
import pl.sdacademy.model.Bike;
import pl.sdacademy.model.Car;
import pl.sdacademy.model.Cat;
import pl.sdacademy.model.Dog;
import pl.sdacademy.model.OpelCar;
import pl.sdacademy.model.RenaultCar;
import pl.sdacademy.utils.TableUtils;

import java.util.ArrayList;
import java.util.List;
import pl.sdacademy.lista.Laptop;
//import pl.sdacademy.lista.List;

public class Main {

	public Main() {
	}

	public static void main(String[] args) throws Exception {
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

		System.out.println("=============");

		// wypelniamy tablice wartosciami
		int[] intArray = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		tableUtils.print(intArray);

		// co druga liczbe zwiekszamy o wartosc jej poprzednika
		for (int i = 0; i < intArray.length; i++) {
			if (i > 0 && i % 2 == 0) {
				intArray[i] += intArray[i - 1];
			}
		}

		System.out.println();
		tableUtils.print(intArray);

		// kazda parzysta dzielimy przez 2
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] % 2 == 0) {
				intArray[i] /= 2;
			}
		}

		System.out.println();
		tableUtils.print(intArray);

		// suma wszystkich elementow
		int sum = 0;
		for (int element : intArray) {
			sum += element;
		}
		System.out.println("\nSuma elementow: " + sum);

		/*
		 * System.out.println(
		 * "============= to samo ale na tablicy typu Object!");
		 * 
		 * // wypelniamy tablice wartosciami int n = 10; Object[] objectArray =
		 * new Object[n]; for (int k = 0; k < n; k++) { objectArray[k] = k + 1;
		 * } tableUtils.print(objectArray);
		 * 
		 * // co druga liczbe zwiekszamy o wartosc jej poprzednika for (int i =
		 * 0; i < objectArray.length; i++) { if (i > 0 && i % 2 == 0) { int
		 * value = Integer.parseInt(objectArray[i - 1] + ""); objectArray[i] +=
		 * objectArray[i-1];
		 * 
		 * } }
		 * 
		 * System.out.println(); tableUtils.print(objectArray);
		 * 
		 * // kazda parzysta dzielimy przez 2 for (int i = 0; i <
		 * objectArray.length; i++) { if (objectArray[i] % 2 == 0) {
		 * objectArray[i] /= 2; } }
		 * 
		 * System.out.println(); tableUtils.print(objectArray);
		 * 
		 * // suma wszystkich elementow int sum = 0; for (int element :
		 * objectArray) { sum += element; } System.out.println(
		 * "\nSuma elementow: " + sum);
		 */
		System.out.println("=================");

		int[] randomTable = tableUtils.generateNumbers(10, 0, 123);
		Object[] tulipan = { 1, 2, 3 };
		tableUtils.printStream(tulipan);

		System.out.println();
		System.out.println("======== prezentacja listy =========");

		// lista napisana przeze mnie; wymaga odkomentowania importu
		// pl.sdacademy.lista.List i zakomentowania importu import java.util.List 
		//List<Laptop> lista = new List<Laptop>();
		
		//lista wzieta z javy
		List<Laptop> lista = new ArrayList<>();
		
		Laptop laptop1 = new Laptop("Jan");
		lista.add(laptop1);
		Laptop laptop2;
		laptop2 = lista.get(0);
		lista.toString();
		System.out.println(laptop2);

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
