package main.java.com.example.task;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Second {

    public static void main(String[] args) {
        Second.sumSimple(new int[]{1, 3, 4, 2, 6, 5});
    }

    /**
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
