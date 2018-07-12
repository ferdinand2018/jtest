package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testDistance(){
    /*1я проверка*/
    Point p = new Point(12, 2, 2, 54);
    Assert.assertEquals(p.distance(), 52.952809179494906);
    /*2я проверка (с отрицательным числом)*/
    Point p1 = new Point(-12, 22, 21, 154);
    Assert.assertEquals(p1.distance(), 136.0624856453828);
  }
}