package Number_Theory;

public class GCDandLCM {

	// Optimized Euclidean Algorithm
	// GCD: Greatest Common Divisor
	static int gcd(int a, int b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

	// a * b = gcd(a, b) * lcm(a, b)
	// LCM: Least Common Multiplie
	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	public static void main(String[] args) {

		int a = 15, b = 12;

		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));

	}
}
