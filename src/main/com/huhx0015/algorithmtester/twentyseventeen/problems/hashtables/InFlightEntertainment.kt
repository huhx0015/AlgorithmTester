package com.huhx0015.algorithmtester.twentyseventeen.problems.hashtables

import java.util.HashSet

/**
 * Interview Cake:

 * You've built an in-flight entertainment system with on-demand movie streaming.

 * Users on longer flights like to start a second movie right when their first one ends, but they complain that the
 * plane usually lands before they can see the ending. So you're building a feature for choosing two movies whose total
 * runtimes will equal the exact flight length.
 * Write a function that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes)
 * and returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.

 * When building your function:

 * Assume your users will watch exactly two movies
 * Don't make your users watch the same movie twice
 * Optimize for runtime over memory

 * URL: https://www.interviewcake.com/question/java/inflight-entertainment

 * Hint:
 * HashSet is a set, e.g. {1,2,3,4,5}
 * HashMap is a key -> value (key to value) map, e.g. {a -> 1, b -> 2, c -> 2, d -> 1}
 * Notice in my example above that in the HashMap there must not be duplicate keys, but it may have duplicate values.
 * In the HashSet, there must be no duplicate elements.

 * NOTE: Variant of this question (pair sum) asked by Razer.

 * Created by Michael Yoon Huh on 5/24/2017.
 */
object InFlightEntertainment {

    @JvmStatic fun main(args: Array<String>) {

        val flightLength = 8
        val movieLengths = intArrayOf(3, 2, 7, 10, 20, 30, 50, 2, 8, 9, 11, 2, 5, 4, 3)

        inflightEntertainment(flightLength, movieLengths)
    }

    // InterviewCake Solution: Big(O) Complexity: O(n)
    fun inflightEntertainment(flightLength: Int, movieLengths: IntArray): Boolean {

        val movieSet = HashSet<Int>() // Store all unique movies in the hash set.

        // This loop is O(n), for which n is the total number of integers in movieLengths.
        for (firstMovie in movieLengths) {

            // We take the difference to find the exact movie length we are looking for in the second movie.
            val secondMovie = flightLength - firstMovie

            if (movieSet.contains(secondMovie)) {
                println("Found two movies that match the flight time: Movie 1: $firstMovie | Movie 2: $secondMovie")
                return true
            }
            movieSet.add(firstMovie)
        }

        // No match was found by this point.
        println("No movies found that match the flight time.")
        return false
    }

    // My attempt: Big(O) Complexity: O(n) + O(k)
    fun inflightEntertainmentAlt(flightLength: Int, movieLengths: IntArray): Boolean {

        if (movieLengths.size < 2) {
            println("We don't have enough movies!")
            return false
        }

        val movieSet = HashSet<Int>() // Store all unique movies in the hash set.

        // This loop is O(n), for which n is the total number of integers in movieLengths.
        for (movie in movieLengths) {
            movieSet.add(movie) // Adds the movie length into the hash set.
        }

        // After hash set of movies is constructed, we iterate through the hash set to find any movies whose sum matches
        // flightLength.
        // This loop is O(k), for which k is the total number of integers in the hash set. Note that k and n could be
        // different, if movieLengths had duplicates or not.
        for (length in movieSet) {

            val otherMovie = flightLength - length // We take the difference to find the exact movie length we are looking for.

            // If movieSet contains the otherMovie value, we have a pair of movies that match. Need to also check if this
            // movie is not the "same movie".
            if (length != otherMovie && movieSet.contains(otherMovie)) {
                println("Found two movies that match the flight time: Movie 1: $length | Movie 2: $otherMovie")
                return true
            }
        }

        println("No movies found that match the flight time.")
        return false // If no match was found before this point, there was no movies whose length matched the flight time.
    }
}
