
// n = 4
// 432*
// 43*1
// 4*21
// *321

import java.util.*;

public class pattern9 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i =1 ; i<=n ; i++){
	      for(int j =n ; j>=1 ; j-- ){
			  if(j==i){
				  System.out.print("*");
			  }
			  else{
				  System.out.print(j);
			  }
		  }
		  System.out.println();
		}	

		}
	}
