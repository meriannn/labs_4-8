package device;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Getter
@Setter
@EqualsAndHashCode
public class ElectronicDevice {
  private final static Logger LOG = Logger.getLogger(ElectronicDevice.class.getName());

  protected String name;
  protected int power;
  protected boolean state;

  ElectronicDevice() {
    name = "empty";
    power = 0;
    state = false;
  }

  public ElectronicDevice(String name, int power) {
    this.name = name;
    this.power = power;
    state = false;
  }

  public void turnOn() {
    if (state) {
      System.out.println("Device(\"+ name +\") is already ON");
      LOG.info("device is already ON");
      return;
    }
    System.out.println("Device(" + name + ") is ON");
    LOG.info("device is turned ON");
    this.state = true;
  }

  public void turnOff() {
    if (!state) {
      System.out.println("Device(" + name + ") is already OFF");
      LOG.info("device is already OFF");
      return;
    }
    System.out.println("Device(" + name + ") is OFF");
    LOG.info("device is turned OFF");
    this.state = false;
  }

  public static void printAll(List<ElectronicDevice> deviceArrayList) {
    for (ElectronicDevice electronicDevice : deviceArrayList) {
      System.out.println(electronicDevice.toString());
      LOG.info("printed all devices");
    }
  }

    public static List<ElectronicDevice> sortByPower(List<ElectronicDevice> deviceArrayList){
        deviceArrayList.sort(Comparator.comparingInt(ElectronicDevice::getPower));
        LOG.info("devices is sorted by power");
        return deviceArrayList;
    }

    @Override
    public String toString() {
        return "\nName='" + name + '\'' +
                ", power=" + power +
                ", state=" + state;
    }
}
