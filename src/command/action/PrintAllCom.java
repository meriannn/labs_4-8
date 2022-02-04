package command.action;

import command.Command;
import device.ElectronicDevice;

import java.util.ArrayList;

public class PrintAllCom implements Command {

    private ArrayList<ElectronicDevice> arrayList;

    public PrintAllCom(ArrayList<ElectronicDevice> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public void execute(){
        ElectronicDevice.PrintAll(arrayList);
    }
}
