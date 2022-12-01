package lesson9;

import java.util.Iterator;

public class RubberList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public void push(T value) {
        if (first == null) {
            first = new Node<>(value, null, null);
            size = 1;
        } else if (first.next == null) {
            last = new Node<>(value, first, null);
            first.next = last;
            size++;
        } else {
            Node<T> buffer = new Node<>(value, last, null);
            last.next = buffer;
            last = buffer;
            size++;
        }
    }
// Внизу есть удаление по индексу
    public T pop() {
        T value = getLast();

        if (size == 1) {
            first = null;
        } else if (last.prev == first) {
            first.next = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;

        return value;
    }

    public T getFirst() {return first == null ? null : first.value;}

    public T getLast() {return last == null ? null : last.value;}

    public void addAll(T... values) {
        for (T value: values) {
            push(value);
        }
    }

    public int size() {return size;}

    public boolean remove(T value) {
        Node<T> cursor = first;

        if (first != null) {
            if (cursor.value.equals(value)) {
                if (first.next != null) {
                    first = first.next;
                } else if (first.next == last) {
                    first = last;
                    first.prev = null;
                    last = null;
                } else {
                    first = null;
                }
                size--;

                return true;
            } else if (first.next == null) {

                return false;
            }

            do {
                cursor = cursor.next;
                if (cursor.value.equals(value)) {
                    if (cursor == last) {
                        pop();
                    } else {
                        cursor.prev.next = cursor.next;
                        cursor.next.prev = cursor.prev;
                        cursor = null;
                    }
                    size--;

                    return true;
                }
            } while (cursor.next != null);
        }

        return false;
    }

    public boolean remove (int idx) {
        if (size > idx) {
            Node<T> cursor = first;
            for (int i = 0; i < size; i++) {
                if(i == idx) {
                    if(cursor == first) {
                        if (first.next == last) {
                            first = last;
                            last = null;
                        } else if ( first.next == null) {
                            first = null;
                        } else {
                            first = first.next;
                        }
                    } else if (cursor == last) {
                        pop();
                    } else {
                        cursor.prev.next = cursor.next;
                        cursor.next.prev = cursor.prev;
                        cursor = null;
                    }
                    size--;

                    return true;
                }
                cursor = cursor.next;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private Node<T> cursor = first;
        private T value;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            value = cursor.value;
            cursor = cursor.next;
            return value;
        }

        @Override
        public void remove() {
            if (value != null) {
                RubberList.this.remove(value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (first != null) {
            Node<T> cursor = first;
            do {
                sb.append(cursor.value);
                cursor = cursor.next;
                if (cursor != null) {
                    sb.append(", ");
                }
            } while (cursor != null);
        }
        return sb.append("]").toString();
    }

    private class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }


}
