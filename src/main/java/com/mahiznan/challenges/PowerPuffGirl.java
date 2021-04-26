package com.mahiznan.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class PowerPuffGirl {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Long[] available = new Long[n];
        Long[] required = new Long[n];
        for (int i = 0; i < n; i++) {
            required[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            available[i] = scanner.nextLong();
        }

//        Test Case 1
//        int n = 4;
//        int[] required = {2, 5, 6, 3};
//        int[] available = {20, 40, 90, 50};

//        Test Case 2
//        int n = 4;
//        int[] required = {0, 5, 0, 1};
//        int[] available = {1, 11, 3, 4};


//        int n =8;
//        long[] required={2,0,4,7,3,9,5,2};
//        long[] available={60,75,44,96,127,324,76,41};

        System.out.println(calculatePowerPuffGirl(n, required, available));
    }

    private static long calculatePowerPuffGirl(int n, Long[] required, Long[] available) {
        for (int i = 0; i < n; i++) {
            if (required[i] > available[i]) {
                return 0;
            } else if (required[i] == 0) {
                available[i] = -1l;
            }else {
                available[i]=available[i]/required[i];
            }
        }
        Arrays.sort(available);
        for(int i=0;i<n;i++){
            if(available[i]>0)
                return available[i];
        }
        return 0;
    }
}
