package Voertuigen;

public class Step extends Voertuig {

    public Step(String merk, String model) {
        super(merk, model);
    }

    @Override
    public boolean isBestuurbaarDoorKinderen() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("Step: %s", super.toString());
    }
}
