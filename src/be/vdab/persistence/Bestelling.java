package be.vdab.persistence;

import be.vdab.model.Product;

import java.util.List;

public interface Bestelling extends Berekenbaar {

    void voegProductToe(Product product);
    List<Product> lijstGesorteerdOpProductnummer();
    List<Product> lijstGesorteerdOpMerk();
    List<Product> lijstGesorteerdOpVolume();
    List<Product> lijstVanHetMerk(String merk);
    List<Product> lijstProductenOnderVijftigEuro();
    List<Product> lijstVanAlleParfums();
    Product duursteProduct();
    void toonLijst(List<Product> producten);
}
