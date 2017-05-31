package pl.sdacademy.predicate;

import pl.sdacademy.enums.Miasto;
import pl.sdacademy.enums.Plec;

public class Kursant {

	String imie;
	String naziwsko;
	int wiek;
	Plec plec;
	Miasto miasto;

	//konstruktor
	public Kursant(String imie, String naziwsko, int wiek, Plec plec, Miasto miasto) {
		super();
		this.imie = imie;
		this.naziwsko = naziwsko;
		this.wiek = wiek;
		this.plec = plec;
		this.miasto = miasto;
	}

	//gettery i settery
	public Plec getPlec() {
		return plec;
	}

	public void setPlec(Plec plec) {
		this.plec = plec;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public Miasto getMiasto() {
		return miasto;
	}

	public void setMiasto(Miasto miasto) {
		this.miasto = miasto;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNaziwsko() {
		return naziwsko;
	}

	public void setNaziwsko(String naziwsko) {
		this.naziwsko = naziwsko;
	}

	@Override
	public String toString() {
		return "Kursant [imie=" + imie + ", naziwsko=" + naziwsko + ", wiek=" + wiek + ", plec=" + plec + ", miasto="
				+ miasto + "]";
	}

}
