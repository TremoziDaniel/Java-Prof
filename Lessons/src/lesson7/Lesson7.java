package lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lesson7 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 6, 2, 9, 1));
        for (Integer number: numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        int[] arr = {1, 2, 3, 5, 8};
        for (int item: arr) {
            System.out.print(item + " ");
        }
        System.out.println();

        RubberArray<Integer> ra = new RubberArray<Integer>();
        ra.addAll(9, 3, 5, 7, 0);
        Iterator<Integer> iterator = ra.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
