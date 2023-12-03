import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class Swiat implements ActionListener {
    int key = 0;
    int czyTarczaDziala = 0;
    final int LOSUJ = -1;
    int ileOrganizmow;
    int szerokosc; //szerokosc
    int wysokosc; //wysokosc
    int dodawanaWspolrzednaX;
    int dodawanaWspolrzednaY;
    Organizm dodawanyOrganizm;
    Organizm[] organizmy = new Organizm[250];
    JFrame frame;
    JFrame checkFrame;
    final TextField tf = new TextField();

    public Swiat() {
        this.szerokosc = 10;
        this.wysokosc = 10;
    }

    public Swiat(int szerokosc, int wysokosc) {
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    void rysujSwiat() {
        int i, j;
        Organizm org;
        String opis = null;
        Color kolor = null;
        frame = new JFrame();
        checkFrame = new JFrame();
        checkFrame.setSize(400, 800);
        tf.setBounds(50, 50, 150, 20);
        JCheckBox checkAntylopa = new JCheckBox("Antylopa", false);
        checkAntylopa.setBounds(0, 50, 300, 50);
        JCheckBox checkBarszcz = new JCheckBox("Barszcz Sosnowskiego", false);
        checkBarszcz.setBounds(0, 100, 300, 50);
        JCheckBox checkCyberOwca = new JCheckBox("Cyber Owca", false);
        checkCyberOwca.setBounds(0, 150, 300, 50);
        JCheckBox checkGuarana = new JCheckBox("Guarana", false);
        checkGuarana.setBounds(0, 200, 300, 50);
        JCheckBox checkLis = new JCheckBox("Lis", false);
        checkLis.setBounds(0, 250, 300, 50);
        JCheckBox checkMlecz = new JCheckBox("Mlecz", false);
        checkMlecz.setBounds(0, 300, 300, 50);
        JCheckBox checkOwca = new JCheckBox("Owca", false);
        checkOwca.setBounds(0, 350, 300, 50);
        JCheckBox checkTrawa = new JCheckBox("Trawa", false);
        checkTrawa.setBounds(0, 400, 300, 50);
        JCheckBox checkWilczeJagody = new JCheckBox("Wilcze Jagody", false);
        checkWilczeJagody.setBounds(0, 450, 300, 50);
        JCheckBox checkWilk = new JCheckBox("Wilk", false);
        checkWilk.setBounds(0, 500, 300, 50);
        JCheckBox checkZolw = new JCheckBox("Zolw", false);
        checkZolw.setBounds(0, 550, 300, 50);
        JButton addButton = new JButton("DODAJ ZWIERZE");
        addButton.setBounds(0, 600, 300, 50);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkAntylopa.isSelected()){
                    dodawanyOrganizm = new Antylopa();
                } else if (checkBarszcz.isSelected()) {
                    dodawanyOrganizm = new BarszczSosnowskiego();
                } else if (checkCyberOwca.isSelected()) {
                    dodawanyOrganizm = new CyberOwca();
                } else if (checkGuarana.isSelected()){
                    dodawanyOrganizm = new Guarana();
                }else if (checkLis.isSelected()){
                    dodawanyOrganizm = new Lis();
                }else if (checkMlecz.isSelected()){
                    dodawanyOrganizm = new Mlecz();
                }else if (checkOwca.isSelected()){
                    dodawanyOrganizm = new Owca();
                }else if (checkTrawa.isSelected()){
                    dodawanyOrganizm = new Trawa();
                }else if (checkWilczeJagody.isSelected()){
                    dodawanyOrganizm = new WilczeJagody();
                }else if (checkWilk.isSelected()){
                    dodawanyOrganizm = new Wilk();
                }else if (checkZolw.isSelected()){
                    dodawanyOrganizm = new Zolw();
                }
                tworzOrganizm(dodawanyOrganizm, dodawanaWspolrzednaX, dodawanaWspolrzednaY, ileOrganizmow);
                checkFrame.setVisible(false);
                frame.setVisible(false);
                rysujSwiat();
                wypiszOrganizmy();
            }
        });
        checkFrame.add(checkZolw);
        checkFrame.add(checkWilk);
        checkFrame.add(checkWilczeJagody);
        checkFrame.add(checkTrawa);
        checkFrame.add(checkOwca);
        checkFrame.add(checkMlecz);
        checkFrame.add(checkLis);
        checkFrame.add(checkGuarana);
        checkFrame.add(checkCyberOwca);
        checkFrame.add(checkBarszcz);
        checkFrame.add(checkAntylopa);
        checkFrame.add(addButton);
        checkFrame.setLayout(null);
        for (i = 0; i < wysokosc; i++) {
            for (j = 0; j < szerokosc; j++) {
                org = znajdzOrganizm(j, i);
                if (org != null) {
                        opis = org.gatunek;
                        kolor = org.kolor;
                        dodawanaWspolrzednaX = j;
                        dodawanaWspolrzednaY = i;
                } else {
                    opis = "PUSTO";
                    kolor = Color.white;
                    dodawanaWspolrzednaX = j;
                    dodawanaWspolrzednaY = i;
                }
                JButton b = new JButton(opis);
                frame.add(b);
                b.setForeground(kolor);
                b.addKeyListener(new Keychecker());
                String finalOpis = opis;
                int finalDodawanaWspolrzednaX = dodawanaWspolrzednaX;
                int finalDodawanaWspolrzednaY = dodawanaWspolrzednaY;
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tf.setText("KLIK NA " + finalOpis);
                        System.out.println("Przycisk o wspolrzędnych: " + finalDodawanaWspolrzednaX + finalDodawanaWspolrzednaY);
                        dodawanaWspolrzednaX = finalDodawanaWspolrzednaX;
                        dodawanaWspolrzednaY = finalDodawanaWspolrzednaY;
                        checkFrame.setVisible(true);
                    }
                });
            }
        }
        frame.add(tf);
        frame.setLayout(new GridLayout(wysokosc + 1, szerokosc));
        frame.setSize(1500, 800);
        frame.setVisible(true);
    }

    void tworzOrganizm(Organizm o, int X, int Y, int ident) {
        int tempX, tempY;
        if (X == -1) {
            Random rand1 = new Random();
            tempX = rand1.nextInt((szerokosc-1) + 1);
        } else {
            tempX = X;
        }
        if (Y == -1) {
            Random rand2 = new Random();
            tempY = rand2.nextInt((wysokosc-1) + 1);
        } else {
            tempY = Y;
        }
        if (czyWolneMiejsce(tempX, tempY)) {
            o.wspolrzednaX = tempX;
            o.wspolrzednaY = tempY;
            o.identyfikator = ident;
            ileOrganizmow++;
            organizmy[ileOrganizmow - 1] = o;
        } else {
            tworzOrganizm(o, -1, -1,ileOrganizmow-1);
        }
    }

    void tworzOrganizmObok(Organizm staryO, Organizm nowyO){
        int ileObrotów = 0;
        int nowaWspolrzednaX = staryO.wspolrzednaX;
        int nowaWspolrzednaY = staryO.wspolrzednaY;
        while(ileObrotów < 4) {
            Random rand = new Random();
            int kierunek = rand.nextInt((4) + 1);
            switch (kierunek) {
                case 1: //góra
                    if (staryO.wspolrzednaY == 0) {
                        ileObrotów++;
                        break;
                    } else {
                        nowaWspolrzednaY = staryO.wspolrzednaY - 1;
                    }
                    break;
                case 2: // dół
                    if (staryO.wspolrzednaY == wysokosc - 1) {
                        ileObrotów++;
                        break;
                    } else {
                        nowaWspolrzednaY = staryO.wspolrzednaY + 1;
                    }
                    break;
                case 3: //lewo
                    if (staryO.wspolrzednaX == 0) {
                        ileObrotów++;
                        break;
                    } else {
                        nowaWspolrzednaX = staryO.wspolrzednaX - 1;
                    }
                    break;
                case 4: //prawo
                    if (staryO.wspolrzednaX == szerokosc - 1) {
                        ileObrotów++;
                        break;
                    } else {
                        nowaWspolrzednaX = staryO.wspolrzednaX + 1;
                    }
                    break;
            }
            if (czyWolneMiejsce(nowaWspolrzednaX, nowaWspolrzednaY)) {
                nowyO.wspolrzednaX = nowaWspolrzednaX;
                nowyO.wspolrzednaY = nowaWspolrzednaY;
                nowyO.identyfikator = ileOrganizmow;
                ileOrganizmow++;
                organizmy[ileOrganizmow - 1] = nowyO;
                ileObrotów = 4;
            } else {
                ileObrotów++;
            }
        }
    }

    void wypiszOrganizmy() {
        for (int i = 0; i < organizmy.length; i++) {
            if (organizmy[i] != null) {
                System.out.println("id: " + organizmy[i].identyfikator + " " +organizmy[i].gatunek + " x: " + organizmy[i].wspolrzednaY + " y: " + organizmy[i].wspolrzednaX + " czy żwywy: " + organizmy[i].czyZywy);
            } else {
                System.out.print("");
            }
        }
    }

    Organizm znajdzOrganizm(int x, int y, int idx) {
        int k;
        for (k = 0; k < organizmy.length; k++) {
            if (this.organizmy[k] == null) {
                return null;
            } else if (x == this.organizmy[k].wspolrzednaX && y == this.organizmy[k].wspolrzednaY && this.organizmy[k].czyZywy && this.organizmy[k].identyfikator != idx) {
                return organizmy[k];
            }
        }
        return null;
    }

    Organizm znajdzOrganizm(int x, int y) {
        return znajdzOrganizm(x, y, -1);
    }

    boolean czyWolneMiejsce(int X, int Y) {
        Organizm tempOrg;
        tempOrg = znajdzOrganizm(X, Y);
        if (tempOrg == null) {
            return true;
        } else {
            return false;
        }
    }

    void posortuj() {
        Arrays.sort(this.organizmy, new Comparator<Organizm>() {
            @Override
            public int compare(Organizm first, Organizm second) {
                if (first != null && second != null) {
                    if (first.inicjatywa != second.inicjatywa) {
                        return first.inicjatywa - second.inicjatywa;
                    } else if (first != null && second == null) {
                        return 1; //first is greater because second is null
                    }
                }
                return 0;
            }
        });
    };


    void wykonajTure(int ky) { //wykonuje turę, porusza zwierzętami, człowiekiem
        int p;
        int k;
        int sky = 0;
        Pozycja poz = new Pozycja();
        Organizm orgPoruszany, orgSkolidowany;
        int dlTabPoczatkowej = ileOrganizmow;
        posortuj();
        wypiszOrganizmy();
        for (k = 0; k < dlTabPoczatkowej; k++) {
            orgPoruszany = this.organizmy[k];
            if (orgPoruszany != null) {
                if (orgPoruszany.czyMogeSieRuszac && orgPoruszany.czyZywy) {
                    if (orgPoruszany.gatunek.equals("czlowiek")) {
                        p = key;
                        sky = czyTarczaDziala;
                    } else {
                        Random randP = new Random();
                        p = randP.nextInt((4) + 1);
                    }
                    poz = orgPoruszany.ruszSie(p, wysokosc, szerokosc);
                    if (poz != null) {
//                           System.out.println("szukamy kolizji dla " + orgPoruszany.gatunek);
                            orgSkolidowany = znajdzOrganizm(poz.X, poz.Y, orgPoruszany.identyfikator); //wykrywamy czy jest kolizja
                        if (orgSkolidowany != null) {
//                               System.out.println("kolizja z " + orgSkolidowany.gatunek);
                            Organizm nowyOrg = orgPoruszany.kolizja(orgSkolidowany, poz.X, poz.Y, sky);
                            if (nowyOrg != null) {
                                tworzOrganizm(nowyOrg, LOSUJ, LOSUJ, ileOrganizmow);
                            }
                        } else {
                            orgPoruszany.wspolrzednaX = poz.X;
                            orgPoruszany.wspolrzednaY = poz.Y;
                        }
                    }
                } else if (orgPoruszany.czyZywy) {
                    Organizm nowaRoslina = orgPoruszany.rozprzestrzenianie(orgPoruszany, orgPoruszany.wspolrzednaX, orgPoruszany.wspolrzednaY);
                    if (nowaRoslina != null){
                        tworzOrganizmObok(orgPoruszany, nowaRoslina);
//                           tworzOrganizm(nowaRoslina, LOSUJ, LOSUJ, ileOrganizmow);
                    }
                    System.out.println(nowaRoslina);
                }
            }
        }
        System.out.println("NOWA TURA");
        wypiszOrganizmy();
        frame.setVisible(false);
        rysujSwiat();
    }

    void saveToFile(String fileName) {
        try {
            PrintWriter csvOutputFile = new PrintWriter(fileName);
            for (int i = 0; i <= this.organizmy.length - 1; i++) {
                if (this.organizmy[i] != null) {
                    csvOutputFile.println(this.organizmy[i].toString());
                }
            }
            csvOutputFile.close();
        } catch (IOException ioe) {
            System.err.format("IOException: %s%n", ioe);
        }
    }


    void readFromFile(String fileName) {
        try {
            BufferedReader csvOutputFile = new BufferedReader(new FileReader(fileName));
            System.out.println("Czytam z pliku: " + fileName);
            String linia = "";
            int k = 0;
            linia = csvOutputFile.readLine();
            while (linia != null) {
                // najpierw odczytujemy cala linie i zapisujemy poszczegolne wartosci z csv do zmiennych
                StringTokenizer tk = new StringTokenizer(linia, ";"); //parsujemy cala linie
                int id = Integer.parseInt(tk.nextToken()); // zczytujemy identyfikator
                String g = tk.nextToken();  //zczytujemy gatunek z linii
                System.out.println("Jestem w czytaniu z pliku, g jest równe: <" + g + ">");
                int posX = Integer.parseInt(tk.nextToken()); // sczytujemy posX
                int posY = Integer.parseInt(tk.nextToken()); //sczytujemyt posY
                Boolean l = Boolean.parseBoolean(tk.nextToken()); //szczytuje czy zyje organizm
                // a potem podmieniam organizmy wartosciami zaczytami z pliku
                this.organizmy[k].identyfikator = id; // zapisujemy identyfikator z pliku
                this.organizmy[k].gatunek = g; // zapisujemy gatunek z pliku
                this.organizmy[k].wspolrzednaX = posX; // zapisujemy posX z pliku
                this.organizmy[k].wspolrzednaY = posY; // zapisujemy posY z pliku
                this.organizmy[k].czyZywy = l; // zapisujemy czy zyje z pliku
                System.out.println("Jestem w czytaniu z pliku ale z this organizmy, g jest równe: <" + this.organizmy[k].gatunek + ">");
                k = k + 1;
                //System.out.println(g);
                linia = csvOutputFile.readLine();
            }
            csvOutputFile.close();
        } catch (IOException ioe) {
            System.err.format("IOException: %s%n", ioe);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tf.setText("Welcome to Javatpoint.");
    }

    class Keychecker extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {
            key = event.getKeyCode();
            int tarcza = event.getKeyCode();

            if (key ==  KeyEvent.VK_RIGHT)
                key = 4;
            else if (key ==  KeyEvent.VK_LEFT)
                key = 3;
            else if (key ==  KeyEvent.VK_UP)
                key = 1;
            else if (key ==  KeyEvent.VK_DOWN)
                key = 2;
            else if (tarcza == KeyEvent.VK_SPACE)
                czyTarczaDziala = 5;
            else
                key = 0;
            if(organizmy[0].czyZywy) {
                wykonajTure(key);
            }
        }

    }

}