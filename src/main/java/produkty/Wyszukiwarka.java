package produkty;

import java.util.function.Predicate;

public class Wyszukiwarka {

	Produkt[] tablicaProduktow = null;

	public Wyszukiwarka(Produkt[] tablicaProduktow) {
		super();
		this.tablicaProduktow = tablicaProduktow;
	}

	public Produkt znajdzProdukt(String kodKreskowy) throws Exception {
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

	public <T extends Produkt> Produkt znajdzProduktPredykatem(Predicate<Produkt> predicate) throws Exception {
		Produkt produktDoZwrocenia = null;
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

	public <T extends Produkt> Produkt wyszukajPoKodzie(String kodKreskowy) {
		try {
			return znajdzProduktPredykatem(n -> n.getKodKreskowy() == kodKreskowy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public <T extends Produkt> Produkt wyszukajPoNazwie(String nazwa) {
		try {
			return znajdzProduktPredykatem(n -> n.getNazwa() == nazwa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public synchronized Produkt[] getTablicaProduktow() {
		return tablicaProduktow;
	}

	public synchronized void setTablicaProduktow(Produkt[] tablicaProduktow) {
		this.tablicaProduktow = tablicaProduktow;
	}

}