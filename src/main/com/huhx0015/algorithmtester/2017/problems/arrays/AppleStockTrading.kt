package main.com.huhx0015.algorithmtester.problems.arrays

import java.util.Arrays

/**
 * Interview Cake

 * 1. Writing programming interview questions hasn't made me rich. Maybe trading Apple stocks will.

 * Ex: int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
 * // returns 6 (buying for $5 and selling for $11)

 * URL: https://www.interviewcake.com/question/java/stock-price
 */
object AppleStockTrading {

    @JvmStatic fun main(args: Array<String>) {

        val stockPricesYesterday = intArrayOf(10, 7, 5, 8, 11, 9)

        // Returns 6 (buying for $5 and selling for $11).
        val maxProfit = getMaxProfit(stockPricesYesterday)

        println(maxProfit)
    }

    // InterviewCake Solution:
    fun getMaxProfit(stockPricesYesterday: IntArray): Int {

        // Make sure we have at least 2 prices.
        if (stockPricesYesterday.size < 2) {
            throw IllegalArgumentException("Getting a profit requires at least 2 prices")
        }

        // We'll greedily update minPrice and maxProfit, so we initialize them to the first price and the first possible
        // profit.
        var minPrice = stockPricesYesterday[0]
        var maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0]

        // Start at the second (index 1) time we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time! if we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our maxProfit is supposed to be *negative*--we'd return 0.
        for (i in 1..stockPricesYesterday.size - 1) {

            val currentPrice = stockPricesYesterday[i]

            // See what our profit would be if we bought at the min price and sold at the current price.
            val potentialProfit = currentPrice - minPrice

            // Update maxProfit if we can do better.
            maxProfit = Math.max(maxProfit, potentialProfit)

            // Update minPrice so it's always the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice)
        }

        return maxProfit
    }

    fun getMaxProfitWithUtils(stockPrices: IntArray): Int {
        val maxProfit: Int // Stores the maximum profit from buying and selling.
        val maxValue: Int // Stores the highest stock value.
        val minValue: Int // Stores the lowest stock value.

        Arrays.sort(stockPrices) // Sorts the array from lowest to highest.

        maxValue = stockPrices[stockPrices.size - 1] // Last value is the highest stock value.
        minValue = stockPrices[0] // First value is the lowest stock value.
        maxProfit = maxValue - minValue // Maximum profit made.

        return maxProfit
    }
}


