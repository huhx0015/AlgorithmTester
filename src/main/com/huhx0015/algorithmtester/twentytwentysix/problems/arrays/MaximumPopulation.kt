package com.huhx0015.algorithmtester.twentytwentysix.problems.arrays

/**
 * Leetcode
 *
 * Problem: 1854. Maximum Population Year
 * Difficulty: Easy
 *
 * You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
 *
 * The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
 *
 * Return the earliest year with the maximum population.
 *
 * Example 1:
 *
 * Input: logs = [[1993,1999],[2000,2010]]
 * Output: 1993
 * Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
 *
 * We want the earliest year the max population. In this case, 1993 is the answer, since these two people did not overlap
 * so there was only a max population of 1, and 1993 is the earliest year with this population.
 *
 * Example 2:
 *
 * Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
 * Output: 1960
 * Explanation:
 * The maximum population is 2, and it had happened in years 1960 and 1970.
 * The earlier year between them is 1960.
 *
 * Constraints:
 *
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 *
 * Solution Explanation: https://algo.monster/liteproblems/1854
 */
object MaximumPopulation {

    @JvmStatic fun main(args: Array<String>) {
        val input1 = arrayOf(intArrayOf(1993, 1999), intArrayOf(2000, 2010))
        val result1 = maximumPopulation(input1)
        println("Maximum Population: Earliest year of max population for input1 was $result1\n")

        val input2 = arrayOf(intArrayOf(1950, 1961), intArrayOf(1960, 1971), intArrayOf(1970, 1981))
        val result2 = maximumPopulation(input2)
        println("Maximum Population: Earliest year of max population for input2 was $result2\n")
    }

    // maximumPopulation():
    // Time Complexity: O(n)
    // Space Complexity: O(C) where C is the range size of the years, calculated as 2050 - 1950 + 1 = 101
    // Pattern: Prefix Sum Pattern
    // logs: 2D integer array where this indicates [birth, death] years of the ith person.
    // Constraints: Notice that the earliest birth is 1950 and latest death is 2050.
    fun maximumPopulation(logs: Array<IntArray>): Int {
        println("Maximum Population: Starting maximum population census for number of logs ${logs.size}")

        // Array to track population changes for years 1950-2050 (101 years).
        val populationChanges = IntArray(101)
        val YEAR_OFFSET = 1950

        // Mark birth and death years using difference array technique.
        for (personLog in logs) {
            val birthYearIndex = personLog[0] - YEAR_OFFSET
            val deathYearIndex = personLog[1] - YEAR_OFFSET

            println("Maximum Population: Birth year index for ${personLog.toSet()} is $birthYearIndex")
            println("Maximum Population: Death year index for ${personLog.toSet()} is $deathYearIndex")

            // Increment population at birth year.
            populationChanges[birthYearIndex]++
            // Decrement population at death year (person is not alive in death year).
            populationChanges[deathYearIndex]--
        }

        // Find the year with maximum population using prefix sum.
        var currentPopulation = 0
        var maxPopulation = 0
        var maxPopulationYearIndex = 0

        for (yearIndex in populationChanges.indices) {
            // Update current population by adding the change for this year.
            currentPopulation += populationChanges[yearIndex]

            println("Maximum Population: Current population at yearIndex $yearIndex is $currentPopulation")

            // Update maximum population and corresponding year if current is greater.
            if (currentPopulation > maxPopulation) {
                println("Maximum Population: Current population $currentPopulation is greater than maxPopulation $maxPopulation")

                maxPopulation = currentPopulation
                maxPopulationYearIndex = yearIndex

                println("Maximum Population: Max population updated to $maxPopulation and maxPopulationYearIndex updated to $yearIndex")
            }
        }

        // Convert index back to actual year and return.
        val earliestYearMaxPopulation = maxPopulationYearIndex + YEAR_OFFSET
        println("Maximum Population: Earliest population with maximum population was: $earliestYearMaxPopulation")
        return earliestYearMaxPopulation
    }
}