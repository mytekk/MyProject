package pl.sdacademy.model;

import pl.sdacademy.enums.BikeBodyType;
import pl.sdacademy.interfaces.IAction;

public class Bike extends Vehicle implements IAction {

	int gearsNumbers;
	BikeBodyType bikeBodyType;

	public Bike() {
		// TODO Auto-generated constructor stub
	}

	public Bike(String engine, int wheelsAmount, double weight) {
		super(engine, wheelsAmount, weight);
		// TODO Auto-generated constructor stub
	}

	public int getGearsNumbers() {
		return gearsNumbers;
	}

	public void setGearsNumbers(int gearsNumbers) {
		this.gearsNumbers = gearsNumbers;
	}

	public BikeBodyType getBikeBodyType() {
		return bikeBodyType;
	}

	public void setBikeBodyType(BikeBodyType bikeBodyType) {
		this.bikeBodyType = bikeBodyType;
	}

	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void run() {
		System.out.println("Wsiadam na rower i jade.");

	}

}
