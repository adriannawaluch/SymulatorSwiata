import java.util.Objects;

public class Wilk extends Zwierze{
    Wilk() {
        super(9, 5, 1);
        gatunek = "wilk";
    }

    @Override
    public Organizm kolizja(Organizm orgSkolidowany, int X, int Y, int sky) {
        czyZywy = true; //nie umiera bo jest sprytny
        if (Objects.equals(orgSkolidowany.gatunek, gatunek)) {
            sila = 9;
            inicjatywa = 5;
            dlugoscKroku = 1;
            return this;
        }
        return null;
    }
}
