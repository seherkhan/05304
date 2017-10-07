package Task4;

/**
 * Created by Seher Khan on 10/1/2017.
 */
public class Triangle {
    private Point vertex1;
    private Point vertex2;
    private Point vertex3;
    public Triangle(Point p1, Point p2, Point p3){
        this.vertex1=p1;
        this.vertex2=p2;
        this.vertex3=p3;
    }

    public String toString(){
        return "MyTriangle[v1="+vertex1+",v2="+vertex2+",v3="+vertex3+"]";
    }
    public double getPerimeter(){
        return vertex1.distance(vertex2)+vertex2.distance(vertex3)+vertex3.distance(vertex1);
    }
    public String getType(){
        double side12 =vertex1.distance(vertex2);
        double side23 =vertex2.distance(vertex3);
        double side31 =vertex3.distance(vertex1);
        if(side12==side23||side23==side31||side12==side31){
            if(side12==side23&&side23==side31)
                return "equilateral";
            return "isoceles";
        }
        else
            return "scalene";
    }
}
