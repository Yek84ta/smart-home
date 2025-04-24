package devices;

import rules.Rule;
import rules.RuleManager;

import java.util.ArrayList;


public class DeviceManager {
    private static ArrayList <Device> devices = new ArrayList<>();

    public static ArrayList<Device> getDevices(){
        return devices;
    }



    public static void add(String type, String name, String protocol){
        for (Device device : devices){
            if ( device.getName().equals(name)){
                System.out.println("duplicate device name.");
                return;
            }
        }

        if (!((protocol.equals("wifi")) || (protocol.equals("bluetooth")))){
                System.out.println("Invalid input.");
                return;
        }

        if (type.equals("light")){
            Light light = new Light(name, protocol);
            devices.add(light);

            System.out.println("device added successfully");

        }
        else if (type.equals("thermostat")){
            Thermostat thermostat = new Thermostat(name, protocol);
            devices.add(thermostat);

            System.out.println("device added successfully");

        }
        else
            throw new IllegalArgumentException("Sorry, we couldn’t find a device with that name. Please double-check the name or contact support for further assistance. Thank you!");

    }

    public static void set ( String name, String property, String value){
        for(Device device : devices){
            if (device.getName().equals(name)){
                if (device instanceof Light){
                    Light light = (Light) device;

                    if (property.equals("status"))
                    {
                      if(value.equals("on")){
                          light.setStatus("on");
                      }
                      else if (value.equals("off")) {
                          light.setStatus("off");
                      }
                      else
                          throw new IllegalArgumentException("What you mentioned is not a valid status for a light.");
                    }
                    else if (property.equals("brightness")){
                        int brightness = Integer.parseInt(value);

                        if ( brightness < 100 && brightness > 0)
                            light.setBrightness(brightness);

                        else
                            throw new IllegalArgumentException("What you mentioned is not a valid amount for a light's brightness.");
                    }
                    else
                        throw new IllegalArgumentException("What you mentioned is not a valid property.");

                } else if (device instanceof Thermostat){
                    Thermostat thermostat = (Thermostat) device;

                    if (property.equals("status"))
                    {
                        if(value.equals("on")){
                            thermostat.setStatus("on");
                        }
                        else if (value.equals("off")) {
                            thermostat.setStatus("off");
                        }
                        else
                            throw new IllegalArgumentException("What you mentioned is not a valid status for a thermostat.");
                    }
                    else if (property.equals("temperature")){
                        int temperature = Integer.parseInt(value);

                        if ( temperature < 30 && temperature > 0)
                            thermostat.setTemperature(temperature);

                        else
                            throw new IllegalArgumentException("What you mentioned is not a valid amount for a thermostat's temperature.");
                    }
                    else
                        throw new IllegalArgumentException("What you mentioned is not a valid property.");



                }
                else
                    throw new IllegalArgumentException("what you mentioned is not a valid device.");

                System.out.println("device updated successfully.");
                return;
            }

        }
        System.out.println("device not found");

    }

    public static void remove (String name){
        for(Device device : devices) {
            if (device.getName().equals(name)) {
                devices.remove(device);
                RuleManager.remove(device);
                if (device instanceof Light){
                    ArrayList<Light> lights = Light.getLights();
                    lights.remove(device);
                }

                else if (device instanceof Thermostat){
                    ArrayList<Thermostat> thermostats = Thermostat.getThermostats();
                    thermostats.remove(device);

                }
                System.out.println("device removed successfully.");
                return;
            }
        }
        System.out.println("device not found.");

    }

    public static void showAll (){
        for ( Device device : devices){
            if (device instanceof Light){
                Light light = (Light) device;
                System.out.println("Light:");
                System.out.println("Name: " + light.getName());
                System.out.println("Status: " + light.getStatus());
                System.out.println("Brightness: " + light.getBrightness() + "%");
                System.out.println("Protocol: " + light.getProtocol());
            }

            if (device instanceof Thermostat){
                Thermostat thermostat = (Thermostat) device;
                System.out.println("Light:");
                System.out.println("Name: " + thermostat.getName());
                System.out.println("Status: " + thermostat.getStatus());
                System.out.println("Temperature: " + thermostat.getTemperature() + "C");
                System.out.println("Protocol: " + thermostat.getProtocol());
            }
        }
    }
}
