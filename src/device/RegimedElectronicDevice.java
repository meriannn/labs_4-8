package device;

public class RegimedElectronicDevice extends ElectronicDevice {
    
    Regimes regime;

    public RegimedElectronicDevice() {
        this.regime = Regimes.Regular;
    }

    public RegimedElectronicDevice(String name, Integer power) {
        
        super(name, power);
        state = false;
        regime = Regimes.Regular;
    }

    public int getRegime() {
        return regime.getRegimeCode();
    }

    public void setRegime(Integer regimeCode){
        switch(regimeCode){
            case(1):
                this.regime = Regimes.Eco;
                break;
            case(2):
                this.regime = Regimes.Regular;
                break;
            case(3):
                this.regime = Regimes.Max;
                break;

        }
        //this.regime.setRegimeCode(regimeCode);
    }

    public void CalculateRegimedPower(RegimedElectronicDevice obj){
        //int regpower = obj.getPower();
        switch(obj.regime.getRegimeCode()){
            case(1):
                this.power = (int)(this.power * 0.5);
                break;

            case(3):
                this.power = (int)(this.power * 1.3);
                break;

            default:
                return;
        }
    }

    @Override
    public String toString() {
        return "\nRegimedElectronicDevice{" +
                "name='" + this.name + '\'' +
                ", power=" + this.power +
                ", state=" + this.state +
                ", regime=" + this.regime +
                "} " ;
    }


}
