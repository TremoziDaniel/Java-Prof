/*
    Danil Izmajlov
    java_39e
    Home work 6
    21.11
*/
package homeWork6;

import java.util.List;
import java.util.ArrayList;

public class FruitStorage {
    public static void main(String[] args) {
        Apple apple = new Apple(0.15f);
        Box box = new Box();
        box.addFruit(apple, 3);
        System.out.println(box);
        System.out.println(box.getWeight());
    }
}
