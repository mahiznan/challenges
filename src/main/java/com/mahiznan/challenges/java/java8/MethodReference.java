package com.mahiznan.challenges.java.java8;

@java.lang.FunctionalInterface
interface Greetings {
    void welcome(String name);
}

class Utils {

    void sayHello(String name) {
        System.out.println("Hello " + name);
    }

}

public class MethodReference {
    public static void main(String[] args) {
        Utils utils = new Utils();
        Greetings greetings = utils::sayHello;
        greetings.welcome("Rajesh");
//        ExecutorService pool = Executors.newFixedThreadPool(10);


    }
}
