package com.mahiznan.java.champion;

interface IntegerCache {

    static void main(String[] args) {
        System.out.println("IntegerCache");

        Integer value1 =  Integer.valueOf(-127);
        Integer value2 =  Integer.valueOf(-127);
        Integer value3 =  Integer.valueOf(3);

        System.out.println(value1 == value2);

    }

}
