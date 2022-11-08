package HomeWork3;

public class Cat extends Animal {
    String kind = "Cat";

    public Cat(double runDist, double swimDist) {
        super(runDist, swimDist);
    }

    public void run() {
        if (runDist == 1)
            System.out.println(kind + " has just run " + runDist + " meter.");
        else if (runDist == 0)
            System.out.println(kind + " stayed put.");
        else if (runDist <= 200)
            System.out.println(kind + " has just run " + runDist + " meters.");
        else
            System.out.println(kind + " is astonished.");
    }

    public void swim() {
        System.out.println(kind + " can't swim!");
    }

    @Override
    public String toString() {
        return kind + "{" +
                "runDist=" + runDist +
                ", swimDist=" + swimDist +
                '}';
    }
}