package lesson8;

public class RubberList<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public void add(T value) {
        if (first == null) {
            first = new Node<>(value, null, null);
            size = 1;
        } else if (first.next == null) {
            last = new Node<>(value, first, null);
            first.next = last;
            size++;
        } else {
            Node<T> mid = new Node<>(value, last, null);
            last.next = mid;
            last = mid;
            size++;
        }
    }

    public T getFirst() {
        return first == null ? null : first.value;
    }

    public T getLast() {
        return last == null ? null : last.value;
    }

    public boolean remove(T value) {
        Node<T> cursor = first;

        if (first != null) {
            if (cursor.value.equals(value)) {
                if (first.next != null) {
                    first = first.next;
                } else if (first.next == last) {
                    first = last;
                    first.prev = null;
//                    last = null;
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
                    if (cursor.next == null) {
                        last = last.prev;
                        last.next = null;
                    } else if(last.prev == first) {
                        last = first;
                        first.prev = null;
                    } else {
                        cursor.prev.next = cursor.next;
                        cursor.next.prev = cursor.prev;
                    }
                    size++;

                    return true;
                }
            } while (cursor.next != null);
        }

        return false;
    }

    public int size() {return size;}

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
