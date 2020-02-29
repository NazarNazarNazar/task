package com.antnzr.func.finalsection;

import java.util.function.Consumer;

public class Callbacks {

    public static void main(String[] args) {
        hello("John", "Petrovich", value -> {
            System.out.println("no lastName for " + value);
        });

        hello2("John", null, () -> System.out.println("no last name provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> cb) {
        System.out.println(firstName);

        if (lastName != null) {
            System.out.println(lastName);
        } else {
            cb.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable cb) {
        System.out.println(firstName);

        if (lastName != null) {
            System.out.println(lastName);
        } else {
            cb.run();
        }
    }
}
