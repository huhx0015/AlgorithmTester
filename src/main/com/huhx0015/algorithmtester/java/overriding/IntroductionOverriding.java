package main.com.huhx0015.algorithmtester.java.overriding;

/**
 * Created by Michael Yoon Huh on 3/30/2017.
 */
public class IntroductionOverriding {

    public static void main(String[] args) {

        Shape[] shapes = new Shape[2];

        Circle circle = new Circle();
        Ambiguous ambiguous = new Ambiguous();

        shapes[0] = circle;
        shapes[1] = ambiguous;

        for (Shape s : shapes) {
            s.printMe();
            System.out.println(s.computeArea());
        }
    }
}
