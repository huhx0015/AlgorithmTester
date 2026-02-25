package com.huhx0015.algorithmtester.twentytwentysix.datastructures

class Stack {

    private val stack = mutableListOf<Int>()

    fun push(n: Int) {
        stack.add(n)
    }

    fun pop(): Int {
        return stack.removeAt(stack.size - 1)
    }

    fun size(): Int {
        return stack.size
    }
}