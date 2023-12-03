public class WilczeJagody extends Roslina{
    WilczeJagody() {
        super();
        gatunek = "wilcze jagody";
        sila = 99;
    }

    @Override
    public Organizm rozprzestrzenianie(Organizm orgPoruszany, int X, int Y ){
        Organizm roslina = super.rozprzestrzenianie(orgPoruszany, X, Y);
        roslina.sila = 99;
        return roslina;
    }
}
