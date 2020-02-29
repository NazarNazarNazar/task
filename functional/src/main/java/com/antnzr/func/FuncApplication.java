package com.antnzr.func;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.antnzr.func.FuncApplication.Gender.*;

public class FuncApplication {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Marishka", FEMALE),
                new Person("Alex", MALE),
                new Person("Agneshka", FEMALE),
                new Person("Bzdishek", MALE),
                new Person("Abrek", MALE),
                new Person("Natashka", FEMALE)
        );

        Predicate<Person> isFemale = person -> FEMALE.equals(person.gender);

        List<Person> female = people.stream()
                .filter(isFemale)
                .collect(Collectors.toList());

        female.forEach(System.out::println);
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
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
