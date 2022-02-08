package device;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AvailableDevicesTest {
  List<ElectronicDevice> allDevices = AvailableDevices.baseDevices();

  @Test
  public void returnElectronicDevicesTest() {
    List<ElectronicDevice> electronicDevices = AvailableDevices.returnElectronicDevices(allDevices);
    for (ElectronicDevice electronicDevice : electronicDevices) {
      Assert.assertEquals(electronicDevice.getClass(), ElectronicDevice.class);
    }
  }

  @Test
  public void returnRegimedDevicesTest() {
    List<RegimeElectronicDevice> regimeElectronicDevices = AvailableDevices.returnRegimedDevices(allDevices);
    for (RegimeElectronicDevice electronicDevice : regimeElectronicDevices) {
      Assert.assertEquals(electronicDevice.getClass(), RegimeElectronicDevice.class);
    }
  }

  @Test
  public void returnDevicesOnTimerTest() {
    List<ElectronicDeviceOnTimer> electronicDeviceOnTimers = AvailableDevices.returnDevicesOnTimer(allDevices);
    Assert.assertEquals(0, electronicDeviceOnTimers.size());

    ElectronicDeviceOnTimer deviceOnTimer = new ElectronicDeviceOnTimer(allDevices.get(0), 5);
    allDevices.add(deviceOnTimer);
    electronicDeviceOnTimers = AvailableDevices.returnDevicesOnTimer(allDevices);
    Assert.assertEquals(1, electronicDeviceOnTimers.size());
  }

  @Test
  public void returnTurnedOnDevicesTest() {
    for (int i = 0; i < allDevices.size(); i++) {
      if (i % 2 == 0) {
        allDevices.get(i).setState(true);
      }
    }
    List<ElectronicDevice> devicesOn = AvailableDevices.returnTurnedOnDevices(allDevices);
    for (ElectronicDevice electronicDevice : devicesOn) {
      Assert.assertTrue(electronicDevice.state);
    }
  }

  @Test
  public void addElectronicDeviceTest() {
    List<ElectronicDevice> electronicDevices = AvailableDevices.baseDevices();
    int expectedSize = electronicDevices.size() + 1;
    ElectronicDevice device = new ElectronicDevice("freezer", 250);
    AvailableDevices.addElectronicDevice(device, electronicDevices);
    Assert.assertEquals(expectedSize, electronicDevices.size());
  }
}