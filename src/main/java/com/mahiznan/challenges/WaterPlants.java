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


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WaterPlants {
    static int min_sprinklers(int[] gallery, int n) {

        //2, 3, 4, -1, 0, 0, 0, 0, 0

        List<List<Integer>> sprinklers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            if (gallery[i] != -1) {
                row.add(Math.max(0, i - gallery[i]));
                row.add(Math.min(i + gallery[i], n - 1));
                sprinklers.add(row);
            }
        }

        /*for (List<Integer> row : sprinklers) {
            for (Integer i : row) {
                System.out.print(i);
            }
            System.out.println();
        }*/
//        sprinklers.sort( (l1, l2) -> l1.get(0).compareTo( l2.get(0) ) );

        sprinklers.sort(Comparator.comparing(l -> l.get(0)));
/*
        System.out.println("After");
        for (List<Integer> row : sprinklers) {
            for (Integer i : row) {
                System.out.print(i);
            }
            System.out.println();
        }*/


        int curr = 0, ON = 0, i = 0;
        // i = No Of Sprinklers Used
        //curr = Current range
        int maxRange = 0;
        //System.out.println("No of sprinklers " + sprinklers.size());
        // 2, 3, 4, -1, 0, 0, 0, 0, 0
        while (curr < n) {
            if (sprinklers.size() <= i || curr < sprinklers.get(i).get(0))
                return -1;
            maxRange = sprinklers.get(i).get(1);
            while (i < sprinklers.size() - 1 && sprinklers.get(i + 1).get(0) <= curr) {
                ++i;
                maxRange = Math.max(sprinklers.get(i).get(1), maxRange);
                //System.out.println("Max Range is " + maxRange + " for " + sprinklers.get(i) + " at i " + i);
            }
            if (maxRange < curr)
                return -1;
            ++ON;
            ++i;
            curr = maxRange + 1;
        }
        return ON;

    }

    static int getMinSprinklers(int[] range, int n) {

        //-1, 2, 2, -1, 0, 0
        int sprinklersCount = 0;
        List<List<Integer>> sprinklers = new ArrayList<>();
        for (int i = 0; i < range.length; i++) {
            if (range[i] != -1) {
                List<Integer> row = new ArrayList<>();
                row.add(Math.max(0, i - range[i]));
                row.add(Math.min(i + range[i], n - 1));
                sprinklers.add(row);
            }
        }

        //-1, 2, 2, -1, 0, 0

        /*for (List<Integer> row : sprinklers) {
            for (Integer i : row) {
                System.out.print(i);
            }
            System.out.println();
        }*/

        sprinklers.sort((o1, o2) -> Integer.compare(o1.get(0), o2.get(0)));


        int curr = 0, i = 0, maxRange;
        while (curr < n) {
            if (i >= sprinklers.size() || sprinklers.get(i).get(0) > curr)
                return -1;
            maxRange = sprinklers.get(i).get(1);
            while (i < sprinklers.size() - 1 && sprinklers.get(i + 1).get(0) <= curr) {
                i++;
                maxRange = Math.max(sprinklers.get(i).get(1), maxRange);
            }
            if (maxRange < curr)
                return -1;
            i++;
            sprinklersCount++;
            curr = maxRange + 1;
        }
        return sprinklersCount;

    }


    static int minSprinklersPractice(int[] gallery, int n) {
        List<List<Integer>> sprinklers = new ArrayList<>();

        for (int i = 0; i < gallery.length; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(Math.max(0, i - gallery[i]));
            row.add(Math.min(i + gallery[i], n - 1));
            sprinklers.add(row);
        }
        int ON = 0, currPosition = 0, i = 0, maxRange = 0;

        sprinklers.sort(Comparator.comparingInt(o -> o.get(0)));
        while (currPosition < n) {
            if (i >= sprinklers.size() || sprinklers.get(i).get(0) > currPosition)
                return -1;
            maxRange = sprinklers.get(i).get(1);
            while (i < sprinklers.size() - 1 && sprinklers.get(i + 1).get(0) <= currPosition) {
                i++;
                maxRange = Math.max(maxRange, sprinklers.get(i).get(1));
            }
            if (maxRange < currPosition)
                return -1;
            i++;
            ON++;
            currPosition = maxRange + 1;
        }

        return ON;
    }


    public static void main(String[] args) {
        int[] gallery = {-1, 2, 2, -1, 0, 0};
//        int[] gallery = {2, 3, 4, -1, 2, 0, 0, -1, 0};
//        int[] gallery = {2, 3, 4, -1, 0, 0, 0, 0, 0};
        System.out.println(min_sprinklers(gallery, gallery.length));
        System.out.println(getMinSprinklers(gallery, gallery.length));
        System.out.println(minSprinklersPractice(gallery, gallery.length));
    }
}
