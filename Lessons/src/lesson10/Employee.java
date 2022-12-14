package lesson10;

public class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;
    private int age;
    private static int count = 1_000;

    public Employee(String name, String position, double salary, int age) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.age = age;
        this.id = ++count;
    }

    public String getName() {return name;}

    public int getId() {return id;}

//    public int count() {return count;}

    public void update(String position, int salary, int age) {
        this.position = position;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee №" + id + "\n" +
                "{name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
