package pr8.strategy;

public class F1Car extends Auto {

    public F1Car() {
        this.fillStrategy = new F1PitstopStrategy();
    }
}