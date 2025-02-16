

public class Prime_function {
	
	public static boolean isPrime(int n) {
		for(int d =2 ; d<n ; d++) {
			if(n%d==0) {
				return false ;
			}
		}
		return true ;
	}
	
	public static void printPrime(int n) {
		for(int i =1 ; i<=n ; i++) {
			boolean isIprime = isPrime(i);
			if(isIprime) {
				System.out.print(i+" ");
			}
		}
	}
	public static void main(String args[]) {
		printPrime(50);
	}

}
