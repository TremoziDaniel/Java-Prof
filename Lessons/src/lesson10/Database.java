package lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    List<Employee> employees = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void init(List<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void create() {
        System.out.println("Create employee");
        System.out.print("name: ");
        String name = scanner.next();
        System.out.print("position: ");
        String position = scanner.next();
        System.out.print("salary: ");
        double salary = scanner.nextDouble();
        System.out.print("age:");
        int age = scanner.nextInt();
        employees.add(new Employee(name, position, salary, age));
    }

    public void read() {
        if (employees.size() == 0) {
            System.out.println("No employees");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private Employee findById(int id) {
        for (Employee employee: employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void update() {
        System.out.print("Update by id: ");
        int id = scanner.nextInt();
        Employee employee = findById(id);
        if (employee != null) {
            System.out.print("Update {positon, salary, age}: ");
            String position = scanner.next();
            int salary = scanner.nextInt();
            int age = scanner.nextInt();
            employee.update(position, salary, age);
            System.out.println(employee + " updated.");
        } else {
            System.out.println("This is employee don't exist or was fired");
        }
    }

    public void delete() {
        System.out.print("Delete find: ");
        int id = scanner.nextInt();
        Employee employee = findById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Deleted " + employee);
        }
    }
}
