package leetcode;

/* 
https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */
public class Array_1588 {
    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        System.out.println("Prefix Sum:");
        for (int in : prefix) {
            System.out.print(in + " ");
        }
        System.out.println();

        int sum = 0;
        for (int window = 1; window <= n; window = window + 2) {
            sum += prefix[window - 1];
            for (int i = window; i < n; i++) {
                sum += prefix[i] - prefix[i - window];
            }
            System.out.println("For Window: " + window + " Sum: " + sum);
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 5, 3 };
        System.out.println(sumOddLengthSubarrays(arr));
    }
}
