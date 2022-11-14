package HomeWork4;

public class Track implements IObstacles{
    static final String type = "track";
    private double length;

    public Track(double length) {
        this.length = length;
    }

    public double len() {
        return length;
    }

    public String getType() {
        return type;
    }
}
