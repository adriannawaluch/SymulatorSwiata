import javax.swing.JFrame;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int idx = 0;
        Swiat mojSwiat = new Swiat(10,10);
        mojSwiat.tworzOrganizm(new Czlowiek(), 1, 0, idx++);
        mojSwiat.tworzOrganizm(new Owca(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Antylopa(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Lis(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Mlecz(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Guarana(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new BarszczSosnowskiego(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Trawa(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new WilczeJagody(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Wilk(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Zolw(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Wilk(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Zolw(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Owca(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Antylopa(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Lis(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Owca(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Antylopa(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Lis(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Zolw(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.tworzOrganizm(new Wilk(), mojSwiat.LOSUJ, mojSwiat.LOSUJ, idx++);
        mojSwiat.rysujSwiat();
        mojSwiat.wypiszOrganizmy();
        mojSwiat.saveToFile("Swiat1.csv");
//        mojSwiat.readFromFile("Swiat1.csv");
        mojSwiat.rysujSwiat();
        mojSwiat.wypiszOrganizmy();
//        mojSwiat.rysujSwiat();

    }
}