package lesson6;

public class Lesson6 {
    public static void main(String[] args) {
//        RubberArray ra = new RubberArray();
//        ra.addAll("aa", "bb", "cc");
//        System.out.println(ra);
//        RubberArray intRA = new RubberArray();
//        intRA.addAll(1, 2, 3, 4);
        SimpleBox<Integer> dig1 = new SimpleBox<>(1);
        SimpleBox<Integer> dig2 = new SimpleBox<>(2);
        int sum = dig1.getObject() + dig2.getObject();
        System.out.println(sum);
    }
}
