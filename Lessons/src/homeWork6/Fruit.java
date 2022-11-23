package homeWork6;

public class Fruit {
    private String name = "Fruit";
    protected float weight;

    public Fruit (float weight) {
        this.weight = weight;
    }

    public double getWeight() {return weight;}

    @Override
    public String toString() {
        return name + "=" + String.format("%.2f", weight);
    }
}
