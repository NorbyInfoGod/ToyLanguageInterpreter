package utils;

import exceptions.SymTableException;

import java.util.HashMap;
import java.util.Map;

public class SymTableDict<K,V> implements SymTable<K,V> {

    Map<K,V> dictionary;
    public SymTableDict()
    {
        dictionary = new HashMap<>();
    }
    @Override
    public boolean isDefined(K key) {
        return dictionary.containsKey(key);
    }

    @Override
    public void put(K key, V value) throws SymTableException{
        if(isDefined(key))
            throw new SymTableException("Variable already declared");
        dictionary.put(key,value);
    }

    @Override
    public V lookup(K key) {
        return dictionary.get(key);
    }
    @Override
    public void update(K key, V value){
        dictionary.put(key, value);
    }
    @Override
    public String toString()
    {
        return ""+dictionary;
    }
}
