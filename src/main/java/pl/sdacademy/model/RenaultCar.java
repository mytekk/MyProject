package pl.sdacademy.model;

import pl.sdacademy.enums.BodyType;

public class RenaultCar extends Car {

	public RenaultCar() {
		super(BodyType.SEDAN, 3000);
	}

	public void refuel() {
		System.out.println("Tankuje Renault...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Zatankowalem!");
	}

	@Override
	public String getInfo() {
		return super.getInfo() + "Renaltut.";
	}

}
