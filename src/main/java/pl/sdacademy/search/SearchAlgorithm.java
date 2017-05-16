package pl.sdacademy.search;

public class SearchAlgorithm implements ISearchAlgorithm {

	public SearchAlgorithm() {
		// konstruktor
	}

	@Override
	public void search(int[] array) {
		// TODO

	}

	@Override
	public int search(int[] array, int value) {
		int i = 0;
		int valueToReturn = -1;

		while (i < array.length && valueToReturn == -1) {
			if (array[i] == value) {
				valueToReturn = i;
			}
			i++;
		}

		return valueToReturn;
	}

	// pisanie tutaj maina jest złą praktyką!!!
	public static void main(String[] args) {
		SearchAlgorithm qwerty = new SearchAlgorithm();
		int[] arrayToSearch;
		arrayToSearch = new int[] { 6, 1, 8, 4, 9, 9, 5, 8, 3 };
		int valueToSearch = 4;

		int result = qwerty.search(arrayToSearch, valueToSearch);

		System.out.println(result);
	}

}
