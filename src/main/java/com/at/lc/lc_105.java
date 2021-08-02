package com.at.lc;

import com.at.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2021-08-03
 */
public class lc_105 {

    /*

        105. 从前序与中序遍历序列构造二叉树
            https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

     */

    Map<Integer, Integer> map = new HashMap<>(); // k:value v:index

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preLen = preorder.length;
        int inLen = inorder.length;

        if(preLen != inLen){
            return null;
        }

        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i],i);
        }


        return builds(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    public TreeNode builds(int[] preOrder, int preLeft, int preRight,
                           int[] inOrder, int inLeft, int inRight) {

        if(preLeft > preRight || inLeft > inRight){
            return null;
        }


        int rootVal = preOrder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        Integer pivot = map.get(rootVal);


        root.left = builds(preOrder,preLeft+1,pivot-inLeft + preLeft,inOrder,inLeft,pivot-1);

        root.right = builds(preOrder,pivot-inLeft+preLeft+1,preRight,inOrder,pivot+1,inRight);

        return root;


    }


}
