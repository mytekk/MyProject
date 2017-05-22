package pl.sdacademy.produkty;

public class Readme {

	/*
	 * Zadanie -------
	 * 
	 * Zadanie polegało na stowrzeniu klasy Produkt, zdefiniowaniu kilku pól tej
	 * klasy, oraz metody znajdż produkt, która będzie umiała wyszukac dany
	 * produkt z 10-elementowej tablicy obiektów typu Produkt. Oprócz tego
	 * trzeba było stworzyc odpowiednie gettery i settery, oraz metode toString,
	 * zeby wiedziec jak wyswietlac dany produkt (dany obiekt klasy Produkt).
	 * Oczywiście najważniejsze było stworzenie metody znajdzProdukt - najpierw
	 * zrobiłem to "normalnie", a potem, w drugiej wersji, za pomocą predykatu
	 * (funkcja znajdzProduktPredykatem). Pierwotnie mielismyzmodyfikować metodę
	 * znajdzProdukt, ale ja stworzyłem druga obok, tak, zeby mozna było sobie
	 * sprawdzic roznice miedzy nimi. Opis plików -----------
	 * 
	 * IProdukt - interfejs dla klasy Produkt; zawiera deklaracje metod
	 * znajdzProdukt i znajdzProduktPredykatem.
	 * 
	 * Produkt - plik z klasą; Patrząc od góry: definicja pól, konstruktor
	 * (ustawia wszystkie pola), metoda znajdzProdukt i znajdzProduktPredykatem
	 * (pierwotnie tutaj była zdefiniowana jedna i druga funkcja, później te
	 * definicje zostały przeniesione do Maina, a tutaj wpisalismy proste
	 * "return null"), gettery i settery, metoda toString.
	 * 
	 * Main - głowny plik z programem. Na początku jest stworzenie obiektu typu
	 * data - potrzebowalismy go tylko po to, zeby kazdemu produktoi moc
	 * przypisac date waznosci. Nastepnie jest definicja 10 produktów i
	 * utworzenie z nich tablicy. Następnie - linia 30 - mamy implementację
	 * imterfejsu, czyli tworzymy obiekt o nazwie wyszukiwarkaProduktow, który
	 * jest typu IProdukt, czyli "typu interfejsu". Od razu po utworzeniu tego
	 * obiektu implementujemy metody znajdzProdukt i znajdzProduktPredykatem.
	 * Opis tych funkcji niżej. Po tym fragmencie gdzie implementujemy interfejs
	 * nastepują trzy scenariusze wyszukiwania produktu: najpierw tą
	 * "tradycyjną" metodą wyszukujemy po kodzie reskowym, nastepnie szukamy tą
	 * metodą predykatową, również po kodzie kreskowym, w ostatnim scenariuszu
	 * szukamy rownież metodą predykatową, ale tym razem po nazwie produtu. W
	 * tym miejscu kończą się pliki, która zawierają to co mieliśmy zrobić na
	 * zajęciach.
	 * 
	 * 
	 * Następne dwa to dodatek, za który zabraliśmy się nieobowiazkowo, pod
	 * koniec zadań. Wydaje mi się, że jest on ukończony (w każdym razie jak dla
	 * mnie, działa poprawnie), aczkolwiek nie rozumiem kilku miejsc, w których
	 * Kuba poprawiał mi kod. Niemniej jednak nie ma on nic wspolnego z
	 * powyzszym plikami - można na to patrzeć jak na dwie odrębne rzeczy.
	 * 
	 * 
	 * Wyszukiwarka - klasa z jednym polem, bedącym tablicą obiektów typu
	 * Produkt. W konstruktorze ta tablica jest wypełniana produktami. Nastepnie
	 * definicja metod znajdzProdukt i znajdzProduktPredykatem - ale uwaga - one
	 * róznią się jakimiś niuansami od tego co było w poprzednich plikach.
	 * Nastepnie, mamy definicje dwóch metod: wyszukajPoKodzie i
	 * wyszukajPoNazwie, które w swoim "ciele" wywoluja metodę
	 * znajdzProduktPredykatem z odpowiednim argumentem: predkatem określającym
	 * po czym szukamu produktu (po kodzie, po nazwie itp...). Na końcu jest
	 * getter i setter dla tablicy produktów.
	 * 
	 * 
	 * MainForWyszukiwarka - plik z programem dla tej nieobowiazkowej częsci
	 * zadania. Definicja tablicy produktów, definicja obiektu typu
	 * Wyszukiwarka, odpalenie metody wyszukajPoKodzie w celu znalezienia
	 * produktu.
	 * 
	 * Opis metody znajdzProdukt ------------------------- Meotd * przyjmuje
	 * jako argument tablice produktów wsrod ktorych ma wyszuiwac, oraz kod
	 * kreskowy po ktorym ma szukac. Jesli tablica wejsciowa jest nullem lub ma
	 * dlugosc zero, to wtedy nie wyszukujemy i albo zwracamy blad albo null.
	 * Jesli tablica jest OK, to wtedy przechodzimy przez nia w teli while
	 * dopóki tabalica sie nei skończy (i < tablicaProduktow.length) i dopóki
	 * nie znaleźlismy jeszcze produktu wg naszego kryterium (czyli zmienna
	 * produktDoZwrocenia jest null). W pętli sprawdzamy, czy dany element
	 * tablicy, czyli dany produkt, ma kod kreskowy, ktorego szukamy. Jesli
	 * znajdziemy taki produkt, to zapisujemy go w zmiennej produktDoZwrocenia,
	 * dzieki czemu opuszczamy petle i mozemy zrobic return.
	 * 
	 * 
	 * Opis metody znajdzProduktPredykatem -----------------------------------
	 * 
	 * 
	 * Meotda przyjmuje jako argument tablice jakis obiektów (oiektów T) -
	 * niekoniecznie musza to byc obiekty typu Produkt. Drugi ardument to
	 * prodykat - ale uwaga - w tym miejscu nie interesuje nas co to konkretnie
	 * za predykat, nie trzeba wiedzieć co on robi (jakie porównanie robi).
	 * Ciało metody jest w zasadzie prawie takie samo jak powyżej, z ta tylko
	 * roznica, ze teraz w pętli nie wykonujemy porównania, lecz odpalamy
	 * predykat, a konkretnie metodę "test" tego predykatu (każdy predykat ma
	 * metodę "test"). Nie interesuje nas co konkretnie robi ten predykat - my
	 * sprawdzamy tylko, czy zwrocil true czy false. Jesli zwrocił false, to
	 * szukamy dalej, a jesli true - przerywamy petle i zwracamy bieżący element
	 * tablicy (ten obiekt, który teraz badaliśmy). Zwróc uwage na odpalanie tej
	 * metody: to wlaśnie dopiero tam wpisujemy predykat, czyli to porównanie,
	 * które chcemy wykonać, np. "n -> n.getKodKreskowy()". To jest wlasnie
	 * predykat, a konkretniej: to jest definicja metoda "test" predykatu, tej
	 * metody "test", która odpalamy wewnątrz funkcji znajdzProduktPredykatem.
	 */

}
