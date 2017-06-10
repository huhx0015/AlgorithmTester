package main.com.huhx0015.algorithmtester.java.overriding;

/**
 * Created by Michael Yoon Huh on 3/30/2017.
 */
public class Circle extends Shape {

    private double rad = 5;

    public void printMe() {
        System.out.println("I am a circle.");
    }

    @Override
    public double computeArea() {
        return rad * rad * 3.15;
    }
}
