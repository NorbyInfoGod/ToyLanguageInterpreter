package utils;

import java.util.ArrayList;
import java.util.List;

public class OutputList<T> implements Output<T> {

    List<T> items;
    public OutputList()
    {
        items = new ArrayList<>();
    }
    @Override
    public void add(T elem) {
        items.add(elem);
    }
    public String toString()
    {
        return "" + items;
    }
}
