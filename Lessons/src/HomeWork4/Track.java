package homeWork4;

public class Track implements IObstacles{
    static final String type = "track";
    private double length;

    public Track(double length) {
        this.length = length;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double len() {
        return length;
    }

    @Override
    public String toString() {
        return "Track{" +
                "length=" + length +
                '}';
    }
}
