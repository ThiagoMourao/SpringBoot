package dev.mourao.movies.tools;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchAlgorithmsTest {
    private static SearchAlgorithms instance;
    private static int[] array;

    @BeforeAll
    static void beforeAll() {
        instance = new SearchAlgorithms();
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    void linearSearchTest() {
        var initial = System.currentTimeMillis();
        for (int target : array) {
            var result = instance.linearSearch(array, target);
            System.out.println(result);
            assertTrue(result);
        }
        System.out.println("linearSearch: Time of execution(Milliseconds): " + (System.currentTimeMillis() - initial));
    }

    @Test
    void binarySearchTest() {
        var initial = System.currentTimeMillis();
        for (int target : array) {
            var result = instance.binarySearch(array, target);
            assertTrue(result);
        }
        System.out.println("binarySearch: Time of execution(Milliseconds): " + (System.currentTimeMillis() - initial));
    }

    @Test
    void recursiveBinarySearchTest() {
        var initial = System.currentTimeMillis();
        for (int target : array) {
            var result = instance.runBinarySearchRecursively(array, target,0, array.length);
            assertTrue(result);
        }
        System.out.println("recursiveBinarySearch: Time of execution(Milliseconds): " + (System.currentTimeMillis() - initial));
    }

    @Test
    void fibonacciSearchTest() {
        var initial = System.currentTimeMillis();
        for (int target : array) {
            var result = instance.fibonacciSearch(array, target);
            assertTrue(result);
        }
        System.out.println("fibonacciSearch: Time of execution(Milliseconds): " + (System.currentTimeMillis() - initial));
    }
}
