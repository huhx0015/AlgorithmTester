package main.com.huhx0015.algorithmtester.problems.arrays;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element
 * in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/#/description
 *
 * Created by Michael Yoon Huh on 4/29/2017.
 */
public class KthSmallestElementSortedMatrix {

    public static void main(String[] args) {

        int[][] testMatrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int testK = 8;

        kthSmallest(testMatrix, testK);
    }

    public static int kthSmallest(int[][] matrix, int k) {

        return 0;
    }
}
