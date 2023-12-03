import java.util.Objects;

public class Antylopa extends Zwierze {
    Antylopa() {
        super(4,4, 2);
        czyZywy = true;
        gatunek = "antylopa";
    }

    public Organizm kolizja(Organizm org, int X, int Y, int sky) {
        super.kolizja(org, X, Y, sky);
        if (Objects.equals(org.gatunek, gatunek)) {
            sila = 4;
            inicjatywa =4;
            dlugoscKroku = 2;
            return this;
        }
        return null;
    }
}
