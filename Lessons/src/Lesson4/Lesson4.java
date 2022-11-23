package lesson4;

import java.util.*;

public class Lesson4 {
    public static void main(String[] args) {
        List<String> list = new /*ArrayList<>()*/ LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        System.out.println(list);
        list.add("C");
        list.add("DDDDD");
        System.out.println(list);
        list.remove("bbb");
        System.out.println(list);
        System.out.println(list.get(list.size()-1));
        list.add(2, "BBB");
        System.out.println(list.get(2));
        list.add(2, "BBB");
        System.out.println(list);

        Set<String> set = new HashSet<>(list);
        Set<String> treeSet = new TreeSet<>(list);
        System.out.println(set + "\n" + treeSet);

        Map<String, String> map = new HashMap<>();
        map.put("Prague", "CZ");
        map.put("Berlin", "DE");
        System.out.println(map);
        System.out.println(map.get("Berlin"));
    }
}