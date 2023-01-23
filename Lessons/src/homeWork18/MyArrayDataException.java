package homeWork18;

public class MyArrayDataException extends IllegalArgumentException {
    public MyArrayDataException(String obj, int row, int columns) {
        super("String type object " + obj + " in " + row + "x" + columns + " is not a number!");
    }
}
