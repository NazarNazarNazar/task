package main.java.com.example.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * searching duplicates in array of int
 */
public class DuplicatesInArray {

    public static void main(String[] args) {
        int[] arr = new int[100];

        // fill an array with length == 100,  with value from 1 to 100
        for (int i = 0, j = 0; i < arr.length; i++) {
            arr[i] = ++j;
        }

        // add duplicate
        arr[8] = 4;

        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);

        List<Integer> duplicates = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            } else {
                duplicates.add(arr[i]);
            }
        }

        System.out.println("The duplicate values are : " + duplicates);
    }
}
