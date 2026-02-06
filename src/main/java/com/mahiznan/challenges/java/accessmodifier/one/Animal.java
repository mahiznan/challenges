package com.mahiznan.challenges.java.accessmodifier.one;

public class Animal {
    private String name;
    protected int age;

    public String getName() {
        return name;
    }

    void packageProtectedMethod() {
        System.out.println("Inside package protected method");
    }
}

class Cat {
    Cat() {
        Animal animal = new Animal();
        animal.age = 100;
        System.out.println(animal.age);
        animal.packageProtectedMethod();
    }
}
