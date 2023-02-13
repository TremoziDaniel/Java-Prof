package homeWork25;

import java.util.concurrent.Semaphore;

import static homeWork25.RaceDemo.CARS_COUNT;

public class Tunnel extends Stage {
    private final static Semaphore SEMAPHORE = new Semaphore(CARS_COUNT/2, true);
    public Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c, int i) {
        System.out.println(c.getName() + " готовится к этапу " + i + "(ждет): " + description);
        try {
            SEMAPHORE.acquire();
                try {
                    System.out.println(c.getName() + " начал этап " + i + ": " + description);
                    Thread.sleep(length / c.getSpeed() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(c.getName() + " закончил этап " + i + ": " + description);
                    SEMAPHORE.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}