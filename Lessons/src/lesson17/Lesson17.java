package lesson17;

import lesson12.Employee;
import lesson12.DBInit;
import lesson12.Position;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lesson17 {
    public static void main(String[] args) {
        List<Employee> employees = DBInit.init();
        System.out.println(employees);

        // Фильтрация списка
        List<Employee> engineers = employees.stream()
                .filter(e -> e.getPosition() == Position.ENGINEER)
                .collect(Collectors.toList());
        System.out.println(engineers);

        // Преобразование списка
        Set<Position> positions = employees.stream()
                .map(e -> e.getPosition())
                // .distinct()
                .collect(Collectors.toSet());
        System.out.println(positions);

        // Преобразование списка в map
        Map<Integer, Employee> employeeMap = employees.stream()
                //.collect(Collectors.toMap(e -> e.getId(), e -> e));
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
        System.out.println(employeeMap);

        // Преобразовать в сложную map
        Map<Position, List<Employee>> positionMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition));
        System.out.println(positionMap);
    }

    static void firstMeeting() {
        List<Employee> employees = DBInit.init();
        System.out.println(employees);

        long count = 0;
        for(Employee employee: employees) {
            if(employee.getPosition() == Position.ENGINEER) {
                count++;
            }
        }
        System.out.println(count);

        count = 0;
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if(employee.getPosition() == Position.ENGINEER) {
                count++;
            }
        }
        System.out.println(count);

        count = employees.stream()
                .filter(e -> e.getPosition() == Position.ENGINEER)
                .count();
        System.out.println(count);

        Optional<Integer> summ = Stream.of(1, 2, 3, 4, 5, 6).reduce((a, b) -> a + b);
        int sum = IntStream.of(1, 2, 3, 4, 5, 6).reduce(0, (a, b) -> a + b)/*.orElse(0)*/;
    }
}
