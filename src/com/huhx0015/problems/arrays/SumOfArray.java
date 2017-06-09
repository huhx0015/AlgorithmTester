package com.huhx0015.problems.arrays;

import java.util.Scanner;

/**
 * Created by Michael Yoon Huh on 5/2/2017.
 */

public class SumOfArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        for (int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        int sum = sumOfArray(arr);
        System.out.println(sum);
    }

    private static int sumOfArray(int[] array) {
        int sum = 0;
        for (int x : array) {
            sum += x;
        }
        return sum;
    }
}