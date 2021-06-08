package com.mahiznan.challenges;

/*
 Given a 5x6 snakes and ladders board, find the minimum number of dice throws required
 to reach the destination or last cell (30th cell) from the source (1st cell).

You are given an integer N denoting the total number of snakes
and ladders and an array arr[] of 2*N size
where 2*i and (2*i + 1)th values denote the starting and ending point
respectively of ith snake or ladder.

Input:
N = 8
arr[] = {3, 22, 5, 8, 11, 26, 20, 29,
       17, 4, 19, 7, 27, 1, 21, 9}
Output: 3
Explanation:
The given board is the board shown
in the figure. For the above board
output will be 3.
a) For 1st throw get a 2.
b) For 2nd throw get a 6.
c) For 3rd throw get a 2.

 */

import java.util.Scanner;
//TODO: PENDING
public class SnakeLadder {

    static int minThrow(int N, int arr[]) {
        int position = 0, snakeOrLaddarPos = 0, rotation = 0;

        for (snakeOrLaddarPos = 0; snakeOrLaddarPos <= arr.length - 1; snakeOrLaddarPos += 2) {



        }


        return N;
    }

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N * 2];
        for (int i = 0; i < N * 2; i++) {
            arr[i] = scanner.nextInt();
        }
        */
        int N = 8;
        int[] arr = {3, 22, 5, 8, 11, 26, 20, 29,
                17, 4, 19, 7, 27, 1, 21, 9};
        System.out.println(minThrow(N, arr));
    }
}

