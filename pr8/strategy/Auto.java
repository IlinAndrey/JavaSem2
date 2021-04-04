package pr8.strategy;

public class Auto {

    FillStrategy fillStrategy;

    public void fill(){
        fillStrategy.fill();
    }

    public void gas() {
        System.out.println("Let's go");
    }

    public void stop() {

        System.out.println("Stop PLSSSS, STOP");
    }
}