package com.mahiznan.challenges.amazon;

/*

Given a Bucket having a capacity of N litres and the task is to determine that
by how many ways you can fill it using two bottles of capacity of 1 Litre and 2 Litre only.
Find the answer modulo 108.

Input:
3
Output:
3
Explanation:
Let O denote filling by 1 litre bottle and
T denote filling by 2 litre bottle.
So for N = 3, we have :
{OOO,TO,OT}. Thus there are 3 total ways.

Input:
4
Output:
5
Explanation:
Let O denote filling by 1 litre bottle and
T denote filling by 2 litre bottle.
So for N = 4, we have :
{TT,OOOO,TOO,OTO,OOT} thus there are 5 total ways.
 */
public class FillingBucket {
    public static void main(String[] args) {
        int N = 8223;
        System.out.println(fillingBucket(N));
    }

    static int fillingBucket(int N) {
        if (N < 3)
            return N;
        int prev1 = 2, prev2 = 1;

        for (int i = 3; i <= N; i++) {
            int curr = (prev1 % 100000000 + prev2 % 100000000) % 100000000;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }


}
