package Repository;

import Model.Item;

public interface IRepository {

    void add(Item item);
    void remove(int pos);
    Item[] list();
    int getLen();

}
