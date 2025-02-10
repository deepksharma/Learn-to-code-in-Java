//      n =  4
//        1
//       232
//      34543
//     4567654
import java.util.*;

public class pattern6 {

           public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        for(int i=1; i<=n;i++)
	        {
	            for(int j=1;j<=n-i;j++)
	            {
	                System.out.print(" ");
	            }
	            int startingNum = i;
	            for(int j=1;j<=i;j++)
	            {
	                System.out.print(startingNum);
	                startingNum++;
	            }
	            int p = 2*i - 2;
	            for(int j=1;j<=i-1;j++)
	            {
	                System.out.print(p);
	                p--;
	            }
	            System.out.println();
	        }
		}
	}
