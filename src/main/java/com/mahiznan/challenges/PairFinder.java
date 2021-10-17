package com.mahiznan.challenges;

import java.util.HashSet;
import java.util.Set;

public class PairFinder {

    //Approach 1 - Recursion
    static boolean findSum(int[] numbers, int sum, int pos, int current) {
        if (pos == numbers.length) {
            return false;
        }
        if (current != 0 && current + numbers[pos] == sum)
            return true;
        else if (current == 0 && current + numbers[pos] < sum) {
            boolean found = findSum(numbers, sum, pos + 1, current + numbers[pos]);
            if (found) {
                return true;
            }
        }
        return findSum(numbers, sum, pos + 1, current);
    }

    static boolean isPairExist(int[] numbers, int sum) {
        return findSum(numbers, sum, 0, 0);
    }

    //Approach 2
    static boolean findPair(int[] numbers, int sum) {
        Set<Integer> numberSet = new HashSet<>();
        for (int i : numbers) {
            numberSet.add(i);
        }
        for (Integer i : numberSet) {
            if (numberSet.contains(sum - i))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] numbers = {5, 7, 1, 2, 8, 4, 3};
        int sum = 19;
//        System.out.println(isPairExist(numbers, sum));
        System.out.println(findPair(numbers, sum));

    }
}
