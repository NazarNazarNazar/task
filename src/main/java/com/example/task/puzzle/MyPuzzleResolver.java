package com.example.task.puzzle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyPuzzleResolver implements PuzzleResolver {

    public static void main(String[] args) {
        MyPuzzleResolver resolver = new MyPuzzleResolver();
        int[] start = {2, 1, 3, 4, 0, 5, 6, 7};
        int[] start2 = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] start3 = {0, 1, 2, 3, 4, 5, 6, 7};
        /*System.out.println(Arrays.toString(resolver.resolve(start)));
        System.out.println(fromStateToInt(start));
        System.out.println(Arrays.toString(toState(21340567, new int[8])));
        System.out.println(Arrays.toString(swap(start, 3, 4)));*/
        Map<Integer, Integer> tm = new TreeMap<>();
        Set<Integer> set = new TreeSet<>();
        Cheater cheater = new Cheater();
        CheaterSec cheaterSec = new CheaterSec();
//        System.out.println(Arrays.toString(resolver.resolve(start3)));
        System.out.println(Arrays.toString(cheaterSec.resolve(start)));
    }

    private static Integer[] fromIntToInteger(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .toArray(Integer[]::new);
    }

    private static int[] fromIntegerToInt(Integer[] arr) {
        return Arrays
                .stream(arr)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Override
    public int[] resolve(int[] start) {
        Integer[] newStart = fromIntToInteger(start);
        LinkedList<Integer[]> availablePaths = new LinkedList<>();
        Set<Integer[]> visited = new HashSet<>();
        Map<Integer, Integer[]> path = new HashMap<>();

        Integer[] expectedResult = {1, 2, 3, 4, 0, 5, 6, 7};
        if (Arrays.equals(newStart, expectedResult)) {
            return new int[0];
        }

        availablePaths.add(newStart);
        visited.add(newStart);

        while (availablePaths.size() > 0) {
            int len = availablePaths.size();
            for (int i = 0; i < len; i++) {

                int[] currState = fromIntegerToInt(availablePaths.remove());

                for (Integer[] number : siblings(currState)) {
                    if (visited.contains(number)) continue;
                    visited.add(number);
                    availablePaths.add(number);
                    path.put(fromStateToInt(fromIntegerToInt(number)), fromIntToInteger(currState));

                    if (Arrays.equals(number, expectedResult)) {
                        i = len;
                        availablePaths.clear();
                        break;
                    }
                }

            }
        }

        List<Integer> route = new ArrayList<>();
        Integer[] curr = expectedResult;

        while (!Arrays.equals(curr, newStart)) {
            Integer[] prev = path.get(fromStateToInt(fromIntegerToInt(curr)));
            int ind = zero(fromIntegerToInt(curr));
            route.add(prev[ind]);
            curr = prev;
        }
        System.out.println("route: " + route);

        Collections.reverse(route);

        return toArray(route);
    }

    private static int fromStateToInt(int[] state) {
        int ret = 0;
        for (int value : state) {
            ret += value;
            ret *= 10;
        }
        return ret / 10;
    }

    private static int[] toState(int source, int[] cache) {
        for (int i = cache.length - 1; i >= 0; i--) {
            cache[i] = source % 10;
            source /= 10;
        }
        return cache;
    }

    private static int zero(int[] array) {
        int result = -1;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == 0) {
                result = index;
            }
        }
        return result;
    }

    private static int[] toArray(List<Integer> list) {
        return list
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int[] swap(int[] arr, int from, int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
        return arr;
    }

    private Integer[] getSibling(int[] arr, int i, int j) {
        int[] swap = swap(arr, i, j);
        swap(arr, i, j);
        return fromIntToInteger(swap);
    }

    Iterable<Integer[]> siblings(int[] state) {
        int zero = zero(state);
        Set<Integer[]> siblings = new HashSet<>();

        switch (zero) {
            case 0:
                siblings.add(getSibling(state, 0, 1));
                siblings.add(getSibling(state, 0, 2));
                break;
            case 1:
                siblings.add(getSibling(state, 1, 0));
                siblings.add(getSibling(state, 1, 2));
                siblings.add(getSibling(state, 1, 3));
                break;
            case 2:
                siblings.add(getSibling(state, 2, 0));
                siblings.add(getSibling(state, 2, 1));
                siblings.add(getSibling(state, 2, 5));
                break;
            case 3:
                siblings.add(getSibling(state, 3, 1));
                siblings.add(getSibling(state, 3, 4));
                siblings.add(getSibling(state, 3, 6));
                break;
            case 4:
                siblings.add(getSibling(state, 4, 3));
                siblings.add(getSibling(state, 4, 5));
                break;
            case 5:
                siblings.add(getSibling(state, 5, 2));
                siblings.add(getSibling(state, 5, 4));
                siblings.add(getSibling(state, 5, 7));
                break;
            case 6:
                siblings.add(getSibling(state, 6, 3));
                siblings.add(getSibling(state, 6, 7));
                break;
            case 7:
                siblings.add(getSibling(state, 7, 6));
                siblings.add(getSibling(state, 7, 5));
                break;
        }

        return siblings;
    }

}
