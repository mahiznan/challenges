package com.mahiznan.faang;

public class NDigitNumber {

    public static int countWays(int n) {
        double startingNumber = Math.pow(10, n - 1) + 7;
        double endingNumber = Math.pow(10, n) - 1;
//        System.out.println(startingNumber);
//        System.out.println(endingNumber);
        int count = 0;
        while (startingNumber < endingNumber) {
            System.out.println(startingNumber);
            count++;
            if (startingNumber + 10 > endingNumber) {
                break;
            }
            startingNumber += 10;
        }
        return count;
    }

    // 1 -> 1
    // 2 -> 18

    public static void main(String[] args) {
        System.out.println(countWays(2));
    }
}
