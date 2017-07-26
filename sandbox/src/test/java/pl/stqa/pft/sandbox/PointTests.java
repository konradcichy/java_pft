package pl.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Konrad on 29/05/2017.
 */
public class PointTests {

  @Test
  public void testDistanceNaturalNumber() {
    Point a = new Point(1, 2);
    Point b = new Point(3, 4);

    Assert.assertEquals(a.calculatePointsDistance(b), 2.8284271247461903);
  }

  @Test
  public void testDistanceZero() {
    Point c = new Point(0, 0);
    Point d = new Point(0, 0);

    Assert.assertEquals(c.calculatePointsDistance(d), 0.0);
  }

//  @Test
//  public void negativeTest() {
//    Point e = new Point(-1, -1);
//    Point f = new Point(0, 2435338.00000020);
//
//    Assert.assertEquals(e.calculatePointsDistance(f), 1.0);
//  }

  @Test void floatingTest(){
    Point g = new Point(2.43353,1.0894);
    Point h = new Point(98553.222,98236.11344);

    Assert.assertEquals(g.calculatePointsDistance(h), 139148.76160497466);

  }





}
