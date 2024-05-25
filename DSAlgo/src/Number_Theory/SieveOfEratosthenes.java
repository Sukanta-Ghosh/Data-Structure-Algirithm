package Number_Theory;

import java.util.Arrays;

/* Statement: Get upto < n Prime Numbers
 * https://www.geeksforgeeks.org/sieve-of-eratosthenes/
 */
public class SieveOfEratosthenes {

	/*
	 * T.C: O(N*log(log(N)))
	 * S.C: O(n)
	 */
	static void sieve(int n) {
		if (n <= 1)
			return;

		/*
		 * Create a boolean array "prime[0..n]" and
		 * initialize all entries it as true. A value in
		 * prime[i] will finally be false if i is Not a
		 * prime, else true.
		 */
		boolean isPrime[] = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		/* Loop from 2 to i = root of n */
		for (int i = 2; i * i <= n; i++) {
			/*
			 * If prime[p] is not changed, then it is a
			 * prime
			 */
			if (isPrime[i]) {
				/*
				 * Update all multiples of i greater than or
				 * equal to the square of it numbers which
				 * are multiple of i and are less than i ^ 2
				 * are already been marked
				 */
				for (int j = i * i; j <= n; j = j + i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (isPrime[i])
				System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {

		int n = 10;

		sieve(n);

	}
}
