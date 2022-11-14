package HomeWork4;

public class RunWithObstacles {
    public static void main(String[] args) {
        IRunners[] Runners = {new Cat(200, 1), new Robot(10, 400), new Human(-300, 20)};
        IObstacles[] obstacles = {new Track(5), new Wall(0.5), new Track(200), new Wall(20)};
        int n = 1;

        for (IObstacles obstacle : obstacles) {
            System.out.println(n + " obstacle.");
            for (IRunners runner : Runners) {
                runner.run(obstacle);
                runner.jump(obstacle);
            }
            n++;
        }
        System.out.println("* Finish! *");
    }
}