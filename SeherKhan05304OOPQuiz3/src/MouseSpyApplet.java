import java.applet.Applet;

/**
 * Created by Seher Khan on 9/26/2017.
 */
public class MouseSpyApplet extends Applet
{
    public MouseSpyApplet()
    {
        System.out.println("creating applet");
        MouseSpy listenerMouse = new MouseSpy();
        KeySpy listenerKey = new KeySpy();
        addMouseListener(listenerMouse);
        addKeyListener(listenerKey);
    }
}
