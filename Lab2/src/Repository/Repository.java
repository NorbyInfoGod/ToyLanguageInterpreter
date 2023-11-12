package Repository;

import Model.Item;
public class Repository implements IRepository{
    private final Item[] items;
    private int len;

    public Repository()
    {
        items = new Item[10];
        len=0;
    }
    @Override
    public void add(Item item)
    {
        this.items[len++]=item;
    }
    @Override
    public void remove(int pos) {
        if (pos<0||pos>=len)
            throw new ArithmeticException("Invalid position");
        for(int i=pos;i<len;i++) {
            items[i] = items[i + 1];
        }
    }

    @Override
    public Item[] list() {
        Item[] newi = new Item[len];
        for(int i=0;i<len;i++)
        {
            newi[i]=items[i];
        }
        return newi;

    }
    @Override
    public int getLen()
    {
        return len;
    }
}
