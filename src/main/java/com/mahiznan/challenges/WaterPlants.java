package com.mahiznan.challenges;

/*
A gallery with plants is divided into n parts, numbered : 0,1,2,3...n-1.
There are provisions for attaching water sprinklers at every partition.
A sprinkler with range x at partition i can water all partitions from i-x to i+x.
Given an array gallery[ ] consisting of n integers, where gallery[i] is the range of
sprinkler at partition i (power==-1 indicates no sprinkler attached),
return the minimum number of sprinklers that need to be turned on to water the complete gallery.
If there is no possible way to water the full length using the given sprinklers, print -1.

Example 1:

Input:
n = 6
gallery[ ] = {-1, 2, 2, -1, 0, 0}
Output:
2
Explanation: Sprinklers at index 2 and 5
can water the full gallery, span of
sprinkler at index 2 = [0,4] and span
â€‹of sprinkler at index 5 = [5,5].
Example 2:

Input:
n = 9
gallery[ ] = {2, 3, 4, -1, 2, 0, 0, -1, 0}
Output:
-1
Explanation: No sprinkler can throw water
at index 7. Hence all plants cannot be
watered.
Example 3:

Input:
n = 9
gallery[ ] = {2, 3, 4, -1, 0, 0, 0, 0, 0}
Output:
3
Explanation: Sprinkler at indexes 2, 7 and
8 together can water all plants.
Your task:
Your task is to complete the function min_sprinklers() which takes the array gallery[ ]
and the integer n as input parameters and returns the value to be printed.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ n ≤ 105
gallery[i] ≤ 50

 */


// C++ program for the above approach

/*

int minSprinklers(int arr[], int N)
        {
        // Stores the leftmost and rightmost
        // point of every sprinklers
        vector<pair<int, int> > V;
        // Traverse the array arr[]
        for (int i = 0; i < N; i++) {
        if (arr[i] > -1) {
        V.push_back(
        pair<int, int>(i - arr[i], i + arr[i]));
        }
        }
        // Sort the array sprinklers in
        // ascending order by first element
        sort(V.begin(), V.end());

        // Stores the rightmost range
        // of a sprinkler
        int maxRight = 0;
        // Stores minimum sprinklers
        // to be turned on
        int res = 0;

        int i = 0;

        // Iterate until maxRight is
        // less than N
        while (maxRight < N) {

        // If i is equal to V.size()
        // or V[i].first is greater
        // than maxRight

        if (i == V.size() || V[i].first > maxRight) {
        return -1;
        }
        // Stores the rightmost boundary
        // of current sprinkler
        int currMax = V[i].second;

        // Iterate until i+1 is less
        // than V.size() and V[i+1].first
        // is less than or equal to maxRight
        while (i + 1 < V.size()
        && V[i + 1].first <= maxRight) {

        // Increment i by 1
        i++;
        // Update currMax
        currMax = max(currMax, V[i].second);
        }

        // If currMax is less than the maxRight
        if (currMax < maxRight) {
        // Return -1
        return -1;
        }
        // Increment res by 1
        res++;

        // Update maxRight
        maxRight = currMax + 1;

        // Increment i by 1
        i++;
        }
        // Return res as answer
        return res;
        }

 */



public class WaterPlants {
    static int min_sprinklers(int[] gallery, int n) {
        return -1;
    }

    public static void main(String[] args) {
        int[] gallery = {-1, 2, 2, -1, 0, 0};
        System.out.println(min_sprinklers(gallery, gallery.length));
    }
}
