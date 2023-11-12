package controller;

public class Controller {

    IRepository repository;
    public Controller(IRepository r)
    {
        repository=r;
    }
    public void add(Item item){this.repository.add(item);}
    public void remove(){};

    public item[] filter(float m);

}
