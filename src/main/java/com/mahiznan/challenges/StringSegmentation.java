package com.mahiznan.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {


    //Approach 1 Recursive
    static boolean canFormStringFromDictionary(String s, Set<String> dictionary) {
        if (dictionary.contains(s))
            return true;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("Checking for " + i);
            if (dictionary.contains(s.substring(0, i)) && canFormStringFromDictionary(s.substring(i), dictionary)) {
                return true;
            }
        }
        return false;
    }

    //Approach 2 Recursive with memorization
    static boolean canFormStringFromDictionaryApproach2(String s, Set<String> dictionary, int[] memory) {
        System.out.println("Checking for " + s);
        int n = s.length();
        if (n == 0)
            return true;
        if (memory[n] == -1) {
            memory[n] = 0;
            for (int i = 0; i <= n; i++) {
                String subString1 = s.substring(0, i);
                System.out.println("Checking for subString " + subString1);
                if (dictionary.contains(subString1) && canFormStringFromDictionaryApproach2(s.substring(i), dictionary, memory)) {
                    memory[n] = 1;
                    return true;
                }
            }
        }
        System.out.println("Solved already for " + s);
        return memory[n] == 1;
    }

    static boolean canFormStringDP(String string, Set<String> dictionary, int[] memory) {
        int n = string.length();
        if (n == 0)
            return true;
        if (memory[n] == -1) {
            memory[n] = 0;
            for (int i = 0; i <= string.length(); i++) {
                String subString = string.substring(0, i);
                if (dictionary.contains(subString) && canFormStringDP(string.substring(i), dictionary, memory)) {
                    memory[n] = 1;
                    return true;
                }
            }
        } else {
            System.out.println("Already solved for " + string);
        }
        if (n == 151) {
            System.out.println("Pause");
        }
        return memory[n] == 1;
    }

    static boolean canFormStringFromDictionaryDP(String s, Set<String> dictionary) {
        if (s.length() == 0) {
            return true;
        }
        int[] lookup = new int[s.length() + 1];
        Arrays.fill(lookup, -1);
        if (canFormStringFromDictionaryApproach2(s, dictionary, lookup)) {
            System.out.print("The string can be segmented ");
            return true;
        } else {
            System.out.print("The string can't be segmented ");
            return false;
        }
    }


    //Practice
    static boolean canFormString_Practice(String s, Set<String> dictionary) {
        System.out.println("Checking for " + s);
        if (dictionary.contains(s))
            return true;
        for (int i = 0; i < s.length(); i++) {
            if (dictionary.contains(s.substring(0, i)) &&
                    canFormString_Practice(s.substring(i), dictionary))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {

//        Test Case 1
//        final Set<String> dictionary = new HashSet<>(Arrays.asList("apple", "apple", "pear", "pie"));
//        String s = "applepie";
//        String s = "applepeer";
//        System.out.println(canFormStringFromDictionaryDP(s, dictionary));


//        Test Case 2
//        final Set<String> dictionary = new HashSet<>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango"));
//        String s = "ilikesamsung";
//        String s = "gomangomango";
//        System.out.println(canFormStringFromDictionaryDP(s, dictionary));

//        Test Case 3
//        final Set<String> dictionary = new HashSet<>(Arrays.asList("go", "goal", "goals", "special"));
//        String s = "goalspecial";
//        System.out.println(canFormStringFromDictionaryDP(s, dictionary));

//        Test Case 3
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        final Set<String> dictionary = new HashSet<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        int[] memory = new int[s.length() + 1];
        Arrays.fill(memory, -1);
//        System.out.println(canFormStringFromDictionaryDP(s, dictionary));
        System.out.println(canFormStringDPPractice(s, dictionary, memory));
//        System.out.println(canFormString_Practice(s, dictionary));
    }

    private static boolean canFormStringDPPractice(String s, Set<String> dictionary, int[] memory) {
        int n = s.length();
        if (n == 0)
            return true;
        if (memory[n] == -1) {
            memory[n] = 0;
            for (int i = 0; i <= n; i++) {
                if (dictionary.contains(s.substring(0, i)) && canFormStringDPPractice(s.substring(i), dictionary, memory))
                    memory[n] = 1;
            }
        }
        return memory[n] == 1;

    }
}
