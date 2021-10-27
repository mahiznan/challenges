package com.mahiznan.challenges;

public class RotateArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 3;
        printArray(array);
//        rotate(array, k, array.length);
        rotatePractice(array, k, array.length);
        printArray(array);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    static void rotatePractice(int[] array, int d, int n) {
        d = d % n;
        int i, j, k, temp;
        int gcd = gcd(n, d);
        for (i = 0; i < gcd; i++) {
            j = i;
            temp = array[j];
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }

    }


    static void rotate(int[] array, int d, int n) {

        d = d % n;
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            j = i;
            temp = array[i];
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
            printArray(array);
        }

    }

    static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
