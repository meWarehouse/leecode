package com.at;


import com.at.bean.ListNode;
import com.at.bean.TreeNode;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.crypto.provider.HmacPKCS12PBESHA1;
import com.sun.deploy.pings.Pings;
import com.sun.javafx.geom.Edge;
import com.sun.media.sound.RIFFInvalidDataException;
import com.sun.org.apache.regexp.internal.RE;
import sun.java2d.opengl.WGLGraphicsConfig;
import sun.reflect.generics.tree.Tree;
import sun.rmi.transport.proxy.CGIHandler;

import javax.lang.model.element.VariableElement;
import java.awt.*;
import java.nio.channels.Pipe;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.*;
import java.util.List;
import java.util.function.DoublePredicate;

/**
 * @author zero
 * @create 2021-07-04
 */
public class Main2 {

    public static void main(String[] args) {


//        new Main2().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});

        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        List<List<Integer>> r = new ArrayList<>();
        r.add(l1);
        r.add(l2);
        r.add(l3);
        r.add(l4);


        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t5.left = t2;
        t5.right = t6;

        t2.left = t1;
        t2.right = t4;

        t1.right = t3;


        char[][] te = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };




    }



    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int len = nums.length;

//        int[] dp = new int[len];
//
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[1],dp[0]);
//
//        for (int i = 2; i < len; i++) {
//
//            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
//
//        }
//
//        return dp[len-1];
//


    }



}












