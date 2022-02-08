package device;

import org.junit.Assert;
import org.junit.Test;

import static device.ElectronicDeviceOnTimer.calculatePowerAfterCertainTime;

public class ElectronicDeviceOnTimerTest {

  @Test
  public void calculatePowerAfterCertainTimeTest() {
    ElectronicDevice pc = new ElectronicDevice("pc", 500);
    ElectronicDeviceOnTimer psWorkingFiveHoursInRegularMode = new ElectronicDeviceOnTimer(pc,5);
    Assert.assertEquals(500*5, calculatePowerAfterCertainTime(psWorkingFiveHoursInRegularMode));

    RegimeElectronicDevice hairdryer = new RegimeElectronicDevice("hairdryer", 1500);
    hairdryer.setRegime(Regimes.ECO.getRegimeCode());
    ElectronicDeviceOnTimer hairdryerWorkingFiveHoursInEcoMode = new ElectronicDeviceOnTimer(hairdryer, 5);
    Assert.assertEquals((int)(1500*5*0.5), calculatePowerAfterCertainTime(hairdryerWorkingFiveHoursInEcoMode));

    RegimeElectronicDevice speakers = new RegimeElectronicDevice("speakers", 40);
    speakers.setRegime(Regimes.MAX.getRegimeCode());
    ElectronicDeviceOnTimer speakersWorkingFiveHoursInMaxMode = new ElectronicDeviceOnTimer(speakers, 5);
    Assert.assertEquals((int)(40*5*1.3), calculatePowerAfterCertainTime(speakersWorkingFiveHoursInMaxMode));

    RegimeElectronicDevice toaster = new RegimeElectronicDevice("toaster", 800);
    toaster.setRegime(Regimes.MAX.getRegimeCode());
    ElectronicDeviceOnTimer toasterWorkingNullHoursInMaxMode = new ElectronicDeviceOnTimer(speakers);
    Assert.assertEquals((int)(0*5*1.3), calculatePowerAfterCertainTime(toasterWorkingNullHoursInMaxMode));
  }
}