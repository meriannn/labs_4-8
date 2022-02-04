package command.action;

import command.Command;
import device.AvailableDevices;
import device.ElectronicDevice;

import java.util.ArrayList;

public class GetOnDevicesCom implements Command {

    private ArrayList<ElectronicDevice> devicesList;

    public GetOnDevicesCom(ArrayList<ElectronicDevice> devices){
        devicesList = AvailableDevices.ReturnTurnedOnDevices(devices);
    }

    @Override
    public void execute(){
        ElectronicDevice.PrintAll(devicesList);
    }
}
