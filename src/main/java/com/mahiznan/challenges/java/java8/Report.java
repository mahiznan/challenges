package com.mahiznan.challenges.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@java.lang.FunctionalInterface
interface ReportFI {
    boolean add(String v);

    default void test() {
        int effectivelyFinalInt = 10;
        ReportFI report
                = (ef) -> {
            System.out.println("Value of effectively variable is : " + effectivelyFinalInt);
            return true;
        };
    }
}


@java.lang.FunctionalInterface
interface FooExtended extends Bar, Baz {
}

@java.lang.FunctionalInterface
interface Bar {
    void sayHello();

    default void sayHelloBar() {
        System.out.println("Hello from Bar");
    }
}

@java.lang.FunctionalInterface
interface Baz {
    void sayHello();

    default void sayHelloBaz() {
        System.out.println("Hello from Baz");
    }
}

public class Report {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("rajesh");
        names.add("kumar");
        names.add("kannan");
        String name = "rajesh";
        System.out.println("Initial name " + name);

//        Supplier<Integer> tmp = i -> new Integer(i);

        Function<Integer, String> test = integer -> integer % 2 == 0 ? "TRUE" : "FALSE";
        System.out.println(test.apply(10));

        Supplier<Double> supplier = Math::random;
        Consumer<Integer> consumer = (t) -> {
            t = t + 1;
            System.out.println(t);
        };
        consumer.accept(10);


        FooExtended fooExtended = () -> {
            names.add(name);
            names.add(name + "1");
            names.add(name + "2");
            System.out.println("Inside");

            names.forEach(System.out::println);

            String ename = "Kannan";
            System.out.println("Hello " + ename);
            ename = "raja";
            System.out.println("Hello " + ename);
        };

        System.out.println("Outside");
        names.forEach(System.out::println);

        fooExtended.sayHello();
        System.out.println("Outside After call");
        names.forEach(System.out::println);
        fooExtended.sayHelloBar();
        fooExtended.sayHelloBaz();

        FooExtended anotherFoo = new FooExtended() {
            @Override
            public void sayHello() {
                System.out.println("Salamat " + name);
            }
        };
        anotherFoo.sayHello();
    }
}





