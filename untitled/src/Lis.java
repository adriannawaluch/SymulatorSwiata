import java.util.Objects;
import java.util.Random;

public class Lis extends Zwierze{
    Lis(){
        super(3, 7, 1);
        czySpryciarz = true;
        gatunek = "lis";
    }

    @Override
    public Organizm kolizja(Organizm orgSkolidowany, int X, int Y, int ky) {
        if (Objects.equals(orgSkolidowany.gatunek, gatunek)) {
            sila = 3;
            inicjatywa = 7;
            dlugoscKroku = 1;
            return this;
        }
        Random rand = new Random();
        int random = rand.nextInt((4) + 1);
        ruszSie(random, X, Y);
        czyZywy = true; //nie umiera bo jest sprytny
        return null;
    }
}
