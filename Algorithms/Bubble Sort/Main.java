package com.company;

public class Main {

    static int[] bubbleSort(int[] inNums) {
        boolean sorted = false;
        int temp;
        int count = 1;

        while (!sorted) {
            sorted = true;

            for (int i = 0; i < inNums.length - 1; i++) {
                count += 1;
                if (inNums[i] > inNums[i + 1]) {
                    temp = inNums[i];
                    inNums[i] = inNums[i + 1];
                    inNums[i + 1] = temp;
                    sorted = false;
                }
            }

        }

        System.out.print("Steps: " + count + "\n");
        return inNums;

    }

    public static void main(String[] args) {

        int[] intArray1 = {46,14,91,31,84,48,35,95,39,54,10,42,79,61,62,50,46,4,80,73};

        intArray1 = bubbleSort(intArray1);

        for (int element: intArray1) {
            System.out.print(element + " ");
        }

    }

}
