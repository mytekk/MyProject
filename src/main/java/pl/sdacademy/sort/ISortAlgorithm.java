package pl.sdacademy.sort;

public interface ISortAlgorithm {

	// diwe takie samemetody
	// jesli przy wywolaniu sort nie podam drugiego argumentu, to wtedy
	// odpale drugą definicje ale z juz ustawionym jednym argumentem

	default void sort(int[] array) {
		bubleSort(array, true);
	}

	void bubleSort(int[] array, boolean ascending);

	default void quickSort(int[] tableToSort, int firstIndex, int lastIndex) {
	}


}
