import devices.DeviceManager;
import rules.RuleManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to your Smart Home System!");

        int q = scn.nextInt();
        scn.nextLine();

        if (q < 1 || q > 50) {
            System.out.println("Error: Number of commands must be between 1 and 50.");
            System.exit(1);
        }


        for (int i = 0; i < q; i++) {
            System.out.print("Enter command " + (i+1) + ": ");
            String command = scn.nextLine().trim().toLowerCase();
            String[] order = command.split(" ");


            switch (order[0]) {
                case "add_device":
                case "1":
                    if (order.length < 4) {
                        System.out.println("Error: add_device requires 3 parameters");
                        break;
                    }
                    DeviceManager.add(order[1], order[2], order[3]);
                    break;

                case "set_device":
                case "2":
                    if (order.length < 4) {
                        System.out.println("Error: set_device requires 3 parameters");
                        break;
                    }
                    DeviceManager.set(order[1], order[2], order[3]);
                    break;

                case "remove_device":
                case "3":
                    if (order.length < 2) {
                        System.out.println("Error: remove_device requires 1 parameter");
                        break;
                    }
                    DeviceManager.remove(order[1]);
                    break;

                case "list_devices":
                case "4":
                    System.out.println("=== Device List ===");
                    DeviceManager.showAll();
                    break;

                case "add_rule":
                case "5":
                    if (order.length < 4) {
                        System.out.println("Error: add_rule requires 3 parameters");
                        break;
                    }
                    RuleManager.add(order[1], order[2], order[3]);
                    break;

                case "check_rules":
                case "6":
                    if (order.length < 2) {
                        System.out.println("Error: check_rules requires 1 parameter");
                        break;
                    }
                    RuleManager.check(order[1]);
                    break;

                case "list_rules":
                case "7":
                    RuleManager.showAll();
                    break;

                case "exit":
                case "8":
                    System.out.println("Exiting Smart Home System. Goodbye!");
                    scn.close();
                    System.exit(0);

                default:
                    System.out.println("Error: Command not recognized");
            }
        }

        scn.close();
    }
}