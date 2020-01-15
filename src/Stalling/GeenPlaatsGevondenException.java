package Stalling;

import Voertuigen.Voertuig;

public class GeenPlaatsGevondenException extends RuntimeException{

    private Voertuig voertuig;
    private Garage garage;

    public GeenPlaatsGevondenException(Voertuig voertuig, Garage garage) {
        super("Voor het opgegeven Voertuig hebben we géén plaats gevonden in de garage");
        this.voertuig = voertuig;
        this.garage = garage;
    }
}
