package command.action;

import command.Command;
import device.ElectronicDevice;
import device.ElectronicDeviceOnTimer;
import device.RegimedElectronicDevice;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchByParametersCom implements Command {

    ArrayList<ElectronicDevice> allDevices;
    Scanner input = new Scanner(System.in);

    public SearchByParametersCom(ArrayList<ElectronicDevice> allDevices){
        this.allDevices = allDevices;
    }

    public ArrayList<ElectronicDevice> SearchByParameters() {
        System.out.println("\nStart of search...");
        System.out.println("\nType of device ( 1 - Plain Electronic; 2 - With Regimes; 3 - On timer)");
        int deviceClassCode = input.nextInt();
        Class deviceClass = ElectronicDevice.class;
        switch (deviceClassCode) {
            case (1):
                deviceClass = ElectronicDevice.class;
                break;
            case (2):
                deviceClass = RegimedElectronicDevice.class;
                break;
            case (3):
                deviceClass = ElectronicDeviceOnTimer.class;
                break;
        }

        System.out.println("\nPower is larger than...");
        int[] powerRange = new int[2];
        powerRange[0] = input.nextInt();
        System.out.println("\n... but lower than...");
        powerRange[1] = input.nextInt();

        System.out.println("\nState (0 - OFF; 1 - ON)");
        int stateCode = input.nextInt();
        boolean state = false;
        if (stateCode == 1)
            state = true;

        int regime;
        if (deviceClass == RegimedElectronicDevice.class || deviceClass == ElectronicDeviceOnTimer.class) {
            System.out.println("\nRegime ( 1 - ECO; 2 - Regular; 3 - MAX)");
            regime = input.nextInt();
        }

        int[] timerRange = new int[2];
        if (deviceClass == ElectronicDeviceOnTimer.class) {
            System.out.println("\nTimer is set on time between...(in minutes)");
            timerRange[0] = input.nextInt();
            System.out.println("... and...");
            timerRange[1] = input.nextInt();
        }

        ArrayList<ElectronicDevice> neededDevices = new ArrayList<>(allDevices.size());
        for (int count = 0; count < allDevices.size(); count++) {
            if (allDevices.get(count).getClass() == deviceClass)
                if (allDevices.get(count).getPower() > powerRange[0] && allDevices.get(count).getPower() < powerRange[1])
                    if (allDevices.get(count).isState() == state){
                        neededDevices.add(allDevices.get(count));
                        continue;
                    }
        }
        return neededDevices;
    }


    @Override
    public void execute() {
        System.out.println("\nRequired devices are :\n");
        System.out.println(SearchByParameters());
    }
}
