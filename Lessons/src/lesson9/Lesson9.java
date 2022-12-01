package lesson9;

import java.util.Iterator;

public class Lesson9 {
    public static void main(String[] args) {
        RubberList<Integer> rl = new RubberList<Integer>();
        rl.addAll(11, 22);
        rl.remove(1);
        System.out.println(rl);

//        Iterator<Integer> iterator = rl.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next() + " ");
//        }
    }
}
