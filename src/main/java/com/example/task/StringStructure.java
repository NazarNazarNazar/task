package main.java.com.example.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом.
Нужно преобразовать строку в такую структуру данных, которая группирует слова по первой букве в слове.
Затем вывести только группы, содержащие более одного элемента.
Группы должны быть отсортированы в алфавитном порядке.
Слова внутри группы нужно сортировать по убыванию количества символов;
если количество символов равное, то сортировать в алфавитном порядке.

Пример строки: String s = «сапог сарай арбуз болт бокс биржа»
Отсортированная строка: [б=[биржа, бокс, болт], c=[caпог, сарай]]
 */
public class StringStructure {
    public static void main(String[] args) {
        String s = "сапог сарай арбуз болт бокс биржа";
        String s1 = "сапоги сар арбуз а болтик бокс биржа";
        String s2 = "саги сар арбузик а а лл ллл лллл болт боксик щбифывафржа";
        getCustomStringStructure(s).forEach((k, v) -> System.out.println("[" + k + "=" + v + "]"));
        System.out.println("**********************************************");
        getCustomStringStructure(s1).forEach((k, v) -> System.out.println("[" + k + "=" + v + "]"));
        System.out.println("**********************************************");
        getCustomStringStructure(s2).forEach((k, v) -> System.out.println("[" + k + "=" + v + "]"));
    }

    private static Map<String, List<String>> getCustomStringStructure(String s) {
        // get the array of the strings
        String[] arr = s.split(" ");
        // the storage
        Map<String, List<String>> map = new TreeMap<>();
        // put the first element in the storage
        List<String> l = new ArrayList<>();
        l.add(arr[0]);
        map.put(arr[0].substring(0, 1), l);

        for (int i = 1; i < arr.length; i++) {
            String sub = arr[i].substring(0, 1);
            // if contains put String arr[i] in the List
            if (map.containsKey(sub)) {
                map.get(sub).add(arr[i]);
            } else {
                // if not put new element in the map
                List<String> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(sub, list);
            }
        }

        // sort by size, by string's length and alphabetically
        Map<String, List<String>> collect = map.entrySet()
                .stream()
                .filter(k -> k.getValue().size() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream().sorted((o1, o2) -> {
                            if (o2.length() != o1.length()) {
                                return o2.length() - o1.length();
                            } else {
                                return o1.compareTo(o2);
                            }
                        })
                                .collect(Collectors.toList())
                ));

        // return TreeMap to sort keys
        return new TreeMap<>(collect);
    }
}
