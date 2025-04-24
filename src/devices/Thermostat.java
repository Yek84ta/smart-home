package devices;

import java.util.ArrayList;

public class Thermostat extends Device{
    private static ArrayList<Thermostat> thermostats = new ArrayList<>();
    private int temperature;

    public Thermostat (String name, String protocol){
        this.setDeviceID(2);
        this.setName(name);
        this.setProtocol(protocol);
        this.setStatus("off");
        this.setTemperature(20);
        thermostats.add(this);
    }
    public int getTemperature(){
        return this.temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public static ArrayList<Thermostat> getThermostats(){
        return thermostats;
    }
}
