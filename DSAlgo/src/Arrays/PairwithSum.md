1. Set the modulo value as mod = 10^9 + 7
2. Calculate frequncy of array elements with HashMap
3. Initialize variables n = size of array A, i = 0, j = n - 1, and count = 0
4. Start a while loop with the condition i < j
5. Calculate the sum of A[i] and A[j] and store it in the variable sum
6. Check if sum is equal to B
   1. If it is equal, check if A[i] is not equal to A[j]
      1. If they are not equal, initialize variables a = 1, b = 1
      2. Assign a and b from hashmap
      3. Update the count by adding (a \* b) % mod
      4. Increment i and decrement j
   2. If A[i] is equal to A[j]
      1. Initialize a variable cnt = 1
      2. Calculate the count of pairs with the same value as A[i] using the formula cnt = (j - i + 1) \* (j - i) / 2
      3. Update the count by adding cnt % mod
      4. Break the loop since no further pairs can be found
7. If sum is greater than B, decrement j
8. If sum is less than B, increment i
9. Return the count as the result
