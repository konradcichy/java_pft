package pl.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Konrad on 29/05/2017.
 */
public class PointTests {

  @Test
  public void testDistance() {
    Point a = new Point(1, 2);
    Point b = new Point(3, 4);

    Assert.assertEquals(a.calculatePointsDistance(b), 2.8284271247461903);
  }

  @Test
  void secondTestDistance() {
    Point c = new Point(0, 0);
    Point d = new Point(0, 0);

    Assert.assertEquals(c.calculatePointsDistance(d), 0.0);
  }

  @Test
  void negativeTest() {
    Point e = new Point(-1, -1);
    Point f = new Point(0, 2435338.00000020);

    Assert.assertEquals(e.calculatePointsDistance(f), 1.0);

  }


}
