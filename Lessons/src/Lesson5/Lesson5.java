package Lesson5;

public class Lesson5 {
    public static void main(String[] args) {
        RubberArray rArr = new RubberArray();
        System.out.println(rArr);
        rArr.add(12);
        rArr.add(3);
        rArr.add(5);
        System.out.println(rArr);
        System.out.println(rArr.get(2));
//        rArr.rm(2);
//        rArr.rm(1);
//        rArr.rm(0);
        System.out.println(rArr.contains(5));
        System.out.println(rArr.contains(8));
    }
}
