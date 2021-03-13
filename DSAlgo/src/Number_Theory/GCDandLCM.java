package Number_Theory;

public class GCDandLCM {
	
	//Optimised Euclidean Algorithm
	static int gcd(int a, int b)
	{
		if(b==0)
			return a;

		return gcd(b, a % b);
	}
	
	// a * b = gcd(a, b) * lcm(a, b)
	static int lcm(int a, int b)
	{
		return (a * b) / gcd(a, b);
	}

	public static void main (String[] args) {
		
		int a = 12, b = 15;

		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));

	}
}
