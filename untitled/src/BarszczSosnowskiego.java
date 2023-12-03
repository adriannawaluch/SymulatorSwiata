public class BarszczSosnowskiego extends Roslina{
    BarszczSosnowskiego(){
        super();
        gatunek = "barszcz sosnowskiego";
        sila = 10;
    }
    @Override
    public Organizm rozprzestrzenianie(Organizm orgPoruszany, int X, int Y ){
        Organizm roslina = super.rozprzestrzenianie(orgPoruszany, X, Y);
        roslina.sila = 10;
        return roslina;
    }
}
