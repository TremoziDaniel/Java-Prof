package lesson22;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("Thread #%d: %d", Thread.currentThread().getId(), i));
        }
    }
}
