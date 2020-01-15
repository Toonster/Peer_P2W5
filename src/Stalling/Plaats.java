package Stalling;

import Voertuigen.Voertuig;

public class Plaats {

    Voertuig voertuig;
    Type soort;

    public Plaats(Type soort) {
        this.soort = soort;
    }

    public enum Type {
        KLEIN, GROOT
    }


    public boolean isBezet() {
        return voertuig != null;
    }

    public boolean stalVoertuig(Voertuig voertuig) throws IllegalArgumentException{
        if (isBezet()) {
            return false;
/*
            throw new IllegalArgumentException("Plaats is bezet");
*/
        }
        if (voertuig.isGemotoriseerd() && this.soort == Type.KLEIN) {
            return false;
/*
            throw new IllegalArgumentException("Gemotoriseerd voertuig mag enkel in grote plaatsen staan");
*/
        }
        if (!voertuig.isGemotoriseerd() && this.soort == Type.GROOT) {
            return false;
            /*throw new IllegalArgumentException("Gemotoriseerd voertuig mag enkel in grote plaatsen staan");*/
        }
        this.voertuig = voertuig;
        return true;
    }

    public Voertuig verlaatPlaats() throws IllegalArgumentException{
        if (!isBezet()) {
            throw new IllegalArgumentException("Plaats is niet bezet");
        }
        Voertuig temp = this.voertuig;
        this.voertuig = null;
        return temp;
    }

    public Voertuig getVoertuig() {
        return voertuig;
    }

    public double getCO2Uitstoot() {
        return this.voertuig.getCO2Uitstoot();
    }
}
