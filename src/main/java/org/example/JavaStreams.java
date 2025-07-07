package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

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

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return name + " - " + age;
    }
}

public class JavaStreams {
    public static void main(String[] args) {

        // Activity 1: Filter Odd Numbers(
        List<Integer> num = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        List<Integer> oddNumbers = num.stream().filter(isOdd).toList();

        System.out.println("Odd numbers: " + oddNumbers);

        // Activity 2: Filter Strings Starting with 'A'
        List<String> names = List.of("Alice", "Adam", "Bob", "Angela", "Brian");
        Predicate<String> startsWithA = name -> name.startsWith("A");
        List<String> namesA = names.stream().filter(startsWithA).toList();

        System.out.println("Names starting with A: " + namesA);

        // Activity 3: Square All Numbers
        num = List.of(1, 2, 3, 4, 5);
        List<Integer> squares = num.stream().map(n -> n * n).toList();

        System.out.println("Squared numbers: " + squares);

        // Activity 4: Combine Predicates
        num = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;
        Predicate<Integer> combined = isEven.and(greaterThanFive);
        List<Integer> combinedList = num.stream().filter(combined).toList();

        System.out.println("Even and >5: " + combinedList);

        // Activity 5: Sort Objects Using Comparator
        List<Person> people = List.of(new Person("Gelo", 23), new Person("Marvs", 22), new Person("Warren", 24), new Person("Robert", 25), new Person("Joana", 21));
        List<Person> peopleByAge = people.stream().sorted(Comparator.comparingInt(Person::getAge)).toList();
        List<Person> peopleByName = people.stream().sorted(Comparator.comparing(Person::getName)).toList();
        List<Person> peopleByAgeDesc = people.stream().sorted(Comparator.comparingInt(Person::getAge)).toList().reversed();

        System.out.println("Sorted by age (ascending):");
        peopleByAge.forEach(System.out::println);
        System.out.println();

        System.out.println("Sorted by name:");
        peopleByName.forEach(System.out::println);
        System.out.println();

        System.out.println("Sorted by age (descending):");
        peopleByAgeDesc.forEach(System.out::println);
    }
}