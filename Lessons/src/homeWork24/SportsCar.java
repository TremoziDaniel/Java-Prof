package homeWork24;

public class SportsCar {
    private int sportscarsAmount = 0;
    String name;
    int number;

    public SportsCar(String name) {
        this.name = name; // Name of sportscar rider
        number = sportscarsAmount++; // Gives sportscar a number
    }

    public int getSportscarsAmount() {
        return sportscarsAmount;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
