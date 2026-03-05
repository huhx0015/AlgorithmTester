package com.huhx0015.algorithmtester.twentytwentysix.problems.linkedlist

/**
 * Leetcode
 *
 * Problem: 1472. Design Browser History
 * Difficulty: Medium
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history
 * number of steps or move forward in the history number of steps.
 *
 * Implement the BrowserHistory class:
 *
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 *
 * Example:
 *
 * Input:
 * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
 * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
 * Output:
 * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
 *
 * Explanation:
 * BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
 * browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
 * browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
 * browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
 * browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
 * browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
 * browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
 * browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
 * browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
 * browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
 * browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
 *
 *
 * Constraints:
 *
 * 1 <= homepage.length <= 20
 * 1 <= url.length <= 20
 * 1 <= steps <= 100
 * homepage and url consist of  '.' or lower case English letters.
 * At most 5000 calls will be made to visit, back, and forward.
 */
object DesignBrowserHistory {

    @JvmStatic fun main(args: Array<String>) {
        val browserHistory = BrowserHistory("leetcode.com")
        browserHistory.visit("google.com") // You are in "leetcode.com". Visit "google.com"
        println("BrowserHistory: Visiting google.com")

        browserHistory.visit("facebook.com") // You are in "google.com". Visit "facebook.com"
        println("BrowserHistory: Visiting facebook.com")

        browserHistory.visit("youtube.com") // You are in "facebook.com". Visit "youtube.com"
        println("BrowserHistory: Visiting youtube.com")

        // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        println("BrowserHistory: Going back 1, browser history is at ${browserHistory.back(1)}")

        // You are in "facebook.com", move back to "google.com" return "google.com"
        println("BrowserHistory: Going back 1, browser history is at ${browserHistory.back(1)}")

        // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        println("BrowserHistory: Going forward 1, browser history is at ${browserHistory.forward(1)}")

        browserHistory.visit("linkedin.com") // You are in "facebook.com". Visit "linkedin.com"
        println("BrowserHistory: Visiting linkedin.com")

        // You are in "linkedin.com", you cannot move forward any steps.
        println("BrowserHistory: Going forward 2, browser history is at ${browserHistory.forward(2)}")

        // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        println("BrowserHistory: Going back 2, browser history is at ${browserHistory.back(2)}")

        // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
        println("BrowserHistory: Going back 7, browser history is at ${browserHistory.back(7)}")
    }
}

class BrowserHistory(homepage: String) {

    var currentPage: Page? = Page(url = homepage) // Reference to the current Page.

    data class Page(
        val url: String, // URL String value.
        var previous: Page? = null, // Pointer to the previous Page.
        var next: Page? = null // Pointer to the next Page.
    )

    // visit(): Visits url from the current page. It clears up all the forward history.
    fun visit(url: String) {
        val newPage = Page(url = url)

        // If currentPage is null (meaning no Page has been visited yet), the currentPage is set to the new Page.
        if (currentPage == null) {
            currentPage = newPage
        } else {
            // Otherwise, we update the currentPage to be the newPage and set the existing currentPage to be the previous
            // page of the new currentPage.
            val previousPage = currentPage // Reference the currentPage to be the new previousPage of the newPage.
            newPage.previous = previousPage // Updates the newPage previous pointer to point to the newPage.
            previousPage?.next = newPage // Updates the previousPage's next pointer to be the newPage.
            currentPage = newPage // Sets the currentPage to be the newPage.
        }
    }

    // back(): Move steps back in history. If you can only return x steps in the history and steps > x, you will return
    // only x steps. Return the current url after moving back in history at most steps.
    fun back(steps: Int): String {
        var current = currentPage // Reference copy to the currentPage.
        var stepCount = steps // Counter value used for decrementing in the while loop.

        // Move back up to steps times, stopping if we reach the start of history.
        while (stepCount > 0 && current?.previous != null) {
            current = current.previous // Updates the current Page to point to the previous Page for the next loop.
            stepCount--
        }
        currentPage = current // Updates the currentPage to be the current Page.
        return current?.url ?: String()
    }

    // forward(): Move steps forward in history. If you can only forward x steps in the history and steps > x, you will
    // forward only x steps. Return the current url after forwarding in history at most steps.
    fun forward(steps: Int): String {
        var current = currentPage // Reference copy to the currentPage.
        var stepCount = steps // Counter value used for decrementing in the while loop.

        // Move forward up to steps times, stopping if we reach the end of history.
        while (stepCount > 0 && current?.next != null) {
            current = current.next // Updates the current Page to point to the next Page for the next loop.
            stepCount--
        }
        currentPage = current // Updates the currentPage to be the current Page.
        return current?.url ?: String()
    }
}