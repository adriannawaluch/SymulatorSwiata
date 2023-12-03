import java.awt.*;
import java.util.Objects;

public class Zwierze extends Organizm {
    boolean czyLeniwy = false;
    boolean czySpryciarz = false;
    Zwierze() {
        czyZywy =true;
    }

    Zwierze(int s, int n, int d) {
        super();
        czyZywy =true;
        czyMogeSieRuszac = true;
        sila = s;
        inicjatywa = n;
        dlugoscKroku = d;
        kolor = Color.ORANGE;
    }

    public Zwierze(String g) {
        gatunek = g;
    }

    @Override
    public Pozycja ruszSie(int kierunek, int wysokoscSwiata, int szerokoscSwiata) {
        Pozycja poz = new Pozycja();
        int i = 1;
        int nowaWspolrzednaY = wspolrzednaY;
        int nowaWspolrzednaX = wspolrzednaX;
        if (czyMogeSieRuszac && czyZywy && i == 1) {
            switch (kierunek) {
                case 1: //góra
                    if (wspolrzednaY == 0) {
                        nowaWspolrzednaY = 0;
                    } else if ((wspolrzednaY - dlugoscKroku) <= 0) {
                        nowaWspolrzednaY = 0;
                    } else {
                        nowaWspolrzednaY = wspolrzednaY - dlugoscKroku;
                    }
                    break;
                case 2: // dół
                    if (wspolrzednaY == wysokoscSwiata - 1) {
                        nowaWspolrzednaY = wysokoscSwiata - 1;
                    } else if ((wspolrzednaY + dlugoscKroku) >= (wysokoscSwiata - 1)) {
                        nowaWspolrzednaY = wysokoscSwiata - 1;
                    } else {
                        nowaWspolrzednaY = wspolrzednaY + dlugoscKroku;
                    }
                    break;
                case 3: //lewo
                    if (wspolrzednaX == 0) {
                        nowaWspolrzednaX = 0;
                    } else if ((wspolrzednaX - dlugoscKroku) <= 0) {
                        nowaWspolrzednaX = 0;
                    } else {
                        nowaWspolrzednaX = wspolrzednaX - dlugoscKroku;
                    }
                    break;
                case 4: //prawo
                    if (wspolrzednaX == szerokoscSwiata - 1) {
                        nowaWspolrzednaX = szerokoscSwiata - 1;
                    } else if ((wspolrzednaX + dlugoscKroku) >= (szerokoscSwiata - 1)) {
                        nowaWspolrzednaX = szerokoscSwiata - 1;
                    } else {
                        nowaWspolrzednaX = wspolrzednaX + dlugoscKroku;
                    }
                    break;
            }
        }
        poz.X = nowaWspolrzednaX;
        poz.Y = nowaWspolrzednaY;
        return poz;
    }

    public Organizm kolizja(Organizm org, int X, int Y, int sky) {
        if (Objects.equals(org.gatunek, gatunek)) {
            Zwierze zwierz = new Zwierze(org.gatunek);
            return zwierz;
        }
        if (org.czyTarcza && sila >= 5){
            return null;

        }
        if(org.dodatkowaEnergia){
            sila = sila + 3;
        }
        if (sky != 0){
            if(Objects.equals(org.gatunek, "czlowiek")){
                sky = sky -1;
                return null;
            }
        }
        super.kolizja(org, X, Y, sky);
        return null;
    }
}
