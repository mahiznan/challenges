package com.mahiznan.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Bubble {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
        int swap = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = 0; j < a.size() - 1; j++)
                if (a.get(j) > a.get(j + 1)) {
                    Collections.swap(a, j, j + 1);
                    swap++;
                }
        }
        System.out.println("Array is sorted in " + swap + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size() - 1));

    }

}

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Bubble.countSwaps(a);

        bufferedReader.close();
    }
}
/*
4
4 2 3 1
*/