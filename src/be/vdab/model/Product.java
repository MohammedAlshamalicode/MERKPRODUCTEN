package be.vdab.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public abstract class Product implements Serializable , Comparable<Product>{
    private static final long serialVersionUID = 1L;

    private int productNummer;
    private String merk;
    private String naam;
    private int volume;
    private double prijs;

    public Product(String merk, String naam, int volume, double prijs) {
        this.merk = merk;
        this.naam = naam;
        this.volume = volume;
        this.prijs = prijs;
    }

    public int getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public String getMerk() {
        return merk;
    }

    public String getNaam() {
        return naam;
    }

    public int getVolume() {
        return volume;
    }

    public double getPrijs() {
        return prijs;
    }

    public String getProductCode(Product product ){
        String merkCode = product.getMerk().substring(0,3).toUpperCase().replace(" ","_");
        String naamCode = product.getNaam().substring(0,3).toUpperCase().replace(" ","_");
        int volumeCode = product.getVolume();
        return merkCode+naamCode+volumeCode ;
    }

    public static Comparator<Product> sorteerOpmerkNaam(){
        return (p1,p2) -> p1.getMerk().compareToIgnoreCase(p2.getMerk());
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.getProductNummer(),o.getProductNummer());
    }

    @Override
    public String toString() {
        return String.format("%-4d Merk: %-25s Naam: %-30s Volume: %-3dml   Prijs: %-6.2f   Code: %-9s",
                productNummer,merk,naam,volume,prijs,getProductCode(this));
    }
}
