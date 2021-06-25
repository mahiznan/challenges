package com.mahiznan.challenges;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReArrangeCharacters {
    public static String rearrangeCharacters(String str) {
        char[] input = str.toCharArray();

        Stack<Character> extraC = new Stack();

        char prC = input[0];
        for (int i = 1; i < input.length; i++) {
            System.out.println("Checking for " + input[i]);
            if (input[i] == prC) {
                extraC.push(input[i]);
            }
            prC = input[i];
        }

        while (!extraC.isEmpty()) {
            List<Integer> l = new LinkedList<>();
            System.out.println(extraC.pop());
        }


        return str;
    }


    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("geeksforgeeks"));
    }
}
