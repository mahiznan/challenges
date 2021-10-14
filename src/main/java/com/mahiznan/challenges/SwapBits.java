package com.mahiznan.challenges;

public class SwapBits {
    static int swap(int n) {
        StringBuilder s = new StringBuilder();
        int i = 1;
        while (n > 0) {
            if (i % 2 == 0) {
                s.insert(s.length() - 1, n % 2);
            } else {
                s.append(n % 2);
            }
            i++;
            n = n / 2;
        }
        if (s.length() % 2 != 0) {
            s.insert(s.length() - 1, "0");
        }
        return Integer.parseInt(s.reverse().toString(), 2);
    }

    public static void main(String[] args) {
        int N = 23;
        System.out.println(swap(N));
    }
}

//23 (00010111), it should be converted to 43(00101011)
