package pr6.Builder;

public class Main {
    public static void main(String[] args) {
        Package andrew = new Package.SendPackage("Andrew").size(12.3).filling("present").weight(20).makePackage();
        System.out.println(andrew);
        Package oleg = new Package.SendPackage("Oleg").size(14.1).filling("meal").weight(10).makePackage();
        System.out.println(oleg);
    }
}
