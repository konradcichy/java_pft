package pl.stqa.pft.sandbox;


public class MyFirstProgram {

  public static void main(String[] args) {
    hello("konrad");
    hello("user");
    hello("Alexei");

    Square s = new Square(5);
    Rectangle r = new Rectangle(5, 2);


    System.out.println("Area of square : " + "len " + s.l + " = " + s.area());
    System.out.println("Area of rectangle : " + "width " + r.a + " and " + "length " + r.b + " = " + r.calculateOfRectangleArea());

  }

  public static void hello(String somebody) {

    System.out.println("Hello " + somebody + " ! ");
  }


}



