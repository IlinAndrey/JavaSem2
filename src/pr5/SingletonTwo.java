package pr5;

public class SingletonTwo {
    private static SingletonTwo instance = new SingletonTwo();

    private SingletonTwo() {
        System.out.println("SingletonTwo");
    }

    public static SingletonTwo getInstance() {
        return instance;
    }
}
