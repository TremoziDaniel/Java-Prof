package HomeWork4;

public class Wall implements IObstacles {
    static final String type = "wall";
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double len() {
        return height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }
}