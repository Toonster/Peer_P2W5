package Stalling;

import Voertuigen.*;

import java.time.LocalDate;

public class PlaatsTest {
    public static void main(String[] args) throws Exception {
        Plaats grotePlaats = new Plaats(Plaats.Type.GROOT);
        Plaats kleinePlaats = new Plaats(Plaats.Type.KLEIN);
        Auto a = new Auto("Audi", "A3", LocalDate.now(), 97.1);
        ElektrischeFiets ef = new ElektrischeFiets("Gazelle", "Electron", (byte) 6, 55);
        Step s = new Step("Disney", "Frozen");
        if (grotePlaats.isBezet() || kleinePlaats.isBezet()) {
            throw new Exception("Kijk de implementatie van isBezet na, deze klopt niet...");
        }
        try {
            grotePlaats.verlaatPlaats();
            throw new Exception("Oeps, het verlaten van een plaats zou een exception moeten geven maar dat gebeurd niet");
        } catch (IllegalArgumentException iae) {
            // Alles goed, dat verwachten we
        }
        try {
            kleinePlaats.stalVoertuig(a);
            throw new Exception("Oeps, het stallen van een auto in een kleine plaats zou een exception moeten geven ...");
        } catch (IllegalArgumentException iae) {
            // Alles goed, dat verwachten we
        }
        try {
            kleinePlaats.stalVoertuig(ef);
            throw new Exception("Oeps, het stallen van een EF in een kleine plaats zou een exception moeten geven...");
        } catch (IllegalArgumentException iae) {
            // Alles goed, dat verwachten we
        }
        grotePlaats.stalVoertuig(a);
        kleinePlaats.stalVoertuig(s);
        if (!grotePlaats.isBezet() || !kleinePlaats.isBezet()) {
            throw new Exception("Kijk de implementatie van isBezet na, deze klopt niet...");
        }
        try {
            kleinePlaats.stalVoertuig(a);
            throw new Exception("Oeps, het stallen van een reeds bezette plaats zou een fout moeten geven");
        } catch (IllegalArgumentException iae) {
            // Alles goed, dat verwachten we
        }
        Voertuig v = grotePlaats.verlaatPlaats();
        if (v != a) throw new Exception("Oeps, de grote plaats heeft een fout object teruggegeven");
        if (grotePlaats.isBezet()) throw new Exception("Oeps, de grote plaats zou leeg moeten zijn maar dat is ze niet");
        System.out.println("Als je deze uitvoer leest, zijn alle tests geslaagd!");
    }
}
