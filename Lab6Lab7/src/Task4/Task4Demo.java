package Task4;

import java.lang.reflect.Field;

/**
 * Created by Seher Khan on 10/1/2017.
 */
public class Task4Demo {
    public static void main(String[] args) throws NoSuchFieldException {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        System.out.println(p1.distance(p2));
        Triangle tri= new Triangle(new Point(0,0),new Point(0,1),new Point(1,0));
        System.out.println(tri);
        System.out.println("The perimeter of the triangle is "+tri.getPerimeter());

    }

}
