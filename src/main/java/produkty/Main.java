package produkty;

import java.util.Date;
import java.util.function.Predicate;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {

		Date data = new Date();
		Produkt produktPapierowka = new Produkt("2468", "Jabłko papierówka", 2.49, "owoc", "sadownik Zbyszek", data);
		Produkt produktWino = new Produkt("12668", "Komandos", 6.66, "Alkohol", "Domowe Napitki", data);
		Produkt produktWodka = new Produkt("12667", "Wyborowa", 42.65, "Alkohol", "Polmos Wyborowa", data);
		Produkt produktWhisky = new Produkt("12666", "Balantyna", 60.66, "Alkohol", "Szkocka Destylarnia", data);
		Produkt produktOgorek = new Produkt("9432459", "Ogorek", 2.23, "Warzywa", "Matka Ziemia", data);
		Produkt produktMarchewka = new Produkt("9432459", "Marchewka", 12.23, "Warzywa", "Matka Ziemia", data);
		Produkt produktPyra = new Produkt("12345", "Ziemniaki", 11.23, "Warzywa", "Matka Ziemia", data);
		Produkt produktGruszka = new Produkt("13579", "Gruszeczka", 1.89, "owoc", "sadownik Janek", data);
		Produkt produktMleko = new Produkt("123", "Mleko 3,2%", 2.5, "Nabial", "terravita", data);
		Produkt produktChleb = new Produkt("435674", "Razowy", 2.40, "jedzenie", "Piekpol", data);

		Produkt[] tablicaProduktow = new Produkt[] { produktPapierowka, produktWino, produktWodka, produktWhisky,
				produktOgorek, produktMarchewka, produktPyra, produktGruszka, produktMleko, produktChleb };

		// implementacja interfejsu
		IProdukt wyszukiwarkaProduktow = new IProdukt() {

			@Override
			public Produkt znajdzProdukt(String kodKreskowy, Produkt[] tablicaProduktow) throws Exception {
				Produkt produktDoZwrocenia = null;
				int i = 0;

				if (tablicaProduktow == null) {
					throw new Exception("Tablica produktow jest pusta!");
				} else if (tablicaProduktow.length == 0) {
					return produktDoZwrocenia;
				} else {
					while (i < tablicaProduktow.length && produktDoZwrocenia == null) {
						if (tablicaProduktow[i].getKodKreskowy() == kodKreskowy) {
							produktDoZwrocenia = tablicaProduktow[i];
						}
						i++;
					}
				}
				return produktDoZwrocenia;
			}

			@Override
			public <T> T znajdzProduktPredykatem(Predicate<T> predicate, T[] tablicaProduktow) throws Exception {
				T produktDoZwrocenia = null;
				int i = 0;

				if (tablicaProduktow == null) {
					throw new Exception("Tablica produktow jest pusta!");
				} else if (tablicaProduktow.length == 0) {
					return produktDoZwrocenia;
				} else {
					while (i < tablicaProduktow.length && produktDoZwrocenia == null) {
						boolean test = predicate.test(tablicaProduktow[i]);
						if (test) {
							produktDoZwrocenia = tablicaProduktow[i];
						}
						i++;
					}
				}
				return produktDoZwrocenia;
			}
		};

		String szukanyKodKreskowy = "13579";
		System.out.println("Szukam TRADYCYJNIE produktu o kodzie kreskowym: " + szukanyKodKreskowy + " ");

		Produkt wyszukanyProdukt = wyszukiwarkaProduktow.znajdzProdukt(szukanyKodKreskowy, tablicaProduktow);

		if (wyszukanyProdukt != null) {
			System.out.println(wyszukanyProdukt);
		} else {
			System.out.println("nie udało się wyszukać produktu...");
		}

		System.out.println("Szukam PREDYKATEM produktu o kodzie kreskowym: " + szukanyKodKreskowy + " ");

		Produkt wyszukanyProduktPredykatem = wyszukiwarkaProduktow
				.znajdzProduktPredykatem(n -> n.getKodKreskowy() == szukanyKodKreskowy, tablicaProduktow);

		if (wyszukanyProduktPredykatem != null) {
			System.out.println(wyszukanyProduktPredykatem);
		} else {
			System.out.println("nie udało się wyszukać produktu...");
		}

		System.out.println("Szukam PREDYKATEM produktu o nazwie: " + szukanyKodKreskowy + " ");
		String nazwa = "Ziemniaki";

		Produkt wyszukanyProduktPredykatemPoNazwie = wyszukiwarkaProduktow
				.znajdzProduktPredykatem(n -> n.getNazwa() == nazwa, tablicaProduktow);

		if (wyszukanyProduktPredykatemPoNazwie != null) {
			System.out.println(wyszukanyProduktPredykatemPoNazwie);
		} else {
			System.out.println("nie udało się wyszukać produktu...");
		}

	}

}
