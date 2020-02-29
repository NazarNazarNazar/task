package com.antnzr.func.funcInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        System.out.println(incrementByOne(0));

        System.out.println(incrementByOneFunction.apply(1));

        Function<Integer, Integer> incAnMultFunction = incrementByOneFunction
                .andThen(multiplyByTenFunction);

        System.out.println(incAnMultFunction.apply(2));

        //BiFunction
        System.out.println("BiFunction: " + incrementByOneAndMultiplyFunction.apply(2, 3));
    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction =
            number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction =
            (numToIncrementByOne, numToMultiply)-> (numToIncrementByOne + 1) * numToMultiply;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static int incrementByOneAndMultiply(int number, int toMultiply) {
        return (number + 1) * toMultiply;
    }
}
