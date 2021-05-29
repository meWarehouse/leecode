package com.at.jz;

/**
 * @author zero
 * @create 2021-05-26 18:21
 */
public class JZ17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root1 == null || root2 == null) return false;

        if(root1.val == root2.val ){
//            recur(root1.left,root2.left) && recur(root1.right,root2.right)
            if(recur(root1.left, root2.left)  && recur(root1.right, root2.right)){
                return true;
            }
        }

        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);

    }

    public boolean recur(TreeNode r1,TreeNode r2){

        if(r2 == null) return true;

        if(r1 == null) return false;

        if(r1.val == r2.val){
            return recur(r1.left,r2.left) && recur(r1.right,r2.right);
        }else {
            return false;
        }



    }


}

//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//
//    }
//
//}
