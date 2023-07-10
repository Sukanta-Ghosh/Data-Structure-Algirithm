1. Initialize a set called "se" to store unique elements.
2. Initialize a variable "ans" to store the number of subarrays with unique elements. Set it to 0.
3. Initialize variables "N" and "l" to store the size of the input array A and the left pointer of the sliding window, respectively.
4. Iterate over the array A using a right pointer "r" from 0 to N-1: a. Check if A[r] is already present in the "se" set:
   - If yes, remove elements from the "se" set and increment the left pointer "l" until A[r] is not present in the set anymore.
   - Calculate the number of subarrays ending at position r by subtracting the left pointer "l" from the right pointer "r" and adding 1.
   - Add the calculated number of subarrays to the "ans" variable. d. Insert A[r] into the "se" set.
5. Return the remainder of the "ans" variable divided by 10^9 + 7 as the result.
