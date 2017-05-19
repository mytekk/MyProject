package produkty;

import java.util.Date;

public class MainForWyszukiwarka {

	public MainForWyszukiwarka() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

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

		// tworze obiekt wyszukiwarki i zadaje mu liste produktow
		Wyszukiwarka wyszukiwarka = new Wyszukiwarka(tablicaProduktow);

		// teraz bezposrednio w wyszukiwarce moge korzystac z metod
		// wyszukujacych
		// po roznych polach i wyszukiwac produkty
		Produkt szukanyProdukt = wyszukiwarka.wyszukajPoKodzie("13579");
		System.out.println(szukanyProdukt);

	}

}
