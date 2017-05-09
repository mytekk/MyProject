package pl.sdacademy.main;

import pl.sdacademy.model.Bike;
import pl.sdacademy.model.Car;
import pl.sdacademy.model.OpelCar;
import pl.sdacademy.model.RenaultCar;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		System.out.println("Hello!:)");

		Bike marcinsRomet = new Bike();
		Car adamsOpel = new OpelCar();
		Car maciejsRenault = new RenaultCar();

		Car[] carTable = new Car[2];
		carTable[0] = adamsOpel;
		carTable[1] = maciejsRenault;

		maciejsRenault.refuel();
		adamsOpel.refuel();

		maciejsRenault.run();
		marcinsRomet.run();

		for (int i = 0; i < carTable.length; i++) {
			System.out.println(carTable[i].getInfo());
		}

	}

}
