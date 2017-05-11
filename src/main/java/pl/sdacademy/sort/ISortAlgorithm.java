package pl.sdacademy.sort;

public interface ISortAlgorithm {

	// diwe takie samemetody
	// jesli przy wywolaniu sort nie podam drugiego argumentu, to wtedy
	// odpale drugą definicje ale z juz ustawionym jednym argumentem

	default void sort(int[] array) {
		sort(array, true);
	}

	void sort(int[] array, boolean ascending);

}
