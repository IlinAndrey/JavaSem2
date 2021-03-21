package pr7.Linker;

public class Main {
    public static void main(String[] args) {
        Car sportCar = new SportCar();
        Car unknownCar = new UnknownCar();
        Drawing drawing = new Drawing();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.draw("black");
        drawing.clear();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.draw("white");
    }
}
