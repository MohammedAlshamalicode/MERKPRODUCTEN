package be.vdab.console;

import be.vdab.ProductSerializer;
import be.vdab.persistence.Bestelling;
import be.vdab.persistence.Data;
import be.vdab.model.Product;
import be.vdab.persistence.BestellingImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;

import static java.time.LocalTime.now;

public class TestApp {
    public static void main(String[] args) {
        System.out.printf("Oplossing van %s %s\n", "Kenneth Van Gijsel ",
                "Java Instructeur");

        Bestelling bestelling = new BestellingImpl();
        List<Product> lijst = Data.getData();

        for (Product artikel : lijst) {
            bestelling.voegProductToe(artikel);
        }

        String desktopPath = System.getProperty("user.home") + "/Desktop/merkproducten.dat";

        ProductSerializer.saveProductsToFile(bestelling,desktopPath);

        System.out.println("Lijst gesorteerd op natuurlijke volgorde: ");
        bestelling.toonLijst(bestelling.lijstGesorteerdOpProductnummer());

        System.out.println("\nLijst gesorteerd op merknaam: ");
        bestelling.toonLijst(bestelling.lijstGesorteerdOpMerk());

        System.out.println("\nLijst gesorteerd op volume: ");
        bestelling.toonLijst(bestelling.lijstGesorteerdOpVolume());

        System.out.println("\nVan het merk Georgio Armani:");
        bestelling.toonLijst(bestelling.lijstVanHetMerk("Georgio Armani"));

        System.out.println("\nAlle Parfums:");
        bestelling.toonLijst(bestelling.lijstVanAlleParfums());

        System.out.println("\nAlle producten onder €50; ");
        bestelling.toonLijst(bestelling.lijstProductenOnderVijftigEuro());

        Product product = bestelling.duursteProduct();
        System.out.println("\nDuurste product:\n" + product);

        System.out.printf("\nTotale prijs: €%.2f", bestelling.totalePrijs());
        System.out.println();
//        var formater = DateTimeFormatter.ofPattern("HH:mm:ss");
//        var nuDate = LocalDate.now();
//        var nuTime = LocalTime.now().format(formater);
//        System.out.println(nuDate+"\n"+nuTime);

    }
}
