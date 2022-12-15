package lesson14;

import java.util.*;

public class Lesson14 {
    public static void main(String[] args) {
        HashTable<String, String> hashT = new HashTable<>();
        hashT.put("Kiev", "Ukraine");
        hashT.put("Kiev", "Ukraine");
        hashT.put("Krakow", "Poland");
        hashT.put("Paris", "France");
        hashT.put("Amsterdam", "Niderland");
        hashT.put("Moscow", "Russia");
        System.out.println(hashT.get("Kiev"));
        System.out.println(hashT.get("Krakow"));
        System.out.println(hashT.get("Amsterdam"));
        System.out.println(hashT.get("Moscow"));
        System.out.println(hashT);
//        Map<String, String> map = new HashMap<>();
//        map.put("Kiev", "Ukraine");
//        map.put("Krakow", "Poland");
//        map.put("Krakov", "Poland");
//        map.put("Moscow", "Russia");
//        System.out.println(map);
//        System.out.println(map.get("Kiev"));
//        System.out.println(map.keySet());
//        System.out.println(map.values());
//        System.out.println(map.entrySet());

//        ArrayList<Integer> arrayList = new ArrayList<>();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        Set<Integer> hashSet = new HashSet<>();
//        ex(arrayList);
//        ex(linkedList);
//        ex(hashSet);
    }

//    private static void ex(Collection<Integer> list) {
//        // TODO
//    }
}
