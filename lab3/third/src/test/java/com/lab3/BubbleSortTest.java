package com.lab3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @Before
    public void setUp() throws Exception {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void test1() {
        // Boundary values : Empty array
        int[] arr1 = {};
        bubbleSort.sort(arr1);
        assertArrayEquals(new int[]{}, arr1);
    }

    @Test
    public void test2() {
        // Boundary values : Single element array
        int[] arr2 = {1};
        bubbleSort.sort(arr2);
        assertArrayEquals(new int[]{1}, arr2);
    }

    @Test
    public void test3() {
        // Boundary values : Sorted array
        int[] arr3 = {1, 3, 5, 7, 9};
        bubbleSort.sort(arr3);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr3);
    }

    @Test
    public void test4() {
        // Boundary values : Sorted array
        int[] arr3 = {1, 2, 3, 4, 5};
        bubbleSort.sort(arr3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr3);
    }

    @Test
    public void test5() {
        // Boundary values : Reverse sorted array
        int[] arr4 = {9, 7, 5, 3, 1};
        bubbleSort.sort(arr4);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr4);
    }

    @Test
    public void test6() {
        // Boundary values : Reverse sorted array
        int[] arr4 = {5, 4, 3, 2, 1};
        bubbleSort.sort(arr4);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr4);
    }

    @Test
    public void test7() {
        // Equivalence partitioning : Random unsorted array
        int[] arr5 = {3, 2, 1, 5, 4};
        bubbleSort.sort(arr5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr5);
    }

    @Test
    public void test8() {
        // Equivalence partitioning : All elements are the same
        int[] arr6 = {1, 1, 1, 1};
        bubbleSort.sort(arr6);
        assertArrayEquals(new int[]{1, 1, 1, 1}, arr6);
    }

    @Test
    public void test9() {
        // Equivalence partitioning : All elements are the same
        int[] arr7 = {5, 5, 5, 5};
        bubbleSort.sort(arr7);
        assertArrayEquals(new int[]{5, 5, 5, 5}, arr7);
    }

    @Test
    public void test10() {
        // Specific use cases: some elements are the same
        int[] arr8 = {6, 7, 8, 9, 9, 7, 8, 6};
        bubbleSort.sort(arr8);
        assertArrayEquals(new int[]{6, 6, 7, 7, 8, 8, 9, 9}, arr8);
    }

    @Test
    public void test11() {
        // Specific use cases: Random unsorted array
        int[] arr8 = {5, 3, 9, 1, 7};
        bubbleSort.sort(arr8);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr8);
    }

    @Test
    public void test12() {
        // Specific use cases :Random unsorted array
        int[] arr9 = {9, 7, 5, 3, 1};
        bubbleSort.sort(arr9);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr9);
    }

    @Test
    public void test13() {
        // Specific use case: Array with negative numbers
        int[] arr = {-5, -3, -9, -1, -7};
        bubbleSort.sort(arr);
        assertArrayEquals(new int[]{-9, -7, -5, -3, -1}, arr);
    }

    @Test
    public void test14() {
        // Specific use case: Large random unsorted array
        int[] arr = {9, 4, 7, 2, 8, 3, 6, 1, 5};
        bubbleSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    public void test15() {
        // Specific use case: Large random unsorted array
        int[] arr = {9, 4, 7, 2, 8, 3, 6, 1, 5, 0};
        bubbleSort.sort(arr);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    public void test16() {
        // Specific use case: Large random unsorted array
        Random random = new Random();
        int[] arr = new int[100];
        for(int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(1000);
        }
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);

        bubbleSort.sort(arr);
        assertArrayEquals(arrCopy, arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testSortIncorrectOrder() {
        BubbleSort sorter = new BubbleSort();
        int[] arr = {10, 5, 3, 7, 2}; // 输入数组，第一个元素是最大值
        int[] expected = {2, 3, 5, 7, 10}; // 期望输出数组，升序排列

        bubbleSort.sort(arr);

        assertArrayEquals(expected, arr); // 检查排序后数组是否为升序排列
    }

    @After
    public void tearDown() throws Exception {
        bubbleSort = null;
    }
}


