package lesson13;

import java.util.*;

public class Lesson13 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList("hello", "welcome", "java", "bye", "day"));
        System.out.println(stringList);
        Set<String> treeSet = new TreeSet<>(stringList);
        System.out.println(treeSet);

        List<Person> personList = new ArrayList<>();
        personList.addAll(Arrays.asList(
                new Person("Mike", 32),
                new Person("John", 35),
                new Person("Mike", 23),
                new Person("Luke", 28)));
        System.out.println(personList);
        Set<Person> personSet = new TreeSet<>(personList);
        System.out.println(personSet);

        ComparatorAge comparatorAge = new ComparatorAge();
        Set<Person> ageSortedAge = new TreeSet<>(comparatorAge);
        ageSortedAge.addAll(personList);
        System.out.println(ageSortedAge);

        ComparatorName comparatorName = new ComparatorName();
        Set<Person> ageSortedName = new TreeSet<>(comparatorName);
        ageSortedName.addAll(personList);
        System.out.println(ageSortedName);
        personList.sort(comparatorName);
        System.out.println(personList);


        Comparator<Person> compareNameAge = new ComparatorName().thenComparing(new ComparatorAge());
        personList.sort(compareNameAge);
        System.out.println(personList);
    }
}
