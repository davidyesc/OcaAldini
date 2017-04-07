package Juegos.ClearShot.controles;

import herramientas.Sonido;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.Clip;

public class Teclado implements KeyListener {

    private final static int numeroTeclas = 120;
    private final boolean[] teclas = new boolean[numeroTeclas];
    private Clip Bang;
    public Clip Song;

    public boolean disparo1;
    public boolean disparo2;
    public boolean ganador = false;
    public boolean fin = false;

    public void actualizar() {
        disparo1 = teclas[KeyEvent.VK_A];
        disparo2 = teclas[KeyEvent.VK_L];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!ganador) {
            teclas[e.getKeyCode()] = true;
            if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_L) {
                Song = Sonido.cargaSonido("/ClearShot/Audio/YesPost.wav");
                Song.start();
                Bang = Sonido.cargaSonido("/ClearShot/Audio/Disparo.wav");
                Bang.start();
                ganador = true;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && ganador == true) {
            fin = true;
            Bang.close();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}