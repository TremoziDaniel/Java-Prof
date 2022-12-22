package lesson15;



public class HashTable<K, V> {
    private int capacity = 30;
    private Entry<K, V>[] table;
    private int size = 0;

    public HashTable() {
        table = new Entry[capacity];
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    public Entry<K, V>[] getTable() {
        return table;
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        Entry<K, V> entry = new Entry(hash, key, value);
        int idx = hash & (capacity - 1);
        if (table[idx] == null) {
            table[idx] = entry;
        } else {
            Entry<K, V> pointer = table[idx];
            while (pointer.next != null) {
                if (pointer.key == key ) {
                    pointer.value = value;

                    return;
                }
                pointer = pointer.next;
            }
            if (pointer.key == key) {
                pointer.value = value;

                return;
            }
            pointer.next = entry;
        }
        size++;

//        if (capacity * 0.7 <= size) {
//            capacity *= 2;
//        }
    }

    public V get(K key) {
        int hash = key.hashCode();
        int idx = hash & (capacity - 1);
        if (table[idx] == null) {

            return null;
        }
        Entry<K, V> pointer = table[idx];
        do {
            if (pointer.key.equals(key)) {

                return pointer.value;
            }
            pointer = pointer.next;
        } while (pointer != null);

        return null;
    }

    public boolean remove(K key) {
        int hash = key.hashCode();
        int idx = hash & (capacity - 1);
        if (table[idx] == null) {

            return false;
        }
        Entry<K, V> pointer = table[idx];
        Entry<K, V> tmPointer = null;
        do {
            if (pointer.key.equals(key)) {
                if (tmPointer == null) {
                    table[idx] = pointer.next;
                }
                else {
                    tmPointer.next = pointer.next;
                }
                size --;

                return true;
            }
            tmPointer = pointer;
            pointer = pointer.next;
        } while (pointer != null);

        return false;
    }

    public class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public String toString() {
        int counter = 0;
        StringBuilder sb = new StringBuilder("{");
        for (Entry<K, V> entry: table) {
            if(entry != null) {
                Entry<K, V> pointer = entry;
                do {
                    sb.append(pointer.key + "=" + pointer.value);
                    counter++;
                    if (counter < size) {
                        sb.append(", ");
                    }
                    pointer = pointer.next;
                } while (pointer != null);
            }
        }

        return sb.append("}").toString();
    }
}
