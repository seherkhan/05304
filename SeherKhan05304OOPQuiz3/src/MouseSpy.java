import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Seher Khan on 9/26/2017.
 * This class implements MouseListener
 */
class MouseSpy implements MouseListener
{
    public void mouseClicked(MouseEvent event)
    {
        System.out.println("Mouse clicked. x = "
                + event.getX() + " y = " + event.getY());
    }
    public void mouseEntered(MouseEvent event)
    {
        System.out.println("Mouse entered. x = "
                + event.getX() + " y = " + event.getY());
    }
    public void mouseExited(MouseEvent event)
    {
        System.out.println("Mouse exited. x = "
                + event.getX() + " y = " + event.getY());
    }
    public void mousePressed(MouseEvent event)
    {
        System.out.println("Mouse pressed. x = "
                + event.getX() + " y = " + event.getY());
    }
    public void mouseReleased(MouseEvent event)
    {
        System.out.println("Mouse released. x = "
                + event.getX() + " y = " + event.getY());
    }
}
