package com.huhx0015.algorithmtester.twentytwentysix.problems.recursion

// Recursive implementation to calculate the n-th Fibonacci number
object Fibonacci {

    @JvmStatic fun main(args: Array<String>) {
        val fibonacci1 = fibonacci(1)
        println("Fibonacci for n=1: $fibonacci1")

        val fibonacci2 = fibonacci(2)
        println("Fibonacci for n=2: $fibonacci2")

        val fibonacci3 = fibonacci(3)
        println("Fibonacci for n=3: $fibonacci3")

        val fibonacci4 = fibonacci(4)
        println("Fibonacci for n=4: $fibonacci4")

        val fibonacci5 = fibonacci(5)
        println("Fibonacci for n=5: $fibonacci5")

        val fibonacci6 = fibonacci(6)
        println("Fibonacci for n=6: $fibonacci6")

        val fibonacci7 = fibonacci(7)
        println("Fibonacci for n=7: $fibonacci7")

        val fibonacci8 = fibonacci(8)
        println("Fibonacci for n=8: $fibonacci8")

        val fibonacci9 = fibonacci(9)
        println("Fibonacci for n=9: $fibonacci9")

        val fibonacci10 = fibonacci(10)
        println("Fibonacci for n=10: $fibonacci10")
    }

    fun fibonacci(n: Int): Int {
        // Base case: n = 0 or 1
        if (n <= 1) {
            return n
        }
        // Recursive case: fib(n) = fib(n - 1) + fib(n - 2)
        return fibonacci(n - 1) + fibonacci(n - 2)
    }
}