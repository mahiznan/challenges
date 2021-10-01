package org.example;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void initializeStream() {
        List<String> stringList = new ArrayList<>();
        stringList.add("String 1");
        stringList.add("String 2");
        Stream<String> stream = stringList.stream();
        Assert.assertEquals(stream.count(), 2);
    }


    // Q #18) Write a program to print 5 random numbers using forEach in Java 8?

    @Test
    public void printRandom() {
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(System.out::println);
        System.out.println(random.nextInt(100));
        IntStream.range(1, 6).forEach(value -> {
            System.out.println(random.nextInt(100));
        });

    }


}
