package Voertuigen;

public abstract class Voertuig {

    private String merk;
    private String model;
    private static int id = 0;
    private int voertuigID;

    public Voertuig(String merk, String model) {
        this.merk = merk;
        this.model = model;
        this.voertuigID = ++id;
    }

    public String getMerk() {
        return merk;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("(%d) %s '%s'", voertuigID, merk, model);
    }

    public abstract boolean isBestuurbaarDoorKinderen();

    public int getId() {
        return voertuigID;
    }

    public boolean isGemotoriseerd() {
        return false;
    }

    public double getCO2Uitstoot() {
        return 0.0;
    }
}
