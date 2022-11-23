package homeWork6;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> box;

    public Box () {
        box = new ArrayList<>();
    }

    public void addFruit (T... fruits) {
        for (T fruit: fruits) {
            box.add(fruit);
        }
    }

    public void addFruit (T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }
    }

    public void pourBox(List<T> toBox) {
        for (T fruit: box) {
            toBox.add(fruit);
        }
    }

    public double getWeight() {
        double weight = 0f;

        for (Fruit fruit: box) {
            weight += fruit.getWeight();
        }
        return Math.round(weight * 100) / 100.;
    }

    public boolean compare(Box<T> anotherBox) {
        //return Double.compare(this.getWeight(), otherBox.getWeight()); if method returns int
        return this.getWeight() == anotherBox.getWeight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if (box != null) {
            for (int i = 0; i < box.size(); i++) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(box.get(i));
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
