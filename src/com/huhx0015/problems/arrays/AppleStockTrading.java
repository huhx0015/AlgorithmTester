package com.huhx0015.problems.arrays;

import java.util.Arrays;

/**
 * Interview Cake
 *
 * 1. Writing programming interview questions hasn't made me rich. Maybe trading Apple stocks will.
 * https://www.interviewcake.com/question/java/stock-price
 *
 * Ex: int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
 *     // returns 6 (buying for $5 and selling for $11)
 */
public class AppleStockTrading {

    public static void main(String[] args) {

        int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};

        // returns 6 (buying for $5 and selling for $11)
        int maxProfit = getMaxProfit(stockPricesYesterday);

        System.out.println(maxProfit);
    }

    // InterviewCake solution.
    private static int getMaxProfit(int[] stockPricesYesterday) {

        // make sure we have at least 2 prices
        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        // we'll greedily update minPrice and maxProfit, so we initialize them to the first price and the first possible
        // profit.
        int minPrice = stockPricesYesterday[0];
        int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

        // start at the second (index 1) time we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time! if we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our maxProfit is supposed to be *negative*--we'd return 0.
        for (int i = 1; i < stockPricesYesterday.length; i++) {

            int currentPrice = stockPricesYesterday[i];

            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
        }

        return maxProfit;
    }

    private static int getMaxProfitWithUtils(int[] stockPrices) {
        int maxProfit; // Stores the maximum profit from buying and selling.
        int maxValue; // Stores the highest stock value.
        int minValue; // Stores the lowest stock value.

        Arrays.sort(stockPrices); // Sorts the array from lowest to highest.

        maxValue = stockPrices[stockPrices.length - 1]; // Last value is the highest stock value.
        minValue = stockPrices[0]; // First value is the lowest stock value.
        maxProfit = maxValue - minValue; // Maximum profit made.

        return maxProfit;
    }
}


