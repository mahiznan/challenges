package com.mahiznan.faang;

public class SubSequence {

    public static void main(String[] args) {

        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        char[] chars = s.toCharArray();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int k = 0;
            while (k < chars.length) {
                if (chars[k] == word.charAt(k)) {
                    k = k + 1;
                }
            }


            System.out.println(words[i]);
        }

    }
}
