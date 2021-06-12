package com.mahiznan.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class BeybladeChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] members = new int[t];
        int[][] teamAStrengths = new int[t][];
        int[][] teamBStrengths = new int[t][];
        for (int i = 0; i < t; i++) {
            members[i] = scanner.nextInt();
            teamAStrengths[i] = new int[members[i]];
            teamBStrengths[i] = new int[members[i]];
            for (int j = 0; j < members[i]; j++) {
                teamAStrengths[i][j] = scanner.nextInt();
            }
            for (int j = 0; j < members[i]; j++) {
                teamBStrengths[i][j] = scanner.nextInt();
            }
        }
//        Test case 1
//        int n = 3;
//        int[] teamA = {30, 50, 20};
//        int[] teamB = {25, 60, 40};
        for (int i = 0; i < t; i++) {
            System.out.println(beybladeChampionship(members[i], teamAStrengths[i], teamBStrengths[i]));
        }
    }




    private static int beybladeChampionship(int n, int[] teamA, int[] teamB) {
        Arrays.sort(teamA);
        Arrays.sort(teamB);
        int r = 0;
        for (int i = 0, j = 0; i < n; ) {
            if (teamA[i] > teamB[j]) {
                r++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return r;
    }
}
