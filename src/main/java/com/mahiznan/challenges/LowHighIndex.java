package com.mahiznan.challenges;

public class LowHighIndex {
    static int getLowIndex(int[] array, int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || x > array[mid - 1]) && x == array[mid])
                return mid;
            else if (x > array[mid]) {
                return getLowIndex(array, (mid + 1), high, x);
            } else
                return getLowIndex(array, low, (mid - 1), x);
        }
        return -1;
    }

    static int getHighIndex(int[] array, int v, int start, int end) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if ((mid == array.length - 1 || v < array[mid + 1]) && array[mid] == v) {
                return mid;
            }
            if (v < array[mid])
                return getHighIndex(array, v, start, mid - 1);
            return getHighIndex(array, v, mid + 1, end);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        int v = 1;
        System.out.println("Low Index " + getLowIndex(arrays, 0, arrays.length - 1, v));
        System.out.println("High Index " + getHighIndex(arrays, v, 0, arrays.length - 1));
    }
}
