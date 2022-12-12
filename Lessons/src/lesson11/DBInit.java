package lesson11;

import java.util.Arrays;
import java.util.List;

public class DBInit {
    public static List<Employee> init() {
        List<Employee> employees = Arrays.asList(
        new Employee("john", "boss", 1500, 45),
        new Employee("jina", "assistent", 650, 21),
        new Employee("bill", "enginer", 1050, 35),
        new Employee("john", "enginer", 1100, 35));

        return employees;
    }
}
