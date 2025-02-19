

import java.util.Scanner;
public class array1 {

	public static void main(String[] args) {
     
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
		int size = sc.nextInt();
		int input[] = new int[size];
        System.out.println("Enter the number you want to insert: ");
		
		for(int i =0 ; i<size ; i++) {
			input[i] = sc.nextInt();
		}
		for(int i =0 ; i<size ; i++) {
			System.out.print(input[i]+" ");
		}
		
	}
}

// how to take input in array and print it
