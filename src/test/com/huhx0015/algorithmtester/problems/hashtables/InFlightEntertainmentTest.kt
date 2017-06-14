package test.com.huhx0015.algorithmtester.problems.hashtables

import main.com.huhx0015.algorithmtester.problems.hashtables.InFlightEntertainment
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class InFlightEntertainmentTest {

    @Test
    fun testInflightEntertainment() {
        assertEquals(true, InFlightEntertainment.inflightEntertainment(TEST_FLIGHT_LENGTH, TEST_MOVIE_LENGTH))
    }

    @Test
    fun testInflightEntertainmentAlt() {
        assertEquals(true, InFlightEntertainment.inflightEntertainmentAlt(TEST_FLIGHT_LENGTH, TEST_MOVIE_LENGTH))
    }

    companion object {
        private val TEST_FLIGHT_LENGTH = 8
        private val TEST_MOVIE_LENGTH = intArrayOf(3, 2, 7, 10, 20, 30, 50, 2, 8, 9, 11, 2, 5, 4, 3)
    }
}