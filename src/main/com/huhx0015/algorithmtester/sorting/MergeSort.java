package main.com.huhx0015.algorithmtester.sorting;

/**
 * Created by Michael Yoon Huh on 4/24/2017.
 *
 * http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html#mergesort
 */
public class MergeSort {

    public static void sort(int[] array) {
        mergesort(array, 0, array.length - 1);
    }

    // Big(O) Complexity: Best:	Ω(n log(n)) | Average:	Θ(n log(n))	| Worst: O(n log(n)) | Space Complexity:	O(n)
    public static void mergesort(int[] array, int low, int high) {

        // Checks if low is smaller than high, if not then the array is sorted.
        if (low < high) {

            // Gets the index of the element which is in the middle.
            int middle = (low + high) / 2;

            // Sorts the left side of the array.
            mergesort(array, low, middle);

            // Sorts the right side of the array.
            mergesort(array, middle + 1, high);

            // Combines them both.
            merge(array, low, middle, high);
        }
    }

    private static void merge(int[] array, int low, int middle, int high) {

        int[] helper = new int[array.length];

        // Copy both parts into the helper array.
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        // Copy the smallest values from either the left or the right side back
        // to the original array.
        while (i <= middle && j <= high) {

            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copy the rest of the left side of the array into the target array.
        while (i <= middle) {
            array[k] = helper[i];
            k++;
            i++;
        }
    }
}
