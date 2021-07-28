package com.at;

import com.at.bean.TreeNode;
import com.at.test.HeapSort;
import com.sun.org.apache.bcel.internal.generic.POP2;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zero
 * @create 2021-06-21 23:20
 */
public class Test {

    public static void main(String[] args) {


        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);

        n3.left = n5;
        n3.right = n1;

        n5.left = n6;
        n5.right = n2;

        n1.left = n0;
        n1.right = n8;

        n2.left = n7;
        n2.right = n4;




    }




    /*
        给定一个数组 其中只有一个数出现了奇数次 其他的都出现了偶数次
     */
    public int test1(int[] arr){

        int tmp = 0;

        for (int i : arr) {
            tmp = tmp ^ i;
        }

        return tmp;

    }

    /*
        给定一个数组 其中只有两个不同的数出现了奇数次 其他的都出现了偶数次
     */
    public void test2(int[] arr){

        int tmp = 0;

        for (int i : arr) {
            tmp = tmp ^ i;
        }

        //tmp = a ^ b 并且 ab 不相等
        int rightOne = tmp & (~tmp + 1);

        int onlyOne = 0;

        for (int i : arr) {
            if((i&rightOne) == 0){
                onlyOne^=i;
            }
        }

        System.out.println(onlyOne + " " + ( onlyOne^tmp));




    }




}
