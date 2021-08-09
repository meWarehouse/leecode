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
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                      };




    }

    public int num(int n){

        if(n < 1) return 0;

        int[] recode = new int[n];

        return process(0,recode,n);

    }

    private int process(int i, int[] recode, int n) {

        if(i == n) return 1;


        int res = 0;

        for (int j = 0; j < n; j++) {
            //当前 i 行的皇后，放在 j 列 会不会和前 (0... i-1) 的皇后 共行 共列 共斜线
            //如果是 则不能放在此处
            if(!isValid(recode,i,j)){
                recode[i] = j;
                res += process(i+1,recode,n);
            }

        }

        return res;

    }

    private boolean isValid(int[] recode, int i, int j) {

        for (int k = 0; k < i; k++) {
            if(j == recode[k] || Math.abs(recode[k]-j) == Math.abs(i-k)){
                return false;
            }
        }

        return true;
    }


}













