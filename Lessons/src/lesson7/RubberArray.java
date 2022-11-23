package lesson7;

import java.util.Iterator;

public class RubberArray<T> implements Iterable<T> {
        private T[] array;

        public void add(T item) {
            if (array == null) {
                array = (T[]) new Object[0];
            }
            T[] newArray = (T[]) new Object[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[array.length] = item;
            array = newArray;
        }

        public T get(int idx) {
            return array[idx];
        }

        public int size() {
            if (array != null) {
                return array.length;
            }
            return 0;
        }

        public void rm(int i) {
            if (array != null && array.length > 0) {
                T[] newArr = (T[]) new Object[array.length - 1];

                System.arraycopy(array, 0, newArr, 0, i);
                System.arraycopy(array, i + 1, newArr, i, newArr.length - i);
                array = newArr;
            }
        }

        public void addAll (T... items) {
            for (T item: items) {
                add(item);
            }
        }

        public T[] toArray() {
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

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
            private int cursor = -1;

        @Override
        public boolean hasNext() {
            return array != null && array.length - 1 > cursor;
        }

        @Override
        public T next() {
            return array[++cursor];
        }
    }
}
