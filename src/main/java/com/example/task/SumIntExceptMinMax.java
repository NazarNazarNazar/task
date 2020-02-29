package com.example.task;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class SumIntExceptMinMax {

    public static void main(String[] args) {
        SumIntExceptMinMax.sumSimple(new int[]{1, 3, 4, 2, 6, 5});
        SumIntExceptMinMax.sum(new int[]{1, 3, 4, 2, 6, 5});
        SumIntExceptMinMax.sumOn(new int[]{1, 3, 4, 2, 6, 5});
    }

    /**
     * Method calculates the sum of values of array, except min and max
     * values.
     * Algorithm complexity 0(n)
     *
     * @param arr of int
     */
    private static void sumOn(int[] arr) {
        if (arr != null) {
            int max = arr[0];
            int min = arr[0];
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }

                if (arr[i] < min) {
                    min = arr[i];
                }

                sum += arr[i];
            }

            sum -= (max + min);

            System.out.println(sum);
        }
    }

    /**
     * Method calculates the sum of values of array, except min and max
     * values.
     *
     * @param arr of int
     */
    public static void sum(int[] arr) {
        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[arr.length - 1];
        int sum = IntStream.of(arr).sum() - (min + max);

        System.out.println(sum);
    }

    /**
     * Method calculates the sum of values of array, except min and max
     * values.
     *
     * @param array of int
     */
    public static void sumSimple(int[] array) {
        if (array != null && array.length != 0) {

            // https://stackoverflow.com/questions/1484347/finding-the-max-min-value-in-an-array-of-primitives-using-java
            IntSummaryStatistics statistics = Arrays.stream(array).summaryStatistics();
            int min = statistics.getMin();
            int max = statistics.getMax();

            int sum = IntStream.of(array).sum() - (min + max);

            System.out.println(sum);
        }
    }
}
