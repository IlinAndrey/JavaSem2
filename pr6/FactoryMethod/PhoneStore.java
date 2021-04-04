package pr6.FactoryMethod;

public class PhoneStore extends Shop{
    @Override
    protected Phone doPhone(TypesOfPhone phone) {
        Phone phone1 = null;

        switch (phone){
            case Apple:
                phone1 = new PhoneStoreApple();
                break;
            case Samsung:
                phone1 = new PhoneStoreSamsung();
                break;
            case Xiaomi:
                phone1 = new PhoneStoreXiaomi();
                break;
            case Nokia:
                phone1 = new PhoneStoreNokia();
                break;
        }
        return phone1;
    }
}
