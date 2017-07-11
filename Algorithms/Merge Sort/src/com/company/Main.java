package com.company;

public class Main {

    public static void mergeSort(int[] inNums) {
        mergeSort(inNums, new int[inNums.length], 0, inNums.length - 1);
    }

    private static void mergeSort(int[] inNums, int[] tempArray, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return;
        }
        int middle = (lowerBound + upperBound) / 2;
        mergeSort(inNums, tempArray, lowerBound, middle);
        mergeSort(inNums, tempArray, middle + 1, upperBound);
        mergeHalves(inNums, tempArray, lowerBound, upperBound);
    }

    private static void mergeHalves(int[] inNums, int[] tempArray, int lowerBound, int upperBound) {
        int leftEnd = (lowerBound + upperBound) / 2;
        int rightStart = leftEnd + 1;
        int size = upperBound - lowerBound + 1;
        int leftIndex = lowerBound;
        int rightIndex = rightStart;
        int index = lowerBound;

        while (leftIndex <= leftEnd && rightIndex <= upperBound) {
            if (inNums[leftIndex] <= inNums[rightIndex]) {
                tempArray[index] = inNums[leftIndex];
                leftIndex++;
            }
            else {
                tempArray[index] = inNums[rightIndex];
                rightIndex++;
            }
            index++;
        }

        System.arraycopy(inNums, leftIndex, tempArray, index, leftEnd - leftIndex+ 1);
        System.arraycopy(inNums, rightIndex, tempArray, index, upperBound - rightIndex+ 1);
        System.arraycopy(tempArray, lowerBound, inNums, lowerBound, size);

    }

    public static void main(String[] args) {

        int[] intArray1 = {46,14,91,31,84,48,35,95,39,54,10,42,79,61,62,50,46,4,80,73};

        mergeSort(intArray1);

        for (int element: intArray1) {
            System.out.print(element + " ");
        }

    }

}
