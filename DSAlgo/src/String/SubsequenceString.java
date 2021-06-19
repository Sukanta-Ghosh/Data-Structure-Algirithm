package String;

public class SubsequenceString {
	
	/*Iterative Solution
	 * Efficient Solution
	 * Time: O(n+m)
	 * Space: O(1)
	 * */
	static boolean isSubSeq(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		
		int j = 0;
		for(int i = 0; i < n && j < m; i++) {
			if(s1.charAt(i) == s2.charAt(j))
				j++;
		}
		
		return (j == m);
	}
	
	/*Recursive Solution
	 * Efficient Solution
	 * Time: O(n+m)
	 * Space: O(n+m)
	 * */
	static boolean isSubSeq(String s1, String s2, int n, int m) {
		
		if(m == 0)
			return true;
		if(n == 0)
			return false;
		if(s1.charAt(n-1) == s2.charAt(m-1))
			return isSubSeq(s1, s2, n-1, m-1);
		else
			return isSubSeq(s1, s2, n-1, m);
		
	}
	
	public static void main(String[] args) {
		String s1 = "ABCDEF";
		String s2 = "ADE";
		 
		int n = s1.length();
		int m = s2.length();
		
		isSubSeq(s1, s2);
		isSubSeq(s1, s2, n, m);
	}
}
