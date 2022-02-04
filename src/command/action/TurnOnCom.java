package command.action;

import command.Command;
import device.ElectronicDevice;

import java.util.ArrayList;

public class TurnOnCom implements Command {
    private ArrayList<ElectronicDevice> deviceList;
    private int deviceNum;

    public TurnOnCom(ArrayList<ElectronicDevice> deviceList, int deviceNum){
        this.deviceList=deviceList;
        this.deviceNum = deviceNum;
    }

    @Override
    public void execute(){
        deviceList.get(deviceNum).turnOn();
    }
}
