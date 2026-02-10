package test.com.huhx0015.algorithmtester.problems.arrays

import main.com.huhx0015.algorithmtester.problems.arrays.KthLargestElementArray
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class KthLargestElementArrayTest {

    @Test
    fun testFindKthLargestUsingSort() {
        val largestElement = KthLargestElementArray.findKthLargestUsingSort(TEST_ARRAY, TEST_KTH)
        assertEquals(TEST_RESULT, largestElement)
    }

    @Test
    fun testFindKthLargest() {
        val largestElement = KthLargestElementArray.findKthLargest(TEST_ARRAY, TEST_KTH)
        assertEquals(TEST_RESULT, largestElement)
    }

    companion object {
        private val TEST_ARRAY = intArrayOf(3, 2, 1, 5, 6, 4)
        private val TEST_KTH = 2
        private val TEST_RESULT = 5
    }
}