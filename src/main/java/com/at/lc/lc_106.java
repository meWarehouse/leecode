package com.at.lc;

import com.at.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2021-09-24
 */
public class lc_106 {

    //106. 从中序与后序遍历序列构造二叉
    //https://leetcode-cn.com/problemset/all/?search=106&page=1

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder,0,inorder.length-1, postorder,0,postorder.length-1);

    }


    public TreeNode buildTree(int[] inorder, int iL, int iR,
                              int[] postorder, int pL, int pR) {

        if (iL > iR || pL > pR) return null;

        int headVal = postorder[pR];
        TreeNode root = new TreeNode(headVal);
        Integer p = map.get(headVal);

        root.left = buildTree(inorder, iL, p - 1, postorder, pL, pR+p-iR);
        root.right = buildTree(inorder, p + 1, iR, postorder, pR+p-iR-1, pR - 1);


        return root;

    }


}
