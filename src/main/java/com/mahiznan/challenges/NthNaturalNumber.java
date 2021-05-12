package com.mahiznan.challenges;

public class NthNaturalNumber {
    static long findNth(long N) {
        long r = 0, p = 1;
        while (N > 0) {
            r += (p * (N % 9));
            N /= 9;
            p *= 10;
        }
        return r;
    }


//    11010124579;

    public static void main(String[] args) {
//        long N = 9;
        long N = 18;
//        long N = 10000021409L; //27726721438
//        long N = 1000L; //27726721438
        System.out.println(findNth(N));
    }
}


//10 -> 1
//100 -> 10 + 9
//1000 -> 100 + 90 + 9


