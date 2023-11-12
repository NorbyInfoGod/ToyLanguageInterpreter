package repository;

public class Repository implements IRepository{
    private final Item[] items;
    private int size=0;

    Repository()
    {
        items=new Item[10];
    }

    public void add(Item item)
    {
        items[this.size++] = item;
    }
}
