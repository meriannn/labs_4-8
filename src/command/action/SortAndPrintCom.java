package command.action;

import command.Command;
import device.ElectronicDevice;

import java.util.ArrayList;

public class SortAndPrintCom implements Command {

    private ArrayList<ElectronicDevice> arrayList;

    public SortAndPrintCom(ArrayList<ElectronicDevice> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public void execute(){
        ElectronicDevice.SortByPower(arrayList);
        ElectronicDevice.PrintAll(arrayList);
    }
}
