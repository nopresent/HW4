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

        SquarePyramid squarePyramid = new SquarePyramid(5,5,4,5);
        System.out.println("SquarePyramid");
        System.out.println("Area: " + squarePyramid.getArea());
        System.out.println("---------------------------------------------");

    }

}
