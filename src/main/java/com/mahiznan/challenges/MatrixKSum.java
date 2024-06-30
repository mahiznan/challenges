package com.mahiznan.challenges;
/*
Number of paths in a matrix with k coins
MediumAccuracy: 16.96%Submissions: 36K+Points: 4
Internship Alert!
Become an SDE Intern by topping this monthly leaderboard!

banner
Given a n x n matrix such that each of its cells contains some coins. Count the number of ways to collect exactly k coins while moving from top left corner of the matrix to the bottom right. From a cell (i, j), you can only move to (i+1, j) or (i, j+1).

Example 1:

Input:
k = 12, n = 3
arr[] = [[1, 2, 3],
       [4, 6, 5],
       [3, 2, 1]]
Output:
2
Explanation:
There are 2 possible paths with exactly 12 coins, (1 + 2 + 6 + 2 + 1) and (1 + 2 + 3 + 5 + 1).
Example 2:

Input:
k = 16, n = 3
arr[] = [[1, 2, 3],
       [4, 6, 5],
       [9, 8, 7]]
Output:
0
Explanation:
There are no possible paths that lead to sum=16
Your Task:
You don't need to read input or print anything. Your task is to complete the function numberOfPath() which takes n, k and 2D matrix arr[][] as input parameters and returns the number of possible paths.

Expected Time Complexity: O(n*n*k)
Expected Auxiliary Space: O(n*n*k)

Constraints:

1 <= k < 100
1 <= n < 100
0 <= arrij <= 200


 */
public class MatrixKSum {

    static long calculate(int i, int j, int[][] arr, int total, int k, int n) {
        if (i == n)
            return 0;

        if (total + arr[i][j] == k) {
            return 1;
        }

        if (total + arr[i][j] > k) {
            int i1 = nextI(i, j, n);
            int j1 = nextJ(i, j, n);
            return calculate(i1, j1, arr, total, k, n);
        }

        int i1 = nextI(i, j, n);
        int j1 = nextJ(i, j, n);
        int i2 = nextI(i1, j1, n);
        int j2 = nextJ(i1, j1, n);
        return
                calculate(i1, j1, arr, total + arr[i][j], k, n) +
                        calculate(i2, j2, arr, total, k, n);
    }

    static int nextI(int i, int j, int n) {
        if (j == n - 1) {
            return i + 1;
        }
        return i;
    }

    static int nextJ(int i, int j, int n) {
        if (j == n - 1) {
            return 0;
        }
        return j + 1;
    }


    static long numberOfPath(int n, int k, int[][] arr) {
        return calculate(0, 0, arr, 0, k, n);
    }

    public static void main(String[] args) {
        int k = 12, n = 3;
        int[][] arr = {{1, 2, 3}, {4, 6, 5}, {3, 2, 1}};
//        int k = 12, n = 5;
//        int[][] arr = {{1, 4, 3, 3, 2}, {1, 1, 4, 3, 1}, {4, 1, 3, 4, 4}, {1, 1, 4, 5, 4}, {5, 3, 5, 4, 5}};
//        int k = 16, n = 3;
//        int[][] arr = {{1, 2, 3}, {4, 6, 5}, {9, 8, 7}};
        System.out.println(numberOfPath(n, k, arr));
    }


}
