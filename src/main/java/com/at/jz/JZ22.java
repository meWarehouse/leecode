package com.at.jz;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zero
 * @create 2021-05-29 18:13
 */
public class JZ22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){

            TreeNode pop = queue.poll();
            list.add(pop.val);

            if(pop.left != null){
                queue.add(pop.left);
            }

            if(pop.right != null){
                queue.add(pop.right);
            }

        }


        return list;

    }


}
