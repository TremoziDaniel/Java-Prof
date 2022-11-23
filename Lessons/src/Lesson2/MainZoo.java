package lesson2;

import java.sql.SQLOutput;

public class MainZoo {
    public static void main(String[] args) {
        Dog dog = new Dog("Archi", "black", 8);
        Cat cat = new Cat();

        System.out.println(dog);
        System.out.println(cat);
        dog.voice();
        cat.voice();

        System.out.println(add(3, 2));
        System.out.println(add(3.5, 2.5));
        System.out.println(add("123", "45"));
    }

    static int add (int a, int b) {
        return a + b;
    }

    static double add (double a, double b) {
        return a + b;
    }

    static String add (String a, String b) {
        return a + b;
    }
}