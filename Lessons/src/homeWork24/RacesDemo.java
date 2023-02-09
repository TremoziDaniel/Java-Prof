package homeWork24;

public class RacesDemo {
    public static void main(String[] args) {

        Races races = new Races(4);
        new Thread(() -> races.drive(new SportsCar("Nicolo Castello"))).start();
        new Thread(() -> races.drive(new SportsCar("Jordan Speed"))).start();
        new Thread(() -> races.drive(new SportsCar("Ivan Shumaher"))).start();
        new Thread(() -> races.drive(new SportsCar("Lee Kuan Yew"))).start();
        new Thread(() -> races.drive(new SportsCar("Carol Wachewski"))).start();
        new Thread(() -> races.drive(new SportsCar("Wolfgang Mercedec"))).start();
    }
}
