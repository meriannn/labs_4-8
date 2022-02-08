package device;

import org.junit.Assert;
import org.junit.Test;

public class RegimeElectronicDeviceTest {

  @Test
  public void calculateRegimedPower() {
    RegimeElectronicDevice hairdryer = new RegimeElectronicDevice("hairdryer", 1500);
    hairdryer.setRegime(Regimes.ECO.getRegimeCode());
    int expectedPowerHairDryer = (int) (1500 * 0.5);
    Assert.assertEquals(expectedPowerHairDryer, hairdryer.power);

    RegimeElectronicDevice dishwasher = new RegimeElectronicDevice("dishwasher", 850);
    dishwasher.setRegime(Regimes.MAX.getRegimeCode());
    int expectedPowerDishwasher = (int) (850 * 1.3);
    Assert.assertEquals(expectedPowerDishwasher, dishwasher.power);
  }

  @Test
  public void setRegime() {
    RegimeElectronicDevice hairdryer = new RegimeElectronicDevice("hairdryer", 1500);
    hairdryer.setRegime(Regimes.ECO.getRegimeCode());
    Assert.assertEquals(Regimes.ECO, hairdryer.getRegime());

    RegimeElectronicDevice dishwasher = new RegimeElectronicDevice("dishwasher", 850);
    dishwasher.setRegime(Regimes.MAX.getRegimeCode());
    Assert.assertEquals(Regimes.MAX, dishwasher.getRegime());

    RegimeElectronicDevice iron = new RegimeElectronicDevice("iron", 2000);
    Assert.assertEquals(Regimes.REGULAR, iron.getRegime());
  }
}