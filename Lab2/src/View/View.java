package View;
import Model.Apple;
import Model.Book;
import Model.Cake;
import Model.Item;
import Repository.IRepository;
import Repository.Repository;
import Controller.Controller;

public class View {
    public View(){};
    public void run()
    {
        try {
            Apple a1 = new Apple(230);

            Apple a2 = new Apple(174.5);
            Apple a3 = new Apple(201);
            Book a4 = new Book(150);
            Book a5 = new Book(150);
            Book a6 = new Book(150);
            Cake a7 = new Cake(100);
            Cake a8 = new Cake(300);
            Cake a9 = new Cake(400);
            Repository repo = new Repository();
            repo.add(a1);
            repo.add(a2);
            repo.add(a3);
            repo.add(a4);
            repo.add(a5);
            repo.add(a6);
            repo.add(a7);
            repo.add(a8);
            repo.add(a9);
            Controller controller = new Controller(repo);

            for (Item i : controller.filter()) {
                i.display();
            }
            controller.remove(10);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}