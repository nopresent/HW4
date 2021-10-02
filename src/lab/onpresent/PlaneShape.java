package lab.onpresent;

abstract class PlaneShape extends Shape implements Interface.PerimeterMeasurable, Interface.AreaMeasurable {

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

    // distance between two 2D vertices
    public double getDistBetween2Dvertices(double x1, double y1, double x2, double y2) {
        double diffX = Math.pow((x1 - x2), 2);
        double diffY = Math.pow((y1 - y2), 2);
        return Math.sqrt(diffX + diffY);
    }
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
