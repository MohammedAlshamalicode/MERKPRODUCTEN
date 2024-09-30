package be.vdab.model;

public class Doedorant extends Product{

    public enum DoeType{VAPO,STICK}
    private DoeType soort ;

    public Doedorant(String merk, String naam, int volume, double prijs, DoeType soort) {
        super(merk, naam, volume, prijs);
        this.soort = soort;
    }

    public DoeType getSoort() {
        return soort;
    }

    @Override
    public String toString() {
        return  String.format("%s  %-5s",super.toString(),getSoort());
    }
}
