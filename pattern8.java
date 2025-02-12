
//  n  =   4

//        *
//       ***
//      *****
//     *******
//      *****
//       ***
//        *


public class pattern8 {
	    public static void main(String[] args) {
	        int n = 4; // number of rows for the upper half of the diamond

	        // upper half of the diamond
	        for (int i = 1; i <= n; i++) {
	            // print leading spaces
	            for (int j = i; j < n; j++) {
	                System.out.print(" ");
	            }
	            // print stars
	            for (int j = 1; j <= (2 * i - 1); j++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }

	        // lower half of the diamond
	        for (int i = n - 1; i >= 1; i--) {
	            // print leading spaces
	            for (int j = n; j > i; j--) {
	                System.out.print(" ");
	            }
	            // print stars
	            for (int j = 1; j <= (2 * i - 1); j++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	    }
	}

	
	


    

