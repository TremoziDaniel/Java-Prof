package lesson5;

import java.util.Arrays;

public class RubberArray {
    private int[] array;

    public void add(int item) {
        if (array == null)
            array = new int[0];
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = item;
        array = newArray;
    }

    public int get(int i) {
        return array[i];
    }

    public int size() {
        if (array != null)
            return array.length;
        return 0;
    }

    public void rm(int i) {
        if (array != null && array.length > 0) {
            int[] newArr = new int[array.length - 1];
            System.arraycopy(array, 0, newArr, 0, i);
            System.arraycopy(array, i + 1, newArr, i, newArr.length - i);
            array = newArr;
        }
    }

    public boolean contains(int item) {
        for(int i: array) {
            if (i == item)
                return true;
        }
        return false;
    }

    public void addAll (int... items) {
        for (int item: items) {
            add(item);
        }
    }

    public int[] toArray() {
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i != array.length - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
