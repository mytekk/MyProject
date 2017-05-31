package pl.sdacademy.predicate;

import java.util.ArrayList;
import java.util.List;

import pl.sdacademy.enums.Miasto;
import pl.sdacademy.enums.Plec;

public class Main {

	public static void main(String[] args) {

		System.out.println("Utowrzenie listy obiektów typu Kursant");
		
		List<Kursant> listaKursantow = new ArrayList<Kursant>();
		Kursant kursant1 = new Kursant("Lukasz", "Nowak", 19, Plec.MEZCZYNA, Miasto.POZNAN);
		Kursant kursant2 = new Kursant("Jan", "Kowalski", 17, Plec.MEZCZYNA, Miasto.BYDGOSCZ);
		Kursant kursant3 = new Kursant("Marta", "Nowak", 16, Plec.KOBIETA, Miasto.POZNAN);
		Kursant kursant4 = new Kursant("Lukasz", "Nowak", 23, Plec.MEZCZYNA, Miasto.KATOWICE);
		Kursant kursant5 = new Kursant("Ola", "Nowak", 18, Plec.KOBIETA, Miasto.WARSZAWA);
		Kursant kursant6 = new Kursant("Wiktoria", "Nowakowska", 9, Plec.KOBIETA, Miasto.SZCZECIN);
		Kursant kursant7 = new Kursant("Kamil", "Nowak", 29, Plec.MEZCZYNA, Miasto.POZNAN);
		Kursant kursant8 = new Kursant("Slawek", "Nowak", 15, Plec.MEZCZYNA, Miasto.POZNAN);
		Kursant kursant9 = new Kursant("Piotr", "Nowak", 6, Plec.MEZCZYNA, Miasto.POZNAN);
		Kursant kursant10 = new Kursant("Marcin", "Nowak", 21, Plec.MEZCZYNA, Miasto.POZNAN);
		Kursant kursant11 = new Kursant("Anna", "Lipa", 26, Plec.KOBIETA, Miasto.POZNAN);
		listaKursantow.add(kursant1);
		listaKursantow.add(kursant2);
		listaKursantow.add(kursant3);
		listaKursantow.add(kursant4);
		listaKursantow.add(kursant5);
		listaKursantow.add(kursant6);
		listaKursantow.add(kursant7);
		listaKursantow.add(kursant8);
		listaKursantow.add(kursant9);
		listaKursantow.add(kursant10);
		listaKursantow.add(kursant11);

		Predykaty predykaty = new Predykaty();
		
		System.out.println("========= Wypisanie wszystkich doroslych kursantow - w petli, z predykatem =====================");
		for (int i = 0; i < listaKursantow.size(); i++) {
			//wywoluje predykat jestDorosly, czyli odpalam jego nienazwana metode test
			//do tej metody przekazuje obiekt typu kursant, ktory wyciagam za pomoca
			//predefiniowanej funkcji get(index)
			//jesli warunek jest spelniony, to wypisz kursanta
			if (predykaty.jestDorosly().test(listaKursantow.get(i))) {
				System.out.println(listaKursantow.get(i));
			}
		}

		System.out.println("========== Wypisanie wszystkich doroslych kursantow - strumieniem, z predykatem ================");
		listaKursantow.stream().filter(predykaty.jestDorosly()).forEach((kursant) -> System.out.println(kursant));

		
		System.out.println("========= Wypisanie wszystkich kursantow - strumieniem, z wykorzystaniem podwojnego dwukropka ============");
		System.out.println("Wykorzystanie podwojnego dwukropka - ::");
		listaKursantow.stream().forEach(System.out::println);

		
		System.out.println("=========== Wypisanie wszystkich niepelnoletnich kursantow ===================");
		listaKursantow.stream().filter(predykaty.jestDorosly().negate()).forEach(System.out::println);
		

		System.out.println("============ Wypisanie wszystkich kursantow z Poznania ==============");
		listaKursantow.stream().filter((kursant) -> kursant.getMiasto().equals(Miasto.POZNAN))
				.forEach(System.out::println);
		

		System.out.println("============= Ile jest kobiet z Poznania ==============");
		int licznikKobiet = listaKursantow.stream().filter(predykaty.jestKobieta().and(kursant ->kursant.getMiasto().equals(Miasto.POZNAN))).toArray().length;
		System.out.println(licznikKobiet);
		
		System.out.println("============= Ile jest mezczyzn z Poznania ==============");
		int licznikMezczyzn = listaKursantow.stream().filter(predykaty.jestMezczyzna().and(kursant ->kursant.getMiasto().equals(Miasto.POZNAN))).toArray().length;
		System.out.println(licznikMezczyzn);

	}

}