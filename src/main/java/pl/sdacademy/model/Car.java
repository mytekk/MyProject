package pl.sdacademy.model;

import pl.sdacademy.enums.BodyType;
import pl.sdacademy.interfaces.IAction;
import pl.sdacademy.interfaces.ICar;

public class Car extends Vehicle implements ICar, IAction {

	BodyType bodyType;

	// domyslny konstruktor bezargumentowy
	public Car() {
		super("benzin", 4, 2000.5); // wywoluje konstruktor z klasy vehicle
	}

	// konstruktor argumentowy
	public Car(BodyType bodyType) {
		this(); // wywolanie konstruktora domyslnego
		setBodyType(bodyType);
	}

	// konstruktor dwuargumentowy
	public Car(BodyType bodyType, double weight) {
		this(bodyType); // wywolujemy konstruktor ten jeden wyzej
		setWeight(weight); // potomek ma dostep do tego co jest u ojca, w tym do
							// getterow i setterow

	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}

	public void refuel() {
		// TODO Auto-generated method stub

	}

	public void openDoor() {
		System.out.println("Otwieram drzwi w samochodzie.");

	}

	public void startEngine() {
		// TODO Auto-generated method stub

	}

	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void run() {
		System.out.println("Uruchamian auto i jade.");

	}

}
