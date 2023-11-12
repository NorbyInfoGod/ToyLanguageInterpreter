package Model;

public class Apple implements Item{

    private double weight;

    public Apple(double weight)
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
        System.out.println("Apple" + weight);
    }

}
