package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignBrowserHistoryTest {

    @Test
    fun testDesignBrowserHistory() {
        val facebookUrl = "facebook.com"
        val leetcodeUrl = "leetcode.com"
        val googleUrl = "google.com"
        val youTubeUrl = "youTube.com"
        val linkedinUrl = "linkedin.com"

        val browserHistory = BrowserHistory(leetcodeUrl)
        browserHistory.visit(googleUrl) // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit(facebookUrl) // You are in "google.com". Visit "facebook.com"
        browserHistory.visit(youTubeUrl) // You are in "facebook.com". Visit "youtube.com"

        val pageUrlResult1 = browserHistory.back(1)
        assertEquals(facebookUrl, pageUrlResult1)

        val pageUrlResult2 = browserHistory.back(1)
        assertEquals(googleUrl, pageUrlResult2)

        val pageUrlResult3 = browserHistory.forward(1)
        assertEquals(facebookUrl, pageUrlResult3)

        browserHistory.visit("linkedin.com") // You are in "facebook.com". Visit "linkedin.com"

        val pageUrlResult4 = browserHistory.forward(2)
        assertEquals(linkedinUrl, pageUrlResult4)

        val pageUrlResult5 = browserHistory.back(2)
        assertEquals(googleUrl, pageUrlResult5)

        val pageUrlResult6 = browserHistory.back(7)
        assertEquals(leetcodeUrl, pageUrlResult6)
    }
}