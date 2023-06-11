package Arrays;

/* 
 * Leetcode: https://leetcode.com/problems/next-permutation/
 * Scale Qs: https://www.scaler.com/academy/mentee-dashboard/class/47512/homework/problems/71?navref=cl_tt_lst_sl
 * 
 * Explanation: https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 4, 2 };
        // o/p: 1, 4, 2, 3, 5
        /*
         * Example 1:
         * Input: 1, 2, 3
         * Output: 1, 3, 2
         * ----------------
         * Example 2:
         * Input: 3, 2, 1
         * Output: 1, 2, 3
         */
        nextPermutation(arr);

        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void nextPermutation(int[] nums) {
        // Sanity Check
        if (nums.length == 1) {
            return;
        }

        /*
         * Step 1:
         * Find index(i) of first element(A[i]) which is smaller
         * than A[i + 1] element, i is from right side.
         * (A[i] < A[i + 1])
         */
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        System.out.println(i);

        /*
         * Step 2:
         * Find index(j) of A[j] element which is greater than
         * previous computed A[i] element
         * and swap
         */
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            System.out.println(j);
            swap(nums, i, j);
        }

        /*
         * Step 3: Reverse array from i + 1 th index to array end
         * where no is swapped till the end of the array.
         */
        reverse(nums, i + 1, nums.length - 1);

    }

    public static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }
}
