package pl.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("konrad");
    hello("user");
    hello("Alexei");

    Square s = new Square(5);
    Rectangle r = new Rectangle(5, 2);
    Point p1 = new Point(3, -4);
    Point p2 = new Point(-3, 5);

    double tempDistance = calculateDistanceBetweenTwoPoints(p1, p2);

    System.out.println("Area of square : " + "len " + s.l + " = " + calculateOfSquareArea(s));
    System.out.println("Area of rectangle : " + "width " + r.a + " and " + "length " + r.b + " = " + calculateOfRectangleArea(r));
    System.out.println("Distance between points is: " + " = " + Math.sqrt(tempDistance));

  }

  public static void hello(String somebody) {

    System.out.println("Hello " + somebody + " ! ");
  }


  public static double calculateOfSquareArea(Square s) {

    return s.l * s.l;
  }

  public static double calculateOfRectangleArea(Rectangle r) {

    return r.a * r.b;
  }

  public static double calculateDistanceBetweenTwoPoints(Point p1, Point p2) {

    return ((p1.x - p1.y) * (p1.x - p1.y)) + ((p2.x - p2.y) * (p2.x - p2.y));
  }

}



