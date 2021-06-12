package com.mahiznan.challenges;
/*
Given an array arr[] of N positive integers.
Find an integer denoting the maximum XOR subset value in the given array arr[].

Example 1:

Input :
N = 3
arr[] = {2, 4, 5}
Output : 7
Explanation :
The subset {2, 5} has maximum
subset XOR value.
Example 2 :

Input :
N= 3
arr[] = {9, 8, 5}
Output : 13
Explanation :
The subset {8, 5} has maximum
subset XOR value.
Your Task :
You don't need to read input or print anything. Your task is to complete the function maxSubarrayXOR() which takes the array and an integer as input and returns the maximum subset XOR value.

Expected Time Complexity : O(N*Log(max(arr[i])))
Expected Auxiliary Space : O(1)

Constraints :
1 <= N <= 105
1 <= arr[i] <= 106
 */

import java.util.ArrayList;

public class MaximumSubsetXOR {

    /*
    String a = Length is longer than or equal to length of b
    String a = Length is shorter than or equal to length of a
     */
    static ArrayList<Integer> XOR(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<>();
        // 1000
        //  101
        int p1 = 0, p2 = 0, i = 0;
        while (p2 < b.size()) {
            if (a.get(p1) + b.get(p2) == 1) {
                res.add(1);
            } else {
                res.add(0);
            }
            i++;
            p2++;
            p1++;
        }
        while (p1 < a.size()) {
            if (a.get(p1) == 1) {
                res.add(1);
            } else {
                res.add(0);
            }
            p1++;
        }
        return res;
    }


    static int calculateXOR(int[] data) {
        ArrayList<Integer> total;
        total = getBinary(data[0]);
        System.out.println(total);
        for (int i = 1; i < data.length; i++) {
            ArrayList<Integer> nextValue = getBinary(data[i]);
            System.out.println("Adding " + nextValue);
            if (total.size() > nextValue.size())
                total = XOR(total, nextValue);
            else {
                total = XOR(nextValue, total);
            }
            System.out.println(total);
        }
        return getDecimal(total);
    }


    static ArrayList<Integer> getBinary(int n) {
//        int noOfBits = (int) (Math.log(n) / Math.log(2) + 1);
        ArrayList<Integer> binary = new ArrayList<>();
        int t = n, i = 0;
        while (n > 0) {
            int r = n % 2;
            binary.add(r);
            n = n / 2;
            i++;
        }
        return binary;
    }

    static int getDecimal(ArrayList<Integer> binary) {
        int res = 0;
        for (int i = 0; i < binary.size(); i++) {
            res += binary.get(i) * Math.pow(2, i);
        }

        return res;
    }


    static void combinationUtil(int arr[], int n, int r,
                                int index, int data[], int i) {
        // Current combination is ready to be printed,
        // print it
        if (index == r) {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println("");
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n)
            return;

        // current is included, put next at next
        // location
        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1,
                data, i + 1);

        // current is excluded, replace it with
        // next (Note that i+1 is passed, but
        // index is not changed)
        combinationUtil(arr, n, r, index, data, i + 1);
    }

    // The main function that prints all combinations
    // of size r in arr[] of size n. This function
    // mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r) {
        // A temporary array to store all combination
        // one by one
        int data[] = new int[r];

        // Print all combination using temporary
        // array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }


    static int calculateMaxSubarrayXORValue(int arr[], int n, int r,
                                            int index, int data[], int i, int max) {
        // Current combination is ready to be printed,
        // print it
        if (index == r) {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println("");
            int tot = calculateXOR(data);
            System.out.println("XOR Value is " + tot);

            return tot;
        }

        // When no more elements are there to put in data[]
        if (i >= n)
            return max;

        // current is included, put next at next
        // location
        data[index] = arr[i];
        int tempMax = calculateMaxSubarrayXORValue(arr, n, r, index + 1,
                data, i + 1, max);
        if (tempMax > max) {
            max = tempMax;
        }

        // current is excluded, replace it with
        // next (Note that i+1 is passed, but
        // index is not changed)
        tempMax = calculateMaxSubarrayXORValue(arr, n, r, index, data, i + 1, max);
        if (tempMax > max) {
            max = tempMax;
        }
        return max;
    }

    public static int maxSubarrayXOR(int arr[], int N) {
        int max = 0;
        for (int i = 2; i <= N; i++) {
            int[] data = new int[i];
            int tempMax = calculateMaxSubarrayXORValue(arr, N, i, 0, data, 0, max);
            System.out.println("Current Max for " + i + " is " + tempMax);
            if (tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[100004];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
*/
//        int n = 3;
//        int[] a = {2, 4, 5};

//        int n = 3;
//        int[] a = {9, 8, 5};

        int n = 11;
        int[] a = {1, 2, 3, 4, 5, 6, 22, 33, 44, 22, 111};

//        127

//        78

//        printCombination(a, n, 2);
//        getBinary(7);
//        calculateXOR(5, 2);
//        getBinary(13);
//        calculateXOR(8, 5);
        int[] data = {6, 22, 11};
        System.out.println(calculateXOR(data));

//        System.out.println(maxSubarrayXOR(a, n));
    }
}

