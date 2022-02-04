package main;

import command.CommandEnum;
import command.RegulateCommands;
import device.AvailableDevices;
import device.ElectronicDevice;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManaging {

    static Scanner input = new Scanner(System.in);

    public static void MainMenuText(){
        System.out.println("\n\t1\t|\t\tManage device" +
                "\n\t2\t|\t\tPrint all devices" +
                "\n\t3\t|\t\tSort by power consumption" +
                "\n\t4\t|\t\tList of turned ON devices" +
                "\n\t5\t|\t\tSearch by parameters" +
                "\n\t6\t|\t\tExit\n");
    }

    public static void DeviceMenuText(){
        System.out.println("\n\t1\t|\t\tTurn ON device" +
                "\n\t2\t|\t\tTurn OFF device" +
                "\n\t3\t|\t\tSet regime (only for selected)" +
                "\n\t4\t|\t\tSet timer\n");
    }

    public static CommandEnum DeviceMenuManaging(){
        CommandEnum com = null;
        Integer deviceNum;
        DeviceMenuText();

        int choice = input.nextInt();
        switch(choice){
            case(1):
                com = CommandEnum.ON;
                break;

            case(2):
                com = CommandEnum.OFF;
                break;

            case(3):
                com = CommandEnum.SetRegime;
                break;

            case(4):
                com = CommandEnum.SetTimer;
                break;

        }
        return com;
    }

    public static void MenuManaging(Integer choice, ArrayList<ElectronicDevice> allDevices ){
        int num = 0;
        CommandEnum com = null;

        switch (choice){
            case(1):
                com = DeviceMenuManaging();
                break;

            case(2):
                com = CommandEnum.PrintAll;
                break;

            case(3):
                com = CommandEnum.SortAndPrint;
                break;

            case(4):
                com = CommandEnum.PrintOnDevices;
                break;

            case(5):
                com = CommandEnum.SearchByParameters;
                break;

            default:
                System.out.println("\n\n\t\tOops... Wrong command :(");
                return;
        }
        RegulateCommands.Certainty(com, allDevices);
    }
}
