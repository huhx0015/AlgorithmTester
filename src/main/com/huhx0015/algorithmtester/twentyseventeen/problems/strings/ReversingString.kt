package com.huhx0015.algorithmtester.twentyseventeen.problems.strings

/**
 * Created by Michael Yoon Huh on 3/31/2017.
 */
object ReversingString {

    @JvmStatic fun main(args: Array<String>) {
        println(reverseString("hello my name is korean"))
    }

    fun reverseString(str: String): String {
        val reversedStringArray = CharArray(str.length)

        var j = 0
        for (i in str.length - 1 downTo 0) {
            reversedStringArray[j] = str[i]
            j++
        }

        return String(reversedStringArray)
    }
}
