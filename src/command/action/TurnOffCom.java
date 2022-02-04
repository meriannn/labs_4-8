package command.action;

import command.Command;
import device.ElectronicDevice;

public class TurnOffCom implements Command {
    private ElectronicDevice device;

    public TurnOffCom(ElectronicDevice xdevice){

        this.device=xdevice;
    }

    @Override
    public void execute(){
        device.turnOff();
    }

}
