package test.com.huhx0015.algorithmtester.datastructures

import main.com.huhx0015.algorithmtester.datastructures.CustomLinkedList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

/**
 * Created by Michael Yoon Huh on 6/12/2017.
 */
internal class CustomLinkedListTest {

    private var mRootLinkedList: CustomLinkedList? = null
    private var mSecondLinkedList: CustomLinkedList? = null
    private var mThirdLinkedList: CustomLinkedList? = null
    private var mFourthLinkedList: CustomLinkedList? = null

    @BeforeEach
    fun initTestLinkedList() {
        mRootLinkedList = CustomLinkedList(TEST_VALUE_1)
        mSecondLinkedList = CustomLinkedList(TEST_VALUE_2)
        mThirdLinkedList = CustomLinkedList(TEST_VALUE_3)
        mFourthLinkedList = CustomLinkedList(TEST_VALUE_4)

        mSecondLinkedList!!.head = mRootLinkedList
        mThirdLinkedList!!.head = mSecondLinkedList
        mFourthLinkedList!!.head = mThirdLinkedList

        mRootLinkedList!!.tail = mSecondLinkedList
        mSecondLinkedList!!.tail = mThirdLinkedList
        mThirdLinkedList!!.tail = mFourthLinkedList
    }

    @Test
    fun testGetData() {
        assertEquals(TEST_VALUE_3, mThirdLinkedList?.data)
        assertEquals(TEST_VALUE_1, mRootLinkedList?.data)
        assertEquals(TEST_VALUE_4, mFourthLinkedList?.data)
    }

    @Test
    fun testSetData() {
        mSecondLinkedList?.data = TEST_VALUE_ALT_2
        mFourthLinkedList?.data = TEST_VALUE_ALT_4

        assertEquals(TEST_VALUE_ALT_2, mSecondLinkedList?.data)
        assertEquals(TEST_VALUE_ALT_4, mFourthLinkedList?.data)
    }

    @Test
    fun testGetHead() {
        assertEquals(mSecondLinkedList, mThirdLinkedList?.head)
    }

    @Test
    fun testSetHead() {
        mRootLinkedList?.head = mFourthLinkedList
        assertEquals(TEST_VALUE_4, mRootLinkedList?.head?.data)
    }

    @Test
    fun testGetTail() {
        assertEquals(mThirdLinkedList, mSecondLinkedList?.tail)
    }

    @Test
    fun testSetTail() {
        mFourthLinkedList?.tail = mRootLinkedList
        assertEquals(TEST_VALUE_1, mFourthLinkedList?.tail?.data)
    }

    companion object {
        private val TEST_VALUE_1 = "First"
        private val TEST_VALUE_2 = "Second"
        private val TEST_VALUE_3 = "Third"
        private val TEST_VALUE_4 = "Fourth"
        private val TEST_VALUE_ALT_1 = "1st"
        private val TEST_VALUE_ALT_2 = "2nd"
        private val TEST_VALUE_ALT_3 = "3rd"
        private val TEST_VALUE_ALT_4 = "4th"
    }
}