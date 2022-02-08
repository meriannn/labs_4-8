package command.action;

import device.AvailableDevices;
import device.ElectronicDevice;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SortAndPrintComTest {
  List<ElectronicDevice> allDevices = AvailableDevices.baseDevices();


  @Test
  public void executeTest() {
    SortAndPrintCom sortAndPrintCom = new SortAndPrintCom(allDevices);
    sortAndPrintCom.execute();
    for (int i = 0; i < allDevices.size() - 1; i++) {
      if (allDevices.get(i).getPower() > allDevices.get(i + 1).getPower()) {
        Assert.assertEquals(allDevices.get(i).getPower(), allDevices.get(i + 1).getPower());
      }
    }
  }
}