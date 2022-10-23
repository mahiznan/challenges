package com.mahiznan.challenges.java.java8;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Bird {
    default void fly() {
        System.out.println("Bird is flying");
    }
}

class SupplierImpl implements Supplier<Double> {
    @Override
    public Double get() {
        return Math.random();
    }
}

class LoggerImpl implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 1;
    }

    @Override
    public <V> Function<V, Integer> compose(Function<? super V, ? extends Integer> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Integer, V> andThen(Function<? super Integer, ? extends V> after) {
        return Function.super.andThen(after);
    }
}

public class FunctionalInterface {

    public static void main(String[] args) {

        Bird bird = new Bird() {
        };
        bird.fly();


        ReportFI report = (v) -> {
            System.out.println(v);
            return true;
        };


        System.out.println(report.add("Some sample message"));

        LoggerImpl cLogger = new LoggerImpl();
        System.out.println("Result is " + cLogger.apply(10));
        System.out.println("Result is " + cLogger.andThen(integer -> integer + 2).andThen(integer -> integer + 100).apply(10));

        Predicate<Integer> p = o -> o % 2 == 0;
        System.out.println(p.test(10));

        Function<Integer, Integer> square1 = integer -> integer * integer;
        System.out.println(square1.apply(11));


        Function<Double, Double> log = Math::log;
        Function<Double, Double> square = (value) -> Math.pow(value, 2);
        IntFunction<Double> sqrt = (value) -> Math.sqrt(value);
        System.out.println(log.apply(10D));
        System.out.println(log.andThen(aDouble -> {
            return aDouble + 100;
        }));
        System.out.println(square.apply(10D));
        System.out.println(sqrt.apply(10));


        SupplierImpl supplierViaClass = new SupplierImpl();
        System.out.println("Value " + supplierViaClass.get());
        System.out.println(supplierViaClass.get());
        System.out.println(supplierViaClass.get());


        Supplier<Double> supplier = Math::random;
        System.out.println("Value " + supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());


        Predicate<Integer> isEven = (v) -> v % 2 == 0;
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(11));


        Consumer<String> logger = (v) -> System.out.println(LocalDateTime.now() + "-" + v);
        logger.accept("Custom log message");
        logger.accept("Another log message");


        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        System.out.println("Value is " + value);

        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        System.out.println(intToString.apply(10));
        System.out.println(quoteIntToString.apply(5));

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((name, oldValue) -> 9000);
        salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);

        for (Map.Entry<String, Integer> entry : salaries.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        salaries = new HashMap<>();
        salaries.put("Rajesh", 999999);
        salaries.put("Kannan", 888888);
        salaries.put("Raja", 777777);

        //Map interface provides a default method named replaceAll which takes a BiFunction as argument

        salaries.replaceAll((name, oldSalary) -> name.equals("Rajesh") ? oldSalary : oldSalary + 10000); //One line method to increase all salary by 10000 except for Rajesh
        for (Map.Entry<String, Integer> entry : salaries.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }


        int[] fibs = {0, 1};
        Stream<Integer> fibonacci = Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        });
        //fibonacci.forEach(integer -> System.out.println(integer + ","));

        List<String> employees = new ArrayList<>();
        employees.add("Rajesh");
        employees.add("Raja");
        employees.add("Prathika");
        employees.add("Saranya");
        employees.add("Mya");
        employees.add("Rahul");

        employees.replaceAll(String::toUpperCase);

        employees.forEach(s -> {
            System.out.println("Hello, " + s);
        });

        List<String> employeesFiltered = employees.stream().filter(s -> s.startsWith("R")).collect(Collectors.toList());

        employeesFiltered.forEach(s -> {
            System.out.println("R Hello, " + s);
        });


        List<Integer> numberList = Arrays.asList(3, 4, 5, 1, 92, 43);
        int sum = numberList.stream().reduce(0, Integer::sum);
        System.out.println("Total " + sum);

        List<String> lowerCaseEmployees = employees.stream().map(String::toLowerCase).collect(Collectors.toList());
        lowerCaseEmployees.forEach(s -> {
            System.out.println("Lower Hello, " + s);
        });
    }
}
