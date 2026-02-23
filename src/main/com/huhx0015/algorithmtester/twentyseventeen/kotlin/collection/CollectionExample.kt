package com.huhx0015.algorithmtester.twentyseventeen.kotlin.collection

import java.util.*

/**
 * Created by Michael Yoon Huh on 3/30/2017.
 */
object CollectionExample {

    @JvmStatic fun main(args: Array<String>) {

        // ArrayList:
        val arrayList = ArrayList<String>()
        arrayList.add("one")
        arrayList.add("two")
        println("ArrayList 0 Element: " + arrayList[0])

        for (s in arrayList) {
            println("ArrayList LOOP: " + s)
        }

        // Vector:
        val vector = Vector<String>()
        vector.add("one")
        vector.add("two")
        println("Vector 0 Element: " + vector[0])

        for (s in vector) {
            println("Vector LOOP: " + s)
        }

        // LinkedList
        val linkedList = LinkedList<String>()
        linkedList.add("one")
        linkedList.add("two")
        println("LinkedList 0 Element: " + linkedList[0])

        val iter = linkedList.iterator()
        while (iter.hasNext()) {
            println("LinkedList LOOP: " + linkedList.first)
            linkedList.removeFirst()
        }

        val hashMap = HashMap<Int, String>()
        hashMap.put(0, "one")
        hashMap.put(1, "two")
        println("HashMap 0 Element: " + hashMap[0])

        for (i in 0..hashMap.size - 1) {
            println("HashMap LOOP: " + hashMap[i])
        }

        println("Program end.")
    }
}
