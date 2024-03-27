package org.example.lab1;

import org.example.lab1.solution.Solution;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] nodes = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        BinaryTree<Integer> tree = new BinaryTree<>(nodes);
        tree.printLevelOrder();
        // your code here
//        Solution solution = new BinaryTreeSolution();
//        List<List<Integer>> results = solution.pathSum(tree.root, 22);
//        System.out.println(results);

    }

}