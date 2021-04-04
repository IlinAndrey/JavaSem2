package pr5;

public class SingletonThree {
    private SingletonThree() {
        System.out.println("SingletonThree");
    }

    private static class SingletonThreeImplHolder {
        private final static SingletonThree instance = new SingletonThree();
    }

    public static SingletonThree getInstance() {
        return SingletonThreeImplHolder.instance;
    }
}
