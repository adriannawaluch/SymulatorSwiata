public class Guarana extends Roslina {
    Guarana() {
        super();
        gatunek = "guarana";
        sila = 0;
        dodatkowaEnergia = true;
    }
    @Override
    public Organizm rozprzestrzenianie(Organizm orgPoruszany, int X, int Y ){
        Organizm roslina = super.rozprzestrzenianie(orgPoruszany, X, Y);
        roslina.sila = 0;
        roslina.dodatkowaEnergia = true;
        return roslina;
    }
}
