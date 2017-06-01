package pl.sdacademy.celebrities_lambda_example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Main {

	public static void main(String[] args) {
		
		List<Celebrity> celebrities = new ArrayList<Celebrity>(); //lista celebrytów
        celebrities.add(new Celebrity("Justin Bieber", true, false, true));
        celebrities.add(new Celebrity("Kim Kardashian", false, false, false));
        celebrities.add(new Celebrity("Joanna Krupa", true, true, false));
        
        
        
        
        //podejscie tradycyjne: 
        //tworze obiekt klasy, ktora umie sprawdzac,
        //czy dany celebryta umie spiewac

        CheckTalent checker = new CheckIfSinger();
        
        for (Celebrity celebrity:celebrities){
            if(checker.test(celebrity)){
                System.out.println(celebrity + " ");
            }
            System.out.println();
        }
        
        System.out.println("================");
        
        //podejscie za pomoca wyrazenia lambda
        //nie potrzenuje zadnego dodatkowego interfejsu, ani 
        //klasy go implementujacej
        //definiuje sobie tlyko predykat
        //a wewnatrz niego jest wyrazenie lambda
        
        Predicate<Celebrity> checkIfCanSing = c -> c.canSing();
        Predicate<Celebrity> checkIfCanDance = c -> c.canDance();
        
        for (Celebrity celebrity : celebrities){
            if(  checkIfCanSing.test(celebrity) ){
                System.out.println(celebrity + " ");
            }
            System.out.println();
        }
        

	}


}
