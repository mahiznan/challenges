package com.mahiznan.challenges.amazon;

import java.util.ArrayList;
import java.util.List;

public class GiftingGroups {
    static int countGroups(List<String> related) {
        if (null == related || related.isEmpty()) {
            return 0;
        }
        int count = 0;
        int[][] isConnected = new int[related.size()][related.size()];

        for (int i = 0; i < related.size(); i++) {
            String row = related.get(i);
            for (int j = 0; j < row.length(); j++) {
                isConnected[i][j] = Integer.parseInt(Character.toString(row.charAt(j)));
            }
        }
        boolean[] isReached = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!isReached[i]) {
                checkGroups(isConnected, isReached, i);
                count++;
            }
        }
        return count;
    }

    private static void checkGroups(int[][] isConnected, boolean[] isReached, int v) {
        isReached[v] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[v][i] == 1 && !isReached[i])
                checkGroups(isConnected, isReached, i);
        }

    }

    public static void main(String[] args) {
        List<String> related = new ArrayList<>();
        related.add("110");
        related.add("110");
        related.add("001");
        System.out.println(countGroups(related));
    }
}
