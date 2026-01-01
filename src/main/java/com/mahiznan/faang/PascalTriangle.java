package com.mahiznan.faang;

import java.util.*;

/*
The triangle below (Refer the image PascalTriangle.png) is known as Pascal’s triangle.

In this triangle, the value at a position is equal to the sum of values of the 2 elements just above it.

Examples
The 2nd element of 5th row is 1+3 => 4
The 3rd element of 5th row is 3+3 => 6
The 4th element of 5th row is 3+1 => 4
For the leftmost and the rightmost position in each row, the value is 1. The element in the first row is also 1.

Given a number n, find the nth row of pascal’s triangle.

Testing
Input Format
The first line contains ‘T’ denoting the no. of test cases.

Next T lines contains a number 'n' denoting the row number of pascal’s triangle.

Output Format
For each test case, a line containing ‘n’ space-separated integers denoting the elements in the nth row.

Examples
Sample Input
3
4
5
6
Expected Output
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
Constraints
1 <= T <= 100

1 <= n <= 30

 */
public class PascalTriangle {

    int[] pascalTriangleRow(int n) {
        int[] pascalTriangle = new int[n];
        int pos = 0;
        // To follow 0 based indexing, decrement n
        n--;
        // nC0 = 1
        int prev = 1;
        pascalTriangle[pos++] = prev;
        for (int i = 1; i <= n; i++) {
            // nCr = (nCr-1 * (n - r + 1))/r
            int curr = (prev * (n - i + 1)) / i;
            pascalTriangle[pos++] = curr;
            prev = curr;
        }
        return pascalTriangle;
    }

    /*
        int[] pascalTriangleRow(int rowNo) {
            int[] pascalTriangle;
            if (rowNo == 1) {
                pascalTriangle = new int[1];
                pascalTriangle[0] = 1;
                return pascalTriangle;
            } else if (rowNo == 2) {
                pascalTriangle = new int[2];
                pascalTriangle[0] = 1;
                pascalTriangle[1] = 1;
                return pascalTriangle;
            }
            pascalTriangle = new int[rowNo];
            Queue<Integer> firstQueue = new LinkedList<>();
            Queue<Integer> secondQueue = new LinkedList<>();
            Queue<Integer> result = null;
            int count = 2;
            firstQueue.add(1);
            firstQueue.add(1);
            while (!firstQueue.isEmpty()) {

                while (!firstQueue.isEmpty()) {
                    if (secondQueue.isEmpty()) {
                        secondQueue.add(1);
                    }
                    int currentValue = firstQueue.poll();
                    if (!firstQueue.isEmpty()) {
                        secondQueue.add(currentValue + firstQueue.peek());
                    } else {
                        secondQueue.add(currentValue);
                    }
                }
                while (!secondQueue.isEmpty()) {
                    if (firstQueue.isEmpty()) {
                        firstQueue.add(1);
                    }
                    int currentValue = secondQueue.poll();
                    if (!secondQueue.isEmpty()) {
                        firstQueue.add(currentValue + secondQueue.peek());
                    } else {
                        firstQueue.add(currentValue);
                    }
                }
                count += 2;
                if (count == rowNo) {
                    if (firstQueue.isEmpty()) {
                        result = secondQueue;
                    } else {
                        result = firstQueue;
                    }
                    break;
                }
            }
            int index = 0;
            while (!result.isEmpty()) {
                pascalTriangle[index++] = result.poll();
            }
            return pascalTriangle;
        }
    */
    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();
        System.out.println(Arrays.toString(triangle.pascalTriangleRow(4)));
    }
}
