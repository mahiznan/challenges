package com.mahiznan.challenges;

import java.util.Arrays;

public class SmallestPositiveInteger {
    static long smallestpositive(long[] array, int n) {
        Arrays.sort(array);
        long res = 1;
        for (int i = 0; i < n && array[i] <= res; i++)
            res += array[i];
        return res;
    }

    public static void main(String[] args) {
//        long[] arr = {1, 1, 3, 4};
        long[] arr = {1, 2, 3, 6, 10, 11, 15};
//        long[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15};
        int n = arr.length;
        System.out.println(smallestpositive(arr, n));
    }
}

/*

If elements from 0 to (i-1) can represent 1 to ‘res-1’,
then elements from 0 to i can represent from 1 to ‘res + arr[i] – 1’
be adding ‘arr[i]’ to all subsets that represent 1 to ‘res’

 */
