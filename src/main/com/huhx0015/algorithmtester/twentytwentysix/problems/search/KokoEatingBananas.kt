package com.huhx0015.algorithmtester.twentytwentysix.problems.search

/**
 * Problem: Koko Eating Bananas
 * Difficulty: Medium
 *
 * You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an integer h, which represents the number of hours you have to eat all the bananas.
 *
 * You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.
 *
 * Return the minimum integer k such that you can eat all the bananas within h hours.
 *
 * Example 1:
 *
 * Input: piles = [1,4,3,2], h = 9
 *
 * Output: 2
 * Explanation: With an eating rate of 2, you can eat the bananas in 6 hours. With an eating rate of 1, you would need 10 hours to eat all the bananas (which exceeds h=9), thus the minimum eating rate is 2.
 *
 * Example 2:
 *
 * Input: piles = [25,10,23,4], h = 4
 *
 * Output: 25
 * Constraints:
 *
 * 1 <= piles.length <= 1,000
 * piles.length <= h <= 1,000,000
 * 1 <= piles[i] <= 1,000,000,000
 */
object KokoEatingBananas {

    @JvmStatic
    fun main(args: Array<String>) {
        val piles1 = intArrayOf(1, 4, 3, 2)
        val h1 = 9

        println("Koko Eating Bananas: Start piles=${piles1.contentToString()}, h=$h1")
        val answer1 = minEatingSpeed(piles = piles1, h = h1)
        println("Koko Eating Bananas: Minimum eating speed: $answer1\n")

        val piles2 = intArrayOf(25, 10, 23, 4)
        val h2 = 4

        println("Koko Eating Bananas: Start piles=${piles2.contentToString()}, h=$h2")
        val answer2 = minEatingSpeed(piles = piles2, h = h2)
        println("Koko Eating Bananas: Minimum eating speed: $answer2\n")

        println("Koko Eating Bananas (Brute Force): Start piles=${piles1.contentToString()}, h=$h1")
        val answer3 = minEatingSpeedBruteForce(piles = piles1, h = h1)
        println("Koko Eating Bananas (Brute Force): Minimum eating speed: $answer3\n")

        println("Koko Eating Bananas (Brute Force): Start piles=${piles2.contentToString()}, h=$h2")
        val answer4 = minEatingSpeedBruteForce(piles = piles2, h = h2)
        println("Koko Eating Bananas (Brute Force): Minimum eating speed: $answer4\n")
    }

    /**
     * Binary search on k: if Koko can finish in ≤ h hours at rate k, any larger rate also works;
     * we want the smallest feasible k.
     *
     * Time: O(n log M) with n = piles.size and M = max pile. Space: O(1).
     *
     * @param trace when true, prints state at key steps (search bounds, trial k, hours used, updates).
     */
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1 // Binary-search lower bound: eating rate cannot be below 1.
        var right = piles.max() // Binary-search upper bound: eating faster than the largest pile never improves the plan.
        var result = right // Running minimum k that still finishes within h hours; start pessimistic at max pile.

        println("Koko Eating Bananas: init left=$left, right=$right, result=$result")

        // Repeat while there is still a candidate interval of k values to test.
        while (left <= right) {
            val k = left + (right - left) / 2 // Pick the midpoint rate k to test feasibility.

            println("Koko Eating Bananas: try k=$k (left=$left, right=$right)")

            var hours = 0L // Accumulate hours needed at rate k across all piles.

            // Visit every pile to sum per-pile time at this k.
            for (p in piles) {
                hours += Math.ceil(p.toDouble() / k).toLong() // Add this pile’s contribution to the total hour count.
                println("Koko Eating Bananas: pile p=$p at k=$k → +h (running total hours=$hours)")
            }

            println("Koko Eating Bananas: total hours=$hours for k=$k (budget h=$h)")

            // Branch: if we finish in time at k, try a slower (smaller) k.
            if (hours <= h) {
                result = k // Tighten the best answer to the smaller feasible k seen so far.
                println("Koko Eating Bananas: feasible — result=$result, shrink right to ${k - 1}")
                right = k - 1
            } else {
                println("Koko Eating Bananas: too slow — raise left to ${k + 1}")
                left = k + 1 // Move the low end past k to search only faster rates.
            }
        }

        println("Koko Eating Bananas: done — returning result = $result")
        return result // Return the minimum eating speed found.
    }

    // minEatingSpeedBruteForce(): Brute force solution. Time Complexity: O(m * n) | Space Complexity: O(1)
    fun minEatingSpeedBruteForce(piles: IntArray, h: Int): Int {
        var speed = 1 // Start with speed = 1

        while (true) {
            var totalTime = 0L

            // For each speed, compute the total hours needed by summing ceil(pile / speed) for every pile.
            for (pile in piles) {
                totalTime += Math.ceil(pile.toDouble() / speed).toLong()
            }

            // If the total hours is less than or equal to h, return the current speed.
            if (totalTime <= h) {
                return speed
            }
            speed += 1 // Otherwise, increase the speed and repeat.
        }
        return speed
    }
}
