package com.mahiznan.challenges;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {

    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int currentLeader = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= currentLeader) {
                leaders.add( arr[i]);
                currentLeader = arr[i];
            }
        }
       Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 2, 2};
//        int[] arr = {16,17,4,3,5,2};
        int[] arr = {1, 2, 3, 4, 0};
        ArrayList<Integer> res = leaders(arr, arr.length);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
