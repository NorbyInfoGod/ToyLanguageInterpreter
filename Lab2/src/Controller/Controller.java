package Controller;
import Model.Item;
import Repository.IRepository;
public class Controller {
    private IRepository repo;

    public Controller(IRepository r){
        this.repo=r;
    }
    void add(Item item)
    {
        repo.add(item);
    }
    public void remove(int pos)
    {
        repo.remove(pos);
    }
    public Item[] list()
    {
        return repo.list();
    }
    public Item[] filter()
    {
        Item[] newi = new Item[repo.getLen()];
        int j=0;
        for(Item i:repo.list())
        {
            if (i.getWeight()>200) {
                newi[j++]=i;
            }
        }
        Item[] newj = new Item[j];
        for(int i=0;i<j;i++)
        {
            newj[i]=newi[i];
        }
        return newj;
    }
}
