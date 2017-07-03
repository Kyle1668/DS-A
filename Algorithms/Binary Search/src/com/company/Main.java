package com.company;

import java.util.Arrays;

public class Main {

    static boolean binarySearch(int[] set, int target) {
        int mid = set[(set.length) / 2];

        if (set.length == 1 && set[0] != target) {
            return false;
        }
        else {
            if (mid == target) {
                return true;
            }
            else if (mid > target) {
                set = Arrays.copyOfRange(set, 0, (set.length) / 2);
                return binarySearch(set, target);
            }
            else {
                int lowerBound = (set.length) / 2;
                int upperBound = set.length - 1;
                set = Arrays.copyOfRange(set, lowerBound, upperBound);
                return binarySearch(set, target);
            }
        }

    }

    public static void main(String[] args) {

        int[] intArray = {46,14,91,31,84,48,35,95,39,54,10,42,79,61,62,50,46,49,80,73};
        Arrays.sort(intArray);

        System.out.print("Array: " + Arrays.toString(intArray) + "\n");
        System.out.print("Has 54: " + binarySearch(intArray, 54) + "\n");
        System.out.print("Has 12: " + binarySearch(intArray, 12) + "\n");

    }
}
