package homeWork25;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c, int i) {
        try {
            System.out.println(c.getName() + " начал этап " + i + ": " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап " + i + ": " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}