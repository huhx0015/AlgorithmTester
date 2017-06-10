package main.com.huhx0015.algorithmtester.problems.arrays;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael Yoon Huh on 5/22/2017.
 *
 * Find all unique pairs in the array that are the sum of the magic number. All numbers in the array are unique.
 *
 * Asked at Razer.
 *
 * input: [1,3,5,7]
 * output: [1,3] [3,5] [5,7]
 */
public class PairSum {

    public static void main(String[] args) {

        int[] inputArray = new int[] {1, 3, 5, 7};
        findPairsBruteForce(inputArray, 8);

    }

    // O(n) Solution:
    private static void findPairs(int[] nums, int magicNum) {

        if (nums.length < 2) {
            return;
        }

        HashMap<Integer, Boolean> set = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            set.put(i, true);
        }

        // Remove the x from the set. If number was already used, we mark it as false.
        for (int i = 0; i < set.size(); i++) {
            int x = magicNum - nums[i]; // Finds the difference and sees if that number exists.

            if (set.containsKey(x) && set.get(x)) {
                System.out.println("[" + nums[i] + "," + x + "]");
                set.put(x, false); // Marks the value as already being used.
            }
        }
    }

    // Bruteforce method. O(n^2)
    private static void findPairsBruteForce(int[] nums, int magicNum) {

        if (nums.length < 2) {
            return;
        }

        HashMap<Point, Boolean> sumPairs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == magicNum) {
                    if (magicNum - nums[i] == nums[j]) {
                        Point point = new Point(nums[i], nums[j]);
                        sumPairs.put(point, true);
                    }
                }
            }

            for (Map.Entry<Point, Boolean> entry : sumPairs.entrySet()) {
                System.out.println("[" + entry.getKey().x + "," + entry.getKey().y + "]");
            }
        }
    }
}
