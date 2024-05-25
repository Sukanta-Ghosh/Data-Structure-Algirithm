Approach 2 (Most Efficient)

We can use the concept of two pointers.
Search from left to right and maintain a max height of left and right separately, which is like a one-side wall of a partial container. Fix the higher one and flow water
from the lower part. For example, if the current height of the left is lower, we fill water in the left bin. Until the left meets right,
we filled the whole container.

We will follow the below steps:

1. Maintain two variables ‘left’ and ‘right’ (‘left’ denotes the left pointer and ‘right’ denotes the right pointer) and initialize it to 0 and n-1 respectively.
2. Also maintain two variables ‘leftmax’ and ‘rightmax’ (‘leftmax’ denotes the maximum height till ‘left’ ( i.e. from 0 to left) and ‘rightmax’ denotes the maximum height till ‘right’(i.e. from right to n-1) ) and initialize both of them to 0.
3. while left <= right we have two possible conditions

Condition 1: leftmax<=rightmax
For the element at index left , we have already traversed from 0 to left , therefore leftmax is known. But rightmax of left'th index is not known. We only know the rightmax for right.
But we know that rightmax can only get bigger from right to left,and we already know that leftmax<=rightmax, therefore leftmax of left <= rightmax of left.
Now we can simply add leftmax-A[left] , if this quantity is positive
otherwise change leftmax to A[left].
Increment left.

Condition 2: leftmax>rightmax
For the element at index right , we have already traversed from n-1 to right , therefore rightmax is known. But leftmax of right'th index is not known. We only know the leftmax for left.
But we know that leftmax can only get bigger from left to right, and we already know that leftmax>rightmax, therefore rightmax of right < leftmax of right.
Now we can simply add rightmax-A[right] , if this quantity is positive
otherwise change rightmax to A[right].
decrement right
