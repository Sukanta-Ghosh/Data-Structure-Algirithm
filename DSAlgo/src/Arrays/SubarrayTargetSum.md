Pseudo-code for finding the first continuous subarray that adds up to B:

1. Initialize variables:

- n = length of array A
- l = 0 (left pointer of the current window)
- r = 0 (right pointer of the current window)
- sum = A[l] (sum of elements in the current window)

2. While r is less than n and l is less than or equal to r:

- If sum is equal to B:

  - Create an empty vector called ans
  - Iterate from l to r:
  - Add A[i] to ans
  - Return ans as the result

- If sum is less than B:

  - Increment r by 1
  - If r is less than n, add A[r] to sum

- If sum is greater than B:

  - Subtract A[l] from sum
  - Increment l by 1
  - If l is greater than r and l is less than n - 1:
  - Increment r by 1
  - If r is less than n, add A[r] to sum

3. If the loop completes without finding a subarray that adds up to B, return [-1] as the result.
