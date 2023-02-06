package lesson23;


public class PrintABDemo {
    public static void main(String[] args) {
        PrintAB ab = new PrintAB();
        new Thread(() -> ab.printA()).start();
        new Thread(() -> ab.printB()).start();
    }
}
