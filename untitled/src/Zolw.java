import java.util.Objects;
import java.util.Random;

public class Zolw extends Zwierze{
    Zolw() {
        super(2, 1, 1);
        czyTarcza = true;
        czyLeniwy = true;
        gatunek = "zolw";
    }

    @Override
    public Pozycja ruszSie(int kierunek, int wysokoscSwiata, int szerokoscSwiata) {
        int i;
        Random randP = new Random();
        i = randP.nextInt((4) + 1);
        if(i == 1) {
            return super.ruszSie(kierunek, wysokoscSwiata, szerokoscSwiata);
        }
        return null;
    }

    @Override
    public Organizm kolizja(Organizm orgSkolidowany, int X, int Y, int sky) {
        czyZywy = true; //nie umiera bo jest sprytny
        if (Objects.equals(orgSkolidowany.gatunek, gatunek)) {
            sila = 3;
            inicjatywa = 7;
            dlugoscKroku = 1;
            return this;
        }
        return null;
    }
}
