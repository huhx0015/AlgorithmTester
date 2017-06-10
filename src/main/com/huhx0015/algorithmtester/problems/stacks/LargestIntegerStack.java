package main.com.huhx0015.algorithmtester.problems.stacks;

import java.util.EmptyStackException;

/**
 * Implement a Stack for integer inputs
 * Stack should be able to return Maximum value contained in it
 * Ideally getMax is constant time

 * Should have Push, Pop, Max.
 *
 * Asked At: Clover Networks
 *
 * Note 1: This function does it in O(1) runtime. Space time for each method is O(n), based on how many elements are in
 * the stack.
 * Note 2: Does not handle dynamic array re-creation.
 *
 * Similar to Interview Cake problem:
 * URL: https://www.interviewcake.com/question/java/largest-stack
 *
 * Created by Michael Yoon Huh on 5/8/2017.
 *
 */
public class LargestIntegerStack {

    private int[] dataArray; // Stores the values.
    private int[] maxArray; // Stores the values in sorted order, from min to max.

    private int maxSize;
    private int topPosition;

    private static final int EMPTY_STACK = -1;

    public LargestIntegerStack(int size) {
        this.maxSize = size;

        dataArray = new int[size]; // Initializes the array of elements.
        maxArray = new int[size]; // Initializes the array of elements from min to max.
        topPosition = EMPTY_STACK; // Represents an empty array.

        System.out.println("LargestIntegerStack(): Created new stack with size " + size + ", starting at position: " + topPosition);
    }

    public int peek() {

        // Check if the stack is empty or not.
        if (topPosition != EMPTY_STACK) {
            int peekValue = dataArray[topPosition];

            System.out.println("peek(): Peek value: " + peekValue + " at position: " + topPosition + " | Size: " + maxSize);

            return peekValue;
        } else {
            throw new EmptyStackException();
        }
    }

    public void push(int value) {

        // Check to make sure that the array has not been filled up yet.
        if (topPosition + 1 < maxSize) {
            topPosition++;
            dataArray[topPosition] = value;

            System.out.println("push(): Pushed " + value + " at position: " + (topPosition) + " | Size: " + maxSize);

            // MAX VALUE:
            // ----------
            // Gets the previous max value. If there is no previous max value, prevMax is set to Integer.MIN_VALUE.
            int prevMax = topPosition > 0 ? maxArray[topPosition - 1] : Integer.MIN_VALUE;

            // If value is greater than previous max, we found our new max.
            if (value > prevMax) {
                maxArray[topPosition] = value;
                System.out.println("push(): New value was greater, setting new maximum value: " + value);
            } else {
                maxArray[topPosition] = prevMax;
                System.out.println("push(): Older max value was greater: " + prevMax);
            }
        }

        else {
            System.out.println("push(): Cannot push any more values to this stack, stack is full: " + topPosition + " | Size: " + maxSize);

            // TODO: For bonus points, implement dynamic array-like behavior to re-size the array, if you have time.
        }
    }

    public int pop() {

        // Check if stack is empty or not.
        if (topPosition != EMPTY_STACK) {
            int popValue = dataArray[topPosition];

            System.out.println("pop(): Popped " + popValue + " at position: " + topPosition + " | Size: " + maxSize);

            topPosition--;
            return popValue;
        } else {
            throw new EmptyStackException();
        }
    }

    public int getMax() {

        // Check if stack is empty or not.
        if (topPosition != EMPTY_STACK) {
            int maxValue = maxArray[topPosition];

            System.out.println("getMax(): Current max value is: " + maxValue);

            return maxValue;
        } else {
            throw new EmptyStackException();
        }
    }

    public static void main(String[] args) {

        LargestIntegerStack stack = new LargestIntegerStack(5);

        stack.push(1);
        stack.getMax();
        stack.push(2);
        stack.getMax();
        stack.peek();
        stack.pop();
        stack.getMax();
        stack.push(3);
        stack.getMax();
        stack.peek();
        stack.push(4);
        stack.getMax();
        stack.push(5);
        stack.getMax();
        stack.push(6);
        stack.getMax();
        stack.push(7);
        stack.getMax();
        stack.pop();
        stack.pop();
    }
}
