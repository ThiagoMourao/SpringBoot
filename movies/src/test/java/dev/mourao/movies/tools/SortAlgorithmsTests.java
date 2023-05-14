package dev.mourao.movies.tools;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortAlgorithmsTests {

    private static SortAlgorithms instance;

    @BeforeAll
    static void beforeAll() {
        instance = new SortAlgorithms();
    }

    @Test
    void sliptSortAndMergeSortTest() {
        int[] actual = {5, 9, 1, 6, 8, 2, 3, 7, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        var initial = System.currentTimeMillis();
        assertArrayEquals(expected, instance.sliptSortAndMergeSort(actual));
        System.out.println("sliptSortAndMergeSort: Time of execution(Milliseconds): " + (System.currentTimeMillis() - initial));
    }

    @Test
    void mergeAndSort2UnsortedsTest() {
        int[] array1 = {5, 9, 1, 6, 8, 10};
        int[] array2 = {2, 3, 7, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var initial = System.currentTimeMillis();
        assertArrayEquals(expected, instance.mergeAndSort2Unsorteds(array1, array2));
        System.out.println("mergeAndSort2Unsorteds: Time of execution(Milliseconds): " + (System.currentTimeMillis() - initial));
    }
}
