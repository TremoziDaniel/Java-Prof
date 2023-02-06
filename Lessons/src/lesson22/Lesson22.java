package lesson22;

public class Lesson22 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(100);
        System.out.println(String.format("Thread #%d: %s", Thread.currentThread().getId(), Thread.currentThread().getName()));
        System.out.println(Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis());
        System.out.println(Thread.getAllStackTraces());

//        Implemets Runnable
//        Thread thread1 = new Thread(new RunnableImpl());
//        Thread thread2 = new Thread(new RunnableImpl());

//        Extends Thread
        Thread thread1 = new ThreadExtands();
        Thread thread2 = new ThreadExtands();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(String.format("Thread #%d: %d", Thread.currentThread().getId(), i));
            }
        });

//        thread1.setDaemon(true);
        thread1.start();
        thread1.join();
//        thread2.start();
//        thread.start();
        System.out.println("END");
    }
}
