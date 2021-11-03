package Dynamic_Programming;

import java.util.*;

public class BooleanParenthesization {

	/**
	 * Recursive Approach
	 **/
	public int recursive(String str, int i, int j, boolean isTrue) {

		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue)
				return str.charAt(i) == 'T' ? 1 : 0;
			else
				return str.charAt(i) == 'F' ? 1 : 0;
		}

		int ans = 0;
		for (int k = i + 1; k <= j - 1; k = k + 2) {

			int lT = recursive(str, i, k - 1, true);
			int lF = recursive(str, i, k - 1, false);
			int rT = recursive(str, k + 1, j, true);
			int rF = recursive(str, k + 1, j, false);

			if (str.charAt(k) == '&') {
				if (isTrue)
					ans += lT * rT;
				else
					ans += lF * rT + lT * rF + lF * rF;
			} else if (str.charAt(k) == '|') {
				if (isTrue)
					ans += lT * rT + lF * rT + lT * rF;
				else
					ans += lF * rF;
			} else if (str.charAt(k) == '^') {
				if (isTrue)
					ans += lF * rT + lT * rF;
				else
					ans += lT * rT + lF * rF;
			}
		}

		return ans;
	}

	/**
	 * Top-down Approach
	 **/
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public int topdown(String str, int i, int j, boolean isTrue) {

		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue)
				return str.charAt(i) == 'T' ? 1 : 0;
			else
				return str.charAt(i) == 'F' ? 1 : 0;
		}

		StringBuffer sb = new StringBuffer();
		sb.append(Integer.toString(i));
		sb.append(Integer.toString(j));
		sb.append(Boolean.toString(isTrue));
		String st = sb.toString();
		if (map.containsKey(st)) {
			return map.get(st);
		}

		int ans = 0;
		for (int k = i + 1; k <= j - 1; k = k + 2) {

			int lT = topdown(str, i, k - 1, true);
			int lF = topdown(str, i, k - 1, false);
			int rT = topdown(str, k + 1, j, true);
			int rF = topdown(str, k + 1, j, false);

			if (str.charAt(k) == '&') {
				if (isTrue)
					ans += lT * rT;
				else
					ans += lF * rT + lT * rF + lF * rF;
			} else if (str.charAt(k) == '|') {
				if (isTrue)
					ans += lT * rT + lF * rT + lT * rF;
				else
					ans += lF * rF;
			} else if (str.charAt(k) == '^') {
				if (isTrue)
					ans += lF * rT + lT * rF;
				else
					ans += lT * rT + lF * rF;
			}
		}

		map.put(st, ans);
		return ans;
	}

	public static void main(String[] args) {
		String str = "T|F&T^F";
		BooleanParenthesization obj = new BooleanParenthesization();
		System.out.println(obj.recursive(str, 0, str.length() - 1, true));

		System.out.println(obj.topdown(str, 0, str.length() - 1, true));
	}
}
