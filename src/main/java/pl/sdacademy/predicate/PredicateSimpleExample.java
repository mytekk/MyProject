package pl.sdacademy.predicate;

import java.util.function.Predicate;

public class PredicateSimpleExample {

	public static void main(String[] args) {

		Predicate<Integer> condition = p -> p == 0;
		// definicja predykatu o nazwie condition, ktory przyjmuje do
		// sprawdzenia integery i sprawdza czy sa one rowne zero

		int number = 5;
		checkPredicate(condition, number);

		number = 0;
		checkPredicate(condition, number);

		number = 99;
		// wrzucam inny predykat: czy liczba jest rowna 99?
		checkPredicate(p -> p == 99, number);

	}

	private static void checkPredicate(Predicate<Integer> condition, int number) {
		System.out.print(number);

		// wywoluje metode test predykatu. Zdefiniowalem ja powyzej, przy
		// definicji predykatu condition

		if (condition.test(number)) {
			System.out.println(" is condition true.");
		} else {
			System.out.println(" is condition false.");
		}
	}

}
