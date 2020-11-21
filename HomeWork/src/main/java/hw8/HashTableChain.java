package hw8;

public class HashTableChain <K, V> implements ChainHashTable<K, V>{
    private static final int START_CAPACITY = 16;

    private HashTableChain.Chain<K, V>[] table;

    private int capacity;

    static class Chain<K, V> {
        private K key;
        private V value;
        private Chain next;

        Chain(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public Chain getNext() {
            return next;
        }

        public void setNext(Chain next) {
            this.next = next;
        }
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    public HashTableChain() {
        capacity = START_CAPACITY;
        table = new Chain[capacity];
        for (int i = 0; i < capacity; ++i) {
            table[i] = null;
        }
    }

    public HashTableChain(int capacity) {
        table = new Chain[capacity];
        this.capacity = capacity;
        for (int i = 0; i < this.capacity; i++) {
            table[i] = null;
        }
    }

    @Override
    public void add(K key, V value) {
        final int hash = hash(key);
        if (table[hash] == null) {
            table[hash] = new Chain(key, value);
        } else {
            Chain entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key) {
                entry = entry.getNext();
            }
            if (entry.getKey() == key) {
                entry.setValue(value);
            } else {
                entry.setNext(new Chain(key, value));
            }
        }
    }

    @Override
    public void delete(K key) {
        final int hash = hash(key);
        if (table[hash] != null) {
            Chain prevEntry = null;
            Chain entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getKey() == key) {
                if (prevEntry == null) {
                    table[hash] = entry.getNext();
                } else {
                    prevEntry.setNext(entry.getNext());
                }
            }
        }
    }

    @Override
    public K search(K key) {
        final int hash = hash(key);
        if (table[hash] == null)
            return null;
        else {
            Chain entry = table[hash];
            while (entry != null && entry.getKey() != key) {
                entry = entry.getNext();
            }
            if (entry == null) {
                return null;
            } else {
                return (K) entry.getKey();
            }
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < capacity; ++i) {
            final Chain entry = table[i];
            if (entry != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String print() {
        final StringBuilder description = new StringBuilder("Hash table: [ ");
        for (int i = 0; i < capacity; i++) {
            description.append("{  ");
            if (table[i] != null) {
                Chain entry = table[i];
                do {
                    description.append(String.format("%d  ", entry.getValue()));
                    entry = entry.getNext();
                } while (entry != null);
            }
            description.append("} ");
        }
        description.append(']');
        return description.toString();
    }
}
