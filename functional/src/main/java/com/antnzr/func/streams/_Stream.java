package com.antnzr.func.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.antnzr.func.streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Marishka", FEMALE),
                new Person("Alex", MALE),
                new Person("Agneshka", FEMALE),
                new Person("Bzdishek", MALE),
                new Person("Abrek", MALE),
                new Person("Natashka", FEMALE)
        );

        Set<Gender> genders = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());

//        genders.forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person: {" +
                    "name: '" + name + '\'' +
                    ", gender: " + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
