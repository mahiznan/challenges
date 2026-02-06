package com.mahiznan.challenges.java.core;

import org.w3c.dom.ls.LSOutput;

class Config {

    static {
        System.out.println("Config class initialized");
    }

    /*
    A variable is a compile-time constant only if:
        It is:
        1. static, 2. final, 3. primitive or String, 4. initialized with a constant expression
        ALL four must be true.
     */

    // compile-time constant (will be inlined)
    public static final int PORT = 8080;

    // NOT compile-time constant (runtime)
    public static final Integer TIMEOUT = 30;

    // normal static
    public static int MAX_CONN = 100;

    public static void print() {
        System.out.println("print() called");
    }
}

public class ConfigTest {

    static void main(String[] args) {

        System.out.println("Start");

        System.out.println(Config.PORT);      // Case 1
        System.out.println("----");

        System.out.println(Config.TIMEOUT);   // Case 2
        System.out.println("----");

        System.out.println(Config.MAX_CONN);  // Case 3
        System.out.println("----");

        Config.print();                      // Case 4
    }
}