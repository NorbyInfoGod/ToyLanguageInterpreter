package utils;

import java.util.List;

public interface ExeStack<T> {
    void push(T elem);
    T pop();

    boolean isEmpty();

    List<T> getReverse();
}
