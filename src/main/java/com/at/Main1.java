package com.at;


import java.util.Arrays;

/**
 * @author zero
 * @create 2021-06-10 18:47
 */
public class Main1 {


    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 0, 9, 4, 7, -3, 10};
//        int[] arr = {1,2,3,4,5,6,8,4,9,3,3,4,1};

//        new Main1().quickSort(arr, 0, arr.length - 1);


        System.out.println(Arrays.toString(arr));


    }

    public TreeNode mirrorTree(TreeNode root) {


        if(root == null) return root;

        TreeNode left = root.left;

        root.left= root.right;
        root.right = left;

        mirrorTree(root.left);

        mirrorTree(root.right);

        return root;


    }





}
