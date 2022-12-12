package lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    List<Employee> employees;
    Map<Integer, Employee> idxEmployees;

    public Database (List<Employee> employees) {
        // create List
        this.employees = new ArrayList<>(employees);
//        this.employees.addAll(employees);
        // create Map
        this.idxEmployees = new HashMap<>();
        for(Employee employee: employees) {
            idxEmployees.put(employee.getId(), employee);
        }
    }

    public void create() {
        Employee employee = DataUtil.getEmployee("Create employee");
        employees.add(employee);
        idxEmployees.put(employee.getId(), employee);
    }

    public void read() {
        DataUtil.print(employees);
    }

    private Employee findById(int id) {
//        for (Employee employee: employees) {
//            if (employee.getId() == id) {
//                return employee;
//            }
//        }
//        return null;
        return idxEmployees.get(id);
    }

    public void update() {
        int id = DataUtil.getInt("Update by id: ");
        Employee employee = findById(id);
        if (employee != null) {
            Employee tmpUpdt = DataUtil.getEmployeeUpdate("Update {positon, salary, age}: ");
            employee.update(tmpUpdt.getPosition(), tmpUpdt.getSalary(), tmpUpdt.getAge());
            System.out.println(employee + " updated.");
        } else {
            System.out.println("This is employee don't exist or was fired");
        }
    }

    public void delete() {
        System.out.print("Delete find: ");
        int id = DataUtil.getInt("");
        Employee employee = findById(id);
        if (employee != null) {
            employees.remove(employee);
            idxEmployees.remove(employee.getId());
            System.out.println("Deleted " + employee);
        }
    }

    public void find() {
        System.out.print("find: ");
        String name = DataUtil.getString("find: ");
        List<Employee> found = new ArrayList<>();
        for (Employee employee: employees) {
            //if (employee.getName().equalsIgnoreCase(name)) {
            if (employee.getName().contains(name)) {
                found.add(employee);
            }
        }

        DataUtil.print(found);
    }
}
