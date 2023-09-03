package com.mahiznan.challenges.java.patternmatch;

public class PatternMatch {


    static String process(Object message) {
        if (message instanceof Integer)
            return "It's a number";
        if(message instanceof String str) {
            int length = str.length();
            return "It's a string of length "+length;
        }
        return "whatever";
    }

    public static void main(String[] args) {
        System.out.println(process(1));
        System.out.println(process("Hello"));
    }
}
