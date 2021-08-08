package com.at.lc;

import com.at.bean.TreeNode;

/**
 * @create 2021-08-08
 */
public class lc_99 {

    /*

        99. 恢复二叉搜索树

            https://leetcode-cn.com/problems/recover-binary-search-tree/

            中序遍历过程中，记录错误两个错误排序节点，最后进行交换

     */

    TreeNode t1, t2, pre;


    public void inOrder(TreeNode root) {

        if (root == null) return;

        inOrder(root.left);

        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }

        pre = root;

        inOrder(root.right);

    }


    public void recoverTree(TreeNode root) {

        if (root == null) return;

        inOrder(root);

        TreeNode tmp = t1;
        t1 = t2;
        t2 = tmp;


    }

}
