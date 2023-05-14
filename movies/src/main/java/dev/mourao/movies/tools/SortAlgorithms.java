package dev.mourao.movies.tools;

import java.util.Arrays;

public class SortAlgorithms {

    //O(n+p) -> n = array1.length, p = array2.length
    public int[] mergeAndSort2Unsorteds(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        return mergeAndSort(array1, array2);
    }

    //O(n * log n) -> n = array.length
    public int[] sliptSortAndMergeSort(int[] array) {
        return sliptAndSort(array);
    }

    private int[] sliptAndSort(int[] array) {
        var length = array.length;
        if (length <= 1) {
            return array;
        }
        int midpoint = length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, midpoint);
        int[] rightHalf = Arrays.copyOfRange(array, midpoint, length);

        var leftPart = sliptAndSort(leftHalf);
        var rightPart = sliptAndSort(rightHalf);

        return mergeAndSort(leftPart, rightPart);
    }

    private int[] mergeAndSort(int[] leftPart, int[] rightPart) {
        int[] result = new int[leftPart.length + rightPart.length];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                result[index++] = leftPart[i++];
                continue;
            }
            result[index++] = rightPart[j++];
        }

        while (i < leftPart.length) {
            result[index++] = leftPart[i++];
        }

        while (j < rightPart.length) {
            result[index++] = rightPart[j++];
        }

        return result;
    }
}
