package org.example.lab1;

import org.example.lab1.solution.Solution;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeSolutionTest {
    Solution solution;
    @Before
    public void setUp() {
        System.out.println("--------- Starting test ---------");
        solution = new BinaryTreeSolution();
    }

    @Test
    public void test0( ) {
        Integer[] nodes = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        BinaryTree<Integer> tree = new BinaryTree<>(nodes);
        List<List<Integer>> res = new ArrayList<>();
        Integer path[] = { 5, 4, 11, 2 };
        List<Integer> ans = Arrays.asList(path);
        Integer path2[] = { 5, 8, 4, 5 };
        List<Integer> ans2 = Arrays.asList(path2);
        res.add(ans);
        res.add(ans2);
        assertEquals(res, solution.pathSum(tree.root, 22));
        assertTrue(res.equals(solution.pathSum(tree.root, 22)));
        System.out.println("Test Multiple Paths Satisfying Condition passed");
    }

    @Test
    public void test1() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, solution.pathSum(tree.root, 0));
        assertFalse(solution.pathSum(tree.root, 0).size() > 0);
        System.out.println("Test Empty Tree passed");
    }

    @Test
    public void test2() {
        // 构建一棵单支树
        Integer[] nodes = {1, null, 2, null, 3, null, 4, null, 5};
        BinaryTree<Integer> tree = new BinaryTree<>(nodes);

        // 期望的路径和目标值
        int target = 15;
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> path = Arrays.asList(1, 2, 3, 4, 5);
        expected.add(path);

        assertEquals(expected, solution.pathSum(tree.root, target));
        assertTrue(solution.pathSum(tree.root, target).get(0).size() == 5);
        System.out.println("Test Single Branch Tree passed");
    }


    @Test
    public void test3() {
        // 构建一个新的随机生成的树
        Integer[] nodes = {10, 5, 15, 3, 7, 13, 18, null, null, 6, null, null, null, null, null};
        BinaryTree<Integer> tree = new BinaryTree<>(nodes);

        // 期望的路径和目标值
        int target = 28;
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> path1 = Arrays.asList(10, 5, 7, 6);
        expected.add(path1);

        assertEquals(expected, solution.pathSum(tree.root, target));
        assertFalse(solution.pathSum(tree.root, target).size() > 1);
        System.out.println("Test Single Path Satisfying Condition passed");
    }

    @Test
    public void test4() {
        // 构建一个新的随机生成的树
        Integer[] nodes = { 1, 3, 2, 4, 7, 5, 2, 1, 3, null, null, null, 3, null, null};
        BinaryTree<Integer> tree = new BinaryTree<>(nodes);

        // 期望的路径和目标值
        int target = 11;
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> path1 = Arrays.asList(1, 3, 4, 3);
        List<Integer> path2 = Arrays.asList(1, 3, 7);
        List<Integer> path3 = Arrays.asList(1, 2, 5, 3);
        expected.add(path1);
        expected.add(path2);
        expected.add(path3);

        assertEquals(expected, solution.pathSum(tree.root, target));
        assertTrue(solution.pathSum(tree.root, target).size() == 3);
        System.out.println("Test Triple Path Satisfying Condition passed");
    }

    @After
    public void tearDown() {
        System.out.println("--------- Ending test ---------");
    }



}
