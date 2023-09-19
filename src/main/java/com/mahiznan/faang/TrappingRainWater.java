package com.mahiznan.faang;

/*
Given an array A where each element denotes a the height of blocks, calculate the total volume of water that can be trapped when it rains.

Note: one cubic block has a volume of 1 unit.

Example:
A: [ 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 ]

Refer the image trapped-rain-water.png in this path

The total volume of water is 1 + 3 + 1 + 1 = 6 units.

Trapped Rain Water
Testing
Input Format
First-line contains an integer ‘T’ denoting the number of test cases.

For each test-case the input has two lines:

An integer ‘n’ denoting the size of the array A.
n space separated integers denoting the elements of array A.
Output Format
For each test case, the output has a line with an integer ‘w’ denoting the volume of trapped rainwater.

Sample Input
2
5
1 0 0 1 0
6
1 0 2 0 0 1
Expected Output
2
3
Constraints
1 <= T <= 100
1 <= n <= 30000
0 <= Ai <= 104
 */
public class TrappingRainWater {
    int volumeOfTrappedRainWater(int[] heights) {
        int pos = 1, capacity = 0;
        while (pos < heights.length - 1) {
            int curLeft = pos - 1, curRight = pos + 1, prevLeft, prefRight;

            while (true) {
                if (curLeft < 0 || heights[pos] > heights[curLeft]) {
                    pos = curRight + 1;
                    break;
                }
                int currentCapacity = (heights[curRight] > heights[curLeft] ? (heights[curRight] - heights[curLeft]) : (heights[curLeft] - heights[curRight])) - heights[pos];
                prevLeft = curLeft--;
                prefRight = curRight++;
            }


        }


        return capacity;
    }

    public static void main(String[] args) {
        System.out.println("Ok");
    }
}
