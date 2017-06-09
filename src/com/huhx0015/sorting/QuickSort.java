package com.huhx0015.sorting;

/**
 * QuickSort:
 *
 * A comparison based sorting algorithm
 *
 * Divides entire dataset in half by selecting the average element and putting all smaller elements to the left of the
 * average.
 *
 * It repeats this process on the left side until it is comparing only two elements at which point the left side is
 * sorted.
 *
 * When the left side is finished sorting it performs the same operation on the right side.
 *
 * Computer architecture favors the quicksort process.
 *
 * 1) Array is already sorted in same order.
 * 2) Array is already sorted in reverse order.
 * 3) All elements are same (special case of case 1 and 2)
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = {37, 89, 41, 65, 91, 53};
        sort(array);

        System.out.println("main(): Sorted values: ");
        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Big-O Analysis: Average: O(n log(n)) | Worst: O(n^2) | Memory: O(log n)
    private static void quickSort(int[] array, int left, int right) {

        // If less than or equal to 0, array is already sorted.
        if (right - left <= 0) {
            return;
        }

        int index = partition(array, left, right); // Gets the index value from partitioning the array.
        System.out.println("quickSort(): Index value set at: " + index);

        // If left side is less than index value - 1, the left half is sorted.
        if (left < (index - 1)) {
            System.out.println("quickSort(): Left " + left + " is less than " + (index - 1) + " left side to be sorted.\n");
            quickSort(array, left, index - 1);
        }

        // If the index value is less than the right value, the right half is sorted.
        if (index < right) {
            System.out.println("quickSort(): Index " + index + " is less than " + right + " right side to be sorted.\n");
            quickSort(array, index, right);
        }
    }

    private static int partition(int[] array, int left, int right) {

        int pivot = array[(left + right / 2)]; // Picks a pivot point by getting the value in the middle of the array.
        System.out.println("partition(): Pivot value set at: " + pivot );

        // While the left value is less than or equal to right value.
        while (left <= right) {

            // If the left position in the array is less than pivot.
            // Find element on the left that should be on the right.
            while (array[left] < pivot) {
                System.out.println("partition(): item at " + left + " is " + array[left] + " less than pivot. Left index incremented.");
                left++;
            }

            // If the right position in the array is greater than pivot.
            // Find element on the right that should be on the left.
            while (array[right] > pivot) {
                System.out.println("partition(): item at " + right + " is " + array[right] + " greater than pivot. Right index incremented.");
                right--;
            }

            // Swap elements, and move left and right indices.
            if (left <= right) {
                swap(array, left, right); // Swap elements.
                left++;
                right--;
            }
        }

        System.out.println("partition(): Partition done, returning left " + left + " as the index value.\n");
        return left; // Returns the left value as the index value.
    }

    // Swaps the values in the array.
    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        System.out.println("swap(): Left " + left + " and right " + right + " are swapped.\n");
    }
}
