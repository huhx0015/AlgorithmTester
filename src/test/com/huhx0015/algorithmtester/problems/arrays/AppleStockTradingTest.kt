package test.com.huhx0015.algorithmtester.problems.arrays

import main.com.huhx0015.algorithmtester.problems.arrays.AppleStockTrading
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class AppleStockTradingTest {

    val TEST_STOCK_PRICES = intArrayOf(10, 7, 5, 8, 11, 9)
    val TEST_MAX_PROFIT = 6

    @Test
    fun getMaxProfit() {
        assertEquals(TEST_MAX_PROFIT, AppleStockTrading.getMaxProfit(TEST_STOCK_PRICES))
    }

    @Test
    fun getMaxProfitWithUtils() {
        assertEquals(TEST_MAX_PROFIT, AppleStockTrading.getMaxProfitWithUtils(TEST_STOCK_PRICES))
    }
}