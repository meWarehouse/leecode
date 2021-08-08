package com.at.lc;

import com.at.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @create 2021-08-08
 */
public class lc_145 {

    /*

        145. 二叉树的后序遍历
            https://leetcode-cn.com/problems/binary-tree-postorder-traversal/

     */


    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null){

            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();


            if(root.right == null || root.right == prev){

                list.add(root.val);
                prev = root;
                root = null;

            }else {
                stack.push(root);
                root = root.right;
            }
        }

        return list;


    }

}
