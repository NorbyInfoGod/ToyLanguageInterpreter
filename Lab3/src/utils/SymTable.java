package utils;

import exceptions.SymTableException;

public interface SymTable<K,V> {

    boolean isDefined(K key);

    void put(K key, V value) throws SymTableException;

    V lookup(K key);

    public void update(K key, V value);

    public String toString();


}