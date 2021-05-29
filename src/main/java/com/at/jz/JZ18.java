package jz;



import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zero
 * @create 2021-05-27 18:32
 */
public class JZ18 {
    public TreeNode MirrorDFS(TreeNode pRoot) {

        if (pRoot == null){
            return null;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(pRoot);

        while (!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null){
                nodes.add(node.left);
            }

            if(node.right != null){
                nodes.add(node.right);
            }
        }

        return pRoot;


    }

    public TreeNode MirrorBFS(TreeNode pRoot) {

        if (pRoot == null){
            return null;
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();

        nodes.add(pRoot);

        while (!nodes.isEmpty()){

            TreeNode tree = nodes.poll();

            TreeNode left = tree.left;
            tree.left = tree.right;
            tree.right = left;

            if(tree.left != null){
                nodes.add(tree.left);
            }

            if(tree.right != null){
                nodes.add(tree.right);
            }

        }

        return pRoot;

    }



    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
        if (pRoot == null) return null;

        TreeNode l = Mirror(pRoot.left);
        TreeNode r = Mirror(pRoot.right);

        pRoot.left = r;
        pRoot.right = l;

        return pRoot;


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
