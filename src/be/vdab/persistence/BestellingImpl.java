package be.vdab.persistence;

import be.vdab.model.Parfum;
import be.vdab.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class BestellingImpl implements Bestelling{

    private ArrayList<Product> bestelling = new ArrayList<>();
    private static int productNummer = 1000 ;


    @Override
    public void voegProductToe(Product product) {
       product.setProductNummer(productNummer++);
        bestelling.add(product);
    }

    @Override
    public List<Product> lijstGesorteerdOpProductnummer() {
        return bestelling.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public List<Product> lijstGesorteerdOpMerk() {
        return bestelling.stream().sorted(Product.sorteerOpmerkNaam()).collect(Collectors.toList());
    }

    @Override
    public List<Product> lijstGesorteerdOpVolume() {
        return bestelling.stream().sorted(Comparator.comparingInt(Product::getVolume)).collect(Collectors.toList());
    }

    @Override
    public List<Product> lijstVanHetMerk(String merk) {
        return bestelling.stream().filter(p -> p.getMerk().equalsIgnoreCase(p.getMerk())).collect(Collectors.toList());
    }

    @Override
    public List<Product> lijstProductenOnderVijftigEuro() {
        return bestelling.stream().filter(p -> p.getPrijs() > 50).collect(Collectors.toList());
    }

    @Override
    public List<Product> lijstVanAlleParfums() {
        return bestelling.stream().filter(p -> p instanceof Parfum).collect(Collectors.toList());
    }

    @Override
    public Product duursteProduct() {
        return bestelling.stream().max(Comparator.comparing(Product::getPrijs)).orElse(null);
    }

    @Override
    public void toonLijst(List<Product> producten) {
        producten.forEach(System.out::println);
    }

    @Override
    public double totalePrijs() {
        double totalPrijs = 0 ;
        for (Product artikle : bestelling){
            totalPrijs += artikle.getPrijs();
        }
        return  totalPrijs;
    }
}
