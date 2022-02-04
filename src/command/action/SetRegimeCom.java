package command.action;

import command.Command;
import device.ElectronicDevice;
import device.RegimedElectronicDevice;

public class SetRegimeCom implements Command {

    RegimedElectronicDevice device;
    Integer regimeCode;

    public SetRegimeCom(RegimedElectronicDevice device, Integer regimeCode){
        this.device = device;
        this.regimeCode = regimeCode;
    }

    @Override
    public void execute() {
        device.setRegime(regimeCode);
        device.CalculateRegimedPower(device);
    }
}
