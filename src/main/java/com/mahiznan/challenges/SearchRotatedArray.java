package com.mahiznan.challenges;


public class SearchRotatedArray {

    static int findElement(int[] arr, int key, int start, int end) {

        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            boolean validRight = arr[mid] < arr[end];
            boolean validLeft = arr[start] < arr[mid];
            if (validRight) {
                if (key >= arr[mid + 1] && key <= arr[end]) {
                    return findElement(arr, key, mid + 1, end);
                }
                return findElement(arr, key, start, mid - 1);
            } else if (validLeft) {
                if (key >= arr[start] && key <= arr[mid - 1]) {
                    return findElement(arr, key, start, mid - 1);
                }
                return findElement(arr, key, mid + 1, end);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
//        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        int key = 1;
        System.out.println(findElement(arr, key, 0, arr.length - 1));
    }


}
