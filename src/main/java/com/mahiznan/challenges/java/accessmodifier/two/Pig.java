package com.mahiznan.challenges.java.accessmodifier.two;

import com.mahiznan.challenges.java.accessmodifier.one.Animal;
//import com.mahiznan.challenges.java.accessmodifier.one.Cat;

class Pig {
    Pig() {
        Animal animal = new Animal();
//        animal.age = 100; // will throw error due to package private
//        System.out.println(animal.age);
//        animal.packageProtectedMethod();
    }
}
