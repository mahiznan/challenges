package com.mahiznan.challenges.java;

class Bird {
    String name = "";

    void fly() {
        System.out.println("The bird is flying");
    }
}

class Peacock extends Bird {
    String name = "Peacock";

    @Override
    void fly() {
        System.out.println(name + " is flying");
    }
}


public class AnonymousClassExample {
    public static void main(String[] args) {
        Bird bird = new Peacock();
        bird.fly();


        Bird pigeon = new Bird() {
            String name = "Pigeon";

            @Override
            void fly() {
                name = "Another pigeon";
                System.out.println(name + " is flying");
            }
        };
        pigeon.fly();
    }
}
