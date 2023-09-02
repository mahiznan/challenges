package com.mahiznan.challenges;

import java.util.*;

public class MajorityElement {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 1, 2));
        System.out.println(majorityElement(arrayList));
    }

    static int majorityElement(final List<Integer> A) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer no : A) {
            if (countMap.containsKey(no))
                countMap.put(no, countMap.get(no) + 1);
            else
                countMap.put(no, 1);
        }
        int max = 0, value = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                value = entry.getKey();
            }
        }
        return value;
    }
}
