import java.util.Scanner;

public class FahrenheitToCelsiusTable {
   

	    // Method to convert Fahrenheit to Celsius
	    public static double fahrenheitToCelsius(int fahrenheit) {
	        return (fahrenheit - 32) * 5.0 / 9.0;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input start Fahrenheit value, end Fahrenheit value, and step size
	        System.out.print("Enter the start Fahrenheit value (S): ");
	        int start = scanner.nextInt();
	        System.out.print("Enter the end Fahrenheit value (E): ");
	        int end = scanner.nextInt();
	        System.out.print("Enter the step size (W): ");
	        int step = scanner.nextInt();

	        // Print the table header
	        System.out.println("Fahrenheit\tCelsius");

	        // Loop through the range and print Fahrenheit and corresponding Celsius values
	        for (int fahrenheit = start; fahrenheit <= end; fahrenheit += step) {
	            double celsius = fahrenheitToCelsius(fahrenheit);
	            System.out.printf("%d\t\t%.2f\n", fahrenheit, celsius);
	        }

	        
	    }
	}


