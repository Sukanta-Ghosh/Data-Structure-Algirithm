To solve the problem of finding the maximum sum of a contiguous subarray, we can use the Kadane's algorithm. The algorithm maintains two variables: maxsofar and maxendinghere. The variable maxsofar stores the maximum sum encountered so far and maxendinghere stores the maximum sum of subarray ending at the current position.

The algorithm works as follows:

Initialize maxsofar and maxendinghere to the first element of the array.
Traverse the array from the second element to the end.
For each element, update maxendinghere as the maximum of (current element, current element + maxendinghere).
Update maxsofar as the maximum of (maxsofar, maxendinghere).
Return maxsofar as the result.
This algorithm has a time complexity of O(N) and a space complexity of O(1), making it an efficient solution to the problem.
