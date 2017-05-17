package pl.sdacademy.lambda;

public class MainWithLambda {

	public static void main(String[] args) {
		// tworze tak jakby obiekt interfejsu, aleponiewaz interfejs nie zawiera
		// definicji wymaganych funkcji (tylko deklaracje), to tuż po
		// stworzeniu tego obiektu, pomiędzy klamerkami musze zdefiniowac
		// wszystkie funkcje wymagane przez interfejs
		// ale UWAGA - nie piszę funkcji, tylko wyrażenie lambda, które
		// robi to samo co metoda, która musiałbym tu wpisać

		ISumInt object = (n) -> {
			int result = 0;

			for (int i = 1; i <= n; i++) {
				result += i;
			}
			return result;
		};

		ISumInt object2 = (n) -> SumInt.calculateSum(n); // a tutaj dla odmiany
															// korzystam z
															// wywołania
															// statycznej
															// metody, żeby nie
															// pisać tutaj
															// wprost kodu

		int sum = object.sum(5);
		// tutaj korzystam z metody sum z interfejsu
		// a jej implementacja jest za pomoca powyższego wyrażenia lambda
		// w lambdzie nie ma nazwy funkcji, bo skoro w interfejsie możebyc tlyko
		// jedna
		// metoda, to java sama wie, że powyższe wyrażenie lambda to definicja
		// funkcji "sum".
		// dlatego te funkcje sum mogę poniżej wywołać.

		System.out.println("sum: " + sum);
		System.out.println("-----");
		int sum2 = object2.sum(5);
		System.out.println("sum: " + sum2);

	}
}
