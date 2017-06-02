package pl.sdacademy.model;

import java.util.Comparator;

public class KomparatorKolWPojezdzie implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		return Integer.compare(v1.getWheelsAmount(), v2.getWheelsAmount());
	}

}
