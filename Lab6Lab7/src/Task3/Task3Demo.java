package Task3;

import java.util.Scanner;

/**
 * Created by Seher Khan on 10/1/2017.
 */
public class Task3Demo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter x coordinate of center: ");
        double x = Double.parseDouble(s.nextLine());
        System.out.println("Enter y coordinate of center: ");
        double y = Double.parseDouble(s.nextLine());
        System.out.println("Enter radius: ");
        double rad = Double.parseDouble(s.nextLine());
        Circle c =new Circle(rad,new Point(x,y));

        System.out.println("The area of the circle is: "+c.getArea());
        System.out.println("The circumference of the circle is: "+c.getPerimeter());
        c.display();
        System.out.println();
        c.moveDown();
        c.display();
        c.moveLeft();
        c.display();
        c.moveRight();
        c.display();
        c.moveUp();
        c.display();
    }

}
