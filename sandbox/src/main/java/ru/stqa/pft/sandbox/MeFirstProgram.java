package ru.stqa.pft.sandbox;

public class MeFirstProgram {
  public static void main(String[] args) {
    Point p = new Point(12, 2, 2, 54);

    System.out.println("Расстояние между x1(" + p.x1 + ", " + p.y1 + ") и x2(" + p.x2 + ", " + p.y2 + ") = " + p.distance());
  }

}