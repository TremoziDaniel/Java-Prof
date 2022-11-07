package Lesson2;

public class Animal {
    protected String name/* = "Dan"*/;
    protected String color;
    protected int age;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Animal() {super();}

    public void voice() {
        System.out.println("undefined");
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}