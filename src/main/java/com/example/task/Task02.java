package com.example.task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Task02 {

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)
        );

        System.out.println(Task02.diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> lists) {
        int size = lists.size();
        return Math.abs(
                IntStream.range(0, size).map(i -> lists.get(i).get(i)).sum()
                        -
                        IntStream.range(0, size).map(i -> lists.get(i).get(size - 1 - i)).sum()
        );
    }
}
