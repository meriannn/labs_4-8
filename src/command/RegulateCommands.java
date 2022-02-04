package command;

import command.action.*;
import device.AvailableDevices;
import device.ElectronicDevice;
import device.RegimedElectronicDevice;

import java.util.ArrayList;
import java.util.Scanner;

public class RegulateCommands {

    static Scanner input = new Scanner(System.in);

    public static void Certainty(CommandEnum com, ArrayList<ElectronicDevice> allDevices){

        Invoker doer;
        int deviceChoice;
        int continuing = 3;
        int regime;

        switch(com.getCommandCode()){
            case(0):
                do{
                    System.out.println(allDevices+ "\n\n~~Input sequence number of device");
                    deviceChoice = input.nextInt();
                    Command turnOff = new TurnOffCom(allDevices.get(deviceChoice-1));
                    doer = new Invoker(turnOff);
                    doer.doSmth();
                    System.out.println("\n***Press 1 to continue");
                    continuing = input.nextInt();
                }while(continuing == 1);

                break;

            case(1):
                do{
                    System.out.println(allDevices+ "\n\n~~Input sequence number of device");
                    deviceChoice = input.nextInt();
                    Command turnOn = new TurnOnCom(allDevices, deviceChoice-1);
                    doer = new Invoker(turnOn);
                    doer.doSmth();
                    System.out.println("\n***Press 1 to continue");
                    continuing = input.nextInt();
                }while(continuing == 1);
                break;

            case(2):
                ArrayList<RegimedElectronicDevice> regimedDevices = AvailableDevices.ReturnRegimedDevices(allDevices);
                System.out.println(regimedDevices + "\n\n~~Choose device");
                deviceChoice = input.nextInt();
                deviceChoice = allDevices.indexOf(regimedDevices.get(deviceChoice));
                System.out.println("\n~~Choose regime (0 - eco, 1 - regular, 2 - max)");
                regime = input.nextInt();
                Command setRegime = new SetRegimeCom((RegimedElectronicDevice) allDevices.get(deviceChoice-1), regime+1);
                doer = new Invoker(setRegime);
                doer.doSmth();
                break;

            case(3):

                System.out.println(allDevices + "\n\n~~Choose device");
                deviceChoice = input.nextInt();
                System.out.println("\n\n~~Set time ");
                double time = input.nextDouble();
                Command setTimer = new SetTimerCom(allDevices,allDevices.get(deviceChoice-1), time);
                doer = new Invoker(setTimer);
                doer.doSmth();
                break;

            case(4):
                Command printAll = new PrintAllCom(allDevices);
                doer = new Invoker(printAll);
                doer.doSmth();
                break;

            case(5):
                Command printSorted = new SortAndPrintCom(allDevices);
                doer = new Invoker(printSorted);
                doer.doSmth();
                break;
            case(6):
                Command printOnDevices = new GetOnDevicesCom(allDevices);
                doer = new Invoker(printOnDevices);
                doer.doSmth();
                break;

            case(7):
                Command printNeeded = new SearchByParametersCom(allDevices);
                doer = new Invoker(printNeeded);
                doer.doSmth();
                break;

            default:
                System.out.println("\n\n\t\tOops.. Something went wrong");
                break;

        }
    }

}
