Here is the pseudo-code for the given code:

1. Create an hashMap to store the elements of the array as keys and the length of the longest consecutive sequence containing that element as values.
2. Initialize a variable maxCount to 0 to keep track of the maximum length of consecutive elements found so far.
3. Iterate over each element in the array A and add in hashMap.
4. Check if element is not already present in the hMap (i.e., hMap.find(ele) == hMap.end()).
5. If ele is not present in the hMap, find the length of the longest consecutive elements before ele (stored in lCount) and the length of the longest consecutive elements after ele (stored in rCount).
6. Add 1 to lCount and rCount to include ele in the consecutive sequence.
7. Update the hMap with the length of the longest consecutive sequence for ele and its adjacent elements.
   - Set hMap[ele] = lCount + 1 + rCount to store the length of the sequence for ele.
   - Set hMap[ele - lCount] = hMap[ele] to update the length of the sequence for the element before ele.
   - Set hMap[ele + rCount] = hMap[ele] to update the length of the sequence for the element after ele.
8. If the length of the current consecutive sequence (lCount + 1 + rCount) is greater than maxCount, update maxCount with the new length.
9. After iterating through all the elements, return maxCount as the length of the longest set of consecutive elements from the array A.
