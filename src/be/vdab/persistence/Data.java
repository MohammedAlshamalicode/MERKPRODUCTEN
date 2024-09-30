package be.vdab.persistence;

import be.vdab.model.AfterShave;
import be.vdab.model.Doedorant;
import be.vdab.model.Parfum;
import be.vdab.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    private static Product[] artikels = {
            new Parfum("Dolce & Gabbana", "Light Blue", 100, 66.72),
            new Parfum("BVLGARI", "BLV", 75, 61.52),
            new Doedorant("DKNY", "Be Delicious Women", 100, 33.65,
                    Doedorant.DoeType.STICK),
            new Parfum("Georgio Armani", "Code Donna", 50, 59.32),
            new AfterShave("Yves Saint Laurent", "Jazz", 50, 39.84,
                    AfterShave.Soort.VAPO),
            new Parfum("Givency", "Absolutely Irresistible", 75, 75.42),
            new AfterShave("Yves Saint Laurent", "Jazz", 100, 57.76,
                    AfterShave.Soort.VAPO),
            new Parfum("Ted Lapidus", "Pour Elle", 50, 44.48),
            new Parfum("Georgio Armani", "Code Donna", 30, 39.84),
            new Parfum("Georgio Armani", "Code Donna", 75, 76.00),
            new Doedorant("Cacharel", "Anais", 50, 24.50, Doedorant.DoeType.VAPO),
    };

    // Geeft de lijst als een ArrayList terug
    public static List<Product> getData() {
        return new ArrayList<>(Arrays.asList(artikels));
    }
}
