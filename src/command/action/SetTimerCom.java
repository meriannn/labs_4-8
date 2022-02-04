package command.action;

import command.Command;
import device.AvailableDevices;
import device.ElectronicDevice;
import device.ElectronicDeviceOnTimer;

import java.util.ArrayList;

public class SetTimerCom implements Command {

    ArrayList<ElectronicDevice> devices ;
    ElectronicDevice device;
    double time;

    public SetTimerCom(ArrayList<ElectronicDevice> devices, ElectronicDevice device, double time){
        this.devices = devices;
        this.device = device;
        this.time = time;
    }

    @Override
    public void execute() {
        ElectronicDeviceOnTimer deviceOnTimer = new ElectronicDeviceOnTimer(device, time);
        AvailableDevices.AddElectronicDevice(deviceOnTimer, devices);
    }
}
