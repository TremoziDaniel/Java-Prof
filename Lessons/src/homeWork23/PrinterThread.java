package homeWork23;

public class PrinterThread {
    private final Object mon = new Object();

    public void print(String text) {
        synchronized (mon) {
            try {
                System.out.println("\nПечать: " + Thread.currentThread().getId());
                System.out.println(text);
                mon.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
