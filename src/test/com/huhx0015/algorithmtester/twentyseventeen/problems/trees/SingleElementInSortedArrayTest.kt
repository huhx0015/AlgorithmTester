package com.huhx0015.algorithmtester.twentyseventeen.problems.trees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class SingleElementInSortedArrayTest {

    @Test
    fun testSingleNonDuplicateWithHashmap() {
        assertEquals(2, SingleElementInSortedArray.singleNonDuplicateWithHashmap(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)))
    }

    @Test
    fun testSingleNonDuplicate() {
        assertEquals(2, SingleElementInSortedArray.singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)))
    }
}