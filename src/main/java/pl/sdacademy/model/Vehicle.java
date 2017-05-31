package pl.sdacademy.model;

public class Vehicle implements Comparable<Vehicle> {

	public String engine;
	private int wheelsAmount;
	double weight;

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(String engine) {
		this.engine = engine;
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

	/**
	 * metoda porównawcza, wymagana przez interfejs Comparable 
	 * 
	 * uznajemy, że ten pojazd (obiekt klasy Vehicle) będzie więszky, który będzie cięższy
	 * 
	 * wywoływana metoda
	 * compare na obiekcie typu Double (bo waga pojazdu jest typu double) zwroci
	 * zero jesli 0 jeśli wagó dwóch pojazdów będą takie same, liczbę wiekszą od
	 * zera jeśli waga bieżącego obiektu Vehicle (this) będzie wieksza od
	 * pojazdu do porównania, oraz liczbę zmniejszą od zera jeśli waga bieżącego
	 * obiektu Vehicle (this) będzie mniejsza od pojazdu do porównania
	 */
	@Override
	public int compareTo(Vehicle pojazdDoPorownania) {
		return Double.compare(this.getWeight(), pojazdDoPorownania.getWeight());
	}

	@Override
	public String toString() {
		return "Vehicle [engine=" + engine + ", wheelsAmount=" + wheelsAmount + ", weight=" + weight + "]";
	}
	
	

}
