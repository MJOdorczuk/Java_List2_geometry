package com.company.geometry;

public class LineSegment implements Shape{
    private Point from, to;
    public LineSegment(Point from, Point to) {
        if(from.sameWith(to)) throw new IllegalArgumentException("Nondeterministic line");
        this.from = from;
        this.to = to;
    }

    @Override
    public Shape translate(Vector v) {
        try {
            return new LineSegment(((Point) from.translate(v)), ((Point) to.translate(v)));
        } catch (Exception e) {
            e.printStackTrace();// translation is injective, the exception will never occur
        }
        return null; // unused return way
    }

    @Override
    public Shape rotate(Point p, double angle) {
        try {
            return new LineSegment(((Point) from.rotate(p, angle)), ((Point) to.rotate(p, angle)));
        } catch (Exception e) {
            e.printStackTrace();// rotation is injective, the exception will never occur
        }
        return null; // unused return way
    }

    @Override
    public Shape mirror(Line l) {
        try {
            return new LineSegment(((Point) from.mirror(l)), ((Point) to.mirror(l)));
        } catch (Exception e) {
            e.printStackTrace(); // mirror is injective, the exception will never occur
        }
        return null; // unused return way
    }

    public double distance(LineSegment compared)
    {
        return from.distance(compared.from) + to.distance(compared.to);
    }
}
