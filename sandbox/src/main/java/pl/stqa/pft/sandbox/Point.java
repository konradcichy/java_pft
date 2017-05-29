package pl.stqa.pft.sandbox;

/**
 * Created by Konrad on 20/05/2017.
 */
public class Point {

  double x, y;

  public Point(double x, double y) {

    this.x = x;
    this.y = y;

  }

  public double calculatePointsDistance(Point b){

    return Math.sqrt(Math.pow((x - b.x),2) + Math.pow((y - b.y),2));
  }


}
