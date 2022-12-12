package lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapVersusList {
    public static void main(String[] args) {
        final long COUNT = 1_024_000;

        List<Employee> employeesList = new ArrayList<>();
        Map<Integer, Employee> employeesMap = new HashMap<>();
        for (int i = 0; i < COUNT; i++) {
            employeesList.add(new Employee("John", "engineer", i, 36));
            employeesMap.put(i, employeesList.get(i));
        }

        compareListMap(employeesList, employeesMap, 1);
        compareListMap(employeesList, employeesMap, 512000);
        compareListMap(employeesList, employeesMap, 1024000);
    }

    public static void compareListMap(List<Employee> employeesList, Map<Integer, Employee> employeesMap, int id) {
        // List
        long time = System.currentTimeMillis();
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getId() == id) {
                System.out.println("List: " + (System.currentTimeMillis() - time));
                System.out.println("Done");
                break;
            }
        }

        // Map
        time = System.currentTimeMillis();
        employeesMap.get(id);
        System.out.println("Map: " + (System.currentTimeMillis() - time));
    }
}
