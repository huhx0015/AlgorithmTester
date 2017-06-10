package main.com.huhx0015.algorithmtester.problems.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
 * the kth distinct element.
 *
 * FURTHER EXPLANATION: Imagine the array being sorted first. Then find the kth from the last. That is the largest
 * element in the array.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
 *
 */
public class KthLargestElementArray {

    public static void main(String[] args) {

        int[] testArray = new int[] {3, 2, 1, 5, 6, 4};
        int testK = 2;

        int largestElement = findKthLargest(testArray, testK);
        System.out.println("Largest Element: " + largestElement);
    }

    // Finds kth using built-in sort.
    public static int findKthLargestUsingSort(int[] nums, int kth) {

        // Input check.
        if (nums == null || kth > nums.length) {
            System.out.println("ERROR: Invalid input.");
            return -1;
        }

        Arrays.sort(nums);
        return nums[nums.length - kth];
    }

    // Finds kth using PriorityQueue.
    public static int findKthLargest(int[] nums, int kth) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int val : nums) {
            System.out.println("Current Value: " + val);

            queue.offer(val); // Inserts element into priority queue (like push).

            if (queue.size() > kth) {
                int pollValue = queue.poll(); // The method call returns and removes head of the queue.
                System.out.println("Poll Value: " + pollValue);
            }

            int peekValue = queue.peek();
            System.out.println("Peek Value: " + peekValue + "\n");
        }
        return queue.peek();
    }
}
