package HomeWork3;
import static HomeWork3.Animal.wchAmount;

public class MainZoo {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(0, 0), new Dog(0, 0),
        new Cat(20.01, 20), new Dog(20.5, 1),
        new Cat(300, 300), new Dog(-600, 600)};

        for (Animal animal: animals) {
            System.out.println("\n" + animal);
            animal.run();
            animal.swim();
        }

        wchAmount();
    }
}