package Dynamic_Programming_Library;

public class MaxProductSubArray {
    /*
     * To solve this problem, we can use dynamic programming. We can keep track of
     * the maximum and minimum product that can be obtained till i-th element of the
     * array. At each i-th element, we can either multiply the current element with
     * the maximum product obtained till now or the minimum product obtained till
     * now. This is because, if the current element is negative, then multiplying it
     * with the minimum product will give us the maximum product and if the current
     * element is positive, then multiplying it with the maximum product will give
     * us the maximum product.
     * 
     * We can use two variables to keep track of the maximum and minimum product at
     * each i-th element. We can then update the maximum product variable if we find
     * a product greater than the current maximum product.
     * 
     * At the end, we return the maximum product variable.
     * 
     * Here is the pseudo code for the above approach:
     * max_product = A[0]
     * min_product = A[0]
     * result = A[0]
     * 
     * for i in range(1, N):
     * if A[i] < 0:
     * max_product, min_product = min_product, max_product
     * max_product = max(A[i], max_product * A[i])
     */
    public int maxProduct(final int[] A) {
        int n = A.length;
        int minVal = A[0];
        int maxVal = A[0];
        int maxProduct = A[0];

        for (int i = 1; i < n; i++) {
            // When multiplied by -ve number,
            // maxVal becomes minVal
            // and minVal becomes maxVal.
            if (A[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }

            minVal = Math.min(A[i] * minVal, A[i]);

            maxVal = Math.max(A[i], A[i] * maxVal);

            maxProduct = Math.max(maxProduct, maxVal);
        }

        return maxProduct;
    }
}
