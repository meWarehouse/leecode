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
import sun.reflect.generics.tree.Tree;
import sun.rmi.transport.proxy.CGIHandler;

import javax.lang.model.element.VariableElement;
import java.nio.channels.Pipe;
import java.security.PublicKey;
import java.util.*;

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

//        long s = System.currentTimeMillis();


//        System.out.println(System.currentTimeMillis() - s);

    }


    public int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text1.length() == 0) return 0;

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];

    }


}

class NumArray {

    int[] res;

    public NumArray(int[] nums) {
        res = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            res[i] = res[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {

        return res[right + 1] - res[left];

    }
}












