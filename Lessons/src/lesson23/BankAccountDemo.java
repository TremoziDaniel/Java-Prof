package lesson23;

public class BankAccountDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount ba = new BankAccount(500);
        Thread p1 = new Thread(() -> ba.pay(50, "Billy"));
        Thread p2 = new Thread(() -> ba.pay(100, "Bogdan"));
        Thread p3 = new Thread(() -> ba.pay(300, "Van"));
        Thread p4 = new Thread(() -> ba.pay(150, "Steve"));
        p1.start();
//        p1.join();
        p2.start();
//        p2.join();
        p3.start();
//        p3.join();
        p4.start();
//        p4.join();
        System.out.println(ba);
    }
}
