package org.example;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FuncInterfaceTest {

    @Test
    public void BiFunctionTest() {
        Map<Integer, String> employees = new HashMap<>();
        employees.put(1, "Rajesh");
        employees.put(2, "Kumar");
        employees.put(3, "Kannan");
        employees.put(4, "Raja");
        employees.replaceAll((k, v) -> {
            System.out.println(v);
            return "Hi " + v;
        });

        employees.forEach((integer, s) -> System.out.println(s));

    }

    @Test
    public void testFuncInterfaceExtended() {
        FooExtended fooExtended = () -> System.out.println("Hello");
        fooExtended.sayHello();
        fooExtended.sayHelloBar();
        fooExtended.sayHelloBaz();
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
}
