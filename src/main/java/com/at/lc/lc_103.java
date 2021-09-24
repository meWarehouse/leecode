package com.at.lc;

import com.at.bean.TreeNode;

import java.util.*;

/**
 * @create 2021-09-24
 */
public class lc_103 {

    //103. 二叉树的锯齿形层序遍历
    // https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/submissions/

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //true 从 -> 出 ，false 从 <- 出
        boolean getOrder = true;

        while (!queue.isEmpty()){

            int size = queue.size();
            Deque<Integer> levelDeque = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                TreeNode pollNode = queue.poll();
                if(getOrder){
                    levelDeque.addLast(pollNode.val);
                }else {
                    levelDeque.addFirst(pollNode.val);
                }

                if(pollNode.left != null){
                    queue.add(pollNode.left);
                }
                if(pollNode.right != null){
                    queue.add(pollNode.right);
                }

            }

            list.add(new LinkedList<>(levelDeque));
            getOrder = !getOrder;

        }

        return list;

    }

}
