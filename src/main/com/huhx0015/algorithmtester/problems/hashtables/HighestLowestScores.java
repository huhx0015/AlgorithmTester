package main.com.huhx0015.algorithmtester.problems.hashtables;

import main.com.huhx0015.algorithmtester.sorting.MergeSort;

/**
 * Interview Cake:
 *
 * You created a game that is more popular than Angry Birds.
 *
 * You rank players in the game from highest to lowest score. So far you're using an algorithm that sorts in
 * O(n log{n}) time, but players are complaining that their rankings aren't updated fast enough. You need a faster
 * sorting algorithm.
 *
 * Write a function that takes:
 *
 * an array of unsortedScores
 * the highestPossibleScore in the game
 * and returns a sorted array of scores in less than O(n\lg{n})O(nlgn) time.
 *
 * URL: https://www.interviewcake.com/question/java/top-scores
 *
 * Hint: Need to sort faster than O(n log n). Need to get to O(n).
 *
 * Created by Michael Yoon Huh on 5/27/2017.
 */
public class HighestLowestScores {

    public static void main(String[] args) {

        int[] unsortedScores = {37, 89, 41, 65, 91, 53};
        final int HIGHEST_POSSIBLE_SCORE = 100;

        //int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
        // sortedScores: [37, 41, 53, 65, 89, 91]

        MergeSort.mergesort(unsortedScores, 0, unsortedScores.length - 1);

        for (int x : unsortedScores) {
            System.out.println(x);
        }

    }

    private static int[] sortScores(int[] unsortedScores, int highestPossibleScore) {



        return unsortedScores;
    }
}
