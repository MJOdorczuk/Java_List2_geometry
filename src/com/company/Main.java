package com.company;

import com.company.geometry.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Point A = new Point(rnd.nextDouble()*50+50,rnd.nextDouble()*50+50);
        Point B = new Point(rnd.nextDouble()*50+50,rnd.nextDouble()*50-50);
        Point C = new Point(rnd.nextDouble()*50-50,rnd.nextDouble()*50-50);
        Point D = new Point(rnd.nextDouble()*50-50,rnd.nextDouble()*50+50);
        Point E = new Point(rnd.nextDouble()*50,rnd.nextDouble()*50);
        Point A360 = (Point) A.rotate(B,Math.PI/3).rotate(B,Math.PI*5/3);
        System.out.println(" Error of rotation equals = " + A360.distance(A));
        Point Atranslated = (Point) A.translate(new Vector(5,5));
        System.out.println
                ("<"+A.getX()+","+A.getY()+"> translated by <5,5> equals <"+Atranslated.getX()+","+Atranslated.getY()+">");
        Line l = new Line(B,C);
        Point Am = (Point) A.mirror(l).mirror(l);
        System.out.println(" Error of mirroring equals = " + Am.distance(A));
        LineSegment DE = new LineSegment(D,E);
        LineSegment DEr = (LineSegment) DE.rotate(A,Math.PI/3).rotate(A,Math.PI*5/3);
        System.out.println(" Error of rotating the line equals = " + DEr.distance(DE));
        LineSegment DEm = (LineSegment) DE.mirror(l).mirror(l);
        System.out.println(" Error of mirroring the line equals = " + DEm.distance(DE));
        Triangle CDE = new Triangle(C,D,E);
        Triangle CDEr = (Triangle) CDE.rotate(A,Math.PI/3).rotate(A,Math.PI*5/3);
        System.out.println(" Error of rotating the triangle equals = " + CDEr.error(CDE));
        Triangle CDEm = (Triangle) CDE.mirror(l).mirror(l);
        System.out.println(" Error of mirroring the triangle equals = " + CDEm.error(CDE));
    }
}