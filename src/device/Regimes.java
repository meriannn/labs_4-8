package device;

public enum Regimes {
    Eco(1),
    Regular(2),
    Max(3);


    private int regimeCode;

    Regimes(int regimeCode) {
        this.regimeCode = regimeCode;
    }


    public int getRegimeCode() {
        return regimeCode;
    }
    
//    public void setRegimeCode(Integer regimeCode) {
//        this.regimeCode = regimeCode;
//    }
}
