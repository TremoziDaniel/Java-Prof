package lesson24;

public class Printer {
    private volatile static long id = 1;
    private final Object mon = new Object();
    String obj = new String();
    public void print(Document doc) {
        id = Thread.currentThread().getId() > id ? Thread.currentThread().getId(): id;
        synchronized (mon) {
            int pageAmount = doc.getPageAmount();
            for (int i = 1; i <= pageAmount; i++) {
                System.out.printf("Thread: %d Doc: %s; page: %d — is printing...\n", Thread.currentThread().getId(), doc.getName(), i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("Thread: %d Doc: %s; page: %d — printed.\n", Thread.currentThread().getId(), doc.getName(), i);
            }
        }
    }
}
