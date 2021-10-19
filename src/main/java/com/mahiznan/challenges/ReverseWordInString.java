package com.mahiznan.challenges;

public class ReverseWordInString {

    static void reverseWords(char[] s) {
        StringBuilder res = new StringBuilder();
        StringBuilder str = new StringBuilder(String.valueOf(s));
        str.reverse();
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res.append(t.reverse()).append(' ');
                t.setLength(0);
            } else
                t.append(str.charAt(i));
        }
        res.append(t.reverse());
        System.out.println(res);
    }

    public static void main(String[] args) {
//        reverseWords("We love Java".toCharArray());
        reverseWords("To be or not to be".toCharArray());
    }
}
