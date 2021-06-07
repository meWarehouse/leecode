package com.at;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {


    }

    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode pre=null;
    TreeNode root=null;
    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null) return null;

        Convert(pRootOfTree.left);

        if(root == null){
            root = pRootOfTree;
        }
        if(pre != null){
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.right);

        return root;

    }

    public TreeNode Convert1(TreeNode pRootOfTree) {

        if(pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) return pRootOfTree;

        mid(pRootOfTree);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }

        return list.get(0);

    }

    public void mid(TreeNode treeNode){

        if(treeNode.left != null){
            mid(treeNode.left);
        }

        list.add(treeNode);

        if(treeNode.right != null){
            mid(treeNode.right);
        }

    }



}




class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
