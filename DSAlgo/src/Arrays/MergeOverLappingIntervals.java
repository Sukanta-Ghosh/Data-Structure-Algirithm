package Arrays;

import java.util.*;

/* 
Question Link: https://leetcode.com/problems/merge-intervals/ 
Qs: https://www.scaler.com/academy/mentee-dashboard/class/47512/assignment/problems/61?navref=cl_tt_nv

Problem Statement: Given a set of time intervals in any order, merge all overlapping 
intervals into one and output the result which should have only mutually exclusive 
intervals.
Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
Output: {{1, 4}, {6, 8}, {9, 10}}
*/

import java.util.Arrays;
import java.util.Comparator;

// An Interval
class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/*
 * GFG Solution Link: https://www.geeksforgeeks.org/merging-intervals/
 * 
 * Function that takes a set of intervals, merges
 * overlapping intervals and prints the result
 */
class MergeOverlappingIntervals {

    /*
     * T.C: O(n Log n)
     * S.C: O(1)
     */
    public static void mergeIntervals(Interval arr[]) {

        /*
         * Sort Intervals in increasing order based on start time
         * using comparator
         */
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        /*
         * Stores index of last element in output array (modified arr[])
         * Store index 0
         */
        int index = 0;

        // Traverse all input Intervals
        for (int i = 1; i < arr.length; i++) {
            // If current Interval overlaps with the previous one
            if (arr[index].end >= arr[i].start) {
                // Merge previous and current Intervals
                arr[index].start = Math.min(arr[index].start, arr[i].start);
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            }
            /* else increase index by 1 and assign current interval */
            else {
                index++;
                arr[index] = arr[i];
            }
        }

        // Now arr[0..index-1] stores the merged Intervals
        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= index; i++) {
            System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
        }
    }

    public static void main(String args[]) {

        // Striver Solution
        // [[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = new int[4][2];
        intervals[0] = new int[] { 1, 3 };
        intervals[1] = new int[] { 2, 6 };
        intervals[2] = new int[] { 8, 10 };
        intervals[3] = new int[] { 15, 18 };

        int[][] merged = merge(intervals);
        System.out.println("Displaying merged intervals: ");
        for (int[] m : merged) {
            System.out.print("{" + m[0] + "," + m[1] + "}");
        }
        System.out.println();

        // GFG Solution
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(1, 3);
        arr[1] = new Interval(2, 4);
        arr[2] = new Interval(6, 8);
        arr[3] = new Interval(9, 10);
        mergeIntervals(arr);
    }

    /*
     * Striver Solution:
     * https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
     */
    static int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<int[]>();

        // Sorting the intervals array
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                result.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }
        }
        result.add(new int[] { start, end });

        return result.toArray(new int[0][]);
    }

}
