package command.action;

import device.RegimeElectronicDevice;
import org.junit.Assert;
import org.junit.Test;

public class SetRegimeComTest {

  @Test
  public void execute() {
    SetRegimeCom setRegimeCom = new SetRegimeCom(new RegimeElectronicDevice("hairdryer", 1500), 1 );
    setRegimeCom.execute();
    int expectedPowerHairDryer = (int) (1500 * 0.5);
    Assert.assertEquals(expectedPowerHairDryer, setRegimeCom.getDevice().getPower());
  }
}