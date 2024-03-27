package org.example.lab1;

import org.example.lab1.solution.Solution;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSolution implements Solution {

    @Override
    public List<List<Integer>> pathSum(TreeNode<Integer> root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        addPath(root, targetSum, path, res);
        return res;
    }

    private void addPath(TreeNode<Integer> root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        } else {
            addPath(root.left, targetSum, path, res);
            addPath(root.right, targetSum, path, res);
        }
        path.remove(path.size() - 1);
    }


}
