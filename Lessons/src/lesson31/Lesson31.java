package lesson31;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Lesson31 {
    public static void main(String[] args) {
        // get class obj - #1
        String s = "Java";
        Class stringClass = s.getClass();

        // get class obj - #2
        Class strClass = String.class;
        Class intClass = int.class;
        Class voidClass = void.class;

        // get output
        System.out.println(stringClass.getName());
        System.out.println(stringClass.getSimpleName());
        System.out.println(intClass.getName());
        System.out.println(voidClass.getName());

        // Cat Class
        Class catClass = Cat.class;
        System.out.println(catClass.getName());
        System.out.println("Superclass: " + catClass.getSuperclass().getName());
        int m = catClass.getModifiers();
        if (Modifier.isPublic(m)) {
            System.out.println("public");
        }
        if (Modifier.isAbstract(m)) {
            System.out.println("abstract");
        }
        if (Modifier.isFinal(m)) {
            System.out.println("final");
        }

        //Cat Fields
        System.out.println("Fields:");
        Field[] fields = catClass.getFields();
        for (Field f: fields) {
            System.out.println(f.getType() + ":" + f.getName());
        }

        fields = catClass.getDeclaredFields();
        for (Field f: fields) {
            System.out.println(f.getType().getSimpleName() + ":" + f.getName());
        }

    }
}
