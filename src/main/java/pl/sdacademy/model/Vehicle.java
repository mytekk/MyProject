package pl.sdacademy.model;

public class Vehicle {
	
	public String engine;
	private int wheelsAmount;
	double weight;

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(String engine, int wheelsAmount, double weight) {
		this.engine = engine;
		this.wheelsAmount = wheelsAmount;
		this.weight = weight;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getWheelsAmount() {
		return wheelsAmount;
	}

	public void setWheelsAmount(int wheelsAmount) {
		this.wheelsAmount = wheelsAmount;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
