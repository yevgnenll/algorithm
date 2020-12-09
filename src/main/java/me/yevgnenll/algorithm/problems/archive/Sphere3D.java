package me.yevgnenll.algorithm.problems.archive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import javafx.geometry.Point3D;

public class Sphere3D {
  public int solution(Point3D[] a) {
    List<Point3DWithRadius> points = Stream.of(a)
        .map(p -> new Point3DWithRadius(p))
        .collect(Collectors.toList());
    int count = 0;
    for (int i = 0; i < points.size(); i ++) {
      Point3DWithRadius p1 = points.get(i);
      for (int j = i + 1; j < points.size() ; j ++) {
        Point3DWithRadius p2 = points.get(j);
        if (p1.isCovered(p2)) {
          count += 1;
        }
      }
    }
    return count;
  }

  class Point3DWithRadius extends Point3D {

    private double r;

    public Point3DWithRadius(double x, double y, double z) {
      super(x, y, z);
      this.r = calculateRadius();
    }
    public Point3DWithRadius(Point3D point3D) {
      super(point3D.getX(), point3D.getY(), point3D.getZ());
      this.r = calculateRadius();
    }
    private double calculateRadius() {
      return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(getZ(), 2));
    }
    public double getR() {
      return this.r;
    }
    public boolean isCovered(Point3DWithRadius point) {
      double x1 = this.getX() - point.getX();
      double y1 = this.getY() - point.getY();
      double z1 = this.getZ() - point.getZ();
      double distance = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2) + Math.pow(z1, 2));
      double diff = distance - (this.getR() + point.getR());
      return diff <= 0;
    }
  }

  /**
   *  A[0].x =  0  A[0].y =  5  A[0].z =  4
   *   A[1].x =  0  A[1].y =  0  A[1].z = -3
   *   A[2].x = -2  A[2].y =  1  A[2].z = -6
   *   A[3].x =  1  A[3].y = -2  A[3].z =  2
   *   A[4].x =  1  A[4].y =  1  A[4].z =  1
   *   A[5].x =  4  A[5].y = -4  A[5].z =  3
   */

  @Test
  public void 답은_3이_나온다() {
    Point3D[] p = {new Point3D(0, 5, 4),
        new Point3D(0, 0, -3), new Point3D(-2, 1, -6),
        new Point3D(1, -2, 2), new Point3D(1, 1, 1),
        new Point3D(4, -4, 3)
    };
    assertEquals(3, solution(p));
  }
}
