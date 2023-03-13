package lesson31;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom", 5);
        System.out.println(cat);

        try {
            Field field = cat.getClass().getDeclaredField("a");
            field.setAccessible(true);
            field.set(cat, 8);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cat);

        // call Cat method voice() with reflect
        // TODO
        try {
            Method catVoice = Cat.class.getDeclaredMethod("voice", null);
            catVoice.invoke(cat);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
