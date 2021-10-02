package lab.onpresent;

abstract class SpaceShape extends Shape implements Interface.AreaMeasurable, Interface.VolumeMeasurable {

}

class SquarePyramid extends SpaceShape {

    public SquarePyramid(double x1, double y1, double width, double height) {
           setX1(x1);
           setY1(y1);
           setWidth(width);
           setHeight(height);
    }

    @Override
    public double getArea() {
        // https://goo.su/7zQL
        /*
          Ищем диаглональ основания пирамиды -> квадрата
         */
        double diagonal = Math.pow(2,2)*getWidth();

        /*
           Ищем длинну боковой грани - Гипотенуза равнобедренного треугольника
           Катет 1 - половина diagonal
           Катет 2 - height
         */
        double hypotenuse = Math.sqrt(Math.pow(diagonal/2,2) + Math.pow(getHeight(),2));
        System.out.println(hypotenuse);
        return Math.pow(getWidth(),2) + 2*getWidth()*Math.sqrt(Math.pow(hypotenuse,2) - (Math.pow(getWidth(),2)/4));
    }

    @Override
    public double getVolume() {
        return 0;
    }
}