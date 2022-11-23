package homeWork6;

public class Apple extends Fruit{
    private String name = "Apple";

    public Apple(float weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return name + "=" + String.format("%.2f", weight);
    }
}
