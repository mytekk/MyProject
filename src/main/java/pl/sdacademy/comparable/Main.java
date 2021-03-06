package pl.sdacademy.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import pl.sdacademy.model.KomparatorKolWPojezdzie;
import pl.sdacademy.model.Vehicle;

public class Main {

	public static void main(String[] args) {

		Vehicle dostawczak = new Vehicle("Dostawczy - diesel");
		dostawczak.setWeight(2302);
		dostawczak.setWheelsAmount(6);

		Vehicle rower = new Vehicle("Rower - brak silnika");
		rower.setWeight(15);
		rower.setWheelsAmount(2);

		Vehicle ciezarowka = new Vehicle("Tir - diesel");
		ciezarowka.setWeight(7899);
		ciezarowka.setWheelsAmount(12);

		Vehicle auto = new Vehicle("Auto - bena");
		auto.setWeight(3432);
		auto.setWheelsAmount(4);

		List<Vehicle> listaPojazdow = new ArrayList<>();
		listaPojazdow.add(dostawczak);
		listaPojazdow.add(rower);
		listaPojazdow.add(ciezarowka);
		listaPojazdow.add(auto);

		System.out.println("\nPojazdy:");
		for (Iterator iterator = listaPojazdow.iterator(); iterator.hasNext();) {
			Vehicle vehicle = (Vehicle) iterator.next();
			System.out.println(vehicle);
		}

		System.out.println("\nPojazdy - zwykly for:");
		for (int i = 0; i < listaPojazdow.size(); i++) {
			System.out.println(listaPojazdow.get(i));
		}

		System.out.println("\nPojazdy - strumien");
		listaPojazdow.stream().forEach(vehicle -> System.out.println(vehicle));

		System.out.println("\nPojazdy - strumien z notacja ::");
		listaPojazdow.stream().forEach(System.out::println);

		System.out.println("\nPojazdy posortowane po wadze:");
		// sortowanie jest mozliwe, bo klasa Vehicle implementuje interfejs
		// Comparable
		Collections.sort(listaPojazdow);
		for (Iterator iterator = listaPojazdow.iterator(); iterator.hasNext();) {
			Vehicle vehicle = (Vehicle) iterator.next();
			System.out.println(vehicle);
		}

		System.out.println("\nPojazdy posortowane po ilosci kół, za pomocą Komparatora:");
		// takie posortowanie jest mozliwe, bo utworzylem swoj wlasny
		// Komparatow, ktory implementuje interfejs Komparator
		// i umie posortowac pojazdy wzgledem ilosci kol
		Collections.sort(listaPojazdow, new KomparatorKolWPojezdzie());
		for (Iterator iterator = listaPojazdow.iterator(); iterator.hasNext();) {
			Vehicle vehicle = (Vehicle) iterator.next();
			System.out.println(vehicle);
		}

	}

}