package com.mahiznan.challenges.cci.arrays;

public class URLify {
    static String getUrlString(char[] str, int trueLength) {
        int numberOfSpaces = 0, index, i;
        for (i = 0; i < trueLength; i++) {
            if ((str[i] == ' ')) {
                numberOfSpaces++;
            }
        }
        index = trueLength + (numberOfSpaces * 2);
        if (index < str.length)
            str[index] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        String s1 = "Mr John Smith    ";
        int trueLength = 13;
        System.out.println(getUrlString(s1.toCharArray(), trueLength));
    }
}
