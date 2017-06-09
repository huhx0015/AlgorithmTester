package com.huhx0015.java.overriding;

/**
 * Created by Michael Yoon Huh on 3/30/2017.
 */
public class Ambiguous extends Shape {

    private double area = 10;

    @Override
    public double computeArea() {
        return area;
    }
}
