package pr5;

public class SingletonOne {
    private static SingletonOne instance;

    private SingletonOne() {
        System.out.println("SingletonOne");
    }

    public static SingletonOne getInstance() {
        if(instance == null)
            instance = new SingletonOne();
        return instance;
    }
}
