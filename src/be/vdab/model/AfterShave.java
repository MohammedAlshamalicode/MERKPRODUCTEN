package be.vdab.model;

public class AfterShave extends Product{

    public enum Soort {VAPO,GEL}

    private Soort soort ;

    public AfterShave(String merk, String naam, int volume, double prijs, Soort soort) {
        super(merk, naam, volume, prijs);
        this.soort = soort;
    }

    public Soort getSoort() {
        return soort;
    }

    @Override
    public String toString() {
        return  String.format("%s  %-5s",super.toString(),getSoort());
    }
}
