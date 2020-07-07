package Dynamic_Programming;

public class MinimumInsertionDeletion {
	public static void main(String[] args) {
		
		char[] X = {'H', 'E', 'A', 'P'};
		int m = X.length;
		char[] Y = {'P', 'A', 'E'};
		int n = Y.length;
		
		MinimumInsertionDeletion obj = new MinimumInsertionDeletion();
		
		int lcsLen = obj.lcs(X, Y, m, n);
		int insertion = m - lcsLen;
		int deletion = n - lcsLen;
	}
	
	int lcs( char[] X, char[] Y, int m, int n ) { return 1; }
}
