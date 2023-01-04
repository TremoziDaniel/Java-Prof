package homeWork16;

public class Lesson16 {
    public static void main(String[] args) {
        Operationable addition = (x, y) -> x + y;
        Operationable substraction = (x, y) -> {return x - y;};
        Operationable multiplication = (x, y) -> x * y;
        Operationable division = (x, y) -> x / y;


        int a = addition.calculate(5, 5);
        int b = substraction.calculate(5, 5);
        System.out.println(a);
        System.out.println(b);

        // TODO 4. Прочитать Глава 8. Лямбда-вырадения(metanit), попробовать обобщённый функциональный интерфейс
    }
}
