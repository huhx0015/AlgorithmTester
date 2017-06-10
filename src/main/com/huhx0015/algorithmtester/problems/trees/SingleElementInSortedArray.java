package main.com.huhx0015.algorithmtester.problems.trees;

import java.util.HashMap;

/**
 * LeetCode:
 *
 * 540. Single Element in a Sorted Array
 *
 * Given a sorted array consisting of only integers where every element appears twice except for one element which
 * appears once. Find this single element that appears only once.
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 *
 * Hint: Since it's sorted and it is asking for O(log n) time, use a binary search tree!
 * Hint 2: O(1) space indicates that we can't use hashmap here.
 * Hint 3: In binary search trees, left is always less than right.
 *
 * Created by Michael Yoon Huh on 5/30/2017.
 */
public class SingleElementInSortedArray {

    public static void main(String[] args) {

        singleNonDuplicate(new int[] {5, 10, 5, 10, 7} );
    }

    public static int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            else if (nums[mid] == nums[mid + 1] && mid % 2 == 0) {
                low = mid + 1;
            }

            else if (nums[mid] == nums[mid - 1] && mid % 2 == 1) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return nums[low];
    }

    // Solution with Hashmap. But this takes up O(n) runtime and O(n) space, due to hashmap.
    public int singleNonDuplicateWithHashmap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (int val : map.keySet()) {
            if (map.get(val) < 2) {
                return val;
            }
        }

        return 0;
    }
}
