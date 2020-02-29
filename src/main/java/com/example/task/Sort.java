package com.example.task;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 7, 10, 14, 1, 1};
        System.out.println(Arrays.toString(arr));

        Sort.bubbleSort(arr);
        Sort.selectionSort(arr);
    }

    /**
     * @param arr of int
     */
    private static void bubbleSort(int[] arr) {
        if (arr != null) {
            int tmp = 0;

            for (int i = arr.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr of int
     */
    private static void selectionSort(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                int min = arr[i];
                int minIndex = i;

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < min) {
                        minIndex = j;
                        min = arr[j];
                    }
                }

                if (i != minIndex) {
                    int tmp = arr[i];
                    arr[i] = arr[minIndex];
                    arr[minIndex] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
