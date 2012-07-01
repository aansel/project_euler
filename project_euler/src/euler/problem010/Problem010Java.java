package euler.problem010;

public class Problem010Java {

	
	public static void main(String[] args) {
		System.out.println("Java version");
		long t1 = System.currentTimeMillis();
		System.out.println(getSumPrimes(2000000));
		long t2 = System.currentTimeMillis();
		System.out.println((t2 - t1) + " ms5");
	}
	
	// Somme des nombres premiers de 1 à limit
	private static long getSumPrimes(int limit) {
		long sum = 5;
		int nb = 5;
		while(nb <= limit) {
			if (isPrime(nb)) {
				sum += nb;
			}
			nb = nb + 2;
			if (nb <= limit && isPrime(nb)) {
				sum += nb;
			}
			nb = nb + 4;
		}
		return sum;
	}
	
	
	private static boolean isPrime(int nb) {
		if (nb % 2 == 0 || nb % 3 == 0) {
			return false;
		} else {
			int i = 5;
			double limit = Math.sqrt(nb);
			while(i <= limit) {
				if (nb % i == 0) {
					return false;
				}
				i = i + 2;
				if (i <= limit && nb % i == 0) {
					return false;
				}
				i = i + 4;
			}
			return true;
		}
	}

}
