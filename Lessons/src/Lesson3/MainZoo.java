package Lesson3;

public class MainZoo {
    public static void main(String[] args) {
        Dog dog = new Dog("Archi", "black", 8);
        Cat cat = new Cat();

        IAnimal[] animals = {cat, dog};
        for (IAnimal animal : animals) {
            animal.voice();
        }
    }
}