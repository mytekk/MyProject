package pl.sdacademy.predicate;

import java.util.function.Predicate;

import pl.sdacademy.enums.Plec;
import pl.sdacademy.enums.Miasto;

public class Predykaty {

	//stała
	public static final int WIEK_PELNOLETNOSCI = 18;

	//definicje roznych predykatow
	public Predicate<Kursant> jestDorosly() {
		return (kursant) -> kursant.getWiek() >= WIEK_PELNOLETNOSCI;
	}

	public Predicate<Kursant> jestPlci(Plec plec) {
		return (kursant) -> kursant.getPlec().equals(plec);
	}

	public Predicate<Kursant> jestMezczyzna() {
		return jestPlci(Plec.MEZCZYNA);
	}

	public Predicate<Kursant> jestKobieta() {
		return jestPlci(Plec.KOBIETA);
	}

	public Predicate<Kursant> jestDoroslaKobieta() {
		return jestKobieta().and(jestDorosly());
	}
	
	public Predicate<Kursant> jestZPoznania() {
		return kursant -> kursant.getMiasto().equals(Miasto.POZNAN);
	}
	
}