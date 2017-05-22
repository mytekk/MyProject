package pl.sdacademy.stos;

public class Laptop {

	Karteczka karteczka;

	public Laptop(String imie) {
		this.karteczka = new Karteczka();
		this.karteczka.setNapis(imie);
	}

}