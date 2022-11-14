package HomeWork4;

public class Wall implements IObstacles {
    static final String type = "wall";
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public double len() {
        return height;
    }

    public String getType() {
        return type;
    }
}