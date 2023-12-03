import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Czlowiek extends Zwierze {
    int key;
    Czlowiek() {
        super(5, 5, 1);
        gatunek = "czlowiek";
        kolor = Color.MAGENTA;
    }
//    @Override
//    public Pozycja ruszSie(int kierunek,int wysokoscSwiata, int szerokoscSwiata){
//    }
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT) {
//            key = 3;
//        }
//
//        if (key == KeyEvent.VK_RIGHT) {
//            key = 4;
//        }
//
//        if (key == KeyEvent.VK_UP) {
//            key = 1;
//        }
//
//        if (key == KeyEvent.VK_DOWN) {
//            key = 2;
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
}

