package com.mahiznan.challenges.core.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

interface Radio {
    void play();

    void pause();

    void stop();
}


@java.lang.FunctionalInterface
interface FnInterface {
    void play(String name);

    default void shout() {
        System.out.println("Shout");
    }

    static void scream() {
        System.out.println("Scream");
    }
}


class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

}


public class LambdaExample {
    public static void main(String[] args) {

        FnInterface fnInterface = name -> System.out.println("Playing " + name);
        fnInterface.play("Ilayaraja");
        fnInterface.play("Rahman");
        fnInterface.shout();
        FnInterface.scream();

        FnInterface fnInterface1 = new FnInterface() {
            int count = 0;

            @Override
            public void play(String name) {
                System.out.println("Playing " + name + " at " + ++count + " time");
            }
        };
        fnInterface1.play("Ilayaraja");
        fnInterface1.play("Rahman");


        Radio radio = new Radio() {
            @Override
            public void play() {
                System.out.println("Play");
            }

            @Override
            public void pause() {
                System.out.println("Pause");

            }

            @Override
            public void stop() {
                System.out.println("Stop");
            }
        };
        radio.play();
        radio.pause();
        radio.stop();

        System.out.println("Rajesh".indexOf("sh"));

        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Rajesh", 34));
        humans.add(new Human("Ranju", 31));
        humans.add(new Human("Radhu", 31));
        humans.add(new Human("Ranju", 29));
        humans.add(new Human("Jaya", 63));

        //Without lambda Approach
        Comparator<Human> sortedSapiens = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.name.compareTo(o2.name);
            }

        };
        //Human.sort(sortedSapiens);
        humans.forEach(human -> System.out.println(human.name + "--" + human.age));


        //With lambda Approach
        humans.sort(Comparator.comparing(Human::getName));

//        Human.sort(Comparator.comparing(Human::getName).reversed());
//        Human.sort(Comparator.comparing(Human::getName).thenComparingInt(o -> o.age));

        humans.forEach(human -> System.out.println(human.name + "--" + human.age));
        System.out.println("---------------");
        List<Human> humansNewSorted = humans.stream().sorted(Comparator.comparingInt(o -> o.age)).collect(Collectors.toList());
        for (Human human : humansNewSorted) {
            System.out.print(human.name + "-");
            System.out.println(human.age);
        }


    }

}
