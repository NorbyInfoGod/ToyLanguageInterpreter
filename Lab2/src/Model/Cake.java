package Model;

public class Cake implements Item{
    private double weight;

    public Cake(double weight)
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
        System.out.println("Cake" + weight);
    }
}
