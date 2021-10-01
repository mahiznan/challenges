package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

interface Request {
    boolean approve();

    boolean reject();
}

class LeaseRequest implements Request {
    @Override
    public boolean approve() {
        System.out.println("Approving lease request");
        return true;
    }

    @Override
    public boolean reject() {
        System.out.println("Rejecting lease request");
        return true;
    }
}

class DeLeaseRequest implements Request {
    @Override
    public boolean approve() {
        System.out.println("Approving lease request");
        return false;
    }

    @Override
    public boolean reject() {
        System.out.println("Rejecting lease request");
        return false;
    }
}

class Product {
    public String toString() {
        return "Deleting product";
    }
}

class Note {
    public String toString() {
        return "Adding note";
    }
}

class Generics {

    public static <T extends Number, G> List<G> fromArrayToList(T[] array, Function<T, G> mapperFunction) {
        return Arrays.stream(array).map(mapperFunction).collect(Collectors.toList());
    }

    public static <T extends Request> boolean approve(T request) {
        return request.approve();
    }

    public static <T extends Request> boolean reject(T request) {
        return request.reject();
    }

    public static <T> void perform(T t) {
        System.out.println(t.toString());
    }

}

class A {
    void action() {
        System.out.println("Performing Action A");
    }
}

class B extends A {
    void action() {
        System.out.println("Performing Action B");
    }

    void custom() {
        System.out.println("Custom action");

    }
}


public class GenericsTest {

    @Test
    public void superSubCheck() {
        List<Object> objectList = new LinkedList<>();
        List<String> stringList = new LinkedList<>();
        objectList.add(new String("Welcome"));
        stringList.add("custom String");
        A a = new B();
        a.action();
    }


    @Test
    public void callObjectMethod() {
        Generics.perform(new Product());
        Generics.perform(new Note());
    }


    @Test
    public void approveAndRejectLeaseRequest() {
        LeaseRequest leaseRequest = new LeaseRequest();
        assertTrue(Generics.approve(leaseRequest));
        assertTrue(Generics.reject(leaseRequest));
    }

    @Test
    public void approveAndRejectDeLeaseRequest() {
        DeLeaseRequest deLeaseRequest = new DeLeaseRequest();
        assertFalse(Generics.approve(deLeaseRequest));
        assertFalse(Generics.reject(deLeaseRequest));
    }

    @Test
    public void checkArrayToList() {
        Integer[] array = {1, 2, 3, 4, 5};
        List<String> stringList = Generics.fromArrayToList(array, integer -> "S" + integer);
        assertThat(stringList, hasItems("S1", "S2", "S3", "S4", "S5"));
    }

    @Test
    public void test() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        Integer i = list.iterator().next();
        assert i != null;
        assertEquals(1, (int) i);
    }


}
