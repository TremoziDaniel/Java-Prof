package lesson3;

public class Cat extends Animal {
    public Cat() {super();}
    @Override
    public void voice() {
        System.out.println("meow");
    }
}