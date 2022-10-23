package com.mahiznan.challenges.java.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) throws IOException {

        //Test 1
        List<String> names = new ArrayList<>();
        names.add("Rajesh");
        names.add("kumar");
        names.add("");
        names.add("Radhu");
        names.add("Google");
        names.add("");

        List<String> welcomeNames =
                names.stream().filter(s -> !s.isEmpty()).map(s -> "hello, " + s).collect(Collectors.toList());
        welcomeNames.forEach(System.out::println);

        names.stream().filter(s -> !s.isEmpty()).map(s -> "Hello, " + s).forEach(System.out::println);


        //Test 2
        String[] employees = {"Rajesh", "Kumar", "Raja", "Kannan", "Raja"};
        Stream<String> employeeStream = Arrays.stream(employees);
        long count = employeeStream.distinct().count();
        System.out.println(count);

        //Test 3
        employeeStream = Arrays.stream(employees);
        employeeStream.filter(s -> s.startsWith("R")).forEach(System.out::println);

        //Test 4
        employeeStream = Arrays.stream(employees);
        boolean nameWithKExists = employeeStream.anyMatch(s -> s.contains("K"));
        System.out.println(nameWithKExists);

        //Test 5
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbersList.stream().reduce(15, Integer::sum);
        System.out.println(sum);

        //Test 6
        Stream<String> nameStream = Stream.<String>builder().add("Raja").add("Kannan").add("Kumar").build();
        nameStream.forEach(System.out::println);

        //Test 7

        Stream<String> welcomeStream = Stream.generate(() -> "welcome ").limit(10);
        welcomeStream.forEach(System.out::println);

        //Test 8
        Stream<Integer> nStream = Stream.iterate(10, integer -> integer + 1).limit(10);
        nStream.forEach(System.out::println);

        //Test 9
        LongStream longStream = LongStream.rangeClosed(1, 10);
        longStream.forEach(System.out::println);


        //Test 10
//        Path path = Paths.get("/Users/rajesh/Downloads/server.xml");
//        Stream<String> pathStream = Files.lines(path);
//        pathStream.forEach(System.out::println);

        Path p = Paths.get("/Users/rajesh/Downloads/server.xml");
        Files.lines(p).forEach(s -> {
            System.out.println(">>>>>>> " + s);
        });


        //Test 11
        Stream<String> stringStream = Stream.of("a", "b", "c", "d").filter(s -> s.contains("b"));
        stringStream.forEach(System.out::println);
//        Optional<String> str = stringStream.findAny();// will throw exception
//        System.out.println(str.get());// will throw exception

        //Test 12
        List<String> stringList = Stream.of("a", "b", "c", "d").collect(Collectors.toList());
        stringList.forEach(System.out::println);
        Optional<String> str1 = stringList.stream().findAny();
        System.out.println(str1.get());

        //Test 13
        Stream<String> registrationNumbers = Stream.of("TN-45-AR-6375", "AP-45-AR-1476", "KL-23-RW-2396", "KA-22-DC-9812");
        List<String> allowedCars = registrationNumbers
                .filter(s -> Integer.parseInt(s.substring(8)) % 2 == 0)
                .collect(Collectors.toList());
        allowedCars.forEach(System.out::println);

        //Test 13
        Stream<String> stringStream1 = Stream.of("abc1", "bcd2", "def3", "efg4");
        Optional<String> value = stringStream1.filter(s -> {
            System.out.println("Custom call");
            return s.contains("b");
        }).map(s -> s.toUpperCase(Locale.ROOT)).findAny();
        System.out.println("Invoking print");
        System.out.println(value);

        //Test 14
        Optional<Integer> largestNo = numbersList.stream().min(Integer::compareTo);
        System.out.println(largestNo.get());

        //Test 15
        OptionalInt t = IntStream.range(1, 4).reduce(Integer::sum);
        System.out.println(t.isPresent() ? t.getAsInt() : "NA");
        int v = IntStream.range(1, 4).reduce(20, Integer::sum);
        System.out.println(v);

        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    System.out.println("combiner was called");
                    return a + b;
                });
        System.out.println(reducedParams);

        reducedParams = Stream.of(1, 2, 3).parallel()
                .reduce(10, (a, b) -> {
                    System.out.println("Sum was called for " + a + " and " + b);
                    return a + b;
                }, (a, b) -> {
                    System.out.println("combiner was called for " + a + " and " + b);
                    return a + b;
                });
        System.out.println(reducedParams);

        //Test 16
        List<Integer> result = numbersList.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(result);

        //Test 17
        Map<Integer, Boolean> map = numbersList
                .stream()
                .collect(Collectors.toMap(integer -> integer, integer -> integer % 2 == 0));

        map.forEach((integer, aBoolean) -> {
            System.out.println("Number " + integer + "->" + "is Even " + aBoolean);
        });


        //Test 18
        numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 4, 9);
        Map<Integer, Boolean> numberMap = numbersList
                .stream()
                .collect(Collectors.toMap(integer -> integer, integer -> integer % 2 == 0,
                        (aBoolean, aBoolean2) -> aBoolean));

        numberMap.forEach((integer, aBoolean) -> {
            System.out.println("Number " + integer + "->" + "is Even " + aBoolean);
        });

        //Test 19
        String s = numbersList.stream().map(integer -> "" + integer)
//                .collect(Collectors.joining(",", "[", "]"));
                .collect(Collectors.joining());
        System.out.println(s);


        stringList = Arrays.asList("abc", "cd", "aaaa", "aab", "cd", "d", "dce");

        Map<Integer, Set<String>> res = stringList
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        res.forEach((integer, strings) -> {
            System.out.println("No " + integer + "->" + strings);
        });


        //Test 20
        int total = numbersList.stream().reduce(0, Integer::sum);
        System.out.println(total);

        //Test 21
        /*
        Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100
        and then find the average of the remaining numbers?
         */
        System.out.println("Test 21");
        numbersList = Arrays.asList(9, 10, 12, 13, 8, 5, 2, 11);
        List<Integer> filteredNumbers = numbersList.stream().map(n -> n * n).filter(n -> n > 100).collect(Collectors.toList());
        filteredNumbers.forEach(System.out::println);
        Double average = filteredNumbers.stream().collect(Collectors.averagingInt(value1 -> value1));
        System.out.println("Average is " + average);

        Optional<Integer> min = numbersList.stream().min(Integer::compareTo);
        System.out.println(min.get());

        Optional<Integer> max = numbersList.stream().max(Integer::compare);
        System.out.println(max.get());

        //Test 22
        System.out.println("Test 22 -> Flat Map");
        List<List<String>> listInList = Arrays.asList(Arrays.asList("Saket", "Trevor"), Arrays.asList("John", "Michael"),
                Arrays.asList("Shawn", "Franklin"), Arrays.asList("Johnty", "Saket"));
        System.out.println(listInList);
        List<String> listNames = listInList.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
        listNames.forEach(System.out::println);

        //Test 23
        List<Integer> numbersList2 = Arrays.asList(1, 2, 3);
        Stream<Integer> integerStream = Stream.concat(numbersList.stream(), numbersList2.stream());
        integerStream.forEach(System.out::println);
    }
}
