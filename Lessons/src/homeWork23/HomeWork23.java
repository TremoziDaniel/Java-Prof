package homeWork23;

public class HomeWork23 {
    public static void main(String[] args) {
        PrintABC abc = new PrintABC();
        new Thread(() -> abc.printA()).start();
        new Thread(() -> abc.printB()).start();
        new Thread(() -> abc.printC()).start();

        PrinterThread pt = new PrinterThread();
        new Thread(() -> pt.print("Hello, World!")).start();
        new Thread(() -> pt.print("Lorem ipsum dolor sit amet, consectetur adipiscing elit,\n" +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")).start();
        new Thread(() -> pt.print("Ut enim ad minim veniam, quis nostrud exercitation\n" +
                "ullamco laboris nisi ut aliquip ex ea commodo consequat.")).start();
    }
}
