import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Seher Khan on 11/9/2017.
 */
public class ChessBoardApp extends JFrame {
    GridPanel gridPanel;
    static int clickCount = 0;
    static int W=600;
    static int H=600;
    public ChessBoardApp(){
        setTitle("Chess Board");
        setBounds(0,0,W,H);
        gridPanel = new GridPanel();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                ChessBoardApp.W=getWidth();
                ChessBoardApp.H=getHeight();
                gridPanel.repaint();
            }
        });

        getContentPane().add(gridPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        ChessBoardApp b = new ChessBoardApp();
    }
}
class GridPanel extends JPanel{
    JButton btn;
    JPanel[][] squares;
    public GridPanel(){
        setLayout(null);
        setBounds(0,0,600,600);

        squares = new JPanel[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                squares[i][j] = new JPanel();
                squares[i][j].setBounds((ChessBoardApp.W/6+(i)*(ChessBoardApp.W/12)),(ChessBoardApp.H/12)+(j)*(ChessBoardApp.H/12),(ChessBoardApp.W/12),(ChessBoardApp.H/12));
                squares[i][j].setBorder(new LineBorder(Color.black,2));
                squares[i][j].setVisible(true);
                add(squares[i][j]);
            }
        }

        btn = new JButton("Set Color");
        btn.setBounds((5*ChessBoardApp.W/12),(19*ChessBoardApp.H/24),(ChessBoardApp.W/6),(ChessBoardApp.H/6));
        add(btn);

        /*
        //if I do it this way, I will make clickCount is volatile
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                repaint();
            }
        });*/
        class btnActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                ChessBoardApp.clickCount++;
                Color randomColor = new Color((int) (Math.random()*256),(int) (Math.random()*256),(int) (Math.random()*256));
                if(ChessBoardApp.clickCount%2==0){
                    for(int i=0;i<8;i++){
                        for(int j=0;j<8;j++){
                            if(i%2==0&&j%2==1||i%2==1&&j%2==0)
                                squares[i][j].setBackground(randomColor);
                        }
                    }
                }
                else{
                    for(int i=0;i<8;i++){
                        for(int j=0;j<8;j++){
                            if(i%2==0&&j%2==0||i%2==1&&j%2==1)
                                squares[i][j].setBackground(randomColor);
                        }
                    }
                }

            }
        }

        btn.addActionListener(new btnActionListener()); // btnActionListener can only be used *after it is written*
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        btn.setBounds((5*ChessBoardApp.W/12),(19*ChessBoardApp.H/24),(ChessBoardApp.W/6),(ChessBoardApp.H/10));

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                squares[i][j].setBounds((ChessBoardApp.W/6+(i)*(ChessBoardApp.W/12)),(ChessBoardApp.H/12)+(j)*(ChessBoardApp.H/12),(ChessBoardApp.W/12),(ChessBoardApp.H/12));
                squares[i][j].setBorder(new LineBorder(Color.black,2));
            }
        }
    }
}
