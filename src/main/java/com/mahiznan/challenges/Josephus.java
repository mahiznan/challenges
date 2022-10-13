package com.mahiznan.challenges;

/*
Given the total number of persons n and a number k which indicates that k-1 persons
are skipped and kth person is killed in circle in a fixed direction.

The task is to choose the safe place in the circle so that when you perform
these operations starting from 1st place in the circle, you are the last one remaining and survive.

Input:
n = 3 k = 2
Output: 3
Explanation: There are 3 persons so
skipping 1 person i.e 1st person 2nd
person will be killed. Thus the safe
position is 3.

 */
public class Josephus {
    public static int josephus(int n, int k) {
        int p = 0, t = n;
        while (n > 1) {
            p = p == 0 ? (p + k + 1) % t : (p + k) % t;
            if (p == 0) {
                ++p;
            }
            n--;
        }
        return p;
    }

    public static void main(String[] args) {
//        System.out.println(josephus(5, 3));
        System.out.println(josephus(3, 2));
//        System.out.println(josephus(8,2 ));
    }
}
