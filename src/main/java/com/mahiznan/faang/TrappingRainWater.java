package com.mahiznan.faang;

import java.util.Stack;

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

    static int volumeOfTrappedRainWater_Good(int[] heights) {
        int n = heights.length;
        int totalRainWater = 0;
        for (int i = 0; i < n; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, heights[j]);
            }
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, heights[j]);
            }
            totalRainWater += Math.min(maxRight, maxLeft) - heights[i];
        }
        return totalRainWater;
    }

    static int volumeOfTrappedRainWater_Best1(int[] heights) {
        int n = heights.length;
        int totalRainWater = 0;
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!index.isEmpty() && heights[index.peek()] < heights[i]) {
                int prevIndx = index.peek();
                index.pop();
                if (!index.isEmpty()) {
                    int height = Math.min(heights[i], heights[index.peek()]) - heights[prevIndx];
                    totalRainWater += height * (i - 1 - index.peek());
                }
            }
            index.push(i);
        }
        return totalRainWater;
    }

    static int volumeOfTrappedRainWater_Best2(int[] heights) {
        int left = 0, right = heights.length - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];
        int water = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                left++;
                if (leftMax < heights[left]) {
                    leftMax = heights[left];
                } else {
                    water += leftMax - heights[left];
                }

            } else {
                right--;
                if (rightMax < heights[right]) {
                    rightMax = heights[right];
                } else {
                    water += rightMax - heights[right];
                }
            }

        }

        return water;

    }

    public static void main(String[] args) {
        int[] heights = {1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(volumeOfTrappedRainWater_Good(heights));
        System.out.println(volumeOfTrappedRainWater_Best1(heights));
        System.out.println(volumeOfTrappedRainWater_Best2(heights));
    }
}
