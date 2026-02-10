package main.com.huhx0015.algorithmtester.problems.hackerrank

import java.util.*

/**
 * Created by Michael Yoon Huh on 5/2/2017.
 *
 * HackerRank
 *
 * Compare Triplets
 *
 * Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from to for three categories: problem clarity, originality, and difficulty.
 *
 * We define the rating for Alice's challenge to be the triplet, and the rating for Bob's challenge to be the triplet .
 *
 * Sample Input
 *
 * 5 6 7
 * 3 6 10
 *
 * Sample Output
 *
 * 1 1
 *
 * URL: https://www.hackerrank.com/challenges/compare-the-triplets?h_r=next-challenge&h_v=zen
 */

object CompareTriplets {

    internal val ALICE = 0
    internal val BOB = 1

    fun solve(a0: Int, a1: Int, a2: Int, b0: Int, b1: Int, b2: Int): IntArray {

        val result = IntArray(2)

        if (a0 > b0) {
            result[ALICE]++
        } else if (a0 < b0) {
            result[BOB]++
        }

        if (a1 > b1) {
            result[ALICE]++
        } else if (a1 < b1) {
            result[BOB]++
        }

        if (a2 > b2) {
            result[ALICE]++
        } else if (a2 < b2) {
            result[BOB]++
        }

        return result
    }

    @JvmStatic fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        val a0 = `in`.nextInt()
        val a1 = `in`.nextInt()
        val a2 = `in`.nextInt()
        val b0 = `in`.nextInt()
        val b1 = `in`.nextInt()
        val b2 = `in`.nextInt()
        val result = solve(a0, a1, a2, b0, b1, b2)

        var separator = ""
        val delimiter = " "

        for (value in result) {
            print(separator + value)
            separator = delimiter
        }

        println("")
    }
}
