package com.example.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;

/*
    Театральная площадь в столице Берляндии представляет собой прямоугольник n × m метров.
    По случаю очередного юбилея города, было принято решение о замощении площади
    квадратными гранитными плитами. Каждая плита имеет размер a × a.

    Какое наименьшее количество плит понадобится для замощения площади? Разрешено покрыть
    плитами большую поверхность, чем театральная площадь, но она должна быть покрыта обязательно.
    Гранитные плиты нельзя ломать или дробить, а разрешено использовать только целиком.
    Границы плит должны быть параллельны границам площади.

    Входные данные
    В первой строке записано три целых натуральных числа n, m и a (1 ≤ n, m, a ≤ 10^9).

    Выходные данные
    Выведите искомое количество плит.
*/
public class Fourth {

    public static String findDay(int month, int day, int year) {
        Set<String> s = new TreeSet<>();
        return LocalDate.of(year, month, day).format(DateTimeFormatter.ofPattern("EEEE"));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            System.out.println(sub);
            set.add(sub);
        }
        smallest = set.first();
        largest = set.last();
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) throws IOException {
        Fourth.getSmallestAndLargest("welcometojava", 3);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        long n = Long.parseLong(s[0]);
        long m = Long.parseLong(s[1]);
        long a = Long.parseLong(s[2]);
        reader.close();

        long cntSide1 = n / a + (int) Math.signum(n % a);
        long cntSide2 = m / a + (int) Math.signum(m % a);
        System.out.print(cntSide1 * cntSide2);
    }
}
