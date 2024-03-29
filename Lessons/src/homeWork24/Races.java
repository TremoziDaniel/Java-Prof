package homeWork24;

public class Races {
    private static final Object node = new Object();
    int circles;
    int circleFinishesCount = 0;
    boolean finish = false;

    public Races(int circles) {
        this.circles = circles;
        System.out.println("Race has started.");
    }

    public void drive(SportsCar sportsCar) {
        synchronized (node) {
                for (int i = 1; i <= circles; i++) {
                    try {
                        System.out.println("Racer " + sportsCar.name + " by number " + sportsCar.number + " finishes "
                        + i + " circle");
                        circleFinishesCount++;
                        Thread.sleep(200);
                        if (circleFinishesCount == sportsCar.getSportscarsAmount()) {
//                            Thread.sleep(200);
//                            System.out.println("All participants finished " + i + " circle.");
                            circleFinishesCount = 0; // If everyone finished circle wakes up all Threads
                            node.notifyAll();
                        }
                        if (i == circles) {
                            break;
                        }
                        node.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!finish) {
                    System.out.println(sportsCar.name + " by number " + sportsCar.number + " first reaching the finish!!!");
                    finish = true;
                }
        }
    }
}