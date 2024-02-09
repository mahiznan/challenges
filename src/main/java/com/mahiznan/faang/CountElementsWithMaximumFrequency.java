package com.mahiznan.faang;

public class CountElementsWithMaximumFrequency {

    public int maxFrequencyElements(int[] nums) {
        int[] v = new int[101];
        int total = 0,cMax=0;
        for(int num:nums) {
            v[num] ++;
        }

        for (int i=1; i<101 ; i++)
        {
            if(v[i]!=0) {
                if(v[i] > cMax) {
                    total = v[i];
                    cMax = v[i];
                }
                else if (v[i] == cMax) {
                    total += v[i];
                }
            }
        }
        return total;
    }


    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 3, 1, 4};
        int[] nums = {1, 2, 3, 4, 5};
        CountElementsWithMaximumFrequency solution = new CountElementsWithMaximumFrequency();
        System.out.println(solution.maxFrequencyElements(nums));
    }
}
