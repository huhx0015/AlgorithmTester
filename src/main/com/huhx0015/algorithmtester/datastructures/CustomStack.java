package main.com.huhx0015.algorithmtester.datastructures;

/**
 * CustomStack:
 *
 * Stack is LIFO structure.
 *
 * Last In, First Out!
 *
 * Stack Functions:
 *
 * peek: Looks at top most stack item.
 * pop: Gets the top most stack item.
 * push: Adds item to the top of the stack.
 *
 * Created by Michael Yoon Huh on 5/29/2017.
 */
public class CustomStack {

    private int stackSize = 4;
    private Object[] customStack;

    private int topPosition = -1; // Indicates a empty stack.

    public CustomStack() {
        this.customStack = new Object[stackSize];
    }

    public CustomStack(int size) {
        this.stackSize = size;
        this.customStack = new Object[stackSize];
    }

    public Object peek() {
        if (topPosition != -1) {
            System.out.println("peek(): Returning item at position: " + topPosition);
            return customStack[topPosition];
        } else {
            System.out.println("peek(): ERROR: Could not peek, stack is empty: " + topPosition);
            return null;
        }
    }

    public Object pop() {
        if (topPosition != -1) {
            System.out.println("pop(): Found item at position " + topPosition + " and removing item.");
            Object object = customStack[topPosition];
            customStack[topPosition] = null; // Clears item at current top position.
            topPosition--; // Updates top stack position.
            return object;
        } else {
            System.out.println("pop(): ERROR: Could not pop, stack is empty: " + topPosition);
            return null;
        }
    }

    public void push(Object object) {

        // Check if the stack is full or not.
        if (topPosition + 1 < stackSize) {
            topPosition++; // Updates top stack position.
            customStack[topPosition] = object;
            System.out.println("push(): Pushed item at position: " + topPosition);
        } else {
            System.out.println("push(): ERROR: Stack is full, can't add any more items: " + topPosition);
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();

        stack.peek();
        stack.pop();

        stack.push("Hello");
        stack.push("There");
        stack.push("Mai");
        System.out.println((String) stack.pop());
        stack.push("My");
        stack.push("Name");
        stack.push("WHAT");
        System.out.println((String) stack.peek());
        System.out.println((String) stack.pop());
        System.out.println((String) stack.pop());
        System.out.println((String) stack.pop());
        System.out.println((String) stack.pop());
    }

}
