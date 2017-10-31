import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Seher Khan on 10/26/2017.
 */
public class AnalogueClock extends JFrame implements Runnable {
    ClockPanel clockPanel;


    public AnalogueClock() {
        setSize(300, 300);
        clockPanel = new ClockPanel();
        add(clockPanel);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        AnalogueClock clock = new AnalogueClock();
        Thread thread = new Thread(clock);
        thread.start();
    }

    @Override
    public void run() {
        clockPanel.repaint();
        try {
            Thread.sleep(200); // update after every 200 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ClockPanel extends JPanel {
    Date dt;
    Calendar cl;

    Point2D center;
    Ellipse2D clockBoundary;
    Line2D hourHand;
    Line2D minuteHand;
    Line2D secondHand;


    public ClockPanel(){
        dt = new Date();
        cl = GregorianCalendar.getInstance();
        cl.setTime(dt);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        center = new Point2D.Double(getWidth()/2,getHeight()/2);

        clockBoundary = new Ellipse2D.Float(0,0,getWidth(),getHeight());
        hourHand = new Line2D.Double(center,getHourPoint());
        minuteHand = new Line2D.Double(center,getMinutePoint());
        secondHand = new Line2D.Double(center,getSecondPoint());

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0,0,0));
        g2d.setStroke(new BasicStroke(1));
        g2d.draw(clockBoundary);

        g2d.setColor(new Color(40,40,100));
        g2d.setStroke(new BasicStroke(10));
        g2d.draw(hourHand);

        g2d.setColor(new Color(0,110,100));
        g2d.setStroke(new BasicStroke(7));
        g2d.draw(minuteHand);

        g2d.setColor(new Color(250,200,100));
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(secondHand);

    }


    public Point2D getHourPoint(){
        float second = cl.get(cl.SECOND);
        float minute = cl.get(cl.MINUTE);
        float hour = cl.get(cl.HOUR);
        float deg = (hour*30+minute*30/60+second*30/3600);//*((float)Math.PI/180);
        //System.out.println("hour "+hour+", degree "+deg);
        return new Point2D.Double(center.getX()+0.5*getWidth()*(Math.sin(deg)),(center.getY()+0.5*getHeight()*(Math.cos(deg))));
    }
    public Point2D getMinutePoint(){
        float second = cl.get(cl.SECOND);
        float minute = cl.get(cl.MINUTE);
        float deg = (minute*6+second*1/60);//*((float)Math.PI/180);
        System.out.println(minute+" "+deg);
        return new Point2D.Double(center.getX()+0.5*getWidth()*(Math.sin(deg)),(center.getY()+0.5*getHeight()*(Math.cos(deg))));
    }
    public Point2D getSecondPoint(){
        float second = cl.get(cl.SECOND);
        float deg = second*6;//*((float)Math.PI/180);
        System.out.println(second+" "+deg);
        return new Point2D.Double(center.getX()+0.5*getWidth()*(Math.sin(deg)),(center.getY()+0.5*getHeight()*(Math.cos(deg))));
    }
}


//project current time on UI
//on UI we have a frame
//two more classes: dial and hands
//need a timer thread that ticks every 500 ms
//update val of time on every tick
//then update the arc time
//repaint dial and postion of hands


