package Arrays;

public class StockBuySell {

	public static void main(String[] args) {

		int[] price = { 1, 5, 3, 8, 12 };
		// int[] price = { 7, 1, 5, 3, 6, 4 };
		int n = price.length;

		System.out.println(maxProfit_2(price, n));
	}

	/*
	 * Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	 */
	static int maxProfit_2(int[] price, int n) {

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

	/*
	 * Leetcode Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 * Explanation: https://takeuforward.org/data-structure/stock-buy-and-sell/
	 */
	static int maxProfit_1(int[] price, int n) {

		int maxProfit = 0;
		int minPrice = price[0];

		for (int i = 1; i < n; i++) {
			minPrice = Math.min(minPrice, price[i]);
			maxProfit = Math.max(maxProfit, price[i] - minPrice);
		}
		return maxProfit;
	}

	/*
	 * Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	 */
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
