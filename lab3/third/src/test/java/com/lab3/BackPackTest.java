package com.lab3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackPackTest {
    private BackPack backPack;

    @Before
    public void setUp() throws Exception {
        backPack = new BackPack();
    }

    @Test
    public void test1_1() {
        // Boundary values
        int[] weights1 = {};
        int[] values1 = {};
        int capacity1 = 5;
        assertEquals(0, backPack.knapSack(capacity1, weights1, values1, weights1.length));
    }

    @Test
    public void test1_2() {
        // Boundary values
        int[] weights1 = {5,2 ,3, 4};
        int[] values1 = {};
        int capacity1 = 5;
        assertEquals(0, backPack.knapSack(capacity1, weights1, values1, weights1.length));
    }

    @Test
    public void test1_3() {
        // Boundary values
        int[] weights1 = {};
        int[] values1 = {2,3, 4, 5};
        int capacity1 = 5;
        assertEquals(0, backPack.knapSack(capacity1, weights1, values1, weights1.length));
    }

    @Test
    public void test1_4() {
        // Boundary values
        int[] weights1 = {5,2 ,3, 4};
        int[] values1 = {2,3, 4, 5};
        int capacity1 = 0;
        assertEquals(0, backPack.knapSack(capacity1, weights1, values1, weights1.length));
    }

    @Test
    public void test2_1() {
        // Equivalence partitioning: less than each weights
        int[] weights3 = {3, 2, 3, 4, 5};
        int[] values3 = {1, 2, 3, 4, 5};
        int capacity3 = 1;
        assertEquals(0, backPack.knapSack(capacity3, weights3, values3, weights3.length));
    }

    @Test
    public void test2_2() {
        // Equivalence partitioning: just enough for the first weight
        int[] weights3 = {3, 2, 3, 4, 5};
        int[] values3 = {1, 2, 3, 4, 5};
        int capacity3 = 3;
        assertEquals(3, backPack.knapSack(capacity3, weights3, values3, weights3.length));
    }

    @Test
    public void test2_3() {
        // Equivalence partitioning: just enough for the first two weights
        int[] weights3 = {3, 2, 3, 4, 5};
        int[] values3 = {1, 2, 3, 4, 5};
        int capacity3 = 5;
        assertEquals(5, backPack.knapSack(capacity3, weights3, values3, weights3.length));
    }

    @Test
    public void test2_4() {
        // Equivalence partitioning: just enough for every weights
        int[] weights3 = {3, 2, 3, 4, 5};
        int[] values3 = {1, 2, 3, 4, 5};
        int capacity3 = 17;
        assertEquals(15, backPack.knapSack(capacity3, weights3, values3, weights3.length));
    }

    @Test
    public void test2_5() {
        // Equivalence partitioning: over all weights
        int[] weights3 = {1, 2, 3, 4, 5};
        int[] values3 = {1, 2, 3, 4, 5};
        int capacity3 = 18;
        assertEquals(15, backPack.knapSack(capacity3, weights3, values3, weights3.length));
    }

    @Test
    public void test3_1() {
        // Specific use cases : Normal values
        int[] weights3 = {4, 5, 6};
        int[] values3 = {5, 6, 7};
        int capacity3 = 9;
        assertEquals(11, backPack.knapSack(capacity3, weights3, values3, weights3.length));
    }

    @Test
    public void test3_2() {
        // Specific use cases : Negative values
        int[] weights3 = {4, 8, 6};
        int[] values3 = {-5, -6, -7};
        int capacity3 = 5;
        assertEquals(0, backPack.knapSack(capacity3, weights3, values3, weights3.length));
    }

    @Test
    public void test3_3() {
        // Specific use cases : Negative weights
        int[] weights3 = {-4, -5, -6};
        int[] values3 = {5, 6, 7};
        int capacity3 = 5;
        assertEquals(0, backPack.knapSack(capacity3, weights3, values3, weights3.length));
    }

    @Test
    public void test3_4() {
        // Specific use cases: Large values
        int[] weights3 = {300, 400, 50, 600};
        int[] values3 = {40, 50, 600, 700};
        int capacity3 = 800;
        assertEquals(1300, backPack.knapSack(capacity3, weights3, values3, weights3.length));
    }

    @Test
    public void test3_5() {
        //  Specific use cases: weights equals values
        int[] weights2 = {2, 3, 4, 5};
        int[] values2 = {2, 3, 4, 5};
        int capacity2 = 9;
        assertEquals(9, backPack.knapSack(capacity2, weights2, values2, weights2.length));
    }

    @Test
    public void test3_6() {
        // Specific use cases: values are the same
        int[] weights2 = {1, 3, 4, 6};
        int[] values2 = {5, 5, 5, 5};
        int capacity2 = 9;
        assertEquals(15, backPack.knapSack(capacity2, weights2, values2, weights2.length));
    }

    @Test
    public void test3_7() {
        // Specific use cases : weights are the same
        int[] weights2 = {5, 5, 5, 5};
        int[] values2 = {1, 3, 4, 6};
        int capacity2 = 19;
        assertEquals(13, backPack.knapSack(capacity2, weights2, values2, weights2.length));
    }

//    @After
//    public void tearDown() throws Exception {
//        backPack = null;
//    }
}