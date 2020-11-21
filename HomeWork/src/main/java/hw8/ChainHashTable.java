package hw8;

public interface ChainHashTable<K, V> {
    void add(K x, V y);

    void delete(K x);

    K search(K x);

    String print();
}
