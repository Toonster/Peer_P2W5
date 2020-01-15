package Voertuigen;

import java.time.LocalDate;
import java.util.Date;

public class Auto extends Voertuig {

    private LocalDate inschrijvingsdatum;
    private double CO2Uitstoot;

    public Auto(String merk, String model, LocalDate inschrijvingsdatum, double CO2Uitstoot) {
        super(merk, model);
        this.inschrijvingsdatum = inschrijvingsdatum;
        this.CO2Uitstoot = CO2Uitstoot;
    }

    public LocalDate getInschrijvingsdatum() {
        return inschrijvingsdatum;
    }

    @Override
    public boolean isBestuurbaarDoorKinderen() {
        return false;
    }

    @Override
    public double getCO2Uitstoot() {
        return this.CO2Uitstoot;
    }

    @Override
    public String toString() {
        return String.format("Auto: %s - date: %s", super.toString(), inschrijvingsdatum);
    }

    @Override
    public boolean isGemotoriseerd() {
        return true;
    }
}
