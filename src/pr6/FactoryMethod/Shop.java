package pr6.FactoryMethod;

public abstract class Shop {
    protected abstract Phone doPhone(TypesOfPhone phone);

    public void getPhone(TypesOfPhone phone){
        Phone phone1 = doPhone(phone);
        System.out.println("Purchased "+phone1.getTypesOfPhone());
    }
}
