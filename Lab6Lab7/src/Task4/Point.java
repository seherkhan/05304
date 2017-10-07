package Task4;

/**
 * Created by Seher Khan on 10/1/2017.
 */
public class Point {
    private int x;
    private int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
    public double distance(Point other){
        return Math.sqrt(Math.pow((other.x-x),2)+Math.pow((other.y-y),2));
    }
    public String toString(){
        return "("+x+", "+y+")";
    }
}
