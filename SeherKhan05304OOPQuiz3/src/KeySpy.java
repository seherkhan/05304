import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Seher Khan on 9/26/2017.
 * This class implements KeyListener
 */
public class KeySpy implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key \""+e.getKeyChar()+"\" typed.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key \""+e.getKeyChar()+"\" pressed.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key \""+e.getKeyChar()+"\" released.");
    }
}
