package HomeWork3;

public class Dog extends Animal {
    String kind = "Dog";

    public Dog(double runDist, double swimDist) {
        super(runDist, swimDist);
    }

    public void run() {
        if (runDist == 1)
            System.out.println(kind + " has just run " + runDist + " meter.");
        else if (runDist == 0)
            System.out.println(kind + " stayed put.");
        else if (runDist <= 200  && runDist > 0)
            System.out.println(kind + " has just run " + runDist + " meters.");
        else
            System.out.println(kind + " is astonished.");
    }

    public void swim() {
        if (swimDist == 1)
            System.out.println(kind + " has just swum " + swimDist + " meter.");
        else if (swimDist == 0)
            System.out.println(kind + " stayed put.");
        else if (swimDist <= 500 && swimDist > 0)
            System.out.println(kind + " has just swum " + swimDist + " meters.");
        else
            System.out.println(kind + " is astonished.");
    }

    @Override
    public String toString() {
        return kind + "{" +
                "runDist=" + runDist +
                ", swimDist=" + swimDist +
                '}';
    }
}