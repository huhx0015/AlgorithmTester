package test.com.huhx0015.algorithmtester.problems.hackerrank

import main.com.huhx0015.algorithmtester.problems.hackerrank.CompareTriplets
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class CompareTripletsTest {

    val TEST_EXPECTED_VALUE = 1

    @Test
    fun testCompareTriplets() {
        val result = CompareTriplets.solve(5, 6, 7, 3, 6, 10)

        var position = 0
        result.forEach {
            assertEquals(TEST_EXPECTED_VALUE, result[position])
            position++
        }
    }
}