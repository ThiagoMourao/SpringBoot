package dev.mourao.movies.tools;

public class SearchAlgorithms {

    //O(n) -> n = input.length
    public boolean linearSearch(int[] input, int key) {
        for (int index = 0; index < input.length; index++) {
            if (input[index] == key) {
                return true;
            }
        }
        return false;
    }

    //O(n) -> n = sortedInput.length
    public boolean binarySearch(int[] sortedInput, int target) {
        int first = 0;
        int last = sortedInput.length - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (sortedInput[mid] == target) {
                return true;
            }
            if (sortedInput[mid] < target) {
                first = mid + 1;
                continue;
            }
            last = mid - 1;
        }
        return false;
    }

    //O(log n) -> n = input.length
    public boolean runBinarySearchRecursively(int[] sortedInput, int target, int minIndex, int maxIndex) {
        int middle = minIndex + ((maxIndex - minIndex) / 2);

        if (maxIndex < minIndex) {
            return false;
        }

        if (target == sortedInput[middle]) {
            return true;
        }
        if (target < sortedInput[middle]) {
            return runBinarySearchRecursively(sortedInput, target, minIndex, middle - 1);
        }
        return runBinarySearchRecursively(sortedInput, target, middle + 1, maxIndex);
    }

    //O(1) + O(1) + log(n) -> n = sortedInput.length
    public boolean fibonacciSearch(int[] sortedInput, int target) {
        int lenght = sortedInput.length;
        if (lenght == 0) {
            return false;
        }

        // Initialize Fibonacci numbers
        int fib1 = 0;
        int fib2 = 1;
        int fib3 = fib1 + fib2;

        // Find the smallest Fibonacci number greater than or equal to lenght
        while (fib3 < lenght) {
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1 + fib2;
        }

        // Initialize variables for the current and previous split points
        int offset = -1;
        while (fib3 > 1) {
            int i = Math.min(offset + fib2, lenght - 1);

            // If target is greater than the value at index i, move the split point to the right
            if (sortedInput[i] < target) {
                fib3 = fib2;
                fib2 = fib1;
                fib1 = fib3 - fib2;
                offset = i;
                continue;
            }

            // If target is less than the value at index i, move the split point to the left
            if (sortedInput[i] > target) {
                fib3 = fib1;
                fib2 = fib2 - fib1;
                fib1 = fib3 - fib2;
                continue;
            }
            return true;
        }

        // If target is not found in the array, return false
        if (fib2 == 1 && sortedInput[offset + 1] == target) {
            return true;
        }
        return false;
    }
}
