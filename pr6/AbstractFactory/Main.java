package pr6.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        AcerComputer acerComputer = new AcerComputer();
        acerComputer.createPersComp();
        acerComputer.createLaptop();
    }
}
