package homeWork6;

import java.util.List;
import java.util.ArrayList;

public class Lesson6 {
    public static void main(String[] args) {
        RubberArray<Integer> ra = new RubberArray<>();
        ra.addAll(1, 2, 3, 4);
        ra.rm(0);
        ra.replace(0, 2);
        System.out.println(ra);
        System.out.println(ra.toArrayList());
    }
}
