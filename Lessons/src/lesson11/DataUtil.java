package lesson11;

import java.util.List;
import java.util.Scanner;

public class DataUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        String str = scanner.next();

        return str;
    }

    public static int getInt(String prompt) {
        System.out.print(prompt);
        int num = scanner.nextInt();

        return num;
    }

    public static double getDouble(String prompt) {
        System.out.print(prompt);
        double num = scanner.nextDouble();

        return num;
    }

    public static Employee getEmployee(String prompt){
        System.out.println(prompt);
        String name = DataUtil.getString("name: ");
        String position = DataUtil.getString("position: ");
        double salary = DataUtil.getInt("salary: ");
        int age = DataUtil.getInt("age: ");

        return new Employee(name, position, salary, age);
    }

    public static Employee getEmployeeUpdate(String prompt){
        System.out.println(prompt);
        String position = DataUtil.getString("position: ");
        double salary = DataUtil.getInt("salary: ");
        int age = DataUtil.getInt("age: ");

        return new Employee(null, position, salary, age);
    }

    public static void print(List<Employee> toPrint) {
        if (toPrint.size() == 0) {
            System.out.println("No employees");
        } else {
            for (Employee employee : toPrint) {
                System.out.println(employee);
            }
        }
    }
}
