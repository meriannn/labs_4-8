package command.action;

import device.AvailableDevices;
import device.ElectronicDevice;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TurnOffComTest {
  List<ElectronicDevice> allDevices = AvailableDevices.baseDevices();


  @Test
  public void execute() {
    TurnOffCom turnOffCom = new TurnOffCom( allDevices.get(3));
    turnOffCom.execute();
    Assert.assertFalse(allDevices.get(3).isState());

    TurnOnCom turnOnCom = new TurnOnCom( allDevices, 3);
    turnOnCom.execute();
    Assert.assertTrue(allDevices.get(3).isState());

    turnOffCom.execute();
    Assert.assertFalse(allDevices.get(3).isState());

  }
}