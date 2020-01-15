package Stalling;

import Voertuigen.Voertuig;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Garage {

    List<Plaats> garage;
    private static int id = 1;
    private int uniqueID = id;

    public Garage(int amount) {
        garage = new ArrayList<Plaats>(Arrays.asList(new Plaats[amount]));
        fillGarage();
        id++;
    }

    private void fillGarage() {
        int amountTypeKlein = (int) Math.ceil((double) garage.size() * 2 / 3);
        for (int i = 0; i < Math.ceil((double) garage.size() * 2 / 3); i++) {
            garage.set(i, new Plaats(Plaats.Type.KLEIN));
        }
        for (int i = amountTypeKlein; i < garage.size(); i++) {
            garage.set(i, new Plaats(Plaats.Type.GROOT));
        }
    }

    public int freeSpacesOfType(Plaats.Type type) {
        int freeSpaces = 0;
        for (Plaats plaats : garage) {
            if (!plaats.isBezet() && plaats.soort == type) {
                freeSpaces++;
            }
        }
        return freeSpaces;
    }

    public double getAverageCO2Emission() {
        double totalEmission = 0;
        int vehiclesWithCO2 = 0;
        for (Plaats plaats : garage) {
            totalEmission += plaats.getCO2Uitstoot();
            if (plaats.getCO2Uitstoot() > 0) {
                vehiclesWithCO2++;
            }
        }
        return totalEmission / vehiclesWithCO2;
    }

    public void stal(Voertuig voertuig) {
        for (Plaats plaats : garage) {
                if (plaats.stalVoertuig(voertuig)) {
                    return;
                }
        }
        throw new GeenPlaatsGevondenException(voertuig, this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Garage ").append(uniqueID).append("\n");
        for (Plaats plaats : garage) {
            sb.append(" - ");
            sb.append("(").append(plaats.soort).append(") ");
            if (plaats.isBezet()) {
                sb.append(plaats.getVoertuig());
            } else {
                sb.append("LEEG");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
