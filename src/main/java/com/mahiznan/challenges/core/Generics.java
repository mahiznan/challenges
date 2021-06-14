package com.mahiznan.challenges.core;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

interface Bird {
    void fly();
}

class Peacock implements Bird {
    @Override
    public void fly() {
        System.out.println("Peacock is flying");
    }
}

class Crow implements Bird {

    @Override
    public void fly() {
        System.out.println("Crow is flying");
    }
}

interface Zoo {
    void perform(Bird bird);
}

class Mandai implements Zoo {

    @Override
    public void perform(Bird bird) {
        bird.fly();
        System.out.println("Performing custom task");
    }
}


public class Generics {

    public static <T extends Number, G> List<G> fromArrayToList(T[] array, Function<T, G> mapperFunction) {
        return Arrays.stream(array).map(mapperFunction).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Bird bird = new Peacock();
        Zoo zoo = new Mandai();
        zoo.perform(bird);
    }
}





