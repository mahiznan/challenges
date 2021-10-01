package com.mahiznan.challenges;

import java.util.*;

class NumberContainer {

    Map<Long, Long> container = new HashMap<>();

    public void insertOrReplace(Long index, Long number) {
        container.put(index, number);
    }

    public Long findSmallestIndex(Long number) {

        //Approach 1
        if (container.isEmpty() || !container.containsValue(number))
            return -1L;
        long index = Long.MAX_VALUE;
        for (Map.Entry<Long, Long> e : container.entrySet()) {
            index = e.getValue().equals(number) && index > e.getKey() ? e.getKey() : index;
        }
        System.out.println("Approach 1  Index value is " + index);

        //Approach 2
        Set<Map.Entry<Long, Long>> containerSet = container.entrySet();
        Map.Entry<Long, Long> m = containerSet.stream().filter(e -> e.getValue().equals(number)).min(Map.Entry.comparingByKey()).get();
        index = m.getKey();
        System.out.println("Approach 2  Index value is " + index);


        //Approach 3
        Optional<Long> v = containerSet.stream()
                .filter(e -> e.getValue().equals(number))
                .map(Map.Entry::getKey)
                .min(Long::compare);

        index = v.isPresent() ? v.get() : -1;
        System.out.println("Approach 3  Index value is " + index);


        return index;
    }

    public Long findSmallestIndex(NavigableMap<Long, Long> navigableMap, Long number) {
        return number;
    }


    public void print() {
        for (Map.Entry<Long, Long> item : container.entrySet()) {
            System.out.println(container.get(item.getKey()));
        }
    }
}


public class HashMapChallenge {

    public static void main(String[] args) {
        NumberContainer numberContainer = new NumberContainer();
        numberContainer.insertOrReplace(10L, 10L);
        numberContainer.insertOrReplace(2L, 20L);
        numberContainer.insertOrReplace(9L, 30L);
        numberContainer.insertOrReplace(1L, 15L);
        numberContainer.insertOrReplace(12L, 15L);
        numberContainer.insertOrReplace(1L, 15L);
        numberContainer.insertOrReplace(2L, 5L);
//        numberContainer.print();
//        System.out.println("Print Over");
//        System.out.println(numberContainer.findSmallestIndex(30L));

        //Approach 4


//        SortedMap<Long, Long> sortedMap = new TreeMap<>(Comparator.comparingInt(o -> ("" + o).length()));
        NavigableMap<Long, Long> sortedMap = new TreeMap<>();
        sortedMap.put(10L, 10L);
        sortedMap.put(21L, 20L);
        sortedMap.put(9L, 30L);
        sortedMap.put(1L, 15L);
        sortedMap.put(12L, 15L);
        sortedMap.put(1123L, 15L);
        sortedMap.put(113L, 15L);
        sortedMap.put(2L, 5L);
/*

        System.out.println("-----------");
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
        SortedMap<Long, Long> subMap = sortedMap.headMap(12L);
        for (Map.Entry<Long, Long> v : subMap.entrySet()) {
            System.out.println(v.getKey() + "-" + v.getValue());
        }
        System.out.println("-----------");
        SortedMap<Long, Long> tailMap = sortedMap.tailMap(12L);
        for (Map.Entry<Long, Long> v : tailMap.entrySet()) {
            System.out.println(v.getKey() + "-" + v.getValue());
        }
        System.out.println("-----------");
        SortedMap<Long, Long> rangMap = sortedMap.subMap(9L, 12L);
        for (Map.Entry<Long, Long> v : rangMap.entrySet()) {
            System.out.println(v.getKey() + "-" + v.getValue());
        }

        for (Map.Entry<Long, Long> v : sortedMap.entrySet()) {
            System.out.println(v.getKey() + "-" + v.getValue());
        }*/

        NavigableMap<Long, Long> navigableMap = new TreeMap<>();
        navigableMap.put(10L, 10L);
        navigableMap.put(26L, 20L);
        navigableMap.put(9L, 30L);
        navigableMap.put(12L, 15L);
        navigableMap.put(4L, 15L);
        navigableMap.put(19L, 15L);
        navigableMap.put(2L, 5L);
        for (Map.Entry<Long, Long> item : navigableMap.entrySet()) {
            System.out.println(item.getKey() + "=" + item.getValue());
        }

        System.out.println("-----------");
        System.out.println(navigableMap.floorKey(15L));
        System.out.println(navigableMap.ceilingKey(15L));

    }


}
