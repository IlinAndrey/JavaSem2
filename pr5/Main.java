package pr5;

public class Main {
    public static void main(String[] args) {
        SingletonOne.getInstance();
        System.out.println("-----------------------------");
        SingletonTwo.getInstance();
        System.out.println("-----------------------------");
        SingletonThree.getInstance();
    }
}
