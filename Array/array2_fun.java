// Removed package declaration to match the expected package structure

import java.util.Scanner;

public class array2_fun {
	
	public static int[] takeinput() {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int input[] = new int[size] ;
		for(int i =0 ; i< size ; i++) {
			input[i] = sc.nextInt();
		}
		return input;
	}
	
	public static void print(int input[]) {
		int size = input.length ; 
		for(int i=0 ; i<size ; i++) {
			System.out.print(input[i]+" ");
		}
	}
	public static void main(String args[]) {
		int arr[] = takeinput();
		print (arr);
	}
}
