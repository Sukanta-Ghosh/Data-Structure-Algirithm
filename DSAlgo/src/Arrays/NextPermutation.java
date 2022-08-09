package Arrays;

/* 
 * Leetcode: https://leetcode.com/problems/next-permutation/
 * 
 * Explanation: https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 4, 2 };
        nextPermutation(arr);

        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void nextPermutation(int[] nums) {
        // Sanity Check
        if (nums.length == 1) {
            return;
        }

        // Step 1: Find ith index samller than i+1 index
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        // Step 2: Find a index that has greater value than
        // previously found index
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j])
                j--;
            swap(nums, i, j);
        }

        // Step 3: Reverse array from index+1 where the index is found at step 1 till
        // the end of the array.
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
