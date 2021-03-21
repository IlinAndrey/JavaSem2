package pr8.command;

public class Main {
    public static void main(String[] args){
        Light l=new Light();
        Command switchUp=new TurnOnLightCommand(l);
        Command switchDown=new TurnOffLightCommand(l);
        Switch s=new Switch(switchUp,switchDown);
        s.flipUp();
        s.flipDown();
    }
}
