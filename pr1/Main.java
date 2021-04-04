package pr1;

class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEvenNumber = x -> ((x & (x - 1)) == 0);
        System.out.println(isEvenNumber.p(64));
    }
}