package device;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ElectronicDeviceTest {
  ElectronicDevice device = new ElectronicDevice("freezer", 250);

  @Test
  public void turnOnTest() {
    device.turnOn();
    Assert.assertTrue(device.state);
  }

  @Test
  public void turnOffTest() {
    device.turnOff();
    Assert.assertFalse(device.state);
  }

  @Test
  public void sortByPowerTest() {
    List<ElectronicDevice> list = AvailableDevices.baseDevices();
    ElectronicDevice.sortByPower(list);
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i).getPower() > list.get(i + 1).getPower()) {
        Assert.assertEquals(list.get(i).getPower(), list.get(i + 1).getPower());
      }
    }
  }
}