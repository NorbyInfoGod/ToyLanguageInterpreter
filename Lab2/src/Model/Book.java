package Model;

public class Book implements Item{
    private double weight;

    public Book(double weight)
    {
        this.weight=weight;
    }
    @Override
    public double getWeight()
    {
        return this.weight;
    }
    @Override
    public void display()
    {
        System.out.println("Book" + weight);
    }
}
