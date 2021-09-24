package com.at.lc;

import com.at.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @create 2021-09-24
 */
public class lc_95 {

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) return new LinkedList<>();

        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> allTree = new LinkedList<>();
        if (start > end) {
            allTree.add(null);
            return allTree;
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = leftTree;
                    currTree.right = rightTree;
                    allTree.add(currTree);
                }
            }

        }

        return allTree;


    }


}
