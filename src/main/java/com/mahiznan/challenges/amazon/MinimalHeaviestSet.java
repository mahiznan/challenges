package com.mahiznan.challenges.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimalHeaviestSet {

    static List<Integer> minimalHeavySetApproach2(List<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        long totalWeight = 0;
        for (Integer integer : arr) {
            totalWeight += integer;
            pq.offer(integer);
        }
        List<Integer> boxAElement = new ArrayList<>();
        long currentWeight = 0;
        for (int i = 0; i < arr.size(); i++) {
            int highWeight = pq.poll();
            currentWeight += highWeight;
            boxAElement.add(highWeight);
            if (currentWeight > totalWeight - currentWeight) {
                break;
            }
        }
        Collections.reverse(boxAElement);
        System.out.println(boxAElement.size());
        return boxAElement;
    }

    static List<Integer> minimalHeavySet(List<Integer> arr) {
        System.out.println(arr.size());
        List<Integer> result = new ArrayList<>();
        arr.sort(Integer::compareTo);
        int sum = 0;
        for (Integer integer : arr) {
            sum += integer;
        }
        int setA = 0, setB = sum;
        for (int i = arr.size() - 1; i >= 0; i--) {
            int number = arr.get(i);
            setA += number;
            setB -= number;
            result.add(number);
            if (setA > setB)
                break;
        }
        result.sort(Integer::compareTo);
        System.out.println(result.size());
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 99430; i++) {
            arr.add(5);
        }
        /*arr.add(3);
        arr.add(7);
        arr.add(5);
        arr.add(6);
        arr.add(2);*/
        minimalHeavySet(arr);
        minimalHeavySetApproach2(arr);
    }
}
