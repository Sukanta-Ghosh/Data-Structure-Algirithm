Consider the array

```
5, -2, 3, 1, 2
```

Possible combinations of elements to be picked if B = 3 would be

```
[] denotes elements that are picked

1.) 5, -2, [3, 1, 2]
sum of elements picked = 6

2.) [5], -2, 3, [1, 2]
sum of elements picked = 8

3.) [5, -2], 3, 1, [2]
sum of elements picked = 5

4.) [5, -2, 3], 1, 2
sum of elements picked = 6
```

We can notice that

```
sum of elements picked = sum of all elements of the array - sum of unpicked elements
eg: [5], -2, 3, [1, 2]

sum of entire array = 9

sum of unpicked elements = -2 + 3 = 1

sum of picked elements = 9 - 1 = 8
```

Keeping this in mind, we can observe that unpicked elements is nothing but a window of fixed size that moves from start till the end

How do you get the size of window of unpicked elements

```
WindowSize = Size of Array - B
= N - B
= 5 - 3
= 2
```

And that we’ve figured out that this window of size 2 needs to be moved across array
Next question comes to mind is how we would calculate the sum of elements inside this window

This could easily be done by maintaining a prefix sum array such that for any given range [l, r]

```
sum[l, r] = prefix[r] - prefix[l-1]
```
