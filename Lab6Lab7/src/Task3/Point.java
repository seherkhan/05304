package Task3;

/**
 * Created by Seher Khan on 10/1/2017.
 */
public class Point implements Movable{
    private double x;
    private double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    @Override
    public void moveLeft() {
       x--;
    }

    @Override
    public void moveRight() {
        x++;
    }

    @Override
    public void moveUp() {
        y++;
    }

    @Override
    public void moveDown() {
        y--;
    }

    public String toString(){
        return "("+x+", "+y+")";
    }
}
