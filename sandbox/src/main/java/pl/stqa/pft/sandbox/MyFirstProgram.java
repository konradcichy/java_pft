package pl.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("konrad");
    hello("user");
    hello("Alexei");

    Square s = new Square(5);


    double l = 5;

    double a = 4;
    double b = 6;
    Rectangle r = new Rectangle(5, 2);


    System.out.println("Area of square : " + "len " + s.l + " = " + area(s));
    System.out.println("Area of rectangle : " + "width " + r.a + " and " + "length " + r.b + " = " + area(r));
  }

  public static void hello(String somebody) {

    System.out.println("Hello " + somebody + " ! ");

  }


  public static double area(Square s) {

    return s.l * s.l;
  }

  public static double area(Rectangle r) {

    return r.a * r.b;
  }

}



