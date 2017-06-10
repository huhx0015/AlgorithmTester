package main.com.huhx0015.algorithmtester.problems.stacks;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Interview Cake:
 *
 * Use the built-in Stack class to implement a new class MaxStack with a function getMax() that returns the largest
 * element in the stack. getMax() should not remove the item.
 *
 * Created by Michael Yoon Huh on 5/8/2017.
 *
 * URL: https://www.interviewcake.com/question/java/largest-stack
 */
public class LargestElementStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> maxStack;

    public LargestElementStack() {
        this.dataStack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public int peek() {

        if (!dataStack.empty()) {
            return dataStack.peek();
        } else {
            throw new EmptyStackException();
        }
    }

    // Runs in O(1) time, O(n) time for space.
    public void push(int value) {

        dataStack.push(value);
        System.out.println("push(): Pushed value: " + value);

        // If maxStack is not empty, we grab the previous max value.
        if (!maxStack.empty()) {
            int prevMax = maxStack.peek();

            if (value > prevMax) {
                maxStack.push(value);
                System.out.println("push(): Value was greater than previous max. New max value is: " + value);
            } else {
                maxStack.push(prevMax);
                System.out.println("push(): Previous max is greater than value. Max value is: " + prevMax);
            }
        } else {
            maxStack.push(value);
            System.out.println("push(): No previous max value was set: " + value);
        }
    }

    // Runs in O(1) time, O(n) time for space.
    public int pop() {

        if (!dataStack.empty()) {
            maxStack.pop();
            return dataStack.pop();
        } else {
            throw new EmptyStackException();
        }
    }

    // Runs in O(1) time, O(n) time for space.
    public int getMax() {

        if (!maxStack.empty()) {
            int maxValue = maxStack.peek();

            System.out.println("getMax(): Current max value: " + maxValue);

            return maxValue;
        } else {
            throw new EmptyStackException();
        }

    }

    public static void main(String[] args) {

        LargestElementStack stack = new LargestElementStack();

        stack.push(5);
        stack.getMax();
        stack.push(25);
        stack.getMax();
        stack.pop();
        stack.getMax();
        stack.push(38);
        stack.getMax();
        stack.pop();
        stack.getMax();
    }
}
