package com.mahiznan.faang;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */

public class OverlappingInterval {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0], nextEnd = intervals[i][1];
            if (nextStart <= start && nextEnd >= end) {
                start = nextStart;
                end = nextEnd;
            } else if (nextStart <= start && nextEnd >= start) {
                start = nextStart;
            } else if (nextStart >= start && nextStart <= end && nextEnd >= end) {
                end = nextEnd;
            } else if (nextStart >= start && nextStart <= end) {

            } else {
                mergedIntervals.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        mergedIntervals.add(new int[]{start, end});
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals =  {{1,4},{4,5}};
//        int[][] intervals = {{1, 3}, {1, 4}};
//        int[][] intervals = {{1, 4}, {2, 3}};
//        int[][] intervals =  {{1, 2}, {2, 3}, {1, 4}, {5, 6}};
//        int[][] intervals =  {{1, 4}, {2, 3}};
//        int[][] intervals =  {{1, 4}, {0,0}};
//        int[][] intervals = {{1, 4}, {0, 1}};
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        OverlappingInterval overlappingInterval = new OverlappingInterval();
        System.out.println(Arrays.deepToString(overlappingInterval.merge(intervals)));
    }
}
