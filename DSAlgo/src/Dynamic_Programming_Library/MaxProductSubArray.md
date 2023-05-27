To solve this problem, we can use dynamic programming. We can keep track of the maximum and minimum product that can be obtained till i-th element of the array. At each i-th element, we can either multiply the current element with the maximum product obtained till now or the minimum product obtained till now. This is because, if the current element is negative, then multiplying it with the minimum product will give us the maximum product and if the current element is positive, then multiplying it with the maximum product will give us the maximum product.

We can use two variables to keep track of the maximum and minimum product at each i-th element. We can then update the maximum product variable if we find a product greater than the current maximum product.

At the end, we return the maximum product variable.

Here is the pseudo code for the above approach:

```java
max_product = A[0]
min_product = A[0]
result = A[0]

for i in range(1, N):
    if A[i] < 0:
        max_product, min_product = min_product, max_product
    max_product = max(A[i], max_product * A[i])
    min_product = min(A[i], min_product * A[i])
    result = max(result, max_product)
```

### Further Explanation:

Sure, let me explain the approach with an example.

Consider the input array A = [4, 2, -5, 1].

We start by initializing three variables: maxproduct, minproduct, and result, with the first element of the array A[0].

```java
max_product = 4
min_product = 4
result = 4
```

Now, we iterate over the array from the second element (i=1) till the end.

At each i-th element, we update the max and min products. If the current element is negative, we swap the max and min products as multiplying a negative number with the minimum product will give us the maximum product.

For i=1, A[i]=2.

```java
max_product = max(2, 4*2) = 8
min_product = min(2, 4*2) = 2
result = max(result, max_product) = max(4, 8) = 8
```

For i=2, A[i]=-5.

```java
max_product = max(-5, 8*(-5)) = -5
min_product = min(-5, 2*(-5)) = -10
result = max(result, max_product) = max(8, -5) = 8
```

For i=3, A[i]=1.

```java
max_product = max(1, -5*1) = 1
min_product = min(1, -10*1) = -10
result = max(result, max_product) = max(8, 1) = 8
```

Finally, we return the result, which is 8.

I hope this explanation with the example helps you understand the approach better. Let me know if you have any more questions!
