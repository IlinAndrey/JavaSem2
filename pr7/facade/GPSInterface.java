package pr7.facade;

public class GPSInterface {
    private GPSPower power;
    private GPSNotifier notifier;
    private RoadAdvisor advisor;

    public GPSInterface(GPSPower power, GPSNotifier notifier, RoadAdvisor advisor){
        this.power = power;
        this.notifier = notifier;
        this. advisor = advisor;
    }

    public void activate(){
        power.powerOn();
        notifier.downloadRoadInfo();
        advisor.route();
    }
}
