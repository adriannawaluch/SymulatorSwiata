import java.awt.*;

public class Roslina extends Organizm{
    Roslina(){
        inicjatywa = 0;
        czyMogeSieRuszac = false;
        kolor = Color.green;
    }
    public Roslina(String g) {
        gatunek = g;
        inicjatywa = 0;
        kolor = Color.green;
    }
    @Override
    public Organizm rozprzestrzenianie(Organizm orgPoruszany, int X, int Y ){
        Roslina roslina = new Roslina(orgPoruszany.gatunek);
        return roslina;
    }
}
