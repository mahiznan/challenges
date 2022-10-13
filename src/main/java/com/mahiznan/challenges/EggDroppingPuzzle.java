package com.mahiznan.challenges;

public class EggDroppingPuzzle {

    private static int dropEgg(int startIndex, int endIndex, int eggs) {
        System.out.println("Start Index " + startIndex + ", End Index " + endIndex + ", Eggs: " + eggs);
        if (eggs == 0 || startIndex >= endIndex)
            return 0;
        int median = (startIndex + endIndex) / 2;
        return 1 + Math.max(dropEgg(startIndex, median - 1, eggs - 1), dropEgg(median + 1, endIndex, eggs));
    }

    public static void main(String[] args) {
        int N = 2, F = 10;
        System.out.println(dropEgg(1, 10, 2));
    }
}
