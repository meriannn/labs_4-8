package device;

import java.util.ArrayList;
import java.util.Comparator;

public class ElectronicDevice {
    protected String name;
    protected Integer power;
    protected boolean state;
    //private Integer workingTime;

    ElectronicDevice(){
        name = "empty";
        power = 0;
        state = false;
    }

    public ElectronicDevice(String name, Integer power){
        this.name = name;
        this.power = power;
        state = false;
    }

    public void turnOn(){
        if(state == true){
            System.out.println("Device(\"+ name +\") is already ON");
            return;
        }
        System.out.println("Device("+ name +") is ON");
        this.state = true;
    }

    public void turnOff(){
        if(state == false){
            System.out.println("Device(" + name + ") is already OFF");
            return;
        }
        System.out.println("Device("+ name +") is OFF");
        this.state = false;
    }

    public boolean isState() {
        return state;
    }

    public Integer getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(Integer power) {
        this.power = power;
    }



    public static void PrintAll(ArrayList<ElectronicDevice> deviceArrayList){
//        System.out.println("\nDevice type\t\t\t" + "Name\t\t\t" +
//                "Power\t\t\t" + "State\n");
        for(int count = 0; count < deviceArrayList.size(); count++){
            System.out.println(deviceArrayList.get(count).toString());
        }
    }

    public static ArrayList<ElectronicDevice> SortByPower(ArrayList<ElectronicDevice> deviceArrayList){
        deviceArrayList.sort(Comparator.comparingInt(ElectronicDevice::getPower));

        return deviceArrayList;
    }

//    public void PrintStateOnDevices(ArrayList<ElectronicDevice> deviceArrayList){
//        ArrayList<ElectronicDevice> ONdevices;
//
//    }

//    public static ArrayList<ElectronicDevice> OnDevices(ArrayList<ElectronicDevice> devices){
//        ArrayList<ElectronicDevice> ONdevices = new ArrayList<>(devices.size());
//        for(int count =0 ; count < devices.size(); count++){
//            if(devices.get(count).isState() == true)
//                ONdevices.add(devices.get(count));
//        }
//        return ONdevices;
//    }

    @Override
    public String toString() {
        return "\nElectronicDevice{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", state=" + state +
                '}';
    }


}
