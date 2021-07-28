package com.at.lc;



import com.at.bean.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @create 2021-07-28
 */
public class lc_236 {

    /*

        236. 二叉树的最近公共祖先
            https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

     */


    HashMap<TreeNode, TreeNode> conn = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        conn.put(root,root);
        process(root);

        HashSet<TreeNode> setConn = new HashSet<>();
        TreeNode curr = p;
        while (curr != conn.get(curr)){
            setConn.add(curr);
            curr = conn.get(curr);
        }
        setConn.add(curr);

        curr = q;
        while (!setConn.contains(curr)){
            curr = conn.get(curr);
        }

        return curr;


    }

    public void process(TreeNode head){

        if(head == null) return;

        conn.put(head.left,head);
        conn.put(head.right,head);

        process(head.left);
        process(head.right);

    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){

        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;

    }

}
