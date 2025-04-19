package com.mahiznan.neet150;

import java.util.*;

public class Q04_GroupAnagram {
    public static void main(String[] args) {
//        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
//        System.out.println(groupAnagrams(strs));

        String[] strs = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        System.out.println(groupAnagrams(strs));
        // [["buy"],["duh","ill"],["bar"],["cab"],["max"],["doc"],["may"],["tin"],["pew"]]
        // [["duh"],["max"],["tin"],["cab"],["bar"],["buy"],["pew"],["may"],["doc"],["ill"]]
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            List<String> list = map.getOrDefault(sortedString, new ArrayList<>());
            list.add(str);
            map.put(sortedString, list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

}
