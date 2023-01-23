package homeWork18;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    public MyArraySizeException(int row, int columns, int size) {
        super("Array layouts " + row + "x" + columns + " out of myArray bounds " + size + "x" + size);
    }
}
