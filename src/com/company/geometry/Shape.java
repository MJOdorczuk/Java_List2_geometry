package com.company.geometry;


public interface Shape {
    public Shape translate(Vector v);
    public Shape rotate(Point p, double angle);
    public Shape mirror(Line l);
}
