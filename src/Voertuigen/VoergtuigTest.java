package Voertuigen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VoergtuigTest {
    public static void main(String[] args) {
        List<Voertuig> voertuigen = new ArrayList<>();
        voertuigen.add(new Auto("Audi", "A3", LocalDate.now(), 97.1));
        voertuigen.add(new Fiets("Gazelle", "One"));
        voertuigen.add(new Fiets("Gazelle", "SixStep", (byte) 6));
        voertuigen.add(new ElektrischeFiets("Gazelle", "Electron", (byte) 6, 55));
        voertuigen.add(new Step("Disney", "Frozen"));
        for (Voertuig v : voertuigen) {
            String uitstoot = "";
            if (v.isGemotoriseerd()) {
                uitstoot = String.format("%.1f gr/km", v.getCO2Uitstoot());
            }
            System.out.printf("%s (%s) %s%n", v.toString()
                    , (v.isBestuurbaarDoorKinderen() ? "KT" : "KNT"), uitstoot);
        }
    }
}

