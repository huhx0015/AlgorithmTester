package com.huhx0015.algorithmtester.twentytwentysix.problems.search

import com.huhx0015.algorithmtester.twentytwentysix.problems.search.KokoEatingBananas.minEatingSpeed
import com.huhx0015.algorithmtester.twentytwentysix.problems.search.KokoEatingBananas.minEatingSpeedBruteForce
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KokoEatingBananasTest {

    @Test
    fun testKokoEatingBananas() {
        val piles1 = intArrayOf(1, 4, 3, 2)
        val h1 = 9
        val answer1 = minEatingSpeed(piles = piles1, h = h1)
        assertEquals(2, answer1)

        val piles2 = intArrayOf(25, 10, 23, 4)
        val h2 = 4
        val answer2 = minEatingSpeed(piles = piles2, h = h2)
        assertEquals(25, answer2)
    }

    @Test
    fun testKokoEatingBananasBruteForce() {
        val piles1 = intArrayOf(1, 4, 3, 2)
        val h1 = 9
        val answer1 = minEatingSpeedBruteForce(piles = piles1, h = h1)
        assertEquals(2, answer1)

        val piles2 = intArrayOf(25, 10, 23, 4)
        val h2 = 4
        val answer2 = minEatingSpeedBruteForce(piles = piles2, h = h2)
        assertEquals(25, answer2)
    }
}