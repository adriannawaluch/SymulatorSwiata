import java.awt.*;
import java.util.Objects;

public class Organizm {
    boolean czyTarcza = false;
    boolean dodatkowaEnergia = false;
    int inicjatywa;
    public boolean czyZywy;
    public int dlugoscKroku;
    Color kolor;
    String gatunek;
    int identyfikator;
    boolean czyMogeSieRuszac = false;
    int sila;
    int wspolrzednaX;
    int wspolrzednaY;

    Organizm() {
        czyZywy = true;
        identyfikator = -1;
        gatunek = "";
        sila = -1;
        wspolrzednaX = -1;
        wspolrzednaY = -1;
    }

    ;

    Organizm(String g) {
        gatunek = g;
        czyZywy = true;
        identyfikator = -1;
        sila = -1;
        wspolrzednaX = -1;
        wspolrzednaY = -1;
    }

    @Override
    public String toString() {
        return identyfikator +
                ";" + gatunek +
                ";" + wspolrzednaX +
                ";" + wspolrzednaY +
                ";" + czyZywy;
    }

    public Organizm kolizja(Organizm orgSkolidowany, int X, int Y, int sky) {
        int oss = orgSkolidowany.sila;
        if (!Objects.equals(orgSkolidowany.gatunek, gatunek)) {
            if (oss <= sila) { //jeżeli na polu jest slabszy organizm
                orgSkolidowany.czyZywy = false;
                wspolrzednaX = X;
                wspolrzednaY = Y;
            } else {
                czyZywy = false;
            }
        }
        return null;
    }

    public Pozycja ruszSie(int p, int wysokosc, int szerokosc) {
        return null;
    }

    public Organizm rozprzestrzenianie(Organizm orgPoruszany, int X, int Y) {
        return null;
    }
}