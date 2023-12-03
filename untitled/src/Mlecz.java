import java.util.Objects;

public class Mlecz extends Roslina{
    Mlecz() {
        super();
        gatunek = "mlecz";
        sila = 0;
    }
    @Override
    public Organizm rozprzestrzenianie(Organizm orgPoruszany, int X, int Y ){
        Organizm roslina = super.rozprzestrzenianie(orgPoruszany, X, Y);
        roslina.sila = 0;
        return roslina;
    }
}
