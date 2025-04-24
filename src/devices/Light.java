package devices;

import java.util.ArrayList;

public class Light extends Device{
    private static ArrayList <Light> lights = new ArrayList<>();
    private int brightness;

    public Light (String name, String protocol){
        this.setDeviceID(1);
        this.setName(name);
        this.setProtocol(protocol);
        this.setStatus("off");
        this.setBrightness(50);
        lights.add(this);

    }

    public int getBrightness(){
        return this.brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public static ArrayList<Light> getLights(){
        return lights;
    }
}
