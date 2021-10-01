package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Integer> getAge() {
        return Optional.of(age);
    }

    public void setAge(int age) {
        this.age = age;
    }
}

@FunctionalInterface
interface Lottery {
    String selectWinner(List<String> name);
}


public class OptionalTest {

    @Test
    public void testOptional() {
        String name = "Rajesh";
        Optional<String> optionalName = Optional.of(name);
        Assert.assertTrue(optionalName.isPresent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoArgOrElseThrowWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoElementThrows() {
        String nullName = null;
        Optional.ofNullable(nullName).get();
    }


    @Test
    public void searchPerson() {
        List<Person> peoples = new ArrayList<>();
        peoples.add(new Person("Rajesh", 10));
        peoples.add(new Person("Peter", 10));
        peoples.add(new Person("Peter", 20));

        List<Person> filteredPersons = search(peoples, "Peter", null);
        filteredPersons.forEach(person -> System.out.println(person.name));

    }

    public static List<Person> search(List<Person> people, String name, Integer age) {
        final Integer ageFilter = age != null ? age : 0;

        // Null checks for people and name
        return people.stream()
                .filter(p -> p.getName().equals(name))
                .filter(p -> p.getAge().get() >= ageFilter)
                .collect(Collectors.toList());
    }


    @Test
    public void testMapWithOptional() {
        List<String> companyNames = new ArrayList<>();
        companyNames.add("Google");
        companyNames.add("Yahoo");
        companyNames.add("Facebook");
        Optional<List<String>> optionalCompanyNames = Optional.of(companyNames);

        int size = optionalCompanyNames
                .map(List::size)
                .orElse(0);

        Assert.assertEquals(3, size);
        long count = companyNames.stream().count();
        Assert.assertEquals(3, count);


    }


    @Test
    public void selectWinnerTest() {
        List<String> names = new ArrayList<>();
        names.add("Rajesh");
        names.add("Kumar");
        names.add("Rajan");
        names.add("Peter");
        Lottery lottery = nameList -> {
            String winner = null;
            for (String name : nameList) {
                if (name.endsWith("a")) {
                    winner = name;
                    break;
                }
            }
//            return Optional.ofNullable(winner).orElse("NO WINNER");
            return Optional.ofNullable(winner).orElseGet(() -> {
                //Some logic goes here
                String name = "WINNER";
                name = "NO " + name;
                return name;
            });
        };

        String winner = lottery.selectWinner(names);
        Assert.assertNotNull(winner);
        Assert.assertEquals("NO WINNER", winner);
        names.add("Jeya");
        winner = lottery.selectWinner(names);
        Assert.assertNotNull(winner);
        Assert.assertEquals("Jeya", winner);
/*
        if (winner.isPresent()) {
            System.out.println(winner.hashCode());
        } else {
        }*/
    }

    @Test
    public void timeDelayFunction() {
        long start = new Date().getTime();
        System.out.println(start);
        while (new Date().getTime() - start < 10000L) {
        }
        System.out.println("After 10 second");
        System.out.println(new Date().getTime());

    }


}
