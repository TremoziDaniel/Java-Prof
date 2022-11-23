package homeWork3;

abstract public class Animal implements IAnimal {
    protected double runDist;
    protected double swimDist;
    protected String kind = "Animal";
    private static int amount = 0;

    public Animal(double runDist, double swimDist) {
        this.runDist = runDist;
        this.swimDist = swimDist;
        amount++;
    }

    public void run() {
        System.out.println("undefined object can't run");
    }

    public void swim() {
        System.out.println("undefined object can't swim");
    }

    public static void getAmount() {
        System.out.println(amount);
    }

    @Override
    public String toString() {
        return kind + "{" +
                "runDist=" + runDist +
                ", swimDist=" + swimDist +
                '}';
    }
}