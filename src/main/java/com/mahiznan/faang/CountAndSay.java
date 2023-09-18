package com.mahiznan.faang;

public class CountAndSay {

    static String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");

        int count = 1;
        if (n == 1)
            return res.toString();
        while (count < n) {
            StringBuilder newString = new StringBuilder();
            char value = res.charAt(0);
            int quantity = 0;
            for (int i = 0; i < res.length(); i++) {
                if (res.charAt(i) == value) {
                    quantity++;
                } else {
                    newString.append(quantity).append(value);
                    value = res.charAt(i);
                    quantity = 1;
                }
            }
            newString.append(quantity).append(value);
            res = newString;
            count++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    //312211


}
