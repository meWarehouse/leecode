package com.at.lc;

import com.at.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @create 2021-08-08
 */
public class lc_100 {

    /*

        100. 相同的树
            https://leetcode-cn.com/problems/same-tree/

     */

    public boolean isSameTree1(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;


        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);


    }


    public boolean isSameTree(TreeNode p, TreeNode q) {


        if (p == null && q == null) return true;

        if ((p == null && q != null) || (p != null && q == null) || p.val != q.val) return false;


        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {

            TreeNode currP = queueP.poll();
            TreeNode currQ = queueQ.poll();

            if (currP.val != currQ.val) {
                return false;
            }

            if ((currP.left != null && currQ.left != null) || (currP.left == null && currQ.left == null)) {
                if (currP.left != null) {
                    queueP.add(currP.left);
                    queueQ.add(currQ.left);
                }
            } else {
                return false;
            }

            if ((currP.right != null && currQ.right != null) || (currP.right == null && currQ.right == null)) {
                if (currP.right != null) {
                    queueP.add(currP.right);
                    queueQ.add(currQ.right);
                }
            } else {
                return false;
            }


        }

        return true;


    }


}
