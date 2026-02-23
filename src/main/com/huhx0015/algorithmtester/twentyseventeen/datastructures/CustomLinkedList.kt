package com.huhx0015.algorithmtester.twentyseventeen.datastructures

/**
 * Created by Michael Yoon Huh on 5/29/2017.
 */
class CustomLinkedList {

    var data: Any? = null
    var head: CustomLinkedList? = null
    var tail: CustomLinkedList? = null

    constructor(data: Any) {
        this.data = data
        this.head = null
        this.tail = null
    }

    constructor(data: Any, head: CustomLinkedList, tail: CustomLinkedList) {
        this.data = data
        this.head = head
        this.tail = tail
    }
}