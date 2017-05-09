package pl.sdacademy.main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        System.out.println("tulipan");      
//        task1();     
//        task2();   
//        task3();
    	rysujTrojkat(6);
        
    }
    
    private static void rysujTrojkat(int height) {
//    	*
//    	**
//    	***
//    	****
    	for (int i = 1; i <= height; i++) {
    		for (int j = 1; j <= i; j++) {
    			System.out.print("* ");
    		}
    		System.out.println();
    	}
    	
    	//gwiazdki po przekatnej
    	for (int i = 1; i <= height; i++) {
    		for (int j = 1; j <= i; j++) {
    			System.out.print(" ");
    		}
    		System.out.print("*");
    		System.out.println();
    	}
    	
    	//prostokat z gwiazdek
    	for (int i = 1; i <= height; i++) {
    		for (int j = 1; j <= height; j++) {
    			System.out.print("*");
    		}
    		System.out.println();
    	}
    	
    }

	private static void task3() {
		//0, 2, 4, 6, 4, 2, 0
        for (int i = 0; i < 6; i++) {
        	if (i % 2 == 0) {
        		System.out.print(i + ", ");
        	}
        }
        for (int i = 6; i >= 0; i--) {
        	if (i % 2 == 0) {
        		System.out.print(i + ", ");
        	}
        }
	}

	private static void task2() {
		//1, 3, 5, 7, .... 61
        for (int i = 0; i < 62; i++) {
        	if (i % 2 != 0) {
        		if (i > 1 && i <= 61) {
            		System.out.print(", ");
            	}
        		System.out.print(i);
        	}
        }
	}

	private static void task1() {
		for (int i = 0; i < 10; ++i) {
        	if (i <= 5) {
        		System.out.println(i);
        	} else {
        		for (int j = 5; j < i; ++j)
        			System.out.print(j);
        		System.out.println();
        	}
        }
	}
}
