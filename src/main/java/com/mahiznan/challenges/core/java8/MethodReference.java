package com.mahiznan.challenges.core.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Utils {

    void sayHello(String name) {
        System.out.println("Hello " + name);
    }

}

@java.lang.FunctionalInterface
interface Greetings {
    void welcome(String name);
}


public class MethodReference {
    public static void main(String[] args) {
        Utils utils = new Utils();
        Greetings greetings = utils::sayHello;
        greetings.welcome("Rajesh");
//        ExecutorService pool = Executors.newFixedThreadPool(10);


    }
}
