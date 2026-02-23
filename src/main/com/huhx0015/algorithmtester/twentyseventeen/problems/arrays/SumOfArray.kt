package com.huhx0015.algorithmtester.twentyseventeen.problems.arrays

import java.util.Scanner

/**
 * Created by Michael Yoon Huh on 5/2/2017.
 *
 * HackerRank:
 *
 * Given an array of integers, can you find the sum of its elements?
 *
 * Input Format
 *
 * The first line contains an integer, denoting the size of the array.
 * The second line contains  space-separated integers representing the array's elements.
 *
 * Output Format
 *
 * Print the sum of the array's elements as a single integer.
 *
 * Sample Input
 *
 * 6
 * 1 2 3 4 10 11
 *
 * Sample Output
 *
 * 31
 *
 * URL: https://www.hackerrank.com/challenges/simple-array-sum
 */

object SumOfArray {

    @JvmStatic fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        val n = `in`.nextInt() // First input line represents size of the array.
        val arr = IntArray(n)

        // Second line input are space-separated integers representing the array's elements.
        for (arr_i in 0..n - 1) {
            arr[arr_i] = `in`.nextInt()
        }

        val sum = sumOfArray(arr)
        println(sum)
    }

    @JvmStatic fun sumOfArray(array: IntArray): Int {
        var sum = 0
        for (x in array) {
            sum += x
        }
        return sum
    }
}