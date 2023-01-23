package homeWork18;

import java.util.Arrays;

public class MyArray {
    String[][] array;
    final int myArraySize = 4;

    MyArray(String[][] array) {
        this.array = array;
        myArraySizeThrow();
    }

    public double myArraySum() {
        myArrayDataThrow();
        double[][] perSum = Arrays.stream(array)
                .map(s -> Arrays.stream(s).mapToDouble(Double::parseDouble).toArray())
                .toArray(double[][]::new);
        double sum  = Arrays.stream(perSum)
                .mapToDouble(s -> Arrays.stream(s).sum())
                .sum();

//        2 Вариант

//        int sum = Arrays.stream(Arrays.stream(array)
//                .map(s -> Arrays.stream(s)
//                        .mapToInt(Double::parseDouble)
//                        .toArray())
//                .toArray(int[][]::new))
//                .mapToInt(s -> Arrays.stream(s)
//                        .sum())
//                .sum();

        return sum;
    }

    private void myArraySizeThrow() {
        if (array.length != myArraySize) {
            throw new MyArraySizeException(array.length, array[0].length, myArraySize);
        }
        for (String arr[] : array) {
            if(arr.length != myArraySize) {
                throw new MyArraySizeException(array.length, arr.length, myArraySize);
            }
        }
    }

    private void myArrayDataThrow() {
//        try {
//            Arrays.stream(array)
//                    .forEach(e -> Arrays.stream(e).forEach(v -> Double.parseDouble(v)));
//        } catch (NumberFormatException exception) {
//            throw new MyArrayDataException();
//        }
        for (int i = 0; i < myArraySize; i++) {
            for (int j = 0; j < myArraySize; j++) {
                try {
                    Double.parseDouble(array[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(array[i][j], i, j);
                }
            }
        }
    }
}
