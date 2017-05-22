package pl.sdacademy.produkty;

import java.util.function.Predicate;

public interface IProdukt {

	public Produkt znajdzProdukt(String kodKreskowy, Produkt[] tablicaProduktow) throws Exception;

	public <T> T znajdzProduktPredykatem(Predicate<T> predicate, T[] tablicaProduktow) throws Exception;

}
