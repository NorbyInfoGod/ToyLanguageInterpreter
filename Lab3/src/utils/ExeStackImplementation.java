package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ExeStackImplementation<T> implements ExeStack<T> {

    Stack<T> stack;
    public ExeStackImplementation()
    {
        stack = new Stack<>();
    }
    @Override
    public void push(T elem)
    {
        stack.push(elem);
    }
    @Override
    public T pop(){
       return stack.pop();
    }

    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public List<T> getReverse()
    {
        List<T> auxList = Arrays.asList((T[])stack.toArray());
        Collections.reverse(auxList);
        return auxList;
    }
    public String toString()
    {
        return "" + getReverse();
    }
}
