package com.mahiznan.java.champion;

import java.util.Objects;

public class HelloWorld {

    public static void main(String args[]) {
        Car car = new Car("V123", "Turbo");
        System.out.println(car.getEngine());
        System.out.println(car.getRegistrationNumber());
    }
}



class Vehicle {
    private final String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    String getRegistrationNumber() {
        return registrationNumber;
    }
}

class Car extends Vehicle {
    private final String engine;

    Car(String registrationNumber, String engine) {
        super(registrationNumber);
        this.engine = engine;
    }

    String getEngine() {
        return engine;
    }
}

class BMW extends Car {
    private final String speaker;
    private final String model;

    BMW(String registrationNumber, String engine, String speaker, String model) {
        super(registrationNumber, engine);
        this.speaker = speaker;
        this.model = model;
    }

    String getSpeaker() {
        return speaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BMW p)) return false;
        return Objects.equals(model, p.model) && Objects.equals(speaker, p.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, speaker);
    }


}