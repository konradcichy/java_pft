package pl.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("konrad");
    hello("user");
    hello("Alexei");

    double l = 5;

    double a = 4;
    double b = 6;

    System.out.println("Area of square : " + "len " + l + " = " + area(l));
    System.out.println("Area of rectangle : " + "width " + a + " and " +  "length " + b + " = " + area(a,b));
  }

  public static void hello(String somebody) {

    System.out.println("Hello " + somebody + " ! ");

  }


  public static double area(double len) {

    return len * len;
  }

  public static double area (double a, double b){

    return a * b;
  }

}



