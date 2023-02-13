package homeWork25;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static CountDownLatch CARS_COUNTDOWN;
    protected static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static boolean winner = false;
    private static long lastThread;
    private static final Object node = new Object();

    public synchronized String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + ++CARS_COUNT;
        CARS_COUNTDOWN = new CountDownLatch(CARS_COUNT);
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            lastThread = Thread.currentThread().getId();
            System.out.println(this.name + " готов");
            CARS_COUNTDOWN.countDown();
            CARS_COUNTDOWN.await();
            CARS_COUNTDOWN = new CountDownLatch(CARS_COUNT);
            if (Thread.currentThread().getId() == lastThread) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this, i + 1);
        }
        synchronized (node) {
            if (!winner) {
                System.out.println(this.name + " – WIN");
                winner = true;
            }
            lastThread = Thread.currentThread().getId();
        }
        try {
            CARS_COUNTDOWN.countDown();
            CARS_COUNTDOWN.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (Thread.currentThread().getId() == lastThread) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
}