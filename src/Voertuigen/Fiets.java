package Voertuigen;

public class Fiets extends Voertuig {

    private int aantalVersnellingen = 1;

    public Fiets(String merk, String model) {
        super(merk, model);
    }

    public Fiets(String merk, String model, int aantalVersnellingen) {
        super(merk, model);
        this.aantalVersnellingen = aantalVersnellingen;
    }

    public int getAantalVersnellingen() {
        return aantalVersnellingen;
    }

    @Override
    public String toString() {
        return String.format("Fiets: %s - #v: %d", super.toString(), aantalVersnellingen);
    }

    @Override
    public boolean isBestuurbaarDoorKinderen() {
        return true;
    }
}
