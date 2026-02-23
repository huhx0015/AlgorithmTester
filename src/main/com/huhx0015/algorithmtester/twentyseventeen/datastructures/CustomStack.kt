package com.huhx0015.algorithmtester.twentyseventeen.datastructures

/*
 * Created by Michael Yoon Huh on 5/29/2017.
 *
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
 */
class CustomStack {

    private var stackSize = 4
    private var customStack: Array<Any?>

    private var topPosition = -1 // Indicates a empty stack.

    constructor() {
        this.customStack = arrayOfNulls<Any?>(stackSize)
    }

    constructor(size: Int) {
        this.stackSize = size
        this.customStack = arrayOfNulls<Any>(stackSize)
    }

    fun peek(): Any? {
        if (topPosition != -1) {
            println("peek(): Returning item at position: " + topPosition)
            return customStack[topPosition]
        } else {
            println("peek(): ERROR: Could not peek, stack is empty: " + topPosition)
            return null
        }
    }

    fun pop(): Any? {
        if (topPosition != -1) {
            println("pop(): Found item at position $topPosition and removing item.")

            val `object` = customStack[topPosition]
            customStack[topPosition] = null // Clears item at current top position.
            topPosition-- // Updates top stack position.
            return `object`
        } else {
            println("pop(): ERROR: Could not pop, stack is empty: " + topPosition)
            return null
        }
    }

    fun push(`object`: Any) {

        // Check if the stack is full or not.
        if (topPosition + 1 < stackSize) {
            topPosition++ // Updates top stack position.
            customStack[topPosition] = `object`

            println("push(): Pushed item at position: " + topPosition)
        } else {
            println("push(): ERROR: Stack is full, can't add any more items: " + topPosition)
        }
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            val stack = CustomStack()

            stack.peek()
            stack.pop()

            stack.push("Hello")
            stack.push("There")
            stack.push("Mai")

            println(stack.pop() as String?)

            stack.push("My")
            stack.push("Name")
            stack.push("WHAT")

            println(stack.peek() as String?)
            println(stack.pop() as String?)
            println(stack.pop() as String?)
            println(stack.pop() as String?)
            println(stack.pop() as String?)
        }
    }
}
