package org.example;


/*

add - method should add the value into the list
count - method should return the number of occurrences for the given value

Example:
add(1);
add(2);
add(3);
add(4);
add(1);

count(1) -> 2
count(2) -> 1
count(5) -> 0

 */

import java.util.HashMap;
import java.util.Map;

class CustomList {
    Map<Integer, Integer> numberMap = new HashMap<>();
//    List<Integer> numberList = new ArrayList<>();

    void add(int i) {
        if (numberMap.containsKey(i)) {
            numberMap.put(i, numberMap.get(i) + 1);
        } else {
            numberMap.put(i, 1);

        }
    }

    void replace(int n, int s) {
        if (!numberMap.containsKey(n) || numberMap.get(n) < 1)
            return;
        if (numberMap.containsKey(s)) {
            numberMap.put(s, numberMap.get(s) + 1);
        } else {
            numberMap.put(s, 1);
        }
        numberMap.put(n, numberMap.get(n) - 1);
    }

    int findMax() //- return number with most occurrence
    {
        int maxOccurrence = 0, n = -1;

        for (Map.Entry<Integer, Integer> item : numberMap.entrySet()) {
            if (item.getValue() > maxOccurrence) {
                maxOccurrence = item.getValue();
                n = item.getKey();
            }
        }
        return n;


    }


    int count(int n) {
        if (numberMap.containsKey(n))
            return numberMap.get(n);
        return 0;
        /*
                int count = 0;
        for (int i : numberList) {
            if (i == n)
                count++;
        }
        return count;*/
    }


}

public class VirtusaChallenge {


    public static void main(String[] args) {
        CustomList customList = new CustomList();
        customList.add(1);
        customList.add(1);
        customList.add(2);
        customList.add(3);
        customList.add(3);
        customList.add(4);
        customList.add(4);
        customList.add(4);

        System.out.println(customList.count(1));
        customList.replace(1, 7);
        System.out.println(customList.count(1));
        System.out.println(customList.count(7));
        customList.replace(1, 7);
        customList.replace(1, 7);
        System.out.println(customList.count(1));
        System.out.println(customList.count(7));

        System.out.println(customList.findMax());

        //        System.out.println(customList.count(2));
//        System.out.println(customList.count(5));


    }
}
