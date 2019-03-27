package com.company.geometry;

public class Vector {
    public final double dx, dy;
    public Vector(double dx, double dy)
    {
        this.dx = dx;
        this.dy = dy;
    }
    public Vector(Point from, Point to)
    {
        this.dx = to.getX() - from.getX();
        this.dy = to.getY() - from.getY();
    }
    public static Vector compose(Vector v1, Vector v2)
    {
        return new Vector(v1.dx + v2.dx, v1.dy + v2.dy);
    }
}
