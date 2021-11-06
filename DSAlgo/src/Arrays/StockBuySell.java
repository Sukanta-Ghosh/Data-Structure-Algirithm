package arrays;

/* Practise Link
https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1 */

public class StockBuySell {

	// Method 1 : Naive
	// Time Complexity: O(n^2)
	// Auxiliary Space: O(1)
	int maxProfitNaive(int[] price, int start, int end) {

		if (end <= start)
			return 0;

		int profit = 0;
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				if (price[j] > price[i]) {
					int curr_profit = price[j] - price[i] + maxProfitNaive(price, start, i - 1)
							+ maxProfitNaive(price, j + 1, end);
					profit = Math.max(profit, curr_profit);
				}
			}
		}
		return profit;
	}

	// Method 2 : Efficient
	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
	int maxProfitEffi(int[] price, int n) {

		int profit = 0;
		for (int i = 1; i < n; i++) {
			if (price[i] > price[i - 1])
				profit += price[i] - price[i - 1];
		}
		return profit;
	}

	public static void main(String[] args) {

		int[] price = { 1, 5, 3, 8, 12 };
		int n = price.length;

		StockBuySell obj = new StockBuySell();
		System.out.println(obj.maxProfitEffi(price, n));
	}
}
