package lesson23;

public class PrintAB {
    private final Object mon = new Object();
    private volatile char currentChar = 'A';

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (currentChar != 'A') {
                        mon.wait();
                    }
                    System.out.print('A');
                    currentChar = 'B';
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (currentChar != 'B') {
                        mon.wait();
                    }
                    System.out.print('B');
                    currentChar = 'A';
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
