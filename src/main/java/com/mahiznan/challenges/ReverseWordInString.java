package com.mahiznan.challenges;

import java.util.Stack;
import java.util.StringJoiner;

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

    public static String reverseWords_Approach2(String sentence) {
        Stack<String> stringStack = new Stack<>();
        int p = 0, i = 0;
        for (; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                if (p == 0)
                    stringStack.push(sentence.substring(p, i));
                else
                    stringStack.push(sentence.substring(p + 1, i));
                p = i;
            }
        }
        if (p == 0)
            stringStack.push(sentence.substring(p, i));
        else
            stringStack.push(sentence.substring(p + 1, i));
        StringJoiner res = new StringJoiner(" ");
        while (!stringStack.isEmpty()) {
            res.add(stringStack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        reverseWords("We love Java".toCharArray());
//        reverseWords_Practice("To be or not to be".toCharArray());
        System.out.println(reverseWords_Approach2("i like this program very much"));
        System.out.println(reverseWords_Approach2("Hi"));
//        reverseWords_Practice("We love Java".toCharArray());
    }
}
