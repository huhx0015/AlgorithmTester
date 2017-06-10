package main.com.huhx0015.algorithmtester.problems.hackerrank;

import java.util.*;

/**
 *
 * HackerRank
 *
 * Compare Triplets
 *
 * URL: https://www.hackerrank.com/challenges/compare-the-triplets?h_r=next-challenge&h_v=zen
 *
 * Created by Michael Yoon Huh on 5/2/2017.
 */

public class CompareTriplets {

    static final int ALICE = 0;
    static final int BOB = 1;

    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){

        int[] result = new int[2];

        if (a0 > b0) {
            result[ALICE]++;
        } else if (a0 < b0) {
            result[BOB]++;
        }

        if (a1 > b1) {
            result[ALICE]++;
        } else if (a1 < b1) {
            result[BOB]++;
        }

        if (a2 > b2) {
            result[ALICE]++;
        } else if (a2 < b2) {
            result[BOB]++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
        String separator = "", delimiter = " ";
        for (Integer value : result) {
            System.out.print(separator + value);
            separator = delimiter;
        }
        System.out.println("");


    }

}
