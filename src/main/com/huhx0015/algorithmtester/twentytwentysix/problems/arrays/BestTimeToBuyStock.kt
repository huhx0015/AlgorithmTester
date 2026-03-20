package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

/**
 * Problem: Best Time to Buy and Sell Stock
 * Difficulty: Easy
 *
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
 *
 * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
 *
 * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
 *
 * Example 1:
 *
 * Input: prices = [10,1,5,6,7,1]
 *
 * Output: 6
 * Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.
 *
 * Example 2:
 *
 * Input: prices = [10,8,7,5,2]
 *
 * Output: 0
 * Explanation: No profitable transactions can be made, thus the max profit is 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 100
 * 0 <= prices[i] <= 100
 *
 * Objectives:
 *
 * Buy at the lowest price
 * Then sell later at the highest price after that buy
 * Only one transaction allowed (buy once, sell once)
 */
object BestTimeToBuyStock {

    @JvmStatic fun main(args: Array<String>) {
        val inputArray1 = intArrayOf(10, 1, 5, 6, 7, 1)
        val inputArray2 = intArrayOf(10, 8, 7, 5, 2)

        val result1 = maxProfit(inputArray1)
        println("Max Profit: Max profit for ${inputArray1.toList()} is $result1\n")

        val result2 = maxProfit(inputArray2)
        println("Max Profit: Max profit for ${inputArray2.toList()} is $result2\n")
    }

    // maxProfit: Time Complexity: O(n) | Space Complexity O(1)
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0 // If there are no prices, we return 0.

        // Lowest stock price we've seen so far.
        var minPrice = prices[0]

        // Maximum profit we've found so far.
        var maxProfit = 0

        // Start from day 1 since day 0 is already our initial minPrice.
        for (i in 1 until prices.size) {
            val currentPrice = prices[i]
            println("Max Profit: currentPrice is $currentPrice")

            // If today's price is cheaper than any previous day, update the best buying price.
            if (currentPrice < minPrice) {
                minPrice = currentPrice
                println("Max Profit: currentPrice $currentPrice < minPrice $minPrice, updating minPrice to $currentPrice")
            } else {
                // Otherwise, calculate the profit if we bought at minPrice and sold today.
                val currentProfit = currentPrice - minPrice

                // Keep the best profit seen so far.
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit
                    println("Max Profit: currentPrice $currentPrice > maxProfit $maxProfit, updating maxProfit to $currentPrice")
                }
            }
        }

        println("Max Profit: The maximum profit is $maxProfit")
        return maxProfit
    }
}