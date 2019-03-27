package com.company.geometry;

public class Point implements Shape {
    private double x, y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public Point(Vector v)
    {
        this.x = v.dx;
        this.y = v.dy;
    }
    public double getX(){return this.x;}
    public double getY(){return this.y;}
    public Vector getAsVector(){return new Vector(x,y);}

    @Override
    public Shape translate(Vector v) {
        return new Point(Vector.compose(this.getAsVector(),v));
    }

    @Override
    public Shape rotate(Point p, double angle) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        double dx = this.x - p.getX();
        double dy = this.y - p.getY();
        return new Point(p.x + dx*c - dy*s, p.y + dy*c + dx*s);
    }

    @Override
        public Shape mirror(Line l) {
        Point mirrorPoint = Line.intersectionPoint(l.getPerpendicular((this)),l);
        Vector v = new Vector(this,mirrorPoint);
        return this.translate(Vector.compose(v,v));
    }

    public boolean sameWith(Point p)
    {
        return this.getX() == p.getX() && this.getY() == p.getY();
    }

    public double distance(Point compared)
    {
        return Math.sqrt(Math.pow(x - compared.getX(),2)+Math.pow(y - compared.getY(),2));
    }
}
