package pr8.strategy;

public class HybridAuto extends Auto {

    public HybridAuto() {
        this.fillStrategy = new HybridFillStrategy();
    }
}