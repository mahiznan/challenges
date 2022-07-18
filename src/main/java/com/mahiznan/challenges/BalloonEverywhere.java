package com.mahiznan.challenges;

import java.io.IOException;
import java.util.*;

public class BalloonEverywhere {
    public static void main(String[] args) throws IOException {
//        String s = "nlaebolko";
        String s = "loonbalxballpoon";
        System.out.println(maxInstance(s));
    }

    public static int maxInstance(String s) {
        Map<Character, Integer> balloonMap = new HashMap<>();
        balloonMap.put('b', 0);
        balloonMap.put('a', 0);
        balloonMap.put('l', 0);
        balloonMap.put('o', 0);
        balloonMap.put('n', 0);

        for (Character c : s.toCharArray()) {
            if (balloonMap.containsKey(c)) {
                balloonMap.put(c, balloonMap.get(c) + 1);
            }
        }

        balloonMap.put('l', balloonMap.get('l') / 2);
        balloonMap.put('o', balloonMap.get('o') / 2);

        List<Integer> values = new ArrayList(balloonMap.values());
        Collections.sort(values);

        return values.get(0);
    }


}