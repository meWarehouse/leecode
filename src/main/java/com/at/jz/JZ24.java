package jz;

import java.util.ArrayList;

/**
 * @author zero
 * @create 2021-06-05 20:44
 */
public class JZ24 {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList();


    public ArrayList<ArrayList<Integer>> FindPath(jz.TreeNode root, int target) {

        if(root == null || target < root.val) return list;

        path.add(root.val);
        target-= root.val;

        if(target == 0 && root.left == null && root.right == null){
            list.add(new ArrayList<Integer>(path));
        }

        FindPath(root.left,target);
        FindPath(root.right,target);

        path.remove(path.size()-1);

        return list;

    }

}
