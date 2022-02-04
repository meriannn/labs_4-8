package device;

import java.util.ArrayList;

public class AvailableDevices {

    public static ArrayList<ElectronicDevice> BaseDevices(){
        ArrayList<ElectronicDevice> devices = new ArrayList<>();
        devices.add(new ElectronicDevice("pc", 500));
        devices.add(new ElectronicDevice("freezer", 250));
        devices.add(new ElectronicDevice("tv", 100));
        devices.add(new ElectronicDevice("ps5", 220));
        devices.add(new ElectronicDevice("speakers", 40));
        devices.add(new ElectronicDevice("toaster", 800));
        devices.add(new RegimedElectronicDevice("vacuum cleaner", 700));
        devices.add(new RegimedElectronicDevice("hairdryer", 1500));
        devices.add(new RegimedElectronicDevice("dishwasher", 850));
        devices.add(new RegimedElectronicDevice("iron", 2000));
        return devices;
    }

    public static ArrayList<ElectronicDevice> ReturnElectronicDevices(ArrayList<ElectronicDevice> devices){

        ArrayList<ElectronicDevice> electronicDevices = new ArrayList<>();
        for(int counter = 0; counter < devices.size(); counter++){
            if(devices.get(counter).getClass() == ElectronicDevice.class){
                electronicDevices.add(devices.get(counter));
            }
        }
        return electronicDevices;
    }

    public static ArrayList<RegimedElectronicDevice> ReturnRegimedDevices(ArrayList<ElectronicDevice> devices){

        ArrayList<RegimedElectronicDevice> regimedDevices = new ArrayList<>();
        for(int counter = 0; counter < devices.size(); counter++){
            if(devices.get(counter).getClass() == RegimedElectronicDevice.class){
                regimedDevices.add((RegimedElectronicDevice) devices.get(counter));
            }
        }
        return regimedDevices;
    }

    public static ArrayList<ElectronicDeviceOnTimer> ReturnDevicesOnTimer(ArrayList<ElectronicDevice> devices){

        ArrayList<ElectronicDeviceOnTimer> devicesOnTimer = new ArrayList<>();
        for(int counter = 0; counter < devices.size(); counter++){
            if(devices.get(counter).getClass() == ElectronicDeviceOnTimer.class){
                devicesOnTimer.add((ElectronicDeviceOnTimer) devices.get(counter));
            }
        }
        return devicesOnTimer;
    }

    public static ArrayList<ElectronicDevice> ReturnTurnedOnDevices(ArrayList<ElectronicDevice> devices){
        ArrayList<ElectronicDevice> onDevices = new ArrayList<>();
        for(int counter = 0; counter < devices.size(); counter++){
            if(devices.get(counter).isState() == true){
                onDevices.add(devices.get(counter));
            }
        }
        return onDevices;
    }

    public static ArrayList<ElectronicDevice> AddElectronicDevice(ElectronicDeviceOnTimer device, ArrayList<ElectronicDevice> allDevices){
        allDevices.add(device);
        for(int count = 0; count < allDevices.size(); count++){
            if(device.name == allDevices.get(count).name && allDevices.get(count).getClass() == ElectronicDevice.class){
                allDevices.remove(count);
            }
        }
        return allDevices;
    }

}
