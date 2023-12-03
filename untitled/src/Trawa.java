public class Trawa extends Roslina{
    Trawa() {
        super();
        gatunek = "trawa";
        sila = 0;
    }

    @Override
    public Organizm rozprzestrzenianie(Organizm orgPoruszany, int X, int Y ){
        Organizm roslina = super.rozprzestrzenianie(orgPoruszany, X, Y);
        roslina.sila = 0;
        return roslina;
    }
}
