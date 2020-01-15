package Voertuigen;

public class ElektrischeFiets extends Voertuig {

    private int aantalVersnellingen;
    private int actieRadius;

    public ElektrischeFiets(String merk, String model, int aantalVersnellingen, int actieRadius) {
        super(merk, model);
        this.aantalVersnellingen = aantalVersnellingen;
        this.actieRadius = actieRadius;
    }

    public int getActieRadius() {
        return actieRadius;
    }

    @Override
    public boolean isBestuurbaarDoorKinderen() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Elektrische Fiets: %s - #v: %d - range: %d km", super.toString(), aantalVersnellingen, actieRadius);
    }

    public int getAantalVersnellingen() {
        return aantalVersnellingen;
    }

    @Override
    public boolean isGemotoriseerd() {
        return true;
    }
}
