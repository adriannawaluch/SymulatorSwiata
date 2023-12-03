import java.util.Objects;

public class CyberOwca extends Zwierze{
    CyberOwca() {
        super(11, 4, 1);
        gatunek = "CyberOwca";
    }

    public Organizm kolizja(Organizm org, int X, int Y, int sky) {
        super.kolizja(org, X, Y, sky);
        if (Objects.equals(org.gatunek, gatunek)) {
            sila = 11;
            inicjatywa =4;
            dlugoscKroku = 1;
            return this;
        }
        return null;
    }
}

