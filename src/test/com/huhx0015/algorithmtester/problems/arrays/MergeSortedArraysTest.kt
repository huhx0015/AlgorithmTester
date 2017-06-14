package test.com.huhx0015.algorithmtester.problems.arrays

import main.com.huhx0015.algorithmtester.problems.arrays.MergeSortedArrays
import org.junit.jupiter.api.Test

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class MergeSortedArraysTest {

    @Test
    fun testMergeSortedArrays() {
        MergeSortedArrays.mergeSortedArrays(TEST_ARRAY, TEST_ALICE_ARRAY)
    }

    @Test
    fun testMergeSortedArraysBuiltIn() {
        MergeSortedArrays.mergeSortedArraysBuiltIn(TEST_ARRAY, TEST_ALICE_ARRAY)
    }

    companion object {
        private val TEST_ARRAY = intArrayOf(3, 4, 6, 10, 11, 15)
        private val TEST_ALICE_ARRAY = intArrayOf(1, 5, 8, 12, 14, 19)
    }
}