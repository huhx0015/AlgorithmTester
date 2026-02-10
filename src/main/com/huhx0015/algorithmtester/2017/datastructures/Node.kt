package main.com.huhx0015.algorithmtester.datastructures

/**
 * Created by Michael Yoon Huh on 4/7/2017.
 */
class Node {

    var name: String = ""
    var value: Int = 0

    var left: Node? = null
    var right: Node? = null

    var children: Array<Node>? = null
    var adjacent: Array<Node>? = null

    var visited = false
    var marked = false

    constructor(name: String) {
        this.name = name
    }

    constructor(value: Int) {
        this.value = value
    }

    constructor(name: String, adjacent: Array<Node>) {
        this.name = name
        this.adjacent = adjacent
    }
}
