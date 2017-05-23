package pl.stqa.pft.sandbox;

/**
 * Created by Konrad on 20/05/2017.
 */
public class Point {

  double x;
  double y;

  double x1;
  double x2;
  double y1;
  double y2;

  public Point(double x, double y) {

    this.x = x;
    this.y = y;

  }

  public Point (double x1, double x2, double y1, double y2){
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;


  }

  public double calculatePointsDistance(double x1, double x2, double y1, double y2){

    return Math.pow(x1 - x2,2) + Math.pow(y1-y2,2);
  }


}
