package test.com.huhx0015.algorithmtester.problems.linkedlist

import main.com.huhx0015.algorithmtester.problems.linkedlist.CTCI2LinkedLists
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import java.util.*

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class CTCI2LinkedListsTest {

    var mTestLinkedList = LinkedList<Int>()

    @BeforeEach
    fun initLinkedList() {
        mTestLinkedList.add(1)
        mTestLinkedList.add(1)
        mTestLinkedList.add(3)
        mTestLinkedList.add(5)
        mTestLinkedList.add(7)
        mTestLinkedList.add(7)
        mTestLinkedList.add(9)
    }

    @Test
    fun testRemoveDupIntegers() {
        mTestLinkedList = CTCI2LinkedLists.removeDupIntegers(mTestLinkedList)

        for (i in mTestLinkedList) {
            println("Integer: $i ")
        }
    }
}