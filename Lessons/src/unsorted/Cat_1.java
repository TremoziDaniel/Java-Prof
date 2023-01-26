package homeWork4;

public class Cat implements IRunners{
    static final String kind = "Cat";
    private double runSupremum;
    private double jumpSupremum;
    private boolean inGame = true;

    public Cat (double runSupremum, double jumpSupremum) {
        this.runSupremum = runSupremum;
        this.jumpSupremum = jumpSupremum;
        if(runSupremum < 0 || jumpSupremum < 0) {
            System.out.println(kind + " have wrong parameters. Disqualification!");
            inGame = false;
        }
    }

    @Override
    public String getType() {
        return kind;
    }

    @Override
    public void run(IObstacles track) {
        if(inGame && track.getType() == "track") {
            if(track.len() <= runSupremum)
                System.out.println(kind + " has succesfully overcame the track.");
            else {
                System.out.println(kind + " failed to overcome the track.");
                inGame = false;
            }
        }
    }

    @Override
    public void jump(IObstacles wall) {
        if(inGame && wall.getType() == "wall") {
            if(wall.len() <= jumpSupremum)
                System.out.println(kind + " has succesfully jumped over the wall.");
            else {
                System.out.println(kind + " failed to jump over the wall.");
                inGame = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "runSupremum=" + runSupremum +
                ", jumpSupremum=" + jumpSupremum +
                ", inGame=" + inGame +
                '}';
    }
}