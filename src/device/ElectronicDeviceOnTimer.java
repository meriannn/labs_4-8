package device;

public class ElectronicDeviceOnTimer extends RegimedElectronicDevice {

    private double workingTime;

    public ElectronicDeviceOnTimer() {
        this.workingTime = 0;
    }

    public ElectronicDeviceOnTimer(ElectronicDevice obj, double time){
        this.name = obj.name;
        this.power = obj.power;
        this.state = obj.state;
        this.workingTime = time;
    }

    public ElectronicDeviceOnTimer(String name, Integer power, Integer regimeCode, double workingTime) {
        super(name, power);
        state = false;
        regime = Regimes.Regular;
        this.workingTime = workingTime;
    }

    public ElectronicDeviceOnTimer(String name, Integer power, double workingTime) {
        super(name, power);
        this.workingTime = workingTime;
    }


    public  void setTimer(Integer time){
        workingTime = time;
    }

    public int CalculatePowerAfterCertainTime(ElectronicDeviceOnTimer obj){
        return (int) (obj.power * obj.workingTime);
    }

    @Override
    public String toString() {
        return "\nElectronicDeviceOnTimer{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", state=" + state +
                ", workingTime=" + workingTime +
                ", regime=" + regime +
                "} " + super.toString();
    }
}
