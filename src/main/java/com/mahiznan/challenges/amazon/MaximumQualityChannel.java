package com.mahiznan.challenges.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumQualityChannel {

    public static long maximumQualityChannel(List<Integer> packets, int channels) {
        long answer = 0;
        int n = packets.size();
        if (channels == n) {
            for (Integer packet : packets) answer += packet;
            return answer;
        }
        Collections.sort(packets);

        for (int i = n - channels + 1; i < n; i++) {
            answer += packets.get(i);
        }
        n -= channels;
        if (n % 2 == 0) {
            double value = packets.get(n / 2) + packets.get((n / 2) + 1);
            answer += value / 2;
        } else {
            answer += packets.get(n / 2);
        }
        return (long) Math.ceil(answer);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(3);
        int channels = 2;
        System.out.println(maximumQualityChannel(list, channels));

    }
}
