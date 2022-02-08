package command.action;

import device.AvailableDevices;
import device.ElectronicDevice;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TurnOnComTest {
  List<ElectronicDevice> allDevices = AvailableDevices.baseDevices();


  @Test
  public void execute() {
    TurnOnCom turnOnCom = new TurnOnCom( allDevices, 3);
    turnOnCom.execute();
    Assert.assertTrue(allDevices.get(3).isState());
  }
}