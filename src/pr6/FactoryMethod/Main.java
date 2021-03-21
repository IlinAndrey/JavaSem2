package pr6.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("Phone Store:");
        PhoneStore phone = new PhoneStore();
        phone.getPhone(TypesOfPhone.Apple);
        phone.getPhone(TypesOfPhone.Samsung);
        phone.getPhone(TypesOfPhone.Xiaomi);
        phone.getPhone(TypesOfPhone.Nokia);
    }
}
