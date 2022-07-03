package com.mahiznan.challenges;

/*
// Problem Description

Given a 2D matrix M of dimensions RxC. Find the maximum sum sub matrix in it.

Example 1:

Input:
R=4
C=5
M=[[1,2,-1,-4,-20],
[-8,-3,4,2,1],
[3,8,10,1,3],
[-4,-1,1,7,-6]]
Output:
29
Explanation:
The matrix is as follows and the
blue rectangle denotes the maximum sum
rectangle.

Example 2:

Input:
R=2
C=2
M=[[-1,-2],[-3,-4]]
Output:
-1
Explanation:
Taking only the first cell is the
optimal choice.

Your Task:
You don't need to read input or print anything.
Your task is to complete the function maximumSumRectangle() which takes the number R, C, and the 2D matrix M as input parameters
and returns the maximum sum sub matrix.

Expected Time Complexity:O(R*R*C)
Expected Auxiliary Space:O(R*C)

Constraints:
1<=R,
C<=500,
-1000<=M[i][j]<=1000

 */

//TODO: This problem is not solved yet
public class MaximumSumRectangle {
    public static void main(String[] args) {
        int[][] M = {{1, 2, -1, -4, -20}, {-8, -3, 4, 2, 1}, {3, 8, 10, 1, 3}, {-4, -1, 1, 7, -6}};
        int R = 4, C = 5;
        System.out.println("Hello World");

        for (int[] ints : M) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print(" " + ints[j]);
            }
            System.out.println();
        }
    }
}
