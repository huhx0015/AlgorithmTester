package test.com.huhx0015.algorithmtester.problems.hashtables

import main.com.huhx0015.algorithmtester.problems.hashtables.WordCloud
import org.junit.jupiter.api.Test

/**
 * Created by Michael Yoon Huh on 6/13/2017.
 */
internal class WordCloudTest {

    @Test
    fun testWordCloud() {
        val wordMap = WordCloud.wordCloud(TEST_WORDS_2)

        for ((word, count) in wordMap!!) {
            println("Word: $word | Count: $count")
        }
    }

    @Test
    fun testWordCloudUsingSplit() {
        val wordMap = WordCloud.wordCloudUsingSplit(TEST_WORDS_2)

        for ((word, count) in wordMap!!) {
            println("Word: $word | Count: $count")
        }
    }

    companion object {
        private val TEST_WORDS_1 = "After beating the eggs, Dana read the next step: Add milk and eggs, then add flour and sugar."
        private val TEST_WORDS_2 = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake. The bill came to five dollars."
    }
}