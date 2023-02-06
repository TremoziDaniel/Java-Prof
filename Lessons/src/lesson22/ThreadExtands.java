package lesson22;

public class ThreadExtands extends Thread {
    static int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("Thread #%d: %d", Thread.currentThread().getId(), i));
            count++;
            try {
                Thread.sleep(50);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count);
    }
}
