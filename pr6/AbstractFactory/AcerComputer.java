package pr6.AbstractFactory;

public class AcerComputer implements ComputerFactory{
    public AcerComputer(){
        System.out.println("Фирма Acer");
    }

    @Override
    public Computer createLaptop() {
        return new Laptop();
    }

    @Override
    public Computer createPersComp() {
        return new PersComp();
    }
}
