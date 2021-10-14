package com.mahiznan.challenges;

public class MaxMeetingsInOneRoom {

    static void maxPossibleMeetings(int[] startTime, int[] endTime) {
        for (int i = 0; i < endTime.length; i++) {
            for (int j = i + 1; j < endTime.length; j++) {
                if (endTime[j] < endTime[i]) {
                    //swap i and j
                    int t = endTime[j];
                    endTime[j] = endTime[i];
                    endTime[i] = t;

                    t = startTime[j];
                    startTime[j] = startTime[i];
                    startTime[i] = t;
                }
            }
        }

        int occupiedTill = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] > occupiedTill) {
                occupiedTill = endTime[i];
                System.out.println(i + ". " + startTime[i] + "->" + endTime[i]);
            }
        }

    }

    public static void main(String[] args) {

        int[] startTime = {1, 3, 0, 5, 8, 5}, endTime = {2, 4, 6, 7, 9, 9};
//        int[] startTime = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924},
//                endTime = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
        maxPossibleMeetings(startTime, endTime);
    }
}
