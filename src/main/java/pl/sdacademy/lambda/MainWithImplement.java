package pl.sdacademy.lambda;

public class MainWithImplement {

	public static void main(String[] args) {

		// tworze tak jakby obiekt interfejsu, aleponiewaz interfejs nie zawiera
		// definicji wymaganych funkcji (tylko deklaracje), to tuż po
		// stworzeniu tego obiektu, pomiędzy klamerkami musze zdefiniowac
		// wszystkie funkcje wymagane przez interfejs
		// tak naprawde, tonie uzywamy tutaj w ogole klasy SumInt,
		// tylko tutaj, na miejscu, piszemy kod ktory potrzebujemy

		ISumInt object = new ISumInt() {

			@Override
			public int sum(int n) {
				int result = 0;

				for (int i = 1; i <= n; i++) {
					result += i;
				}

				return result;
			}
		};

		int sum = object.sum(5);
		System.out.println("sum: " + sum);

	}

}
