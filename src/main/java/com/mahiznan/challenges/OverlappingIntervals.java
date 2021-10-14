package com.mahiznan.challenges;

import java.util.Arrays;
import java.util.Comparator;

public class OverlappingIntervals {

    static int[][] removeOverlapping(int[][] Intervals) {
        int[][] result = new int[Intervals.length][2];

        //Sort the input array based on start time

        /*for (int i = 0; i < Intervals.length - 1; i++) {
            for (int j = i + 1; j < Intervals.length; j++) {
                if (Intervals[i][0] > Intervals[j][0]) {
                    //Swap
                    int t = Intervals[i][0];
                    Intervals[i][0] = Intervals[j][0];
                    Intervals[j][0] = t;

                    t = Intervals[i][1];
                    Intervals[i][1] = Intervals[j][1];
                    Intervals[j][1] = t;
                }
            }
        }*/
        Arrays.sort(Intervals, Comparator.comparingInt(a -> a[0]));
        int totalInterval = 0, endTime = Intervals[0][1];
        result[totalInterval][0] = Intervals[0][0];
        result[totalInterval][1] = endTime;
        for (int i = 1; i < Intervals.length; i++) {
            if (Intervals[i][0] <= endTime) {
                endTime = Math.max(result[totalInterval][1], Intervals[i][1]);
                result[totalInterval][1] = endTime;
            } else {
                totalInterval++;
                endTime = Intervals[i][1];
                result[totalInterval][0] = Intervals[i][0];
                result[totalInterval][1] = endTime;
            }
        }

        int[][] trimmedArray = new int[totalInterval + 1][2];
        System.arraycopy(result, 0, trimmedArray, 0, totalInterval + 1);

        for (int i = 0; i <= totalInterval; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        //From the second interval if the starting time is smaller than previous meeting time
        // then adjust the end time of the previous interval
        // Otherwise add as new entry

        return trimmedArray;
    }

    public static void main(String[] args) {
        //int[][] intervals = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        int[][] intervals = {{32, 39}, {3, 30}, {4, 42}, {33, 41}, {38, 41}, {23, 29}, {39, 45}, {33, 38}, {18, 28}, {18, 38}, {28, 36}, {48, 49}, {16, 18}, {5, 15}, {38, 46}, {29, 32}, {48, 48}, {26, 30}, {28, 48}, {22, 43}, {31, 45}, {19, 28}, {21, 40}, {33, 48}, {20, 37}, {25, 41}, {4, 8}, {44, 48}, {18, 42}, {22, 23}, {48, 48}, {4, 8}, {10, 15}, {47, 48}, {1, 17}, {29, 30}, {45, 46}, {29, 44}, {6, 43}, {24, 37}, {25, 40}, {28, 47}, {2, 16}, {44, 46}, {30, 40}, {29, 42}, {33, 41}, {33, 44}, {12, 16}, {34, 44}};

//        int[][] intervals = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
//        Output: {{1, 9}}
        removeOverlapping(intervals);
    }
}
