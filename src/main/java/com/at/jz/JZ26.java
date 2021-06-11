package jz;



import com.at.jz.TreeNode;

import java.util.ArrayList;

/**
 * @author zero
 * @create 2021-06-07 14:05
 */
public class JZ26 {
    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode pre=null;
    TreeNode root=null;

    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null) return null;

        Convert(pRootOfTree.right);
        if(pre != null){
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.left);

        return pre;

    }

    public TreeNode Convert2(TreeNode pRootOfTree) {

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
