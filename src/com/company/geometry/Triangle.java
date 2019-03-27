package com.company.geometry;

public class Triangle implements Shape {
    private Point a, b, c;
    public Triangle(Point a, Point b, Point c) { // if any line inside triangle is impossible to create
        //than triangle is also impossible to create
        if(Line.isParallel(new Line(a,b),new Line(b,c)))
            throw new IllegalArgumentException("points in line");
        else
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    @Override
    public Shape translate(Vector v) {
        try {
            return new Triangle(((Point) a.translate(v)), ((Point) b.translate(v)), ((Point) c.translate(v)));
        } catch (Exception e) {
            e.printStackTrace(); // translation is injective, the exception will never occur
        }
        return null; // never used return way
    }

    @Override
    public Shape rotate(Point p, double angle) {
        try {
            return new Triangle(((Point) a.rotate(p, angle)), ((Point) b.rotate(p, angle)), ((Point) c.rotate(p, angle)));
        } catch (Exception e) {
            e.printStackTrace(); // rotation is injective, the exception will never occur
        }
        return null; // never used return way
    }

    @Override
    public Shape mirror(Line l) {
        try {
            return new Triangle(((Point) a.mirror(l)), ((Point) b.mirror(l)), ((Point) c.mirror(l)));
        } catch (Exception e) {
            e.printStackTrace(); // rotation is injective, the exception will never occur
        }
        return null; // never used return way
    }

    public double error(Triangle compared)
    {
        return a.distance(compared.a) + b.distance(compared.b) + c.distance(compared.c);
    }
}
