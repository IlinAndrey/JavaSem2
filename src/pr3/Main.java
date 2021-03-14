package pr3;

public class Main {

    static class thread1 extends Thread {
        @Override
        public void run() {
            SetSyn<Integer> ss = new SetSyn<>();
            ss.add(1);
            ss.add(2);
            ss.add(3);
            ss.add(93);
            System.out.println("For SetSyn {"+ss+"}");
            System.out.println(ss.size());
            System.out.println(ss.contains(2));
            ss.remove(3);
        }
    }
    static class thread2 extends Thread {
        @Override
        public void run() {
            ListLock<Integer> ll = new ListLock<>();
            //trying different methods
            ll.add(5);
            ll.add(2);
            ll.add(1, 17);
            ll.add(3);
            System.out.println("For ListLock {"+ll+"}");
            System.out.println(ll.size());
            System.out.println(ll.contains(2));
            ll.remove(3);
            System.out.println(ll.indexOf(1));
        }
    }
    public static void main(String[] args) {

        thread1 ss = new thread1();
        ss.start();
        thread2 ll = new thread2();
        ll.start();
    }

}
