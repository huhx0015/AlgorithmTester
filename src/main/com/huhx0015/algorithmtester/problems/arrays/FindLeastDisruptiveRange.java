package main.com.huhx0015.algorithmtester.problems.arrays;

/**
 * Created by Michael Yoon Huh on 4/3/2017.
 *
 * Finds the smallest index in the original array for which the replacement array has the least distruptive range.
 *
 * Ex. Given original array [1, 2, 3, 4, 5] and a replacement of [5, 8, 1], the least disruptive range starts at index 2 in
 * the original array (3, 4, 5). We compare the differences, (3 vs 5 = 2, 4 vs 8 = 4, 5 vs 1 = 4, for which the total
 * is 10. If we compare this against the very first index [1, 2, 3], (1 vs 5 = 4, 2 vs 8 = 6, 3 vs 1 = 2, for which the
 * total is 12.), the total distance is higher than the set starting at index 2, meaning it's more "disruptive."
 */
public class FindLeastDisruptiveRange {

    public static void main(String[] args) {

        int smallestIndex = leastDisruptiveRange(new int[] {1, 2, 3, 4, 5}, new int[] {5, 8, 1});
        System.out.println(smallestIndex);
    }

    private static int leastDisruptiveRange(int[] original, int[] replacement) {

        int distance;
        int smallestIndex = 0;
        int distanceSum;
        int smallestDistance = 0;

        for (int originalCounter = 0; originalCounter <= original.length - replacement.length; originalCounter++) {

            distanceSum = 0;

            for (int replacementCounter = 0; replacementCounter < replacement.length; replacementCounter++) {
                distance = Math.abs(original[originalCounter + replacementCounter] - replacement[replacementCounter]);
                distanceSum += distance;
            }

            // FIRST TIME CASE:
            if (originalCounter == 0) {
                smallestDistance = distanceSum;
            } else if (distanceSum < smallestDistance) {
                smallestDistance = distanceSum;
                smallestIndex = originalCounter;
            }
        }

        return smallestIndex;
    }
}
