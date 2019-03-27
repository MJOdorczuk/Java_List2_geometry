package com.company.geometry;

public class Line {
    public final double a, b, c;

    public Line(double a, double b, double c) {
        if(a * b == 0 && a == b) throw new IllegalArgumentException("Wrong line parameters");
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Line(Point from, Point to){
        if(from.sameWith(to)) throw new IllegalArgumentException("Nondeterministic line");
        if(from.getX() == to.getY())
        {
            this.a = 1;
            this.b = 0;
            this.c = from.getX();
        }
        else
        {
            this.a = (to.getY() - from.getY())/(from.getX() - to.getX());
            this.b = 1;
            this.c = 0 - (a * from.getX() + from.getY());
        }
    }
    public static Line translate(Line l, Vector v)
    {
        try {
            return new Line(l.a,l.b,l.c - (l.a*v.dx) - (l.b*v.dy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; //Could never occur, as 0,0,c line is impossible to create
    }
    public static boolean isParallel(Line l1, Line l2)
    {
        if(l1.a * l2.a == 0)
            return l1.a == l2.a;
        else if(l1.b * l2.b == 0)
            return l1.b == l2.b;
        else return l1.a/l1.b == l2.a/l2.b;
    }
    public static boolean isPerpendicular(Line l1, Line l2)
    {
        if(l1.b * l2.b == 0)
            return l1.a * l2.a == 0;
        else return l1.a * l2.a / (l1.b * l2.b) == -1;
    }
    public static Point intersectionPoint(Line l1, Line l2)
    {
        if(isParallel(l1,l2)) return null;
        else
        {
            if(l1.a == 0)
            {
                Line temp = l2;
                l2 = l1;
                l1 = temp;
            }
            double y = ((l2.a*l1.c)/l1.a - l2.c)/(l2.b - l2.a*l1.b/l1.a);
            double x = 0 - ((l1.b * y + l1.c)/l1.a);
            return new Point(x,y);
        }
    }
    public Line getPerpendicular(Point p)
    {
        if(a == 0) {
            try {
                return new Line(1,0,0-p.getX());
            } catch (Exception e) {
                e.printStackTrace(); //a == 1, b == 0, exception never occurs
            }
        }
        else if(b == 0)
        {
            try {
                return new Line(0,1,0-p.getY());
            } catch (Exception e) {
                e.printStackTrace(); //a == 0, b == 1, exception never occurs
            }
        }
        else {
            try {
                return new Line(0 - 1 / a, 1 / b, (p.getX() / a) - (p.getY() / b));
            } catch (Exception e) {
                e.printStackTrace(); // a != 0 && b != 0, none exception will occur            }
            }
        }
        return null; //shouldn't ever occur
    }
}
