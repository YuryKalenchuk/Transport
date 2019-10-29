package entity;

public class Bus extends BaseEntity {
    private String regN;

    public Bus(String regN) {
        this.regN = regN;
    }

    public String getRegN() {
        return regN;
    }

    public void setRegN(String regN) {
        this.regN = regN;
    }
}
