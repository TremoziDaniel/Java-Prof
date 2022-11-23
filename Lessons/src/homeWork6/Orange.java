package homeWork6;

public class Orange extends Fruit{
    private String name = "Orange";

    public Orange(float weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return name + "=" + String.format("%.2f", weight);
    }
}
