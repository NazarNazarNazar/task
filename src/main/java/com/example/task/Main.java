package main.java.com.example.task;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main.resultAfterAllIterations(0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11);
//        Main.resultAfterAllIterations(0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11, 391, 2, 2, 1, 9, 9, 3);
        Main.resultAfterAllIterations(0, 2, 7, 0);
//        Main.resultAfterAllIterations(null);
        Main.resultAfterAllIterations(3000000, 0);
    }

    /**
     * Accept an array of any length, with positive numbers within range of Integer type.
     * Should not be negative numbers in the array.
     * Displays iterations, the length of the loop and how many steps need to reach infinite loop
     *
     * @param numbers VarArgs of Integer
     */
    private static void resultAfterAllIterations(Integer... numbers) {
        if (numbers != null && numbers.length != 0) {
            // storage of data; the key is Integer which is hashCode of List<Integer>
            LinkedHashMap<Integer, List<Integer>> listStorage = new LinkedHashMap<>();

            System.out.println("#####################################################");
            System.out.println(Arrays.toString(numbers));

            // save varargs as List in storage with its hashCode
            listStorage.put(Arrays.hashCode(numbers), Arrays.asList(numbers));

            // list from varargs and processed with customIncrementOfList method
            List<Integer> list = customIncrementOfList(new ArrayList<>(Arrays.asList(numbers)));

            // the key of the list for listStorage
            int hashKey = list.hashCode();

            listStorage.put(hashKey, list);

            // the counter of steps to detect an infinite loop
            int stepsOfLoop = 2;

            // while the storage doesn't contain repetitions fill listStorage
            while (true) {
                List<Integer> integers = new ArrayList<>(customIncrementOfList(listStorage.get(hashKey)));
                hashKey = integers.hashCode();
                if (!listStorage.containsKey(hashKey)) {
                    listStorage.put(hashKey, integers);
                    stepsOfLoop++;
                } else {
                    // length of the loop
                    int loopLength = 0;

                    // searching the start of the loop and increment loopLength
                    for (Map.Entry<Integer, List<Integer>> entry : listStorage.entrySet()) {
                        if (!entry.getKey().equals(hashKey)) {
                            loopLength++;
                        } else {
                            loopLength = stepsOfLoop - loopLength;
                            break;
                        }
                    }

                    System.out.println();
                    System.out.println("The length of the loop: " + loopLength + ".");
                    break;
                }
            }

            System.out.println("Steps to the endless loop: " + stepsOfLoop + " steps.");
            System.out.println();
        }
    }

    /**
     * Method finds max value and nullify this value,
     * then redistributes the max value in the list, started with next element after max value
     *
     * @param list list of Integer
     * @return list of incremented values
     */
    private static List<Integer> customIncrementOfList(List<Integer> list) {
        if (list != null && !list.isEmpty()) {

            int counterMaxValue = 0;
            int index = 0;
            int max = 0;

            // Max value of the list
            max = list.stream().reduce(Integer.MIN_VALUE, Integer::max);

            // Take max value of the list and set it 0 value. Also set the counter's value.
            // define an index of the first iteration
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(max)) {
                    counterMaxValue = list.get(i);
                    list.set(i, 0);
                    index = i + 1;
                    break;
                }
            }

            // redistribution of the max value of the list
            while (counterMaxValue > 0) {
                if (index < list.size()) {
                    list.set(index, list.get(index) + 1);
                    index++;
                    counterMaxValue--;
                } else {
                    index = 0;
                    list.set(index, list.get(index) + 1);
                    index++;
                    counterMaxValue--;
                }
            }
            System.out.println(list);

        }
        return list;
    }
}
