package test.com.huhx0015.algorithmtester.problems.strings

import main.com.huhx0015.algorithmtester.problems.strings.FindSubstringIsAnagram
import org.junit.jupiter.api.Test

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class FindSubstringIsAnagramTest {

    @Test
    fun testSubstringAnagram() {
        FindSubstringIsAnagram.substringAnagram("password", "sap")
        FindSubstringIsAnagram.substringAnagram("ABCD", "BACDGABCDA")
        FindSubstringIsAnagram.substringAnagram("AABA", "AAABABAA")
    }

}