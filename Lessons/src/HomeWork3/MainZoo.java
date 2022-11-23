package homeWork3;
import static homeWork3.Animal.getAmount;

public class MainZoo {
    public static void main(String[] args) {
        IAnimal[] animals = {new Cat(0, 0), new Dog(0, 0),
        new Cat(20.01, 20), new Dog(20.5, 1),
        new Cat(300, 300), new Dog(-600, 600)};

        for (IAnimal animal: animals) {
            System.out.println("\n" + animal);
            animal.run();
            animal.swim();
        }

        getAmount();
    }
}