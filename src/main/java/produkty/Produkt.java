package produkty;

import java.util.Date;
import java.util.function.Predicate;

public class Produkt implements IProdukt {

	String kodKreskowy;
	String nazwa;
	double cena;
	String typ;
	String producent;
	Date dataWaznosci;

	// konstruktor
	public Produkt(String kodKreskowy, String nazwa, double cena, String typ, String producent, Date dataWaznosci) {
		setKodKreskowy(kodKreskowy);
		setNazwa(nazwa);
		setCena(cena);
		setTyp(typ);
		setProducent(producent);
		setDataWaznosci(dataWaznosci);
	}

	@Override
	public Produkt znajdzProdukt(String kodKreskowy, Produkt[] tablicaProduktow) throws Exception {
		return null;
	}

	@Override
	public <T> T znajdzProduktPredykatem(Predicate<T> predicate, T[] tablicaProduktow) throws Exception {
		return null;
	}

	// GETTERY I SETTERY
	public String getKodKreskowy() {
		return kodKreskowy;
	}

	public void setKodKreskowy(String kodKreskowy) {
		this.kodKreskowy = kodKreskowy;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getProducent() {
		return producent;
	}

	public void setProducent(String producent) {
		this.producent = producent;
	}

	public Date getDataWaznosci() {
		return dataWaznosci;
	}

	public void setDataWaznosci(Date dataWaznosci) {
		this.dataWaznosci = dataWaznosci;
	}

	@Override
	public String toString() {
		return "Produkt [kodKreskowy=" + kodKreskowy + ", nazwa=" + nazwa + ", cena=" + cena + ", typ=" + typ
				+ ", producent=" + producent + ", dataWaznosci=" + dataWaznosci + "]";
	}

}
