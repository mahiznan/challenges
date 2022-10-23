package com.mahiznan.challenges.amazon;

import java.util.ArrayDeque;
import java.util.Queue;

/*
A number is called a stepping number if all adjacent digits have an absolute difference of 1,
e.g. '321' is a Stepping Number while 421 is not. Given two integers n and m,
find the count of all the stepping numbers in the range [n, m].

Input: n = 0, m = 21
Output: 13
Explanation: Stepping no's are 0 1 2 3 4 5
6 7 8 9 10 12 21

Input: n = 10, m = 15
Output: 2
Explanation: Stepping no's are 10, 12

Your Task:
You don't need to read input or print anything.
Your task is to complete the function steppingNumbers() which takes the integer n and integer m
as input parameters and returns the number of stepping numbers in the range between n and m.

Expected Time Complexity: O(log(M))
Expected Auxiliary Space: O(SN) where
SN is the number of stepping numbers in the range

Constraints:
0 ≤ N < M ≤ 107
 */
public class SteppingNumbers {

    static int steppingNumbersApproach2(int n, int m) {
        //This one exceeds the given time limit
        int count = 0;
        for (int i = n; i <= m; i++) {
            if (isSteppingNumber(i)) {
                count++;
            }
        }
        return count;
    }

    static int steppingNumbersApproach1(int n, int m) {
        return countSteppingNumbers(m) - countSteppingNumbers(n - 1);
    }

    private static boolean isSteppingNumber(int n) {
        int a = n % 10;
        n /= 10;
        while (n != 0) {
            int t = (a - n % 10);
            if (t != 1 && t != -1)
                return false;
            a = n % 10;
            n /= 10;
        }
        return true;
    }

    static int countSteppingNumbers(int x) {
        Queue<Integer> queue = new ArrayDeque<>();

        if (x < 0) return 0;
        if (x < 10) return x + 1;

        for (int i = 1; i < 10; i++) queue.add(i);

        int count = 1;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;

            int num1 = num * 10 + (num % 10 + 1);
            int num2 = num * 10 + (num % 10 - 1);

            if (num % 10 == 0) {
                if (num1 <= x) queue.add(num1);
            } else if (num % 10 == 9) {
                if (num2 <= x) queue.add(num2);
            } else {
                if (num1 <= x) queue.add(num1);
                if (num2 <= x) queue.add(num2);
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int n = 0, m = 21;
        System.out.println(steppingNumbersApproach1(n, m));
        System.out.println(steppingNumbersApproach2(n, m));
    }
}
