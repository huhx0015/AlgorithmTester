package com.huhx0015.java.overriding;

/**
 * Created by Michael Yoon Huh on 3/30/2017.
 */
public abstract class Shape {

    public void printMe() {
        System.out.println("I am a shape.");
    }

    public abstract double computeArea();
}
