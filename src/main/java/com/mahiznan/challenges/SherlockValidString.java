package com.mahiznan.challenges;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SherlockValidString {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    static String isValid(String s) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (characterMap.containsKey(s.charAt(i))) {
                characterMap.put(s.charAt(i), characterMap.get(s.charAt(i)) + 1);
            } else {
                characterMap.put(s.charAt(i), 1);
            }
        }
        //abbccc
        int count1 = 0, count2 = 0, decider = 0;
        boolean flag = true;
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            if (count1 == 0) {
                System.out.println("Counter 1 " + entry.getKey() + "->" + entry.getValue());
                count1 = entry.getValue();
                continue;
            } else if (count2 == 0 && count1 != entry.getValue()) {
                System.out.println("Counter 2 " + entry.getKey() + "->" + entry.getValue());
                count2 = entry.getValue();
                continue;
            }
            if (entry.getValue() == count1 && decider == 0) {
                decider = count1;
            } else if (entry.getValue() == count2 && decider == 0) {
                decider = count2;
            }
            System.out.println("Decider is " + decider);
            if (entry.getValue() != decider) {
                flag = false;
            }
        }

        System.out.println(count1);
        System.out.println(count2);

        if (flag && (Math.abs(count1 - count2) == 1 || ((count1 + count2) - (decider + 1) == 0)))
            return "YES";
        return "NO";

    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();

//        String result = Sherlock.isValid("aabbccddeefghi");//NO
//        String result = Sherlock.isValid("aabbcd"); //NO
//        String result = Sherlock.isValid("abcdefghhgfedecba"); //NO
//        String result = Sherlock.isValid("abbcc");
//        System.out.println(Sherlock.isValid("aaaaabc"));
        System.out.println(isValid("abbccc"));
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
