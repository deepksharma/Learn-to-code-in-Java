import java.util.Scanner;

public class FarhToCel {

public static void main(String[] args) {
		System.out.println("Enter value of Farh. : ");
		
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		int cel = (5*(f-32)/9);
		
		System.out.println("After converting into Cel. : ");
		System.out.println(cel);

	}

}
    

