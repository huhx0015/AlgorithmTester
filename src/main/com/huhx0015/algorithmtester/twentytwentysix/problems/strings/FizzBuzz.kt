package com.huhx0015.algorithmtester.twentytwentysix.problems.strings

import com.huhx0015.algorithmtester.twentytwentysix.problems.stacks.ValidParenthesis.isValid

/**
 * Leetcode
 *
 * Problem: 412. Fizz Buzz
 * Easy
 *
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 *
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 *
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 */
object FizzBuzz {

    @JvmStatic fun main(args: Array<String>) {
        val input1 = 3
        val input2 = 5
        val input3 = 15

        val output1 = fizzBuzz(input1)
        val output2 = fizzBuzz(input2)
        val output3 = fizzBuzz(input3)

        println("FizzBuzz: Finished, output for $input1 is ${output1.toSet()}")
        println("FizzBuzz: Finished, output for $input2 is ${output2.toSet()}")
        println("FizzBuzz: Finished, output for $input3 is ${output3.toSet()}")
    }

    // fizzBuzz(): Time Complexity: O(n) | Space Complexity: O(n)
    // n = 3 -> ["1", "2", "Fizz"]
    // n = 5 -> ["1", "2", "Fizz", "4", "Buzz"]
    // "FizzBuzz": i % 3 == 0 && i % 5 == 0
    // "Fizz": i % 3 == 0
    // "Buzz": i % 5 == 0
    fun fizzBuzz(n: Int): List<String> {
        // Results in space complexity: O(n) since this grows in size n.
        val stringArray: MutableList<String> = mutableListOf()

        // Since the constraint is n >= 1, we start at 1 and loop until n + 1.
        // Since this loops for all n, time complexity is O(n).
        for (i in 1 until n + 1) {
            val output = when {
                (i % 3) == 0 && (i % 5) == 0 -> {
                    println("FizzBuzz: i: $i: Divisible by 3 & 5, so FizzBuzz!")
                    "FizzBuzz"
                }
                (i % 3) == 0 -> {
                    println("FizzBuzz: i: $i: Divisible by 3, so Fizz!")
                    "Fizz"
                }
                (i % 5) == 0 -> {
                    println("FizzBuzz: i: $i: Divisible by 5, so Buzz!")
                    "Buzz"
                }
                else -> {
                    println("FizzBuzz: i: $i: Not divisible, so $i!")
                    i.toString()
                }
            }
            stringArray.add(output)
        }
        return stringArray
    }
}