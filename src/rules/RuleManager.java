package rules;

import devices.Device;
import devices.DeviceManager;

import java.util.ArrayList;
import java.util.HashMap;

public class RuleManager {
    private static ArrayList<Rule> rules = new ArrayList<>();
    private static HashMap<Device, Rule> deviceRule = new HashMap<>();


    public static void showAll (){
        if (rules.isEmpty())
        {
            System.out.println();
        }
        else
            for (Rule rule : rules){
                System.out.println("Name: " + rule.getName() + "  Time: " + rule.getTime() + "  Action:" + rule.getAction());
        }
    }

    public static void add (String name, String time, String action){
        ArrayList<Device> devices = DeviceManager.getDevices();

        for (Device device : devices){
            if (device.getName().equals(name)){
                int hour = Integer.parseInt(time.substring(0, 1));
                int min = Integer.parseInt(time.substring(3, 4));
                if (!((hour < 23) && (hour >= 0) && (min < 60) && (min >= 0)))
                    throw new IllegalArgumentException("What you mentioned is not a valid time.");
                if (!(action.equals("on") || action.equals("off")))
                    throw new IllegalArgumentException("What you mentioned is not a valid action.");
                if(deviceRule.containsKey(device))
                    throw new IllegalArgumentException("The device you mentioned already has a rule.");

                Rule rule = new Rule (name, time, action);
                deviceRule.put(device, rule);
                rules.add(rule);
                System.out.println("rule added successfully.");
                return;

            }
        }
        System.out.println("device not found.");
    }

    public static void check (String time){
        if (rules.isEmpty()) {
            System.out.println("rules checked.");
            return;
        }

        int hour = Integer.parseInt(time.substring(0, 1));
        int min = Integer.parseInt(time.substring(3, 4));
        if (!((hour < 23) && (hour >= 0) && (min < 60) && (min >= 0)))
            throw new IllegalArgumentException("What you mentioned is not a valid time.");

        for (Rule rule : rules)
            if (rule.getTime().equals(time))
                System.out.println("rules checked.");

    }

    public static void remove (Device device){
        if (deviceRule.containsKey(device)){
            rules.remove(deviceRule.get(device));
            deviceRule.remove(device);
        }

    }
}
