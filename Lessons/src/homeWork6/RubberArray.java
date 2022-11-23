package homeWork6;

import java.util.List;
import java.util.ArrayList;

public class RubberArray<T> {
        private T[] array;

        public void add(T item) {
            if (array == null)
                array = (T[]) new Object[0];
            T[] newArray = (T[]) new Object[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[array.length] = item;
            array = newArray;
        }

        public T get(int idx) {
            return array[idx];
        }

        public int size() {
            if (array != null)
                return array.length;
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

        public void rm(T n) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(n))
                    rm(i);
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

        public void replace(int idx1, int idx2) {
            T temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
        }

        public List<T> toArrayList() {
            List<T> arrayList = new ArrayList<T>();
            for (T item: array) {
                arrayList.add(item);
            }
            return arrayList;
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
