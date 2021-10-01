package lab.onpresent;

public class Main {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(2, 2, 3, 4);
        System.out.println("Rectangle");
        System.out.println("Perimeter: " + rectangle.getPerimeter());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("---------------------------------------------");

        // http://mathhelpplanet.com/static.php?p=onlain-reshit-treugolnik )
        Triangle triangle = new Triangle(2, 2, 3, 6, 9, 9);
        System.out.println("Triangle");
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("---------------------------------------------");

        Circle circle = new Circle(2, 2, 4);
        System.out.println("Circle");
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("Area: " + circle.getArea());
        System.out.println("---------------------------------------------");
    }

}

abstract class Shape {

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    private double width;
    private double height;
    private double radius;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // distance between two 2D vertices
    public double getDistBetween2Dvertices(double x1, double y1, double x2, double y2) {
        double diffX = Math.pow((x1 - x2), 2);
        double diffY = Math.pow((y1 - y2), 2);
        return Math.sqrt(diffX + diffY);
    }

}

abstract class PlaneShape extends Shape implements PerimeterMeasurable, AreaMeasurable {

    public PlaneShape(double x1, double y1, double width, double height) {
        setX1(x1);
        setY1(y1);
        setWidth(width);
        setHeight(height);
    }

    public PlaneShape(double x1, double y1, double x2, double y2, double x3, double y3) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setX3(x3);
        setY3(y3);
    }

    public PlaneShape(double x1, double y1, double radius) {
        setX1(x1);
        setY1(y1);
        setRadius(radius);
    }
}

interface PerimeterMeasurable {
    double getPerimeter();
}

interface AreaMeasurable {
    double getArea();
}

interface VolumeMeasurable {
    double getVolume();
}

class Triangle extends PlaneShape {

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        super(x1, y1, x2, y2, x3, y3);
    }

    @Override
    public double getPerimeter() {
        double triangleSide1 = getDistBetween2Dvertices(getX1(), getY1(), getX2(), getY2());
        double triangleSide2 = getDistBetween2Dvertices(getX2(), getY2(), getX3(), getY3());
        double triangleSide3 = getDistBetween2Dvertices(getX3(), getY3(), getX1(), getY1());
        return triangleSide1 + triangleSide2 + triangleSide3;
    }

    @Override
    public double getArea() {
        double answer = ((getX2() - getX1()) * (getY3() - getY1()) - (getX3() - getX1()) * (getY2() - getY1())) / 2;
        return answer < 0 ? answer * (-1) : answer;
    }
}


class Rectangle extends PlaneShape {

    public Rectangle(double x1, double y1, double width, double height) {
        super(x1, y1, width, height);
    }

    @Override
    public double getPerimeter() {
        return getWidth() * 2 + getHeight() * 2;
    }

    @Override
    public double getArea() {
        return getWidth() * getHeight();
    }

}

class Circle extends PlaneShape {

    public Circle(double x1, double y1, double radius) {
        super(x1, y1, radius);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
}

