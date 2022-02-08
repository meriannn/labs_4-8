package command.action;

import device.AvailableDevices;
import device.ElectronicDevice;
import device.ElectronicDeviceOnTimer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SetTimerComTest {
  List<ElectronicDevice> allDevices = AvailableDevices.baseDevices();

  @Test
  public void execute() {
    SetTimerCom setTimerCom = new SetTimerCom(allDevices, allDevices.get(4), 6 );
    setTimerCom.execute();
    List<ElectronicDeviceOnTimer> onTimers = AvailableDevices.returnDevicesOnTimer(allDevices);
    Assert.assertEquals(1, onTimers.size());
  }
}