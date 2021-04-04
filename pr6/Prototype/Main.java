package pr6.Prototype;

public class Main {
    public static void main(String[] args) {
        Clothes shirt = new Clothes(ClothesType.SHIRT);
        Clothes dress = new Clothes(ClothesType.DRESS);
        shirt.setType(ClothesType.TSHIRT);

        System.out.println(shirt);
        System.out.println(dress);
    }
}
