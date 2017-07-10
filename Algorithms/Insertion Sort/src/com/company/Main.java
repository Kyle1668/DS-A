package com.company;

public class Main {

    static int[] insertionSort(int[] inNums) {
        int temp;
        int position;
        boolean inserted;
        for (int current = 1; current < inNums.length; current++) {
            if (inNums[current] < inNums[current - 1]) {
                position = current;
                inserted = false;
                while (!inserted) {
                    if (position == 0 || inNums[position] >= inNums[position - 1]) {
                        inserted = true;
                    }
                    else {
                        temp = inNums[position - 1];
                        inNums[position - 1] = inNums[position];
                        inNums[position] = temp;
                        position--;
                    }
                }
            }
        }
        return inNums;
    }

    public static void main(String[] args) {

        int[] intArray1 = {46,14,91,31,84,48,35,95,39,54,10,42,79,61,62,50,46,4,80,73};
        intArray1 = insertionSort(intArray1);

        for (int element: intArray1) {
            System.out.print(element + " ");
        }

    }
}
