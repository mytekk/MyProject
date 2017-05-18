package pl.sdacademy.lambdaExample;

import java.util.function.Predicate;

import pl.sdacademy.lambdaExample.model.Bulka;
import pl.sdacademy.lambdaExample.model.Jedzenie;
import pl.sdacademy.lambdaExample.model.Kanapka;
import pl.sdacademy.lambdaExample.model.Maslo;
import pl.sdacademy.lambdaExample.model.Warzywo;

public class Main {

	public static void main(String[] args) {

		// obiekty poczatkowe
		Bulka kajzerkaBulka = new Bulka("Kajzerka");
		Maslo ekstraMaslo = new Maslo("Masło ekstra");
		Warzywo pomidorWarzywo = new Warzywo("Pomidor");

		// implementacja interfejsu - "w locie" definiuje sobie metode
		// zrobKanapke
		IUmiejetnosci umiejetnosciPanaKanapki = new IUmiejetnosci() {

			@Override
			public Kanapka zrobKanapke(Bulka bulka, Maslo maslo, Warzywo warzywo) {
				String elementyKanapki = bulka.getNazwa() + " " + maslo.getNazwa() + " " + warzywo.getNazwa();
				Kanapka kanapka = new Kanapka("Bułka z pomidorem");
				kanapka.setSkladniki(elementyKanapki);
				return kanapka;
			}
		};

		// tutaj tworze pierwsza kanapke i wyswietlam ją
		Kanapka wiosennaKanapkaPanaKanapki = umiejetnosciPanaKanapki.zrobKanapke(kajzerkaBulka, ekstraMaslo,
				pomidorWarzywo);

		System.out.println("Kanapka zrobiona przez pana Kanapke: " + wiosennaKanapkaPanaKanapki);

		// druga implementacja interfejsu - tutaj tez definiuje metode
		// zrobKanapke
		// ale nie wprost, jak za pierwszym razem, tylko za pomoca wyrazenia
		// lambda; w dodatku to wyrazenie jest proste i
		// sprowadza sie do utworzenia prawie pustej kanapki
		IUmiejetnosci umiejetnosciPaniJadzi = (bulka, maslo, warzywo) -> {
			return new Kanapka("?");
		};

		// tutaj tworze druga kanapke i wyswietlam ją
		Kanapka wiosennaKanapkaPaniJadzi = umiejetnosciPaniJadzi.zrobKanapke(kajzerkaBulka, ekstraMaslo,
				pomidorWarzywo);
		System.out.println("Kanapka zrobiona przez pania Jadzie: " + wiosennaKanapkaPaniJadzi);

		// trzecia implementacja interfejsu - tutaj tez definiuje metode
		// zrobKanapke
		// ale nie wprost, jak za pierwszym razem, tylko za pomoca wyrazenia
		// lambda - tak jak w drugim przypadku, ale tutaj lambda jest
		// troche bardziej rozbudowana i tworzy kanapkę
		// z wykorzystaniem bulki i malsa, ale bez warzywa
		IUmiejetnosci umiejetnosciPanaFranka = (bulka, maslo, warzywo) -> {
			Kanapka kanapka = new Kanapka("studencka kanapka pana Franka");
			kanapka.setSkladniki(bulka + " " + maslo);
			return kanapka;
		};

		// tutaj tworze trzecia kanapke i wyswietlam ją
		Kanapka wiosennaKanapkaPanaFranka = umiejetnosciPanaFranka.zrobKanapke(kajzerkaBulka, ekstraMaslo, null);
		System.out.println("Kanapka zrobiona przez pania Jadzie: " + wiosennaKanapkaPanaFranka);

		System.out.println("----------- czesc druga -------------");

		// predykat dziala na obiekcie typu Jedzenie
		// i sprawdza czy nazwa tego obiektu jest rowna "Masło ekstra"
		// lub czy obiekt posiada składnik będacy masłem ekstra
		// (dokladniej: czy w stringu ze skladnikami jest odpowiednia fraza)
		Predicate<Jedzenie> posiadaMasloEkstra = (jedzenie) -> {
			return (jedzenie.getNazwa().equalsIgnoreCase("Masło ekstra"))
					|| jedzenie.getSkladniki().contains("Masło ekstra");
		};

		// tablica 3 elementowa obiektow typu jedzenie
		Jedzenie[] jedzenie = new Jedzenie[] { kajzerkaBulka, ekstraMaslo, pomidorWarzywo, wiosennaKanapkaPanaKanapki,
				wiosennaKanapkaPaniJadzi, wiosennaKanapkaPanaFranka };

		for (int i = 0; i < jedzenie.length; i++) {
			System.out.print(jedzenie[i]); // bo mam toString
			if (posiadaMasloEkstra.test(jedzenie[i])) {
				System.out.print(" posiada maslo ekstra!");
			}
			System.out.println("");
		}

	}

}
