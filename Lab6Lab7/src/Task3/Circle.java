package Task3;


public class Circle implements GeometricObject,Movable{
    private double radius;
    private Point center;

    /**
     * Constructor
     * @param rad
     */
    public Circle(double rad){
        this.radius=rad;
    }
    /**
     * Constructor
     * @param rad
     * @param c
     */
    public Circle(double rad,Point c){
        this.radius=rad;
        this.center=c;
    }
    @Override
    public void moveLeft() {
        center.moveLeft();
        System.out.println("Circle moved left");
    }

    @Override
    public void moveRight() {
        center.moveRight();
        System.out.println("Circle moved right");
    }

    @Override
    public void moveUp() {
        center.moveUp();
        System.out.println("Circle moved up");
    }

    @Override
    public void moveDown() {
        center.moveDown();
        System.out.println("Circle moved down");
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
    public void display(){
        System.out.println("center: "+center+", radius: "+radius);
    }
}
