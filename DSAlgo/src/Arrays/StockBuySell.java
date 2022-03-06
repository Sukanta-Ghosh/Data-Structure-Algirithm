package Arrays;

/* Practise Link
https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1 */

public class StockBuySell {

	public static void main(String[] args) {

		int[] price = { 1, 5, 3, 8, 12 };
		int n = price.length;

		System.out.println(maxProfitEffi(price, n));
	}

	// Method 2 : Efficient
	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
	static int maxProfitEffi(int[] price, int n) {

		int maxProfit = 0;

		// maxProfit adds up the difference between adjacent elements if they are in
		// increaisng order
		// The loop starts from 1 as its comparing with the previous
		for (int i = 1; i < n; i++) {
			if (price[i] > price[i - 1])
				maxProfit += (price[i] - price[i - 1]);
		}
		return maxProfit;
	}

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

}
